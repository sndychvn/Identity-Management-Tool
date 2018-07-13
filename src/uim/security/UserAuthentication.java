package uim.security;
import java.sql.*;

/**
 * <h3>Description</h3>
 * <p>This class allows to get the User ID and password from the user and check if provide required comments on the UI for the user</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */

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

