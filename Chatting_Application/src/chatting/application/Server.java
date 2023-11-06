package chatting.application;


import javax.swing.*;            //for frame
import java.awt.*;               //handling features of frame

public class Server extends JFrame {           //class
	Server(){                                //constructor
		
		setLayout(null);                     //set components of frame
		
		JPanel p1 = new JPanel(); //for things above frame
		p1.setBackground(new Color(7, 94, 84));
		p1.setBounds(0, 0, 450, 70);
		add(p1);
		
		
		setSize(450, 700);                  //size of a frame
		setLocation(200, 50);                //frame location
		getContentPane().setBackground(Color.WHITE);     //frame color
		
		
		
		
		setVisible(true);                    //frame visibility
		
	}
	public static void main(String[] args) {
		new Server();                         //object
		
	}
}
