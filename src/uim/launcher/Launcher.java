package uim.launcher;

import java.util.List;
import java.util.Scanner;

import uim.dao.AdministrationDao;
import uim.dao.IdentityDao;
import uim.datamodel.Identity;
import uim.exceptions.UserCreationException;
import uim.exceptions.UserDeletionException;
import uim.exceptions.UserReadException;
import uim.exceptions.UserSearchException;
import uim.exceptions.UserUpdateException;

/**
 * <h3>Description</h3>
 * <p>This class allows to run the main method of the program and give comments/main menu for the user while running the program</p>
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

public class Launcher 
{


	public static void main(String[] args) throws UserCreationException{
		@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

		String User_Option;
		String userChoice;
		System.out.println("\nWelcome to the Identity Management System\n");
		System.out.println("Please enter admin credentials to gain access\n");
		System.out.println("USERNAME: ");
		String adminID=scanner.nextLine();
		System.out.println("PASSWORD: ");
		String pass = scanner.nextLine();

		boolean session = AdministrationDao.getAccess(adminID, pass);
		if(session) {
			System.out.println("Thanks for loggining in\n\nWelcome to the System\n\n");
			System.out.println("Please wait! Loading................");
			do
			{
				System.out.println("\nPlease select the activity you need to perform: ");
				System.out.println("Choose: 1 2 3 4 5 6 ");
				System.out.println("1. Create a User Identity");
				System.out.println("2. Read an existing User");
				System.out.println("3. Display all users");
				System.out.println("4. Modify an existing User Identity");
				System.out.println("5. Delete an existing User Identity");
				System.out.println("6. Exit");

				User_Option = scanner.nextLine();

				if(User_Option.equals("1"))
				{
					//Create user option
					IdentityDao dao = new IdentityDao();
					System.out.println("Enter the username: ");
					String username = scanner.nextLine();
					System.out.println("Enter the user id: ");
					String userID = scanner.nextLine();
					System.out.println("Enter the date of birth: ");
					String dob = scanner.nextLine();
					System.out.println("Enter the email ID: ");
					String email = scanner.nextLine();
					System.out.println("Enter the country: ");
					String country = scanner.nextLine();
					Identity user = new Identity(username, userID,dob,email,country);
					dao.CreateOperation(user);
					System.out.println("Record saved successfully! ");
				}
				else if(User_Option.equals("2"))
				{
					//read a particular user 
					IdentityDao dao = new IdentityDao();
					try {
						System.out.println("Enter the userID to search: ");
						String userID = scanner.nextLine();
						Identity user = dao.getById(userID);
						if(user!= null)
						{
							System.out.println("User ID\tUser Name\t\t\tEmail ID\t\t\tDate Of Birth\tCountry");
							System.out.println(user.getUserID() + "\t" + user.getUserName() + "\t\t" + user.getEmailID() + "\t\t"
									+ user.getDateOfBirth() + "\t" + user.getCountry());
						} 
					}
					catch (UserReadException e) {
						e.printStackTrace();
					}
				}
				else if(User_Option.equals("3"))
				{
					//display all users
					IdentityDao dao = new IdentityDao();
					try {
						List<Identity> resultList = dao.search();
						System.out.println("User ID\tUser Name\t\t\tEmail ID\t\t\tDate Of Birth\t\t\tCountry");
						for(Identity result : resultList)
						{
							System.out.println(result.getUserID() + "\t" + result.getUserName() + "\t\t" + result.getEmailID() + "\t\t"
									+ result.getDateOfBirth() + "\t" + result.getCountry());
						}

					} catch (UserSearchException e) {
						e.printStackTrace();
					}


				}
				else if(User_Option.equals("4"))
				{
					//modify an existing user
					IdentityDao dao = new IdentityDao();
					System.out.println("Enter the username & user ID to modify: ");
					String username = scanner.nextLine();
					String userID = scanner.nextLine();
					System.out.println("Enter the new date of birth: ");
					String dob = scanner.nextLine();
					System.out.println("Enter the new email ID: ");
					String email = scanner.nextLine();
					System.out.println("Enter the new country: ");
					String country = scanner.nextLine();
					Identity old = new Identity(username, userID,dob,email,country);
					try {
						dao.UpdateOperation(old);
					} catch (UserUpdateException e) {
						e.printStackTrace();
					}
				}
				else if(User_Option.equals("5"))
				{
					//delete an existing user
					IdentityDao dao = new IdentityDao();
					try {
						System.out.println("Enter the userID to delete: ");
						String userID = scanner.nextLine();
						dao.DeleteOperation(userID);
					} catch (UserDeletionException e) {
						e.printStackTrace();
					}
				}
				else if(User_Option.contentEquals("6"))
				{
					//exit from application
					System.out.println("Thanks for using Identity Management tool!!!");
					System.out.println("Exiting!!!");
					System.exit(0);
				}
				else 
				{
					System.out.println("Invalid input provided. Please retry with the correct option");
				}
				System.out.println("\n\n\nDo you wish to continue (y/n)");
				userChoice = scanner.nextLine().toLowerCase();

			}
			while(!"n".equals(userChoice));
			System.out.println("Thanks for using Identity Management tool!!!");
			System.out.println("To perform any acivities on UIM, you need to relaunch the tool");
			System.out.println("Bye....!");
		}
		else {
			System.out.println("Sorry!!! You don't have permissions to access the Identity Management System");
			System.out.println("Please contact your admin for details!!!");
		}
	}
}
