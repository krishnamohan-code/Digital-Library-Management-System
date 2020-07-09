package model;

public class Books{
	private int id;
	private String name;
	private float price;
	private String author;
	private String nofBooks;
//	public Books(int id, String name, float price,String author,String nofBooks) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.author=author;
//		this.nofBooks=nofBooks;
//	}
	public String getNofBooks()
	{
		return nofBooks;
	}
	public void setNofBooks(String  nofBooks)
	{
		 this.nofBooks=nofBooks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	
}
