package model;

public class Orders {
	private int id;
	private String name;
	private float price;
	private byte  nofBooks;
	private float total;
	private String author;
//	public Orders(int id, String name, float price, byte  nofBooks, float total) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.nofBooks = nofBooks;
//		this.total = total;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public float getPrice() 
	{
		return price;
	}
	public void setPrice(float price) 
	{
		this.price = price;
	}
	public byte  getNofBooks()
	{
		return nofBooks;
	}
	public void setNofBooks(byte  nofBooks)
	{
		this.nofBooks = nofBooks;
	}
	public float getTotal()
	{
		return total;
	}
	public void setTotal(float total) 
	{
		this.total = total;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	public String getAuthor()
	{
		return author;
	}
	
}
