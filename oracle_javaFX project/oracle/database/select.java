package database;

import java.sql.*;

public class select {
	
	public static void selecte() throws Exception{
		
		Connection conn = connect.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM users ");
		
		System.out.println("USER ID  |  NAME     |   PASSWORD");
		System.out.println("=================================");
		
		while(rs.next()) {
		int id = rs.getInt("user_id");
		String name = rs.getString("name");
		String pass = rs.getString("pass");
		
		System.out.println(id + "        |  " + name + "  |    " + pass);
		}
		
		st.close();
		conn.close();
		
	}
	
	

}
