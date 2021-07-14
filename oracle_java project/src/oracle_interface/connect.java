package oracle_interface;


import java.sql.*;

public class connect {
	
	
	public static Connection getConnection() throws Exception{
		Connection con = null;
		try {
			String driver = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			String username = "system";
			String password = "Heaven4*4";
			
			Class.forName(driver);
			
			System.out.println(); // create a new line
			System.out.println(); // create a new line
			
			 con = DriverManager.getConnection(url, username, password);
			System.out.println("CONGRATULATIONS YOU ARE CONNECTED TO ORACLE DATABASE");
			
			System.out.println(); // create a new line
			System.out.println(); // create a new line
			
				
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return con;
	}
	
}
