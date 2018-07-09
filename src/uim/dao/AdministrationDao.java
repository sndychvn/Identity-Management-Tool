package uim.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uim.connection.DatabaseConnection;

public class AdministrationDao {
	
	static boolean session = false;
	static Connection con = getDaoConnection();
	
	//static Connection getDaoConnection() {
		try {
			try {
				con = DatabaseConnection.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return con;
	}
	
 public static boolean getAccess(String userName, String password)
	{
		String sql = "Select * from Administration where adminID = '"+userName + "' and pass = '" + password + "'";

		try {
			Statement stmt=con.createStatement();
			
			ResultSet set = stmt.executeQuery(sql);
			//System.out.println(set);
			boolean ans = set.next();
			if(ans) session = true;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return session;
		} 
		return session;
	}
	
	
	
}