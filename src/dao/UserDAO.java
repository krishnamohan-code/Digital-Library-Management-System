package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Books;
//import model.Player;
//import model.Users;
import model.Users;
import utility.ConnectionManager;
//import java.ConnectionManager;
public class UserDAO implements UserDaoInterface {
	  String signup= "INSERT INTO USERS (name,mobile_number,email, password) VALUES (?,?,?,?) ";
	 String login= "SELECT * FROM USERS WHERE email = ? AND password = ? ";
	 String books="INSERT INTO BOOKS(id,name,price,total_books,author) VALUES (?,?,?,?,?) ";
//	 String order="INSERT INTO"
	 
	 //Storing user details in database
	public int signUp(Users user)  {
		
		 try
		 {
			Connection con = ConnectionManager.getConnection();
		    int result = 0;	
		   
		   
			PreparedStatement st = con.prepareStatement(signup);
			st.setString(1,user.getName());
			st.setString(2,user.getMobileNo());
			st.setString(3,user.getEmail());
			st.setString(4,user.getPassword());
			result = st.executeUpdate();
			return result;
		} 
		 catch (Exception e)
		    {
//			 System.out.println(e);
//			 System.out.println("The size of name(50),mobile number (10), email(50) password(20)");
			return 0;
		   }
		
	}
	
	// Adding books into DataBase
	
	public int addBooks(Books book)
	{
		try {
			       Connection con =ConnectionManager.getConnection();
			       int result =0;
			       PreparedStatement st =con.prepareStatement(books);
			       st.setInt(1,book.getId());
			       st.setString(2,book.getName());
			       st.setFloat(3, book.getPrice());
			       st.setString(4, book.getNofBooks());
			       st.setString(5, book.getAuthor());
			
			       result =st.executeUpdate();
			       return result;
             	}
		catch (Exception e)
	      {
//		          System.out.println(e);
		          return 0;
	      }
		
	}
	
	public boolean loginUser(Users user)  {
		try 
		{
			Connection con = ConnectionManager.getConnection();

			boolean result = false;
		    PreparedStatement st = con.prepareStatement(login);
		
			st.setString(1, user.getEmail());
			st.setString(2, user.getPassword());
			ResultSet rs = st.executeQuery();
			result = rs.next();
			return result;
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
}





















