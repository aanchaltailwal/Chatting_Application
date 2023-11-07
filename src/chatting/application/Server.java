package chatting.application;


import javax.swing.*;            //for frame
import java.awt.*;               //handling features of frame
import java.awt.event.*;         //for actionlistener


public class Server extends JFrame implements ActionListener {           //class
	Server(){                                //constructor
		
		setLayout(null);                     //set components of frame
		
		JPanel p1 = new JPanel(); //for things above frame
		p1.setBackground(new Color(7, 94, 84));
		p1.setBounds(0, 0, 450, 70);
		p1.setLayout(null);
		add(p1);
		
		
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
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));  
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
		
		JLabel name = new JLabel("Abhinav");    //adding name of the person
		name.setBounds(110, 15, 100, 18);
		name.setForeground(Color.white);           //changing txt clr
		name.setFont(new Font("SAN_SRRIF", Font.BOLD, 18));    //font
		
		
		
		p1.add(name);
		
		setSize(450, 700);                  //size of a frame
		setLocation(200, 50);                //frame location
		getContentPane().setBackground(Color.WHITE);     //frame color
		
		
		
		
		setVisible(true);                    //frame visibility	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	public static void main(String[] args) {
		new Server();                         //object
		
	}
}
