import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class ChatRoom extends ChatServer{
		int maxUserCount;
		PrintWriter out;
		BufferedReader in;
		int currentUserCount;
		boolean isSecretRoom;
		String chatRoomName;
		String chatRoomLeader;
		String chatRoomPassword;
		List<String> blockedUserList;
		Map<String, PrintWriter> chatRoomMember;
		
		public ChatRoom(PrintWriter output, BufferedReader readin)
		{
			chatRoomMember = new HashMap<String, PrintWriter>();
			out = output;
			in = readin;
		}
			
		public ChatRoom(String userID, String chatRoomName, int maxUserCount, PrintWriter out)
		{
			blockedUserList = new ArrayList<String>();
			chatRoomMember = new HashMap<String, PrintWriter>();
			this.chatRoomName = chatRoomName;
			this.maxUserCount = maxUserCount;
			currentUserCount = 1;
			isSecretRoom = false;
		}
			
		public ChatRoom(String userID,String chatRoomName, int maxUserCount, String chatRoomPassword, PrintWriter out)
		{
			blockedUserList = new ArrayList<String>();
			chatRoomMember = new HashMap<String, PrintWriter>();
			this.chatRoomName = chatRoomName;
			this.chatRoomPassword = chatRoomPassword;
			this.maxUserCount = maxUserCount;
			currentUserCount = 1;
			isSecretRoom = true;
		}
		
		public void sendChatRoomMsg(String userID, String msg, Map<String, PrintWriter> chatRoomMember) 
		{
			LocalTime present = LocalTime.now();	
			Iterator<String> it = chatRoomMember.keySet().iterator();
			msg = filterMsg(msg, userID);
			while(it.hasNext()) {
				try {
					PrintWriter it_out = (PrintWriter)chatRoomMember.get(it.next());
					if (userID.equals(""))
						it_out.println(" [" + this.chatRoomName + "] " + msg);
					else
						it_out.println(" [" + this.chatRoomName + "] " + userID + " : " + msg + "  [" + present.getHour() + ":" + present.getMinute() + "]");
				} catch (Exception e) {
					System.out.println(" ▷ 채팅방 메시지 전송 실패");
				}
			}						
		}
			
		public ChatRoom createPublicChatRoom(String userID, PrintWriter out, BufferedReader in) 
		{
			String name = "";
			int maxP = 5; // default value
			ChatRoom pChatRoom = null;
			while(true) {
			try {
				out.println(" ▶ 채팅방 이름을 입력하세요 ");
				name = in.readLine();
				out.println(" ◁ [채팅방 이름] : " + name);
				
				out.println(" ▶ 채팅방 인원을 입력하세요 ");
				maxP = readInt(in, out);
				out.println(" ◁ [채팅방 인원] : " + maxP);
				
				pChatRoom = new ChatRoom(userID, name, maxP, out);
				pChatRoom.chatRoomLeader = userID;	
				break;
				} catch (Exception e) {
					out.println(" ▶ 채팅방 만들기에 실패했습니다 ");
					continue;
				}
			}
			return pChatRoom;
		}

		public ChatRoom createSecretChatRoom(String userID, PrintWriter out, BufferedReader in) 
		{
			String name = "";
			String password = "";
			ChatRoom sChatRoom = null;
			int maxP = 5; // default value
			try {
				out.println(" ▶ 채팅방 이름을 입력하세요 ");
				name = in.readLine();
				out.println(" ◁ [채팅방 이름] : " + name);
				
				out.println(" ▶ 채팅방 인원을 입력하세요 ");
				maxP = readInt(in, out);
				out.println(" ◁ [채팅방 인원] : " + maxP);
				
				out.println(" ▶ 채팅방 암호를 입력하세요 ");
				password = in.readLine();
				out.println(" ◁ [채팅방 암호] : " + password);
				
				sChatRoom = new ChatRoom(userID, name,  maxP, password, out);
				super.chatRoomList.add(sChatRoom);
				sChatRoom.chatRoomLeader = userID;	
				} catch (Exception e) {
					out.println(" ▶ 채팅방 만들기에 실패했습니다 ");
					return sChatRoom;
				}
			return sChatRoom;
		}
		
		public int readInt(BufferedReader in, PrintWriter out )
		{
			String getInt = "";
			int parsedInt = 0;
			boolean isNumString = true;
			while(true)
			{
				try 
				{
					getInt = in.readLine();
					for(int i = 0 ; i < getInt.length(); i ++)
					{    
						// ASCII 48 ~ 57 : 0 ~ 9
						if(48 <= getInt.charAt(i) && getInt.charAt(i) <= 57)
							getInt += getInt.charAt(i);
						else
						{
							out.println(" ▶ 숫자만 입력해주세요 ");
							isNumString = false;
							break;
						}
					}
					if(!isNumString)
						continue;
					else
					{
						parsedInt = Integer.parseInt(getInt);
						break;
					}
				} catch (Exception e) {
					out.println(" ▶ 잘못된 입력입니다\n   기본값 5명으로 생성됩니다. ");
					return 5;
				}
			}
			return parsedInt;
		}
	}