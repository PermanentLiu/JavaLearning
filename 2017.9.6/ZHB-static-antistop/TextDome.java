class Book
{
	private String name;
	private double price;
	static String pub = "清华大学出版社";
	public Book(String name , double price)
	{
		this.name  = name;
		this.price = price;
 	}
	public String getInfo()
	{
		return "书名："+this.name+"，价格："+this.price+"，出版社："+ pub;
	}
	 static void setPub(String p)
	{
		pub = p;
	}
	
}
public class TextDome {
	public static void main(String arge[])
	{
		Book.setPub("北京大学出版社");
		Book ba = new Book ("java开发",10.5);
		Book bb = new Book ("Android开发",11.5);
		Book bc = new Book ("Ios开发",12.5);
		System.out.println(Book.pub);
		System.out.println(bb.getInfo());
		Book.pub = "电子科技大学出版社";
		System.out.println(Book.pub);
		System.out.println(ba.getInfo());
	}
}
