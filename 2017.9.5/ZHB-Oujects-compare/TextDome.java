class Book
{
	private String name;
	private double price;
	public Book(String name , double price)
	{
		this.name  = name;
		this.price = price;
	}
	public boolean compare (Book book)
	{
		if(this == book)
		{
			return true;
		}
		if(this.name.equals(book.name) && this.price==book.price)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	public double getPrice()
	{
		return this.price;
	}
}
public class TextDome {
	public static void main(String arge[])
	{
		Book b1 = new Book ("java exploitation",66.6);
		Book b2 = new Book ("java exploitation",77.7);
		if(b1.compare(b2))
		{
			System.out.println("是同一个对象");
		}
		else
		{
			System.out.println("不是同一个对象");
		}
	}

}
