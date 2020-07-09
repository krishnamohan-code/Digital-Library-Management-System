package libraryoperations;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import businessLogic.RegistrationValidation;
import dao.UserDAO;
import model.Users;

public class userOperations 
{
	static List<Users> usersList = new ArrayList<Users>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean log=false;
	public List<Users> addUsers(Users u) 
	{
		if(usersList.add(u)) 
		{
			System.out.println("Sign Up Sucessful");
		}
		return usersList;
	}
	
	public void signUp() throws IOException 
	{
		System.out.println("Enter your details :");
		System.out.print("Name :");
		String name = br.readLine();
		System.out.print("Enter Mobile No :");
		String mobileNo = br.readLine();
		System.out.print("Enter Email :");
		String email = br.readLine();
		System.out.print("Enter Password :");
		String password = br.readLine();
		System.out.print("Confirm  Password :");
		String confirmPassword = br.readLine();
		//validation part
		 RegistrationValidation reg = new RegistrationValidation();
		 
		 boolean validation=reg.checkUserDetails(email, password, confirmPassword,mobileNo);

		Users user= new Users();
		user.setName(name);
		user.setMobileNo(mobileNo);
		user.setEmail(email);
		user.setPassword(password);
		UserDAO userdao=new UserDAO();
		if(validation)
		{      int checkUser = userdao.signUp(user);
			  System.out.println();
		       if(checkUser != 0)
		           {
			            System.out.println("***Registration Successful***");
			       }
		       else
		           {
			          
			           System.out.println("Already Registrated with mobile number or email ");
		            }
		 }
		   else
		       {
			       System.out.println("yours details are not valid");
		        }
	}
	
	public void displayUser() throws IOException 
	{
		if(usersList.isEmpty())
		{
			System.out.println("No user data was stored");
		}
		else 
		{
            System.out.println("Your details are");
			for (Users u: usersList) 
			{
				    System.out.print("\t"+u.getName());
					System.out.print("\t"+u.getMobileNo());
					System.out.print("\t"+u.getEmail());
					System.out.println("\t"+u.getPassword());
			}
		}
	}
	
	public boolean login() throws IOException 
	{
		  System.out.print("Your email Address : ");
		String email=br.readLine();
		 System.out.print("Your Password : ");
		String password=br.readLine();
		Users user = new Users();
		user.setEmail(email);
		user.setPassword(password);
		UserDAO userdao = new UserDAO();
		boolean validateUser = userdao.loginUser(user);
		if(validateUser)
		{     return true;
			}
		else
		{
			return false;
		}
		}
	}
	
	
	
	
	
	
