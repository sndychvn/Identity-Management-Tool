package uim.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uim.connection.DatabaseConnection;
import uim.datamodel.Identity;
import uim.exceptions.UserCreationException;
import uim.exceptions.UserDeletionException;
import uim.exceptions.UserReadException;
import uim.exceptions.UserSearchException;
import uim.exceptions.UserUpdateException;

public class IdentityDao implements DAO{

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
	/* 
	 * @see uim.dao.DAO#CreateOperation(uim.datamodel.Identity)
	 */
	@Override
	public void CreateOperation(Identity entity) throws UserCreationException {

		try {
		      String query = "Insert into Identity (userName, userID, dateOfBirth, emailID, country) values"
		        + " (?, ?, ?, ?, ?)";

		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString (1, entity.getUserName());
		      preparedStmt.setString (2, entity.getUserID());
		      preparedStmt.setString (3, entity.getDateOfBirth());
		      preparedStmt.setString(4, entity.getEmailID());
		      preparedStmt.setString (5, entity.getCountry());

		      preparedStmt.execute();
		      

			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}  
	
	}

	/* 
	 * @see uim.dao.DAO#DeleteOperation(java.lang.String)
	 */
	@Override
	public void DeleteOperation(String userId) throws UserDeletionException {
 
		String sql = "delete from Identity where userID ="+userId;

		try {
			Statement stmt=con.createStatement();
			
			stmt.execute(sql);
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		}  
	}

	/* 
	 * @see uim.dao.DAO#UpdateOperation(uim.datamodel.Identity)
	 */
	@Override
	public void UpdateOperation(Identity entity) throws UserUpdateException {


		try {
		      String query = "Update Identity SET dateOfBirth = ?, emailID = ?, country = ? where userName = ? and userID = ?";
		        

		      // create sql insert preparedstatement
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString (4, entity.getUserName());
		      preparedStmt.setString (5, entity.getUserID());
		      preparedStmt.setString (1, entity.getDateOfBirth());
		      preparedStmt.setString(2, entity.getEmailID());
		      preparedStmt.setString (3, entity.getCountry());

		      // execute the preparedstatement
		      preparedStmt.execute();
		      

			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		}  
	}

	@Override
	public Identity getById(String id) throws UserReadException {
 
		Identity myResult;
		String sql = "Select * from Identity where userID = "+id;

		try {
			Statement stmt=con.createStatement();
			
			ResultSet set = stmt.executeQuery(sql);
			System.out.println(set);
			set.next();
			myResult = new Identity(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5));
				
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		}  

		return myResult;
		
	}

	@SuppressWarnings("null")
	@Override
	public List<Identity> search() throws UserSearchException {

		String sql = "Select * from Identity";

		List<Identity> result = new ArrayList<Identity>();
		try{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		Identity val = null;
		// Iterate through the data in the result set and display it. 

		while (rs.next()) {
		//Print one row        
		String userName, userID, dob, email, country;
		
			userName=rs.getString(1);
			userID = rs.getString(2);
			dob = rs.getString(3);
			email = rs.getString(4);
			country = rs.getString(5);
			val = new Identity(userName, userID, dob, email, country);
			System.out.println();//Move to the next line to print the next row.      
			result.add(val);
		}
		
	
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
		
	}
		

	

}