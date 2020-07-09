package libraryoperations;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.itextpdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

//import com.sun.xml.internal.txw2.Document;

import model.Orders;
import utility.ConnectionManager;

public class orderOperations
{
	static String[] columns = {"Id","Name","Price","Author","nofBooks","Total"};	
	static List<Orders> orderList = new ArrayList<Orders>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public void addOrders(Orders o) throws IOException 
	{
		if(orderList.add(o))
			System.out.println("\tOrder Placed Sucessfully");
		
	}
	public void displayOrders() 
	{
//		if(orderList.isEmpty())
//		{
//			System.out.println("\n\tNo orders placed\n");
//		}
//		else 
//		{
//			    System.out.println("\n\t\tId\t\tName\t\tPrice\t\tAuthor\t\tnofBookd\t\tTotal");
//			    for (Orders o : orderList) {
//				System.out.print("\t\t"+o.getId());
//				System.out.print("\t\t"+o.getName());
//				System.out.print("\t\t"+o.getPrice());
//				System.out.print("\t\t"+o.getAuthor());
//				System.out.print("\t\t"+o.getNofBooks());
//				System.out.println("\t\t"+o.getTotal());
//			  }
//		}
		try
		{
			Connection con =ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs =st.executeQuery("SELECT * FROM ORDERS");
			System.out.println();
			System.out.println("\tId"+"\t\tName"+"\t\tNo_of_Books"+"\t\tTotal_Cost"+"\t\tAuthor");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				int id =rs.getInt(1);
				String name =rs.getString(2);
				byte total_books=rs.getByte(3);
				float price =rs.getFloat(4)*total_books;
				String author=rs.getString(5);
				System.out.print("\t"+id);
				System.out.print("\t\t"+name);
				System.out.print(" \t\t"+total_books);
				System.out.print(" \t\t\t"+price);
				System.out.println("\t\t"+author);
			}
//			con.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	public void genereateReports() throws IOException {
//		if(ordersList.isEmpty())
//			System.out.println("\n\tNo orders placed\n");
//		else {
//		Workbook workbook= new XSSFWorkbook();
//		Sheet sheet=workbook.createSheet("orders");
//		Row headerRow=sheet.createRow(0);
//		for(int i=0;i<columns.length;i++) {
//			Cell cell = headerRow.createCell(i);
//			cell.setCellValue(columns[i]);
//		}
//		
//		int rowNum=1;
//		for(Orders o : ordersList ) {
//			Row row = sheet.createRow(rowNum++);
//			row.createCell(0).setCellValue(o.getId());
//			row.createCell(1).setCellValue(o.getName());
//			row.createCell(2).setCellValue(o.getPrice());
//			row.createCell(3).setCellValue(o.getNofBooks());
//			row.createCell(4).setCellValue(o.getTotal());
//		}
//		FileOutputStream fos=new FileOutputStream("orders.xlsx");
//		workbook.write(fos);
//		fos.close();
//		workbook.close();
//		}
		
		try
		{
			String File_Name="C:\\PDF_GENERATION\\ORDERS.PDF";
			Document doc = new Document();
			PdfWriter.getInstance(doc,new FileOutputStream(File_Name));
			doc.open();
			Connection con =ConnectionManager.getConnection();
			PreparedStatement ps=null;
			ResultSet rs= null;
			String query="Select * from orders";
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Paragraph para = new Paragraph(rs.getInt("id")+"  "+rs.getString("name")+"  "+rs.getInt("no_of_books")+"  "+rs.getFloat("Total_cost")+"  "+rs.getString("author"));
				doc.add(para);
				doc.add(new Paragraph(" "));
			}
			doc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	}