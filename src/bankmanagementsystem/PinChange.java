package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener
{
	JPasswordField pin,repin;
	JButton change,back;
	String pinNumber;
	PinChange(String pinNumber)
	{
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Change Your Pin");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(270, 310, 500, 35);
		image.add(text);
		
		JLabel pinText = new JLabel("New Pin : ");
		pinText.setForeground(Color.WHITE);
		pinText.setFont(new Font("System", Font.BOLD, 16));
		pinText.setBounds(180, 370, 500, 35);
		image.add(pinText);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 15));
		pin.setBounds(310, 375, 180, 25);
		image.add(pin);
		
		JLabel repinText = new JLabel("Re-Enter Pin : ");
		repinText.setForeground(Color.WHITE);
		repinText.setFont(new Font("System", Font.BOLD, 16));
		repinText.setBounds(180, 410, 500, 35);
		image.add(repinText);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 15));
		repin.setBounds(310, 415, 180, 25);
		image.add(repin);
		
		change = new JButton("Change");
		change.setBounds(355, 525, 150, 30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("Back");
		back.setBounds(355, 560, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setLocation(500,100);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == change) 
		{
			try {
				String npin = pin.getText();
				String rpin = repin.getText();
				
				if (!npin.equals(rpin)) 
				{
					JOptionPane.showMessageDialog(null, "Pin mismatch...!!!");
					return;
				}
				
				if (npin.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Please enter your new pin");
					return;
				}
				if (rpin.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Please re-enter your pin");
					return;
				}
				Connect connect = new Connect();
				String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
				String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
				String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
			
				connect.s.executeUpdate(query1);
				connect.s.executeUpdate(query2);
				connect.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN changed successfully...");
				setVisible(false);
				new Transactions(rpin).setVisible(true);
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		else
		{
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) 
	{
		new PinChange("").setVisible(true);
	}
}
