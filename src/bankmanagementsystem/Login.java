package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
	JButton login,clear,signup,exit;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	public Login() 
	{
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/UN.png"));
		Image i2 = i1.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(120, 10, 150, 100);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(250, 40, 400, 40);
		add(text);
		
		JLabel cardNo = new JLabel("Card No:");
		cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
		cardNo.setBounds(200, 150, 400, 40);
		add(cardNo);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(340, 158, 250, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);
		
		JLabel pin = new JLabel("Pin:");
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		pin.setBounds(200, 220, 400, 40);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(340, 220, 250, 30);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTextField);
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.cyan);
		login.setForeground(Color.MAGENTA);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.cyan);
		clear.setForeground(Color.MAGENTA);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.cyan);
		signup.setForeground(Color.MAGENTA);
		signup.addActionListener(this);
		add(signup);
		
		exit = new JButton("EXIT"); 
        exit.setBounds(365, 400, 100, 30); 
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this); 
        add(exit); 
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800, 600);
		setVisible(true);
		setLocation(500, 200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == clear)
		{
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if (e.getSource() == login) 
		{
			Connect connect = new Connect();
			String cartNumber = cardTextField.getText();
			String pinNumber = pinTextField.getText();
			String query = "select * from login where card_number = '" + cartNumber + "' and pin = '" + pinNumber +"'";
			try {
				ResultSet rs = connect.s.executeQuery(query);
				if (rs.next()) 
				{
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Card Number or Pin");
				}
			} catch (Exception e2) {
				System.out.println(e);
			}
		}
		else if (e.getSource() == signup) 
		{
			setVisible(false);
			new SignUp1().setVisible(true);
		}
		else if(e.getSource() == exit)
		{
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) 
	{
		new Login();
	}
}
