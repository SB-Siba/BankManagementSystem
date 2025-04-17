package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

import com.mysql.fabric.xmlrpc.base.Data;

public class Withdrawl extends JFrame implements ActionListener
{
	JTextField amount;
	JButton withdraw,back;
	String pinNumber;
	//Object is created because we have to use another class variable(non-static) in this class
	BalanceEnquiry bala = new BalanceEnquiry(pinNumber);
	
	Withdrawl(String pinNumber)
	{
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(190, 320, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(170, 360, 320, 25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(360, 525, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
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
		if (e.getSource() == withdraw) 
		{
			String number = amount.getText();
			Date date = new Date();
			
			if (number.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter the amount you eant to deposit");
			}
			else
			{
				int num1 = Integer.parseInt(number);
				try {
					Connect connect = new Connect();
					String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+number+"')";
					if (num1<bala.balance) {
							connect.s.executeUpdate(query);
							JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawal Successfully");
							setVisible(false);
							new Transactions(pinNumber).setVisible(true);
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Insufficient Balance");
					}
					
				} catch (Exception e2) {
					System.out.println(e2);
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
		new Withdrawl("");
	}
}
