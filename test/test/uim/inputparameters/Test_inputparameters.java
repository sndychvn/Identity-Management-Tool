package test.uim.inputparameters;

import java.util.Map;

public class Test_inputparameters {
	private String UserName;
	private String UserID;
	private String DateofBirth;
	private String EmailID;
	private String Country;
	private Map<String, String> parameters;
	
	public Test_inputparameters(String UserName, String UserID, String DateofBirth, String EmailID, String Country)
	{
		this.UserName = UserName;
		this.UserID = UserID;
		this.DateofBirth = DateofBirth;
		this.EmailID = EmailID;
		this.EmailID = EmailID;
	}
	
	/**#public Test_inputparameters()
	#{
		
	}**/
	
	public String getUserName()
	{
		return UserName;
	}
	
	public String getUserID()
	{
		return UserID;
	}
	
	public String getEmailID()
	{
		return EmailID;
	}
	
	public String getCountry()
	{
		return Country;
	}
	
	public String getDateofBirth()
	{
		return DateofBirth;
	}
	
	public void setUserName(String UserName)
	{
		this.UserName = UserName;
	}
	
	public void setUserID(String UserID)
	{
		this.UserID = UserID;
	}
	
	public void setDateofBirth(String DateofBirth)
	{
		this.DateofBirth = DateofBirth;
	}
	
	public void setEmailID(String EmailID)
	{
		this.EmailID = EmailID;
	}	
	
	public void setCountry(String Country)
	{
		this.Country = Country;
	}	
	
	public Map<String, String> getparameters()
	{
		return parameters;
	}
	
	public void setparameters(Map<String, String> parameters)
	{
		this.parameters=parameters;
	}
	
	public String toString()
	{
		return "Test_inputparameters [UserName=" + UserName +", UserID=" + UserID + ", DateofBirth=" + DateofBirth +", EmailID=" + EmailID + ", Country=" + Country + ", parameters=" + parameters + "]";
	}

}
