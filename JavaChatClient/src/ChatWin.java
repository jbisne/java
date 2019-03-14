import java.io.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class ChatWin extends JFrame {

	private static final long serialVersionUID = 1L;
    JTextField tf;
    JPanel p;
    TextHandler handler = null;

	Socket socket;
	PrintWriter out = null;
   	
	ChatWin(Socket socket) {
		
	    this.setTitle("Chat Window");
	    this.setSize(600, 100);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    p = new JPanel();
	    p.setLayout(new FlowLayout());
	    
	    tf = new JTextField(40);
	    p.add(tf);
	    
	    this.setContentPane(p);
	    this.setVisible(true);

		handler = new TextHandler();
		tf.addActionListener(handler);

	    this.socket = socket;        
        try {
			out = new PrintWriter(this.socket.getOutputStream(), true);
        } catch(Exception e) {
        	printEndComment();
        }
	}

	class TextHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String msg = tf.getText();
			if ("".equals(msg)) return;
			
			if ( msg.equals("/q") ) {
				try {
					out.close();
					socket.close();
				} catch (IOException e1) {
					printEndComment();
					return;
				}
			} else {
				try {
					out.println(msg);
				} catch (Exception e2) {
					printEndComment();
					try {
						out.close();
						socket.close();
					} catch (Exception e3) {
						return;
					}
					return;
				}
			}
	        tf.setText("");
		}
	}
	
	public void printEndComment() {
		System.out.println("┌─────────────────────┐");
		System.out.println("│채팅이 종료되었습니다│");
		System.out.println("└─────────────────────┘");
	}
}
