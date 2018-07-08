package uim.security;
import java.sql.*;

public class UserAuthentication {
	
	private String Logon;
	private boolean LoggedIN;

public boolean Auth(String LoginID, String LogonPasscode)
{
	try
	{
		Connection conn = DriverManager.getConnection("" + "user=root&password=admin");
		Statement stmt = conn.createStatement();
		String drbyConn = "Select security from Identity where UserID = '"+LoginID+"' and Password = '"+LogonPasscode+"'";
		ResultSet rs= stmt.executeQuery(drbyConn);

		while (rs.next() == true)
		{	
		LoggedIN = rs.getString("security").equals("1");

			if (LoggedIN)
			{
				System.out.println("Validated! Your access id Granted");
				this.Logon = LoginID;
			}
			else
			{
				System.out.println("Incorrect Password! Please check your UserID / Password and try again later");
			}	
			}
			return LoggedIN;
		}

		catch (SQLException ex) 
		{
				   
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
		}
		return LoggedIN;
	}

public String getLogon() 
{
		return Logon;
}

public boolean isLoggedIN() 
{
		return LoggedIN;
}

}

