package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUp2 extends JFrame implements ActionListener
{
	JTextField pan, aadhar;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox religion,category,income,occupation,education;
	String formno;
	
	public SignUp2(String formno) 
	{
		this.formno = formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel rel = new JLabel("Religion:");
		rel.setFont(new Font("Raleway", Font.BOLD, 20));
		rel.setBounds(100, 140, 100, 30);
		add(rel);
		
		String valReligion[] = {"Hindu", "Muslim", "Christian", "Other"};
		religion = new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		JLabel categories = new JLabel("Category:");
		categories.setFont(new Font("Raleway", Font.BOLD, 20));
		categories.setBounds(100, 190, 200, 30);
		add(categories);
		
		String valCaregory[] = {"General","OBC", "SC", "ST", "Other"};
		category = new JComboBox(valCaregory);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);
		
		JLabel incm = new JLabel("Income:");
		incm.setFont(new Font("Raleway", Font.BOLD, 20));
		incm.setBounds(100, 240, 200, 30);
		add(incm);
		
		String valIncome[] = {"Null","< 1,50,000", "< 2,50,0000", "< 5,00,000", "Uptp 10,00,000"};
		income = new JComboBox(valIncome);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
		
		JLabel edu = new JLabel("Educational");
		edu.setFont(new Font("Raleway", Font.BOLD, 20));
		edu.setBounds(100, 290, 200, 30);
		add(edu);
		
		JLabel quf = new JLabel("Qualification:");
		quf.setFont(new Font("Raleway", Font.BOLD, 20));
		quf.setBounds(100, 315, 200, 30);
		add(quf);
		
		String educationalValues[] = {"Non-Graduation","Graduate", "Post-Graduate", "Doctrate", "Others"};
		education = new JComboBox(educationalValues);
		education.setBounds(300, 315, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);
		
		JLabel occp = new JLabel("Occupation:");
		occp.setFont(new Font("Raleway", Font.BOLD, 20));
		occp.setBounds(100, 390, 200, 30);
		add(occp);
		
		String occupationalValues[] = {"Salaried","Self-Employed", "Bussiness", "Student", "Retired", "Others"};
		occupation = new JComboBox(occupationalValues);
		occupation.setBounds(300, 390, 400, 30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		JLabel panNo = new JLabel("PAN Number:");
		panNo.setFont(new Font("Raleway", Font.BOLD, 20));
		panNo.setBounds(100, 440, 200, 30);
		add(panNo);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		JLabel aadharNo = new JLabel("Aadhar Number:");
		aadharNo.setFont(new Font("Raleway", Font.BOLD, 20));
		aadharNo.setBounds(100, 490, 200, 30);
		add(aadharNo);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);
		
		JLabel sc = new JLabel("Senior Citizen:");
		sc.setFont(new Font("Raleway", Font.BOLD, 20));
		sc.setBounds(100, 540, 200, 30);
		add(sc);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup scitizengroup = new ButtonGroup();
		scitizengroup.add(syes);
		scitizengroup.add(sno);		
		
		JLabel eaccount = new JLabel("Existing Account:");
		eaccount.setFont(new Font("Raleway", Font.BOLD, 20));
		eaccount.setBounds(100, 590, 200, 30);
		add(eaccount);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup eAccountGroup = new ButtonGroup();
		eAccountGroup.add(eyes);
		eAccountGroup.add(eno);	
		
		JButton next = new JButton("Next");
		next.setBackground(Color.cyan);
		next.setForeground(Color.MAGENTA);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 800);
		setLocation(500, 80);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		String sreligion = (String)religion.getSelectedItem();
		String scategory = (String)category.getSelectedItem();		
		String sincome = (String)income.getSelectedItem();
		String seducation = (String)education.getSelectedItem();
		String soccupation = (String)occupation.getSelectedItem();
		String seniorcitizen = null;
		if (syes.isSelected())
		{
			seniorcitizen = "Yes";
		}
		else if (sno.isSelected())
		{
			seniorcitizen = "No";
		}
		String existingaccount = null;
		if (eyes.isSelected())
		{
			existingaccount = "Yes";
		}
		else if (eno.isSelected())
		{
			existingaccount = "No";
		}
		
		String span = pan.getText();
		String saadhar = aadhar.getText();
		
		try 
		{
			Connect c = new Connect();
			String query = "insert into signuptwo values('"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
			c.s.executeUpdate(query);
			
			//signup3 object
			setVisible(false);
			new SignUp3(formno).setVisible(true);
		}
		catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) 
	{
		new SignUp2("");
	}

}
