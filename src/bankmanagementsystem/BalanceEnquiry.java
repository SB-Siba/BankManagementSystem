package bankmanagementsystem;

import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.awt.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
	JButton back;
	String pinNumber;
	public int balance = 0;
	BalanceEnquiry(String pinNumber)
	{
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(355, 560, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		Connect connect = new Connect();
		
		try {
			ResultSet rs = connect.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
			while (rs.next()) 
			{
				if (rs.getString("type").contentEquals("Deposit")) 
				{
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else
				{
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your Current Account balance is Rs " + balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 320, 400, 30);
		image.add(text);
		
		setSize(900, 900);
		setLocation(500, 100);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		setVisible(false);
		new Transactions(pinNumber).setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new BalanceEnquiry("");
	}

}
