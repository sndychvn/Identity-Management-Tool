package uim.launcher;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import uim.operation.CreateUserIdentity;
import uim.operation.DeleteUserIdentity;
import uim.operation.ReadUserIdentity;
import uim.operation.UpdateUserIdentity;

public class Launcher 
{
	System.out.println("Welcome!");
	System.out.println("/nYou are using the User Identity Management Tool");	
	static Scanner scanner = new Scanner(System.in);
	private static boolean res = (!authenticate(scanner)){};
	
	if(res)
	{
		System.out.println("You are logged in successfully");
		end(scanner);
		return;
	}
	
	String UserOption;
	do
	{
		System.out.println("Please select the activity you need to perform: ");
		System.out.println("Choose: 1 2 3 4 5 ");
		System.out.println("1. Create a User Identity");
		System.out.println("2. Read/Search an existing User Identity");
		System.out.println("3. Modify an existing User Identity");
		System.out.println("4. Delete an existing User Identity");
		System.out.println("5. Delete an existing User from the tool");
		UserOption = scanner.nextLine();
		
		if(UserOption.equals("1"))
		{
			CreateUserIdentity.execute(scanner);
		}
		else if(UserOption.equals("2"))
		{
			UpdateUserIdentity.execute(scanner);
		}
		else if(UserOption.equals("3"))
		{
			ReadUserIdentity.execute(scanner);
		}
		else if(UserOption.equals("4"))
		{
			DeleteUserIdentity.execute(scanner);
		}
		else if(UserOption.equals("5"))
		{
			//need to write db code
		}
		else
		{
			System.out.println("Invalid input provided. Please retry with the correct option");
		}
						
	}
	while(!"4".equals(UserOption));
	
	
	
	private static void end(Scanner scanner)
	{
		System.out.println("Thank you for using the tool! Good Bye");
		scanner.close();
	}


	private static boolean authenticate (Scanner scanner2)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	//need to add code for authentication
	
}
}
