class Link
{
	//****************************************
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
		//---------------------------------------------查询
		public boolean containsNode (String data)
		{
			if(data.equals(this.data))
			{
				return true;
			}
			else
			{
				if(this.next != null)
				{
					return this.next.containsNode(data);
				}
				else
				{
					return false;
				}
			}
		}
		//-----------------------------------------
		public String getNode(int index)
		{
			//使用当前的foot内容和要所查询的索引进行比较，然后将foot的内容自增。
			if( Link.this.foot ++ == index)
			{
				return this.data;
			}
			else
			{
				return this.next.getNode(index);
			}
		}
		
	}
   //****************************************
   //-----------------------------------------------增加
	private Node head;
	private int count = 0 ;//计数
	private int foot  = 0;
	private int index;
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
	//------------------------------输出计数 ---
	public int size ()
	{
		return this.count;
	}
	//----------------------判断是否为空链表
	public boolean isEmpty()
	{
		return this.count == 0 ;
	}
	//----------
	public String get(int index)
	{
		if(this.index > this.count)
		{
			return null;
		}
		this.foot = 0;
		return this.head.getNode(index);
	}
	//-----------------------数据查询
	public boolean contains (String data)
	{
		//如果没有要查询的数据，根节点也不保存数
		if(data == null || this.head == null)
		{
			return false;
		}
		return this.head.containsNode(data);
	}
	
	
}
public class TestDome 
{
	public static void main (String arg[])
	{
		Link all = new Link();
		System.out.println(all.isEmpty());//判断是否为空链表 输出boolean形
		all.add("6+66");
		all.add("heiheihei");
		all.add("spider-man~");
		System.out.println(all.size());
		System.out.println("查询是否有这个数据");
		System.out.println(all.contains("hellow"));
		System.out.println("查询是否有这个数据");
		System.out.println(all.contains("6+66"));
		System.out.println("查询对应编号的数据");
		System.out.println(all.get(0));
		System.out.println(all.get(2));
		System.out.println(all.get(10));//超出后查询错误 请大佬明鉴、、、啊啊啊啊啊 我觉得问题在88-92行的判断有问题。。
	}
}
/*
运行结果 ：
true
3
查询是否有这个数据
false
查询是否有这个数据
true
查询对应编号的数据
6+66
spider-man~
Exception in thread "main" java.lang.NullPointerException
	at Link$Node.getNode(TestDome.java:52)
	at Link$Node.getNode(TestDome.java:52)
	at Link$Node.getNode(TestDome.java:52)
	at Link.get(TestDome.java:94)
	at TestDome.main(TestDome.java:126)*/
