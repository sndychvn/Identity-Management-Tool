package test.uim.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class test_database 
{
	public static void main(String[] args) throws Exception 
	{
		final Connection connection = getConnection();
		final PreparedStatement pstmt = connection.prepareStatement("INSERT INTO IDENTITIES (IDENTITY_USERNAME, IDENTITY_USERID, IDENTITY_EMAILID,IDENTITY_COUNTRY,IDENTITY_DATEOFBIRTH) VALUES (?, ?, ?, ?, ?)");
		pstmt.setString(1, "Antoine Griezmann");
		pstmt.setString(2, "Francais");
		pstmt.setString(3, "griezmann@gmail.com");
		pstmt.setString(4, "France");
		pstmt.setString(5, "March 21 1991");
		pstmt.execute();
		pstmt.close();
		connection.close();
	}	


	private static Connection getConnection() throws SQLException
	{
		final String url = "jdbc:derby://localhost:1527/sample;create=true";
		Connection connection = null;

		connection = DriverManager.getConnection(url,"test","test");
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
