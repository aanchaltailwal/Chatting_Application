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
