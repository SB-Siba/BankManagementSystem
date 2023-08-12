package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;

import javax.swing.*;

public class MiniStatement extends JFrame
{
	MiniStatement(String pinNumber)
	{
		setTitle("Mini Statement");
		
		setLayout(null);
		
		JLabel mini = new JLabel();
		add(mini);
		
		JLabel bank = new JLabel("Union Bank of India");
		bank.setFont(new Font("Raleway", Font.BOLD, 20));
		bank.setBounds(100, 20, 200, 20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20, 400, 300, 20);
		add(balance);
		
		try {
			Connect connect = new Connect();
			ResultSet rs = connect.s.executeQuery("select * from login where pin = '"+pinNumber+"'");
			while (rs.next()) 
			{
				card.setText("Card Number: " + rs.getString("card_number").substring(0, 4) + "xxxxxxxx" + rs.getString("card_number").substring(12));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Connect connect = new Connect();
			int bal = 0;
			ResultSet rs = connect.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
			while (rs.next()) 
			{
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
				if (rs.getString("type").contentEquals("Deposit")) 
				{
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else
				{
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your current account balance is Rs " + bal);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		mini.setBounds(20, 140, 400, 200);
		
		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new MiniStatement("");
	}
}
