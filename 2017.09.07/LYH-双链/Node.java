
public class Node
{
	protected Node last;
	protected Node next;
	protected int number;
	protected String name;
	
	public Node(int number, String name)
	{
		this.number = number;
		this.name = name;
	}
	
	protected void display()
	{
		System.out.println(number + " " + name);
	}
}
