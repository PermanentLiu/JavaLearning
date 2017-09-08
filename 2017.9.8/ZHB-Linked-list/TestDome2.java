class Link
{
	private class Node //定义节点类
	{
		private String data ;
		private Node next ;
		public Node (String data)
		{
			this.data = data ;
		}
		public void addNode (Node newNode)//增加
		{
			if(this.next==null)
			{
				this.next = newNode;
			}
			else//向后继续保存
			{
				this.next.addNode(newNode);
			}
		}
	}
   //-----------------------------------------------增加
	private Node head;
	private int count = 0 ;//计数
	public void add (String data)
	{
		Node newNode = new Node (data);//要保存的数据
		if(this.head == null)
		{
			this.head= newNode ;
		}
		else
		{
			this.head.addNode(newNode);
		}
		this.count++ ;//每次保存完后count++；
	}
	//----------------------------------------------
	public int size ()//输出计数
	{
		return this.count;
	}
}
public class TestDome 
{
	public static void main (String arg[])
	{
		Link all = new Link();
		all.add("6+66");
		all.add("heiheihei");
		System.out.println(all.size());
	}
}
