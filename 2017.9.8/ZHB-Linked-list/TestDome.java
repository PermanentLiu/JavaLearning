class Node 
{
	private String data; 
	private Node next;
	public Node (String data)
	{
		this.data = data;
	}
	void setNext(Node next)
	{
		this.next=next;
	}
	public Node getNext()
	{
		return this.next;
	}
	public String getData()
	{
		return this.data;
	}
	void addNode(Node newnode)//实现地址的增加
	{
		if(this.next == null)//当前地址的下一个地址为空
		{
			this.next = newnode; 
		}
		else//当前地址的下一个地址不为空
		{
			this.next.addNode(newnode);//当前地址跳到下一个
		}
	}
	void printNode()
	{
		System.out.println(this.data);
		if(this.next != null)//下个地址不为空 输出下一个地址喽
		{
			this.next.printNode();
		}
	}
	
}
//需要进行Node类对象的关系处理
class  Link//负责数据的设置和取出
{
	private Node head;
	void add (String data)//增加数据
	{
		//为了可以设置数据的先后关系，所以将data包装在Node中
		Node newNode = new Node(data);
		if(this.head==null)
		{
			this.head=newNode;//将第一个地址设置为头地址
		}
		else//头地址已经存在了
		{
			this.head.addNode(newNode);
		}
	}
	void print()//输出数据
	{
		if(this.head!=null)
		{
			this.head.printNode();
		}
	}
}
public class TestDome ·
{
	public static void main (String arg[])
	{
	Link link  =  new Link ();
	link.add("hellow");//存放数据
	link.add("hai");
	link.add("luck");
	link.print();
	}
}
