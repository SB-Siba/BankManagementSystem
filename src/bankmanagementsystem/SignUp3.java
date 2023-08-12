package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class SignUp3 extends JFrame implements ActionListener
{
	JRadioButton savingAccount,currentAccount,fixedDeposit,recurringDeposit;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	
	SignUp3(String formno)
	{
		this.formno = formno;
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);
		
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway", Font.BOLD, 22));
		type.setBounds(100, 140, 200, 30);
		add(type);
		
		savingAccount = new JRadioButton("Saving Account");
		savingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
		savingAccount.setBackground(Color.WHITE);
		savingAccount.setBounds(100, 180, 150, 20);
		add(savingAccount);
		
		fixedDeposit = new JRadioButton("Fixed Deposit Account");
		fixedDeposit.setFont(new Font("Raleway", Font.BOLD, 16));
		fixedDeposit.setBackground(Color.WHITE);
		fixedDeposit.setBounds(350, 180, 250, 20);
		add(fixedDeposit);
		
		currentAccount = new JRadioButton("Current Account");
		currentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
		currentAccount.setBackground(Color.WHITE);
		currentAccount.setBounds(100, 220, 160, 20);
		add(currentAccount);
		
		recurringDeposit = new JRadioButton("Recurring Deposit Account");
		recurringDeposit.setFont(new Font("Raleway", Font.BOLD, 16));
		recurringDeposit.setBackground(Color.WHITE);
		recurringDeposit.setBounds(350, 220, 250, 20);
		add(recurringDeposit);
		
		ButtonGroup account = new ButtonGroup();
		account.add(savingAccount);
		account.add(fixedDeposit);
		account.add(currentAccount);
		account.add(recurringDeposit);
		
		JLabel card = new JLabel("Card Number");
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(100, 300, 200, 30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
		number.setFont(new Font("Raleway", Font.BOLD, 22));
		number.setBounds(330, 300, 300, 30);
		add(number);
		
		JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
		cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
		cardDetail.setBounds(100, 330, 300, 20);
		add(cardDetail);
		
		JLabel pin = new JLabel("Card Number");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100, 370, 200, 30);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
		pnumber.setBounds(330, 370, 300, 30);
		add(pnumber);
		
		JLabel pinDetail = new JLabel("Your 4 Digit pin");
		pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
		pinDetail.setBounds(100, 400, 200, 30);
		add(pinDetail);
		
		JLabel services = new JLabel("Services Required");
		services.setFont(new Font("Raleway", Font.BOLD, 22));
		services.setBounds(100, 450, 400, 30);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD,16));
		c1.setBounds(100, 500, 200, 30);
		add(c1);

		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD,16));
		c2.setBounds(100, 550, 200, 30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD,16));
		c3.setBounds(100, 500, 200, 30);
		add(c3);
		
		c4 = new JCheckBox("EMAIL & SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD,16));
		c4.setBounds(350, 550, 200, 30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD,16));
		c5.setBounds(100, 600, 200, 30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.BOLD,16));
		c6.setBounds(350, 600, 200, 30);
		add(c6);
		
		c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.BOLD,12));
		c7.setBounds(100, 680, 600, 30);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.cyan);
		submit.setForeground(Color.MAGENTA);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(250, 730, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBackground(Color.cyan);
		cancel.setForeground(Color.MAGENTA);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(420, 730, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 850);
		setLocation(500, 80);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == submit) 
		{
			String accountType = null;
			if (savingAccount.isSelected())
			{
				accountType = "Saving Account";
			}
			else if (fixedDeposit.isSelected())
			{
				accountType = "Fixed Diposit Account";
			}
			else if (currentAccount.isSelected())
			{
				accountType = "Current Account";
			}
			else if (recurringDeposit.isSelected())
			{
				accountType = "Recurring Diposit Account";
			}
			
			Random random = new Random();
			String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
			
			String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			
			String facility = "";
			if (c1.isSelected()) 
			{
				facility = facility + " ATM Card";
			}
			else if (c2.isSelected())
			{
				facility = facility + " Internet Banking";			
			}
			else if (c3.isSelected()) 
			{
				facility = facility + " Mobile Banking";
			}
			else if (c4.isSelected()) 
			{
				facility = facility + " EMAIL & SMS Alerts";
			}
			else if (c5.isSelected()) 
			{
				facility = facility + " Cheque Book";
			}
			else if (c6.isSelected()) 
			{
				facility = facility + " E-Statement";
			}
			
			try {
				if (accountType.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}
				else
				{
					Connect connect = new Connect();
					String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
					String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
					connect.s.executeUpdate(query1);
					connect.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pinNumber);
					setVisible(false);
					new Deposit(pinNumber).setVisible(false);
					
				}
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
		else if (e.getSource() == cancel) 
		{
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	public static void main(String[] args) 
	{
		new SignUp3("");
	}
}
