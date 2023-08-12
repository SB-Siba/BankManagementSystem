package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

import com.mysql.fabric.xmlrpc.base.Data;

public class Deposit extends JFrame implements ActionListener
{
	JTextField amount;
	JButton deposit,back;
	String pinNumber;
	
	Deposit(String pinNumber)
	{
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(190, 320, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(170, 360, 320, 25);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(360, 525, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(360, 560, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setLocation(500, 100);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == deposit) 
		{
			String number = amount.getText();
			Date date = new Date();
			if (number.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter the amount you eant to deposit");
			}
			else
			{
				try {
					Connect connect = new Connect();
					String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+number+"')";
					connect.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				} catch (Exception e2) {
					System.out.println(e);
				}
			}
		}
		else if (e.getSource() == back) 
		{
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) 
	{
		new Deposit("");
	}
}
