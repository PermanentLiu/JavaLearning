import java.util.Scanner;
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
	private Node head;
	private Node tail;
	private Node temp;
	private int count = 0;
	private int foot  = 0;
	private Student []retArray ;//定义一个返回数组
	//********************
	private class Node
	{
		private Student data;
		private Node next;
		private Node last;
		public Node(Student data)
		{
			this.data = data;
		}
		public void addNode(Node newNode , Node temp)
		{
			if( this.next == tail)
			{
				this.next = newNode;
				newNode.last = temp;
				newNode.next = tail;
				count ++;
			}
			else
			{
				temp=this.next;
			    this.next.addNode(newNode , temp);
			}
		}
		public void removeNode(Node temp , int flag)
		{
			int x = 1;
			while( x < flag)
			{
				temp = temp.next;
				x++;
			}
		    temp.last.next = temp.next;
		    temp.next.last = temp.last;
		    count--;
		}
		public void insetNode(Node newNode , Node temp , int flag)
		{
			int x = 1;
			while( x < flag)
			{
				temp = temp.next;
				x++;
			}
			newNode.next=temp;
			newNode.last=temp.last;
			temp.last.next = newNode;
			count++;
		}
		public void toArrayNode()
		{
			Link.this.retArray[Link.this.foot++] = this.data;
			if(this.next != tail)
			{
				this.next.toArrayNode();
			}
		}
	}
	//****************************************
	//创建头尾结点
	public void Create(Student data)
	{
		Node newNode1 = new Node (data);
		Node newNode0 = new Node (null);
		head = newNode1;
		tail = newNode0;
		newNode1.next = newNode0;
		newNode0.last = newNode1;
		newNode1.last = null;
		newNode0.next = null;
		newNode0.data = null;
		newNode1.data = data;
		this.count = 1;
	}
	//增加结点
	public void add(Student data)
	{
		Node newNode = new Node (data);
		if(this.head != null)
		{
			temp = head;
			this.head.addNode(newNode,temp);
		}
		else
		{
			System.out.println("请先创建链表");
		}
	}
	//删除结点
	public void remove (int flag)
	{
		if(flag == 1)
		{
			head.next = head;
			head.next.last =null;
			count--;
		}
		temp = head;
		if( count >= flag  && flag !=1)
		{
			this.head.removeNode( temp , flag);
			System.out.println("删除成功");
		}
		else
		{
			System.out.println("删除错误");
		}
	}
	//插入结点
	public int inset(Student data,int flag)
	{
		Node newNode = new Node (data);
		if(flag == 1)
		{
			temp = head ;
			head = newNode;
			head.next = temp;
			head.last = null;
			temp.last = head;
			count++;
			System.out.println("插入成功");
			return 0;
		}
		if(flag == count)
		{
			this.head.addNode(newNode, head);
			return 0;
		}
		if( count > flag &&  flag !=1 )
		{
			temp = head;
			this.head.insetNode(newNode ,temp, flag);
			System.out.println("插入成功");
			return 0;
		}
		else if(flag >count)
		{
			System.out.println("插入失败flag >count");
			return 0;
		}
		else 
		{
			System.out.println("插入失败");
			return 0;
		}
	}
	//搜索结点根据不同要求 (暂时放下)
	//结点排序(学号/年龄)
	public void soft()
	{
	}
	//输出链表
	//链表数组化
	public Student [] toArray()
	{
		if(this.head  == null)
		{
		    System.out.println("NO Data");
			return null;
		}
		this.foot = 0;//控制标识
		this.retArray = new Student [this.count];//开辟数组
		this.head.toArrayNode();
		return this.retArray;
	}
	public void print()
	{
		temp = head;
		while(temp != tail)
		{
			System.out.println(temp.data.getInfo());
			temp = temp.next;
		}
	}
	public void link()//升级为环链
	{
	      head.last = tail;
	      tail.next = head;
	}
}
public class Test {
	public static void main(String args[])
	{   
	    boolean flag = true;
		Link all = new Link();
		System.out.println("创建第一个数据");
		System.out.println("输入用户姓名");
		Scanner temp1 = new Scanner(System.in);
		String name = temp1.next();
		Scanner temp2 = new Scanner(System.in);
		System.out.println("输入用户学号");
		int number = temp2.nextInt();
		System.out.println("输入用户年龄");
		int age = temp2.nextInt();
		all.Create(new Student(name,number,age));
		w:while(flag)
		{
			int x = 3 ;
			System.out.println("如果结束增加数据请输入*,或按任意键继续");
			String temp  = temp1.next();
			if(temp.equals("*"))
			{
				break w;
			}
			System.out.println("增加一个数据");
			System.out.println("输入用户姓名");
			String name1 = temp1.next();
			System.out.println("输入用户学号");
			int number2 = temp2.nextInt();
			System.out.println("输入用户年龄");
			int age2 = temp2.nextInt();
			all.add(new Student(name1,number2,age2));
		}
		System.out.println("输出全部信息");
		all.print();
		System.out.println("删除第二个的信息");
		all.remove(2);
		System.out.println("在第一个位置插入于学博的信息");
		all.inset(new Student("于学博",1600300834,20),1);
		System.out.println("在第三个位置插入潘峋村的信息");
		all.inset(new Student("潘峋村",1600300831,20),3);
		all.print();
		System.out.println("在最后位置加入张汉邦的信息");
 		all.inset(new Student("张汉邦",1600300835,19),5);
		all.print();
	}
}
