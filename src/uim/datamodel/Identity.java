package uim.datamodel;

/**
 * <h3>Description</h3>
 * <p>This class allows to declare the input requirements from user as variables</p>
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

public class Identity {
	
	private String userName;
	private String userID;
	private String dateOfBirth;
	private String emailID;
	private String country;
	
	
	public Identity(String userName, String userID, String dateOfBirth, String emailID, String country) {
		super();
		this.userName = userName;
		this.userID = userID;
		this.dateOfBirth = dateOfBirth;
		this.emailID = emailID;
		this.country = country;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Identity [userName=" + userName + ", userID=" + userID + ", dateOfBirth=" + dateOfBirth + ", emailID="
				+ emailID + ", country=" + country + "]";
	}

	
	
	
	
	
	
	
	
	

}
