package bankmanagementsystem;

import java.sql.*;

public class Connect 
{

	Connection c;
	Statement s;
	public Connect() 
	{
		try {
//			Class.forName(com.mysql.cj.jdbc.Driver);
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "12345");
			s = c.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
