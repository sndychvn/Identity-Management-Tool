package uim.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uim.connection.DatabaseConnection;

/**
 * <h3>Description</h3>
 * <p>This class allows to validate the user credentials for initial logon into the application from the Table 'Administration'</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows: Connects to the database and then validates the credentials entered for the user
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */

public class AdministrationDao {
	
	static boolean session = false;
	static Connection con = getDaoConnection();
	
	static Connection getDaoConnection() {
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
			boolean ans = set.next();
			if(ans) session = true;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return session;
		} 
		return session;
	}
	
	
	
}