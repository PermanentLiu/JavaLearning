class Student
{
	private String name;
	private int  number;
	private int  age ; 
	public Student (String name ,  int number , int age)
	{
		this.name= name;
		this.age = age;
		this.number = number;
	}
	public String getInfo()
	{
		return "学生姓名："+this.name+ "学号 ："+this.number+"年龄："+this.age;
	}
	//定义对象的时候 一定要定义比较函数;
	public boolean compare (Student student)
	{
		if(this == student)
		{
			return true;
		}
		if(student == null)
		{
			return false;
		}
		if(this.name.equals(student.name)&&this.number==student.number&&this.age==student.age)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
class Link
{
	//****************************************
	private class Node //定义节点类
	{
		private Student data ;
		private Node next ;
		public Node (Student data)
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
		public boolean containsNode (Student data)
		{
			if(data.compare(this.data))
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
		public Student getNode(int index)
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
		//------------------------修改
		public void setNode(int index , Student data)
		{
			if(Link.this.foot ++ == index)
			{
				this.data =data;
			}
			else
			{
				this.next.setNode(index,data);
			}
		}
		//-----------------------删除根节点
		public void removeNode(Node previous , Student data)
		{
			if(data.compare(this.data))//是要删除的数据
			{
				previous.next = this.next;
			}
			else
			{
				this.next.removeNode(this, data);
			}
		}
		//--------------------------对创建好的返回数组进行内容处理
		public void toArrayNode()
		{
			Link.this.retArray[Link.this.foot++] = this.data;
			if(this.next != null)
			{
				this.next.toArrayNode();
			}
		}
	}
   //****************************************
   //-----------------------------------------------增加
	private Node head;
	private int count = 0 ;//计数
	private int foot  = 0;
	private Student [] retArray;//定义一个返回数组、定义再link中为了在link 和node中都能访问
	public void add (Student data)
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
	public Student get(int index)
	{
		if(index > this.count)
		{
			return null;
		}
		this.foot = 0;
		return this.head.getNode(index);
	}
	//-----------------------数据查询
	public boolean contains (Student data)
	{
		//如果没有要查询的数据，根节点也不保存数
		if(data == null || this.head == null)
		{
			return false;
		}
		return this.head.containsNode(data);
	}
	//--------------------修改
	public void set(int index , Student data)
	{
		if(index > this.count)
		{
			return ;//结束方法调用
		}
		this.foot = 0 ;
		this.head.setNode(index,data);
	}
	//-------------------删除
	public void remove (Student data)
	{
		if(this.contains(data))
		{
			if(data.compare(this.head.data))//如果要删除头结点
			{
				this.head =this.head.next;
			}
			else
			{
				this.head.next.removeNode(this.head, data);
			}
			this.count -- ;
		}
	}
	//----------------------返回数组
	public Student [] toArray()
	{
		if(this.head == null)
		{
			return null;
		}
		this.foot = 0;//控制标识
		this.retArray = new Student [this.count];//开辟数组
		this.head.toArrayNode();//交给node处理数组的数据
		return this.retArray;
	}
}
public class TestDome 
{
	public static void main (String arg[])
	{
		Link all = new Link();
		all.add(new Student("张汉邦",1600300835,19));
		all.add(new Student("刘永蘅",1600300822,19));
		all.add(new Student("陈添",1600300812,20));
		System.out.println("一共有多少学生: "+all.size());	
		System.out.println("查询张汉邦这个学生信息是否完整："+all.contains(new Student("张汉邦",1600300835,19)));
		System.out.println("查询第一个同学的信息");
		System.out.println(all.get(0).getInfo());
		System.out.println("删除张汉帮的信息");
		all.remove(new Student("张汉邦",1600300835,19));
		System.out.println("输出全部信息");
		Student [] data = all.toArray();//将链表的返回数组传递出来
		for(int x = 0 ; x<data.length ; x ++)//循环输出
		{
			System.out.println(data[x].getInfo());
		}
		//System.out.println(all.isEmpty());//判断是否为空链表 输出boolean形
	}
}
