package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
	
	JButton w1,w2,w3,w4,w5,w6,back;
	String pinNumber;
	FastCash(String pinNumber)
	{
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Select withdrawal amount");
		text.setBounds(215, 320, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		w1 = new JButton("Rs 100");
		w1.setBounds(170, 450, 150, 30);
		w1.addActionListener(this);
		image.add(w1);
		
		w2 = new JButton("Rs 500");
		w2.setBounds(350, 450, 150, 30);
		w2.addActionListener(this);
		image.add(w2);
		
		w3 = new JButton("Rs 1000");
		w3.setBounds(170, 487, 150, 30);
		w3.addActionListener(this);
		image.add(w3);
		
		w4 = new JButton("Rs 2000");
		w4.setBounds(350, 487, 150, 30);
		image.add(w4);
		
		w5 = new JButton("Rs 5000");
		w5.setBounds(170, 523, 150, 30);
		w5.addActionListener(this);
		image.add(w5);
		
		w6 = new JButton("Rs 10000");
		w6.setBounds(350, 523, 150, 30);
		w6.addActionListener(this);
		image.add(w6);
		
		back = new JButton("Back");
		back.setBounds(350, 560, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setLocation(500, 100);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == back) 
		{
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		else 
		{
			String amount = ((JButton)e.getSource()).getText().substring(3); //Rs 500(text will take after R,s, ,)
			Connect connect = new Connect();
			try {
				ResultSet rs = connect.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
				int balance = 0;
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
				if (e.getSource() != back && balance < Integer.parseInt(amount)) 
				{
					JOptionPane.showMessageDialog(null, "Insuffucuent Balance...!!!");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
				connect.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully...");
				
				setVisible(false);
				new Transactions(pinNumber).setVisible(true);
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		new FastCash("");
	}
}
