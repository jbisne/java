import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class ChatServer 
{
	private static DBConnector oracleDBConnector = DBConnector.getInstance();
	ResultSet rs;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	
	Socket socket = null;
	ServerSocket serverSocket = null;
		
	ChatRoom myChatRoom;
	ChatRoom chatRoomManager;
	String targetUser = "";
	
	List<ChatRoom> chatRoomList;
	Map<String, Integer> currentState;
	Map<String, PrintWriter> clientOutMap;
	Map<String, BufferedReader> clientInputMap;
	Map<String, PrintWriter> waitingRoomOutMap;
	public ChatServer()
	{
		chatRoomList = new ArrayList<ChatRoom>();
		currentState = new HashMap<String, Integer>();
		clientOutMap = new HashMap<String, PrintWriter>();
		clientInputMap = new HashMap<String, BufferedReader>();
		waitingRoomOutMap = new HashMap<String, PrintWriter>();
		Collections.synchronizedMap(clientInputMap);
		Collections.synchronizedMap(clientOutMap);
		Collections.synchronizedMap(currentState);
		Collections.synchronizedList(chatRoomList);
		Collections.synchronizedMap(waitingRoomOutMap);
	}
	
	public void init()
	{	
		PrintWriter out = null;
		try
		{
			serverSocket = new ServerSocket(9999);
			System.out.println("┌──────────────────────────────────────────────────────────┐ ");
			System.out.println("│                          서 버                           │ ");
			System.out.println("└──────────────────────────────────────────────────────────┘ ");
			con = oracleDBConnector.getConnection();
			String sql;
			while(true)
			{
				socket = serverSocket.accept();				
				out = new PrintWriter(socket.getOutputStream(), true);
				sql = "select * from CLIENT where IP = '" + socket.getInetAddress() + "'";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					if(rs.getString(3).equals("O") && rs.getString(4).equals("O"))
					{
						System.out.println(" ▷ 차단된 사용자 입니다.\n ▷ 접속을 차단합니다.");
						out.println(" ▶ 접속이 차단되었습니다.");
						continue;
					}
				}
			
				Thread msr = new MultiServerT(socket);
				msr.start();
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			  try {
				  serverSocket.close();
			  } catch(Exception e) { e.printStackTrace(); return;}
		  } 
	} 
	
	public void list(PrintWriter out)
	{
		Iterator<String> it = clientOutMap.keySet().iterator();
		String msg = " ▶ 사용자 리스트 [";
		while (it.hasNext()) {
			msg += (String)it.next() + ",";
		}
		msg = msg.substring(0,msg.length()-1) + "]";
		out.println(msg);
	}
	
	public void sendAllMsg(String msg) 
	{	
		Iterator<String> it = clientOutMap.keySet().iterator();
		msg = filterMsg(msg, "");
		while(it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter)clientOutMap.get(it.next());
				it_out.println(" [관리자] : " + msg);
			} catch (Exception e) {
				System.out.println(" [알림] 전송 실패");
			}
		}
	}
	
	public void sendWaitingRoomMsg(String user, String msg) 
	{
		LocalTime present = LocalTime.now();	
		Iterator<String> it = waitingRoomOutMap.keySet().iterator();
		msg = filterMsg(msg,user);
		while(it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter)waitingRoomOutMap.get(it.next());
				if (user.equals(""))
					it_out.println(" [대기실] "+ msg);
				else
					it_out.println(" [대기실] "+ user + " : " + msg + "  [" + present.getHour() + ":" + present.getMinute() + "]");
			} catch (Exception e) {
				System.out.println(" ◁ 대기실 메시지 전송 실패");
			}
		}
	}
	
	public void sendWhisperMsg(String sendUser, String targetUser, String msg)
	{
		LocalTime present = LocalTime.now();
		msg = filterMsg(msg, sendUser);
		PrintWriter it_out = (PrintWriter)clientOutMap.get(targetUser);
		it_out.println(" [귓속말] " + sendUser + " : " + msg + "  [" + present.getHour() + ":" + present.getMinute() + "]");
	}
	
	public String filterMsg(String msg, String userID)
	{
		String sql = "select * from BADWORDS";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(msg.contains(rs.getString(1)))
				{
					String replace = "";
					for(int j = 0; j < rs.getString(1).length(); j++)
						replace += "*";
					msg = msg.replaceAll(rs.getString(1), replace);
					sql = "update CLIENT set YELLOWCARD = YELLOWCARD + 1 where ID ='" + userID + "'";
					stmt = con.createStatement();
					stmt.executeUpdate(sql);
					PrintWriter it_out = (PrintWriter)clientOutMap.get(userID);
					it_out.println(" ▶ [경고] 금칙어를 사용하셨습니다.");
				}
			}
		} catch (Exception e) { }
		return msg;
	}
	
	public static void main(String[] args) {
		ChatServer ms = new ChatServer();
		ms.init();
	}
	
	public class MultiServerT extends Thread
	{
		
		Socket socket;
		Writer chatFile;
		int userType = 2;
		AdminMenu addminMenu;
		UserManage userHandler;
		PrintWriter out = null;
		BufferedReader in = null;
		String connectedUserID = "";		
		UserManage guest = new UserManage();
		
		public MultiServerT(Socket socket){
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				userHandler = new UserManage(socket, out, in, clientOutMap);
				chatRoomManager = new ChatRoom(out, in);
			} catch(Exception e) { System.out.println("예외[Stream Creation] : " + e.getMessage());}
		}
		
		public int checkGuestType(String connectedUserID)
		{
			if(connectedUserID.equals("BlackList"))
				return 0;
			if(connectedUserID.equals("admin"))
				return 1;
			else
				return 2;
		}
		
		@Override
		public void run()
		{		
			try {
				LocalDateTime logDate = LocalDateTime.now();
				userHandler.showConnectMenu(guest);
				connectedUserID = guest.getUserID();
				
				userType = checkGuestType(connectedUserID);
				if(userType == 0)
				{
					out.println(" ▶ 접속이 차단되었습니다.");
			 		System.out.println(" ◁ 블랙리스트 접속을 차단하였습니다.");
			 		if(in != null)
			 			if(in.readLine().equals("")) {
			 				try {					
			 					in.close();
			 					out.close();
			 					socket.close();
			 				} catch (Exception e) { return; }
			 		} 
				}
				
				clientOutMap.put(connectedUserID, out);
				clientInputMap.put(connectedUserID, in);
				waitingRoomOutMap.put(connectedUserID, out);
				currentState.put(connectedUserID, 1);
				out.println("┌──────────────────────────────────────────────────────────┐ ");
				out.println("│                          대기실                          │");
				out.println("└──────────────────────────────────────────────────────────┘");
				out.println(" ▶ /명령어 : 사용가능한 명령어 목록을 볼 수 있습니다.");
				if(userType == 1)
				{
					out.println(" ▶ 관리자로 접속하였습니다.");
					out.println(" ▶ /회원정보 : 회원 정보를 조회합니다.");
					out.println(" ▶ /금칙어 : 금칙어 목록을 조회합니다.");
					out.println(" ▶ /추가 [단어] : 금칙어를 추가합니다.");
					out.println(" ▶ /ID [ID] : ID 접속을 차단합니다.");
					out.println(" ▶ /IP [ID] : IP 접속을 차단합니다.");
				}
				
				chatFile = new FileWriter(connectedUserID + ".txt", true);
				chatFile.write("-----"+logDate.getYear()+"-" + logDate.getMonthValue() + "-" + logDate.getDayOfMonth() + "-" + "-----\r\n");
				
				if(userType == 1) 
						sendAllMsg(" ▶ 관리자가 접속하였습니다.");
				else 
					sendWaitingRoomMsg("", " ▶ " + connectedUserID + " 님이 입장하셨습니다.");					
				
				System.out.println(" ▷ 현재 접속자 수는 " + clientOutMap.size() + "명 입니다.");
					
				String s = "";
					
				while(in != null)
				{		
					LocalDateTime present = LocalDateTime.now();
					s = in.readLine();
					System.out.println(" ◀ " + connectedUserID + " : " + s + " [" + present.getHour()+":"+present.getMinute() + "]");
					
					if(s.equals("/list"))
						list(this.out);
					else if(s.startsWith("/")) 
					{
						new CommandHandler(connectedUserID, s, out, in, userType);
					}
					else
					{
						if(userType == 1)
							sendAllMsg(s);
						if(currentState.get(connectedUserID) == 1 && userType != 1)
							sendWaitingRoomMsg(connectedUserID, s);
						if(currentState.get(connectedUserID) == 2 || currentState.get(connectedUserID) == 4 && userType != 1)
							sendWhisperMsg(connectedUserID, targetUser, s);
						if(currentState.get(connectedUserID) == 3 && userType != 1)
							myChatRoom.sendChatRoomMsg(connectedUserID, s, myChatRoom.chatRoomMember);							
						chatFile.write(connectedUserID + " : " + s + " [" + present.getHour() + ":" + present.getMinute() + "]\r\n");
					}
				}
			 	} catch (Exception e) {
			 		if( connectedUserID == null) System.out.println(" ▷ 클라이언트가 접속을 종료하였습니다.");
			 		else if( connectedUserID.equals("manager")) System.out.println(" ▷ 관리자가 접속을 종료하였습니다.");
			 		else if( connectedUserID.equals("BlackList")) System.out.println(" ▷ 블랙리스트 ID를 차단하였습니다.");
			 		else System.out.println(" ▷ " + connectedUserID + " 님이 접속을 종료하였습니다.");
			 	
			 	} finally {
			 		if(connectedUserID != null && !connectedUserID.equals("BlackList")) {
			 			clientOutMap.remove(connectedUserID);
			 			waitingRoomOutMap.remove(connectedUserID);
			 			currentState.remove(connectedUserID);
			 			clientInputMap.remove(connectedUserID);
			 			if(userType == 1) sendAllMsg(" ▶ 관리자가 접속을 종료하였습니다.");
			 			else sendWaitingRoomMsg(""," ▶ " + connectedUserID + "님이 퇴장하셨습니다.");
			 		}
			 		System.out.println(" ▷ 현재 접속자 수는 " + clientOutMap.size() + "명 입니다.");
			 		
			 		try {					
			 			in.close();
			 			out.close();
			 			socket.close();
			 			chatFile.close();
			 		} catch (Exception e) { }
			 	}
		}
	}
	
	public class CommandHandler {

		String userID;
		PrintWriter out;
		BufferedReader in;
		String Originmsg;
		AdminMenu addminMenu;
		int userType = 2;
		public CommandHandler(String user, String commandMsg, PrintWriter out, BufferedReader in, int userType)
		{
			this.in = in;
			this.out = out;
			this.userType = userType;
			userID = user;
			Originmsg = commandMsg;
			addminMenu = new AdminMenu(socket, in, out);
			commandExecutor(msgParser(commandMsg));
		}
		
		public String[] msgParser(String msg)
		{
			msg = msg.substring(1, msg.length()); 
			msg.split(" ");
			String[] strArray = msg.split(" ");
			for(int i = 1; i < strArray.length - 2; i++)
				strArray[2] += " " + strArray[2+i];
			return strArray;
		}
		
		public void printNoticeMsg(PrintWriter out, int num)
		{
			switch (num) {
			case 1:
				out.println("┌──────────────────────────────────────────────────────────┐ ");
				out.println("│                 채팅방에 입장하셨습니다.                 │ ");
				out.println("└──────────────────────────────────────────────────────────┘ ");
				break;
			case 2:
				out.println("┌──────────────────────────────────────────────────────────┐ ");
				out.println("│                          대기실                          │ ");
				out.println("└──────────────────────────────────────────────────────────┘ ");
				out.println(" ▶ /명령어 : 사용가능한 명령어 목록을 볼 수 있습니다.");
				break;
			case 3:
				out.println("┌──────────────────────────────────────────────────────────┐ ");
				out.println("│                   채팅방이 없어졌습니다                  │ ");
				out.println("└──────────────────────────────────────────────────────────┘ ");
				break;
			default:
				break;
			}
		}
		
		@SuppressWarnings("unlikely-arg-type")
		public void commandExecutor(String[] command)
		{
			if(command[0].contentEquals("방만들기"))
			{
				myChatRoom = chatRoomManager.createPublicChatRoom(userID, out, in);
				chatRoomList.add(myChatRoom);
				waitingRoomOutMap.remove(userID);
				myChatRoom.chatRoomMember.put(userID, out);
				currentState.replace(userID, 3);
				printNoticeMsg(out, 1);
			}
			
			else if(command[0].contentEquals("비밀방만들기"))
			{
				myChatRoom = chatRoomManager.createSecretChatRoom(userID, out, in);
				chatRoomList.add(myChatRoom);
				waitingRoomOutMap.remove(userID);
				myChatRoom.chatRoomMember.put(userID, out);
				currentState.replace(userID, 3);
				printNoticeMsg(out, 1);
			}
			else if(command[0].contentEquals("채팅방목록"))
			{
				Iterator<ChatRoom> it = chatRoomList.iterator();
				String msg = " ▶ 전체 채팅방 리스트 [  ";
				while (it.hasNext()) {
					msg += (String)it.next().chatRoomName + ",";
				}
				msg = msg.substring(0,msg.length()-1) + " ]";
				out.println(msg);
			}
			else if(command[0].contentEquals("공개방목록"))
			{
				String msg = " ▶ 공개 채팅방 리스트 [  ";
				for(ChatRoom cr : chatRoomList)
				{
					if(!cr.isSecretRoom)
						msg += cr.chatRoomName + ",";
				}
				msg = msg.substring(0,msg.length()-1) + " ]";
				out.println(msg);
			}
			else if(command[0].contentEquals("비밀방목록"))
			{
				String msg = " ▶ 비밀 채팅방 리스트 [  ";
				for(ChatRoom cr : chatRoomList)
				{
					if(cr.isSecretRoom)
						msg += cr.chatRoomName + ",";
				}
				msg = msg.substring(0,msg.length()-1) + " ]";
				out.println(msg);
			}
			else if(command[0].contentEquals("to"))
			{
				Iterator<String> it = clientOutMap.keySet().iterator();
				if(command.length > 2)
					sendWhisperMsg(userID, command[1], command[2]);
				else if(command.length < 3 && currentState.get(userID) == 1)
				{
					for(int i = 0; i < clientOutMap.size(); i++)
					{
						if(it.next().equals(command[1])) {
							targetUser = command[1];
							currentState.replace(userID, 2);
							return;
						}
					}
					out.println(" ▶ 상대방이 채팅 서버에 없습니다. ");
					return;
				}
				else if(command.length < 3 && currentState.get(userID) == 3)
				{	
					for(int i = 0; i < clientOutMap.size(); i++)
					{
						if(it.next().equals(command[1])) {
							targetUser = command[1];
							currentState.replace(userID, 4);
							return;
						}
					}
					out.println(" ▶ 상대방이 채팅 서버에 없습니다. ");
					return;
				}				
				else if(command.length == 1 && currentState.get(userID) == 1)
					currentState.replace(userID, 1);
				else if(command.length == 1 && currentState.get(userID) == 2)
					currentState.replace(userID, 1);
				else if(command.length == 3 && currentState.get(userID) == 3)
					currentState.replace(userID, 3);
				else if(command.length == 1 && currentState.get(userID) == 4)
					currentState.replace(userID, 3);
				else 
					out.println(" ▶ 명령어 사용이 잘못되었습니다 ");
			}
			else if(command[0].contentEquals("참가"))
			{
				boolean isRoomExist = false;
				boolean isBlack = false;
				for(ChatRoom cr : chatRoomList)
				{
					if(cr.chatRoomName.equals(command[1])) 
					{
						myChatRoom = cr;
						isRoomExist = true;
					}
				}
				for(String s : myChatRoom.blockedUserList)
				{
					if(s.equals(userID))
					{
						isBlack = true;
						out.println(" ▶ 채팅방에서 차단당하셨습니다 ");
					}

				}
				if(myChatRoom.currentUserCount >= myChatRoom.maxUserCount) {
					out.println(" ▶ 채팅방 인원이 꽉 찼습니다.");
					return;
				}
				if(isRoomExist && !isBlack)
				{
					if(!myChatRoom.isSecretRoom)
					{
						waitingRoomOutMap.remove(userID);
						myChatRoom.chatRoomMember.put(userID, this.out);
						myChatRoom.currentUserCount++;
						currentState.replace(userID, 3);
						printNoticeMsg(out, 1);
					}
					if(myChatRoom.isSecretRoom && !isBlack)
					{
						out.println(" ▶ 채팅방 비밀번호를 입력하세요 ");
						try {
							String pwd = in.readLine();
							if(pwd.equals(myChatRoom.chatRoomPassword))
							{
								waitingRoomOutMap.remove(userID);
								myChatRoom.chatRoomMember.put(userID, this.out);
								myChatRoom.currentUserCount++;
								currentState.replace(userID, 3);
								printNoticeMsg(out, 1);
							}
							else
								out.println(" ▶ 비밀번호가 일치하지 않습니다 ");
						} catch (Exception e) { 
							out.println(" ▶ 채팅방 참여에 실패했습니다 ");
						} 
					}	
				}
			}
			else if(command[0].contentEquals("대기실사용자"))
			{
				String msg = " ▶ 대기실 사용자 [  ";
				for(String s : waitingRoomOutMap.keySet())
				{
					msg += s + ",";
				}
				msg = msg.substring(0,msg.length()-1) + " ]";
				out.println(msg);
			}
			else if(command[0].contentEquals("채팅방사용자"))
			{
				String msg = " ▶ 채팅방 사용자 [";
				for(String s : myChatRoom.chatRoomMember.keySet())
				{
					msg += s + ",";
				}
				msg = msg.substring(0,msg.length()-1) + " ]";
				out.println(msg);
			}
			else if(command[0].equals("초대"))
			{
				if(currentState.get(userID) != 3)
					out.println(" ▶ 채팅방에서만 사용가능한 명령어입니다  ");
				if(currentState.get(userID) == 3 && !myChatRoom.chatRoomLeader.equals(userID))
					out.println(" ▶ 채팅방 방장만 사용가능한 명령어 입니다  ");
				boolean isRoomExist = false;
				for(ChatRoom cr : chatRoomList)
				{
					if(cr.chatRoomLeader.equals(userID)) {
						myChatRoom = cr;
						isRoomExist = true;
					}
				}
				if(!isRoomExist) return;
				PrintWriter it_out = (PrintWriter)waitingRoomOutMap.get(command[1]);
				if(it_out == null) {
					out.println(" ▶ " + command[1] + "님이 대기실에 없습니다.");
					return;
				}
				BufferedReader it_in = (BufferedReader)clientInputMap.get(command[1]);
				while(isRoomExist)
				{			
					it_out.println(" ▶ [초대]" + userID + " 님이 채팅방에 초대하셨습니다 : y / n");
					try {
						if(it_in.equals('y'))
						{
							out.println(" ▶ " + command[1] + " 님이 초대를 수락하셨습니다.");
							out.println(" ▶ " + command[1] + " 님이 입장하셨습니다.");
							waitingRoomOutMap.remove(command[1]);
							myChatRoom.chatRoomMember.put(command[1], it_out);
							myChatRoom.currentUserCount++;
							currentState.replace(command[1], 3);
							printNoticeMsg(it_out, 1);
							break;
						}
						else if (it_in.readLine().equals('n'))
						{
							out.println(" ▶ " + command[1] + " 님이 초대를 거절하셨습니다.");
							break;
						}
						else
						{
							it_out.println(" ▶ y 혹은 n을 입력해 주세요.");
							continue;
						}
					} catch (Exception e) {
						out.println(" ▶ 채팅방 참여에 실패했습니다 ");
						return;
					}
				}
			}
			else if(command[0].contentEquals("나가기"))
			{
				if(currentState.get(userID) == 3)
				{
					if(myChatRoom.currentUserCount == 1) {
						waitingRoomOutMap.put(userID, out);
						currentState.replace(userID, 1);
						out.println(" ▶ 채팅방이 사라졌습니다.");
						chatRoomList.remove(myChatRoom);
						printNoticeMsg(out, 2);
						return;
					}
					waitingRoomOutMap.put(userID, out);
					myChatRoom.chatRoomMember.remove(userID);
					myChatRoom.currentUserCount--;
					currentState.replace(userID, 1);
					myChatRoom.sendChatRoomMsg(""," ▶ " + userID + " 님이 채팅방을 나갔습니다.", myChatRoom.chatRoomMember);
					out.println(" ▶ 채팅방을 나왔습니다.");
					printNoticeMsg(out, 2);
				}
			}
			else if(command[0].contentEquals("강퇴"))
			{
				PrintWriter it_out = (PrintWriter)clientOutMap.get(command[1]);
				if(currentState.get(userID) == 3 && myChatRoom.chatRoomLeader.equals(userID))
				{
					waitingRoomOutMap.put(command[1], it_out);
					myChatRoom.chatRoomMember.remove(command[1]);
					myChatRoom.currentUserCount--;
					currentState.replace(command[1], 1);
					myChatRoom.sendChatRoomMsg(""," ▶ " + command[1] + " 님이 강퇴당했습니다.", myChatRoom.chatRoomMember);
					it_out.println(" ▶ 채팅방에서 강퇴당했습니다.");
					printNoticeMsg(it_out, 2);
				}
				else
					out.println(" ▶ 채팅방 방장만 사용가능한 명령어 입니다  ");
			}
			else if(command[0].contentEquals("영구강퇴"))
			{
				PrintWriter it_out = (PrintWriter)clientOutMap.get(command[1]);
				if(currentState.get(userID) == 3 && myChatRoom.chatRoomLeader.equals(userID))
				{
					myChatRoom.blockedUserList.add(command[1]);
					waitingRoomOutMap.put(command[1], it_out);
					myChatRoom.chatRoomMember.remove(command[1]);
					myChatRoom.currentUserCount--;
					currentState.replace(command[1], 1);
					myChatRoom.sendChatRoomMsg(""," ▶ "  + command[1] + " 님이 영구강퇴 당했습니다 ", myChatRoom.chatRoomMember);
					it_out.println(" ▶ 채팅방에서 강퇴당했습니다.");
					printNoticeMsg(it_out, 2);
				}
				else
					out.println(" ▶ 채팅방 방장만 사용가능한 명령어 입니다  ");
			}
			else if(command[0].contentEquals("방장"))
			{
				if(currentState.get(userID) == 3 && myChatRoom.chatRoomLeader.equals(userID))
				{
					myChatRoom.chatRoomLeader = command[1];
					myChatRoom.sendChatRoomMsg(""," ▶ " + command[1] + " 님이 방장이 되었습니다", myChatRoom.chatRoomMember);
				}
				else
					out.println(" ▶ 채팅방 방장만 사용가능한 명령어 입니다  ");
			}
			else if(command[0].contentEquals("방폭파"))
			{
				if(currentState.get(userID) == 3 && myChatRoom.chatRoomLeader.equals(userID))
				{					 
					for(String s : myChatRoom.chatRoomMember.keySet())
					{						
						PrintWriter it_out = (PrintWriter)clientOutMap.get(s);
						printNoticeMsg(it_out, 3);
						printNoticeMsg(it_out, 2);
						it_out.println(" ▶ /명령어 : 사용가능한 명령어 목록을 볼 수 있습니다.");
						waitingRoomOutMap.put(s, it_out);
						currentState.replace(s, 1);
					}
					chatRoomList.remove(myChatRoom);
				}
				else
					out.println(" ▶ 채팅방 방장만 사용가능한 명령어 입니다  ");
			}
			else if(command[0].contentEquals("회원목록") && userType == 1 )
			{
				addminMenu.showClientInfo();
			}
			else if(command[0].contentEquals("금칙어") && userType == 1 )
			{
				addminMenu.showBannedWords();
			}
			else if(command[0].contentEquals("추가") && userType == 1 )
			{
				addminMenu.addBannedWords(command[1]);
			}
			else if(command[0].contentEquals("ID") && userType == 1 )
			{
				addminMenu.addIDBlackList(command[1]);
			}
			else if(command[0].contentEquals("IP") && userType == 1 )
			{
				addminMenu.addIPBlackList(command[1]);
			}
			else if(command[0].contentEquals("명령어"))
			{

				out.println(" ──────────────────   대기실 명령어   ─────────────────────");
				out.println(" ▶ /q: 채팅을 종료합니다.");
				out.println(" ▶ /to [상대ID] [내용]: 상대에게 1회 귓속말을 보냅니다.");
				out.println(" ▶ /to [상대방ID]: 상대방에게 귓속말이 고정됩니다. ");
				out.println(" ▶ /to : 귓속말 고정이 해제됩니다.");
				out.println(" ▶ /방만들기 : 공개 채팅방을 만들 수 있습니다.");
				out.println(" ▶ /비밀방만들기 : 비밀 채팅방을 만들 수 있습니다.");
				out.println(" ▶ /채팅방목록 : 전체 채팅방 목록을 보여줍니다.");
				out.println(" ▶ /공개방목록 : 공개 채팅방 목록을 보여줍니다.");
				out.println(" ▶ /비밀방목록 : 비밀 채팅방 목록을 보여줍니다.");
				out.println(" ▶ /list : 현재 접속해 있는 모든 사용자 목록을 보여줍니다.");
				out.println(" ▶ /대기실사용자 : 현재 대기실에 사용자 목록을 보여줍니다.");
				out.println(" ▶ /참가 [채팅방이름] : 지정한 채팅방에 참여합니다.");
				out.println(" ──────────────────   채팅방 명령어   ─────────────────────");
				out.println(" ▶ /채팅방사용자 : 현재 채팅방 사용자 목록을 보여줍니다.");
				out.println(" ▶ /나가기 : 현재 채팅방에서 대기실로 돌아갑니다.");
				out.println(" ───────────────────   방장 명령어   ──────────────────────");
				out.println(" ▶ /초대 [상대방ID] : 채팅방 초대 메세지를 보냅니다.");
				out.println(" ▶ /강퇴 [상대방ID] : 강제로 대기실로 내보냅니다.");
				out.println(" ▶ /영구강퇴 [상대방ID] : 영구적으로 채팅방에서 차단합니다.");
				out.println(" ▶ /방장 [상대방ID] : 상대방을 방장으로 만듭니다.");
				out.println(" ▶ /방폭파: 채팅방을 없애고 참가자들은 대기실로 돌아갑니다.");
				out.println(" ──────────────────────────────────────────────────────────");
			}
			else
				out.println(" ▶ 명령어 사용이 잘못되었습니다 ");
		}
	}
}
