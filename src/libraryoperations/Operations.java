package libraryoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import dao.UserDAO;
//import dao.disp;
//import dao.display;
import model.Books;
import model.Orders;
import utility.ConnectionManager;

public class Operations
{
	static List<Books> list= new ArrayList<Books>();
	orderOperations oo =new orderOperations();
	Orders order =new Orders();
	Books books = new Books();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	
//	public void addBooks(Books books) 
//	{
//		list.add(books);
//
//	}
	
//	public void addList() throws IOException
	public void addBooks() throws IOException
	{   
		System.out.println("Enter below details :");
		System.out.println("-----------------------------");
		System.out.print("\tEnter Book Id :");
		
		int id=Integer.parseInt(br.readLine());
		System.out.print("\tEnter Book Name :");
		String name=br.readLine();
		
		System.out.print("\tEnter Book Price :");
		float price=Float.parseFloat(br.readLine());
		
		System.out.print("\tEnter Book Author :");
		String author=br.readLine();
		
		System.out.print("\tEnter no of books you want :");
		String nofBooks =br.readLine();
//		Books books = new Books();
		books.setId(id);
		books.setName(name);
		books.setPrice(price);
		books.setNofBooks(nofBooks);
		books.setAuthor(author);
		
		UserDAO userdao = new UserDAO();
		int r=  userdao.addBooks(books);
		System.out.println();
		if(r!=0)
		{
			System.out.println("\tBooks added Successfully....");
		}
		else
		{
			
			System.out.println("Duplicate Book id's and Book name ,author should not Allowed");
		}
//		addBooks(books);
	}

// method for removing Books from list
public void removeList() throws IOException, ClassNotFoundException, SQLException {
//	try {
//	if(list.isEmpty())
//	{
//		System.out.println("\n   ***** No Books to delete *****\n");
//	}
//	else 
//	 {    	
//		System.out.print("Enter Book Id to delete : ");
//		int id = Integer.parseInt(br.readLine()); 
//		System.out.println("-------------------------------");
//		System.out.println("\t1.Delete no of books ");
//		System.out.println("\t (or)");
//		System.out.println("\t2.Delete Total Book details  ");
//		System.out.print("Choose option : ");
//     	byte opt;
//     	opt=Byte.parseByte(br.readLine());
//     	switch(opt)
//     	{
//     	case 1:	for (Books book: list) 
//		              {
//			            if(book.getId() == id) 
//			                 {   
//				     System.out.print("There are "+book.getNofBooks()+" Books with id "+book.getId()+" So please Enter how many books do you want delete :");
//				     int n= Integer.parseInt(br.readLine());
//				              if(n<=Integer.parseInt(book.getNofBooks()))
//				                 {
//			                          int b=Integer.parseInt(book.getNofBooks())-n;
//			                          book.setNofBooks(b+"");
//			                          System.out.println("-------------------------------------------------------");
//			                          System.out.println(n+" "+book.getName()+" Book"+" was deleted Sucessfully.......!");
//			                          break;
//				              }
//				               else if(Integer.parseInt(book.getNofBooks())==0)
//				                  {
//				    	                    System.out.println("0 books with id "+book.getId()+"So... deletion not possible");
//				    	                      break;
//				                    }
//				          else
//				          {
//					         System.out.println("Sorry ...There are  "+book.getNofBooks() +" Books With  Id "+book.getId()+" ...So please enter within range");
//					         break;
//				           }
////				list.remove(book);
////				     break;
//				}
//			    else 
//			       {
//				          System.out.println("Books with id "+id+" not found in the library");
//				          break;
//			     }
//			}
//     	  break;
//     	case 2:        for(Books book:list)
// 		                   {
//// 			                    System.out.println("Working");
// 			                     if(book.getId() == id) 
// 			                        {
// 				                        list.remove(book);
// 				                        System.out.println(book.getName()+" was deleted Sucessfully.......!");
// 				                        break;
// 			                         }
//// 			                     else
//// 			                     {
//// 			                    	 System.out.println("Invalid Book id");
//// 			                     }
// 		                    }
//     	                      break;
//     	default :System.out.println("Please .......Enter valid option");
//     	break;
//	    }
//     	}	 
//	}
//	catch (Exception e) 
//	{      
//		System.out.println(e);
//		System.out.println();
//	    System.out.println("Please Enter valid id(Must be numbers) :");
//				
//	}
//	Books book =new Books();
	System.out.print("Enter Book id : ");
	  
	int id =Integer.parseInt( br.readLine());
	books.setId(id);
	Connection con =ConnectionManager.getConnection();
//	Statement st = con.createStatement();
	PreparedStatement st = con.prepareStatement("delete from books where id =?");
	 st.setInt(1, books.getId());
	ResultSet rs =st.executeQuery();
	boolean result=rs.next();
	if(result)
	{
		System.out.println(".....Books with id "+books.getId()+" Deleted...");
	}
	else
	{
		System.out.println("Id "+books.getId()+" Not Found in Library");
	}
  }







//method to display the books
//public void displayList() 
//   {
//	if(list.isEmpty()) 
//	{
//		System.out.println("\n   ***** No Books to display *****\n");
//		}
//	else 
//	{
//		System.out.println("\t\tId"+"\t\tName"+"\t\tPrice+\t\t\tAuthor");
//		for(Books book :list) 
//		{
//			System.out.print("\t\t"+book.getId());
//			System.out.print("\t\t"+book.getName());
//			System.out.print("\t\t"+book.getPrice()*Integer.parseInt( book.getNofBooks())+" for "+book.getNofBooks());
//			System.out.println("\t\t"+book.getAuthor());
//		}
//		
//	}
//	UserDAO userdao = new UserDAO();
//	Books book = new Books();
//		
//}

// display books list
public void displayList()
{
	try
	{
		Connection con =ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs =st.executeQuery("SELECT * FROM BOOKS");
		System.out.println();
		System.out.println("\tId"+"\t\tName"+"\t\tPrice"+"\t\ttotal_books"+"\t\tAuthor");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		while(rs.next())
		{
			int id =rs.getInt(1);
			String name =rs.getString(2);
			float price =rs.getFloat(3);
			String total_books=rs.getString(4);
			String author=rs.getString(5);
			System.out.print("\t"+id);
			System.out.print("\t\t"+name);
			System.out.print(" \t\t"+price);
//			System.out.print("\t\t"+book.getPrice()*Integer.parseInt( book.getNofBooks())+" for "+book.getNofBooks());
			System.out.print("\t\t"+total_books);
			System.out.println("\t\t"+author);
			
		}
		
		con.close();
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}
//sorting

public void sortByNameAsc() 
{
	if(list.isEmpty()) 
	{
		System.out.println("\n   ***** No books to sort - Please add the books first *****\n");
	}
	else {
//		list.sort(Comparator comparing(Products::getName()));
		Collections.sort(list,new Comparator<Books>() {

			@Override
			public int compare(Books b1, Books b2) {
				return b1.getName().compareTo(b2.getName());
			}
			
		});
		displayList();
	}
}
public void sortByPriceAsc() {
	if(list.isEmpty()) {
		System.out.println("\n   ***** No books to sort - Please add the books first *****\n");
	}
	else {
//		list.sort(Comparator comparing(Products::getPrice()));
		Collections.sort(list,new Comparator<Books>() {

			@Override
			public int compare(Books b1, Books b2) {
				return Float.compare(b1.getPrice(), b2.getPrice());
			}
			
		});
		displayList();
	}
}
public void sortByPriceDesc() {
	if(list.isEmpty()) {
		System.out.println("\n   ***** No books to sort - Please add the books first *****\n");
	}
	else {
//		list.sort(Comparator comparing(Products::getPrice()));
		Collections.sort(list,new Comparator<Books>() {

			@Override
			public int compare(Books b1, Books b2) {
				return Float.compare(b2.getPrice(), b1.getPrice());
			}
			
		});
		displayList();
	}
}
public void sortByNameDesc() 
{
	if(list.isEmpty()) 
	{
		System.out.println("\n   ***** No books to sort - Please add the books first *****\n");
	}
	else 
	    {
//		list.sort(Comparator comparing(Products::getName()));
		Collections.sort(list,new Comparator<Books>() 
		{
//The main method itself is not working?
			@Override
			public int compare(Books b1, Books b2) 
			{
				return b2.getName().compareTo(b1.getName());
			}
			
		});
		displayList();
	}
}
public void updateList() throws IOException, ClassNotFoundException, SQLException 
{
//	if(list.isEmpty()) {
//		System.out.println("\n   ***** No Books - Please add the Books first *****\n");
//	}
//	else {
//		System.out.print("Enter Book Id : ");
//		int id=Integer.parseInt(br.readLine());
//		for(Books b : list) {
//			if(id == b.getId()) {
//				System.out.print("Enter Book name : ");
//				String name = br.readLine();
//				System.out.println("Enter Book Price : ");
//				float price = Float.parseFloat(br.readLine());
//				System.out.print("Enter Book Author :");
//				String author=br.readLine();
//				System.out.print("Enter no of books");
//				String nofBooks= br.readLine();
//				b.setNofBooks(nofBooks);
//				b.setName(name);
//				b.setPrice(price);
//				b.setAuthor(author);
//				System.out.println("Update sucess");
//			}
//		}
//	}
	System.out.print("Enter Book Id which book do want change details : ");
	int id =Integer.parseInt(br.readLine());
	
	System.out.print("Enter Book Name : ");
	String name=br.readLine();
	
	System.out.print("Enter Book Price: ");
	float price =Float.parseFloat(br.readLine());
	
	System.out.print("Enter Book Author : ");
	String author=br.readLine();
	
	System.out.print("Enter no of books: ");
	String nofBooks= br.readLine();
	
	books.setId(id);
	books.setName(name);
	books.setPrice(price);
	books.setAuthor(author);
	books.setNofBooks(nofBooks);
	
	
     
		Connection con =ConnectionManager.getConnection();
		PreparedStatement st = con.prepareStatement("update books set name=?,price=?,author=?,total_books=? where id=?");

		 st.setString(1, books.getName());
		 st.setFloat(2, books.getPrice());
		 st.setString(3, books.getAuthor());
		 st.setString(4, books.getNofBooks());
	     st.setInt(5, books.getId());
		
		int rs =st.executeUpdate();
//		boolean result=rs.next();
		if(rs!=0)
		{
			System.out.println("Updated successful");
		}
		else
		{
			System.out.println("Id not presented");
		}
}
public int size() 
{
	return list.size();
}
//order
public void order() throws IOException, ClassNotFoundException, SQLException
{
	System.out.println("\t\t Books in availability\n");
	displayList();
//	System.out.print("How many Books Do You Want :");
//	byte n=Byte.parseByte(br.readLine());
//	if(n>size() || n<0)
//	{      System.out.println(size());
//		System.out.println("out of range");
//		order();
//	}
//	else
//	{
//	String selection[]= new String[n];
//	for(byte i=0;i<n;i++) {
//		System.out.print("Enter name of the Book - "+(i+1)+": ");
//		selection[i]=br.readLine();
//	}
//	for (byte i=0;i<n;i++) 
//	{
//		for(Books b: list) 
//		{
//			if(selection[i].equals(b.getName()))
//			{
//				System.out.print("How many no of Books do you need of "+b.getName());
//				byte nofBooks = Byte.parseByte(br.readLine());
//				float price = b.getPrice();
//				float total = price*nofBooks;
//				Orders o = new Orders(b.getId(),b.getName(),b.getPrice(),nofBooks,total);
//				o.setId(b.getId());
//				o.setName(b.getName());
//				o.setPrice(b.getPrice());
//				o.setAuthor(b.getAuthor());
//				o.setNofBooks(nofBooks);
//				o.setTotal(total);
//				oo.addOrders(o);
//			}
//		}
//	}
	
//	}
        System.out.print("Enter book id : ");
         int bookid=Integer.parseInt(br.readLine());
           books.setId(bookid);
           System.out.print("Enter book name : ");
            String bookname = br.readLine();
           System.out.print("Enter no of books do you want : ");
           byte no_of_books=Byte.parseByte(br.readLine());
//           order.setNofBooks(no_of_books);
                   Connection con =ConnectionManager.getConnection();
                   PreparedStatement ps =con.prepareStatement("SELECT * FROM BOOKS where id=? and name=?");
                   ps.setInt(1, bookid);
                   ps.setString(2, bookname);
            
            ResultSet select =ps.executeQuery();
            boolean check= select.next();
            System.out.println(check);
            int check1=0;
            if(check)
            {
                   float price=select.getFloat(3);
                  String author=select.getString(5);
//                  Connection co =ConnectionManager.getConnection();
                  PreparedStatement insert = con.prepareStatement("insert into orders (id,name,no_of_books,total_cost,author)values(?,?,?,?,?)"); 
                     insert.setInt(1, bookid);
                    insert.setString(2, bookname);
                    insert.setByte(3, no_of_books);
                    insert.setFloat(4, (no_of_books *  price));
                    insert.setString(5,author);
                    System.out.println(price+"   "+author+" "+no_of_books+" "+bookid+"   hiiiiiiiiii");
                     check1= insert.executeUpdate();
                     System.out.println(check1);
            }
            
            else
            {
            	System.out.println("id "+bookid+" not found in Library");
            }
                     System.out.println();
                     System.out.println(check1);
                    if(check1!=0)
                    {
                    	System.out.println("Order successful.........!");
                    }
                    else
                    {
                    	System.out.println("Order failed");
                    }
//                    con.close();
}

}








