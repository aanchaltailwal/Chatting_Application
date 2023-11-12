package chatting.application;

import javax.swing.*;            //for frame
import javax.swing.border.*;
import java.awt.*;               //handling features of frame
import java.awt.event.*;         //for actionlistener
import java.util.*;              //for calender
import java.text.*;
import java.net.*;                 
import java.io.*;

public class Client implements ActionListener {           //class
	
	JTextField text;        //declaring this globally so that could be used in func also but not only in constructor
	static JPanel a1;
	static Box vertical = Box.createVerticalBox();   //so sending msgs should be in that box only
	
	static JFrame f = new JFrame();
	
	static DataOutputStream dout;
	
	Client(){                                //constructor
		
		f.setLayout(null);                     //set components of frame
		
		JPanel p1 = new JPanel(); //for things above frame
		p1.setBackground(new Color(7, 94, 84));
		p1.setBounds(0, 0, 450, 70);
		p1.setLayout(null);
		f.add(p1);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));  //for image
		Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);     //scale the image or set it
		ImageIcon i3 = new ImageIcon(i2);    //obj of imgicon n have to cnvrt img into imgicon
		JLabel back = new JLabel(i3);
		back.setBounds(5, 20, 25, 25);
		p1.add(back);                 //uh'll have to add img above the p1 panel
		 
		
		back.addMouseListener(new MouseAdapter() {         //if click back button
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);           //if exit return back
			}
		});
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));  
		Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);     
		ImageIcon i6 = new ImageIcon(i5);    
		JLabel profile = new JLabel(i6);
		profile.setBounds(40, 10, 50, 50);
		p1.add(profile);  
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));  
		Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);     
		ImageIcon i9 = new ImageIcon(i8);    
		JLabel video = new JLabel(i9);
		video.setBounds(300, 20, 30, 30);
		p1.add(video); 
		
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));  
		Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);     
		ImageIcon i12 = new ImageIcon(i11);    
		JLabel phone = new JLabel(i12);
		phone.setBounds(360, 20, 35, 30);
		p1.add(phone); 
		
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));  
		Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);     
		ImageIcon i15 = new ImageIcon(i14);    
		JLabel morevert = new JLabel(i15);
		morevert.setBounds(420, 20, 10, 25);
		p1.add(morevert);
		
		JLabel name = new JLabel("Synthia");    //adding name of the person
		name.setBounds(110, 15, 100, 18);
		name.setForeground(Color.white);           //changing txt clr
		name.setFont(new Font("SAN_SRRIF", Font.BOLD, 18));    //font
		p1.add(name);
		
		JLabel status = new JLabel("Active Now");    
		status.setBounds(110, 35, 100, 18);
		status.setForeground(Color.white);           
		status.setFont(new Font("SAN_SRRIF", Font.BOLD, 12));    
		p1.add(status);
		
		//different panel for chatting msgs part
		
		a1 = new JPanel();   
		a1.setBounds(5, 75, 440, 570);
		f.add(a1);
		
		text = new JTextField();   //text box for writing msgs
		text.setBounds(5, 655, 310, 40);
		text.setFont(new Font("SAN_SRRIF", Font.PLAIN, 16));
		f.add(text);
		
		JButton send = new JButton("Send");       //for send button
		send.setBounds(320, 655, 123, 40);
		send.setBackground(new Color(7, 94, 84));
		send.setForeground(Color.WHITE);
		send.addActionListener(this);             //what to do if click on send button
		send.setFont(new Font("SAN_SRRIF", Font.PLAIN, 16));
		f.add(send);
		
		
		f.setSize(450, 700);                                //size of a frame
		f.setLocation(800, 50);                            //frame location
		f.setUndecorated(true);                             //for removing the upper part of page
		f.getContentPane().setBackground(Color.WHITE);     //frame color
		f.setVisible(true);                    //frame visibility	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		try {
			String out = text.getText();              //for giving the same text uh are typinf on text box
			
			
			JPanel p2 = formatLabel(out);                 //cauze you can add panel here but not string 
	
			
			a1.setLayout(new BorderLayout());
			JPanel right = new JPanel(new BorderLayout());
			right.add(p2, BorderLayout.LINE_END); //above panel could be move right side, also msgs will be aligned vertically
			vertical.add(right);        //and if many msgs they will be aligned vertically one by one
			vertical.add(Box.createVerticalStrut(15));    //15 is space b/w two msgs
			
			a1.add(vertical, BorderLayout.PAGE_START);    //msg should be from page start
			
			dout.writeUTF(out);     //send msg to server
			
			text.setText("");         //for empting the box after sending the msg
			
			f.repaint();    //we'll have to repaint the obj so that we can see the reloaded text we are typing
			f.invalidate();
			f.validate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static JPanel formatLabel(String out) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
		output.setFont(new Font("Tahoma", Font.PLAIN, 16));
		output.setBackground(new Color(37, 211, 102));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15, 15, 15, 50));
		
		
		panel.add(output);
		
		Calendar cal = Calendar.getInstance();                  //for time down of msg
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		JLabel time = new JLabel();
		time.setText(sdf.format(cal.getTime()));
		panel.add(time);
		
		return panel;
	}
	
	public static void main(String[] args) {
		new Client();                         //object
		
		try {
			Socket s = new Socket("127.0.0.1", 6001);  //ip of server and it's port
			DataInputStream din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			while(true) {
				a1.setLayout(new BorderLayout());
				String msg = din.readUTF();
				JPanel panel = formatLabel(msg);
				
				JPanel left = new JPanel(new BorderLayout());   //recieved msgs in left
				left.add(panel, BorderLayout.LINE_START);
				vertical.add(left);
				
				vertical.add(Box.createVerticalStrut(15));
				a1.add(vertical, BorderLayout.PAGE_START);
				f.validate();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
