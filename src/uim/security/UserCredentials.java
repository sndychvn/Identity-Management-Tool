package uim.security;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserCredentials 
{
	private String User_Name;
	private String User_Passcode;
	public String getUser_Name() 
	{
		return User_Name;
	}
			
	public void setUser_Name(String User_Name) 
	{
		this.User_Name = User_Name;
	}
			
	public String User_Passcode() 
	{
		return User_Passcode;
	}
			
	public void setUser_Passcode(String User_Passcode) 
	{
		this.User_Passcode = User_Passcode;
	}
			
	public String password(String string) throws NoSuchAlgorithmException 
	{
	MessageDigest md5 = MessageDigest.getInstance("MD5");
	md5.update(StandardCharsets.UTF_8.encode(string));
	return String.format("%032x", new BigInteger(1, md5.digest()));
	}
			
	public void printUser()
	{
		System.out.println(this.User_Name +"    "+ this.User_Passcode);
	}

}
