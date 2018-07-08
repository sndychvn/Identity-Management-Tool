package uim.connection;

import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnection 
{
	String url;
	static Connection con = null;
	
	
	
	
	public DatabaseConnection(String url) {
		super();
		this.url = url;
	}
	public static Connection getConnection() throws IOException, ClassNotFoundException{
		
		try {
			Properties prop = new Properties();
			InputStream input = null;
			//read and load the properties file
			input = new FileInputStream(System.getProperty("user.dir") + "/src/uim/connection/connection.properties");
			prop.load(input);
			try {
				Class.forName(prop.getProperty("CLASS_NAME")).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			con=DriverManager.getConnection(  
					prop.getProperty("URL"),prop.getProperty("USERNAME"),prop.getProperty("PASSWORD"));
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}  
			 
		return con; 
		
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}  
	}

}
