package uim.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DatabaseConnection 
{
	/**public static void main(String[] args) throws Exception 
	{
		final Connection connection = getConnection();
		final PreparedStatement pstmt = connection.prepareStatement("INSERT INTO IDENTITIES (IDENTITY_USERNAME, IDENTITY_USERID, IDENTITY_EMAILID,IDENTITY_COUNTRY,IDENTITY_DATEOFBIRTH) VALUES (?, ?, ?, ?, ?)");
		pstmt.setString(1, "Jean Paul");
		pstmt.setString(2, "43567");
		pstmt.setString(3, "jean@gmail.com");
		pstmt.setString(4, "France");
		pstmt.setString(5, "01-01-1991");
		pstmt.execute();
		pstmt.close();
		connection.close();
	}
	
	**/		
	private static Connection getConnection() throws SQLException
	{
		final String url = "jdbc:derby://localhost:1527/testInstance;create=true";
		Connection connection = null;
				
		connection = DriverManager.getConnection(url,"userid","password");
				return connection;
	}
	
	@SuppressWarnings("unused")
	private static void testConnection() throws Exception 
	{
			final String currentSchema = "";
			final Connection connection = getConnection();
			if (!currentSchema.equals("TEST")) 
			{
				throw new Exception("Warning: Unable to Connect");
			}
	}
}
