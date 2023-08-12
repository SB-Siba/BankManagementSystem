package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener
{
	
	JButton deposit,withdrawl,statement,pinChange,fastCash,balanceEnquiry,exit;
	String pinNumber;
	Transactions(String pinNumber)
	{
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(215, 320, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 450, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(350, 450, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(170, 487, 150, 30);
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		statement = new JButton("Mini Statement");
		statement.setBounds(350, 487, 150, 30);
		statement.addActionListener(this);
		image.add(statement);
		
		pinChange = new JButton("Pin Change");
		pinChange.setBounds(170, 523, 150, 30);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(350, 523, 150, 30);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(350, 560, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900, 900);
		setLocation(500, 100);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == exit) 
		{
			System.exit(0);
		}
		else if (e.getSource() == deposit) 
		{
			new Deposit(pinNumber).setVisible(true);
		}
		else if (e.getSource() == withdrawl) 
		{
			setVisible(false);
			new Withdrawl(pinNumber).setVisible(true);
		}
		else if (e.getSource() == fastCash) 
		{
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}
		else if (e.getSource() == pinChange) 
		{
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}
		else if (e.getSource() == balanceEnquiry)
		{
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}
		else if (e.getSource() == statement) 
		{
			setVisible(false);
			new MiniStatement(pinNumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) 
	{
		new Transactions("");
	}
}
