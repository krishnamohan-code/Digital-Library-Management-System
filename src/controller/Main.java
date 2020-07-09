package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import businessLogic.*;
import libraryoperations.Operations;
import libraryoperations.orderOperations;
import libraryoperations.userOperations;
import model.Books;
import model.Users;
public  class Main {
	static ArrayList<Books> list = new ArrayList<Books>();
	static ArrayList<Users> usersList = new ArrayList<Users>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException
	{
		System.out.println("----------------------------------------------------");
		System.out.println("\t***Welcome to Digital-Library***");
		Operations op = new Operations();
		userOperations uo = new userOperations();
		orderOperations oo= new orderOperations();
		byte menu=0 ;
		do{
			
		System.out.println("----------------------------------------------------");
		System.out.println("\t 1. Admin");
		System.out.println("\t 2. User");
		System.out.println("\t 3. Exit");
		System.out.print("\t Your Choice : ");
		try {
		menu = Byte.parseByte(br.readLine());
				
		System.out.println("----------------------------------------------------");
       
		switch (menu)
		{
		case 1: 
			    System.out.print("Enter you email : ");
				String email1=br.readLine();
				System.out.print("Enter you password : ");
				String password1=br.readLine();
				Validation v=new Validation();
				boolean result = v.validate(email1, password1);

				if(result) 
				{
					byte options = 0;
					do 
					{
						
						System.out.println();
						System.out.println("-------------------------------");
						System.out.println("\t Admin Menu");
						System.out.println("-------------------------------");
						System.out.println("\t 1. Add Books");  
						System.out.println("\t 2. View Books");
						System.out.println("\t 3. Remove Books");
						System.out.println("\t 4. Update Books");
						System.out.println("\t 5. View Orders");
						System.out.println("\t 6. Generate Reports");
						System.out.println("\t 7. Exit");
						
						try {
							System.out.print("\t Your Choice :");
						options = Byte.parseByte(br.readLine());
						switch(options) {
						case 1:
							System.out.print("How many books do you want to add : ");
							byte n = Byte.parseByte(br.readLine());
						  
							while(n>0) {
//								op.addList();
								op.addBooks();
								n--;
							}
//							System.out.println("-----------------------------------------");
							
//							System.out.println("\tBooks added Successfully....");
							System.out.println("-----------------------------------------");
							break;
							
						case 2: op.displayList(); break;
						case 3: op.removeList();break;
						case 4: op.updateList();break;
						case 5: oo.displayOrders();break;
						case 6: oo.genereateReports();break;
						case 7: System.out.println("\n\t...Thank You Admin...\n"); break;
						default:System.out.println("\n\tWrong entry...\n");
							
						}
						}
						catch(Exception e)
						{
							System.out.println("\n\tEnter numbers(only)\n");
						}
					}while(options != 7);	
				}
				
				break;
				//main menu case 1 end
		case 2:
			byte option;
			boolean login = false;
			do {
			System.out.println("--------------Select type -------------");
			System.out.println("\t 1. View Books");
			System.out.println("\t 2. Login");
			System.out.println("\t 3. Sign Up");
			System.out.println("\t 4. Sort Books");
			System.out.println("\t 5. Log Out");
			System.out.println("\t 6. Place Order");
			System.out.println("\t 7.View Orders");
			System.out.println("\t 8. Exit");
			System.out.print("\t Your Choice :");
			option = Byte.parseByte(br.readLine());
			
			switch(option) 
			{
			case 1:
				       op.displayList(); 
				       break;
			case 2:
				if(login == true) 
				{
					System.out.println("\n\t\tAlready logged in - Log Out First\n");
				}
				else 
				{
				boolean x = uo.login();
				System.out.println();
				if(x == true)
				     {
					         System.out.println("Login sucess");
					          login = true;
				     }
					else 
					System.out.println("Invaild user/password ");
				}
				break;
			case 3: 
				       uo.signUp(); 
				       break;
			case 4: 
				System.out.println("\nSort by Name - Ascending Order\n");
				op.sortByNameAsc();
				System.out.println("\nSort by Name - Descending Order\n");
				op.sortByNameDesc();
				System.out.println("\nSort by Price - Ascending Order\n");
				op.sortByPriceAsc();
				System.out.println("\nSort by Price - Descending Order\n");
				op.sortByPriceDesc();
			    break; 
			case 5:
				login = false; break;
			case 6: 
				if(login == false) 
				{
					System.out.println("please do login first");
				 }
				else
				op.order();
				break;
			case 7:      oo.displayOrders();break;
			case 8: 
				System.out.println("\t \\...Thank You User.../");
			     break;
			default:
				System.out.println("\tWrong entry...");
			}
			
			}while(option !=8);
			
		
				break;
		case 3:
			System.out.println("\t ***Thank You for using Application***");
			System.out.println("...................................................................");
			break;
		    default: 
		    System.out.println("\tPlease Enter  1 or 2 or 3 ");
		  }
		}
		catch(Exception e)
		{ 
			 System.out.print(e);
			System.out.println("\n\tEnter numbers(only)\n");
		}
		}while(menu != 3);
		System.out.println("Mission completed");
		
		}

	
}
