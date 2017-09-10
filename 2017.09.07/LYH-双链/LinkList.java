

public class LinkList
{
//	public static Node beginning;
//	public static Node ending;
	Node beginning = new Node(0, null);
	Node ending = new Node(0, null);
	
	public LinkList()
	{
//		beginning.number = 0;
//		beginning.name = "0";
//		ending.number = 0;
//		ending.name = "0";
//		beginning = null;
//		ending = null;
		this.beginning.last = null;
		this.ending.next = null;
		this.beginning.next = this.ending;
		this.ending.last = this.beginning;
	}
	
	//插入结点
	public void insertNode(int index, int number, String name)
	{
		int location = 0;
		Node node = new Node(number, name);
		Node current = beginning;
		
		while (location != index)
		{
			current = current.next;
			location++;
		}
		current.last.next = node;
		node.last = current.last;
		current.last = node;
		node.next = current;
	}
	
	//根据index删除结点
	public void deleteByIndex(int index)
	{
		int location = 0;
		Node current = beginning.next;
		
		while (location != index)
		{
			current = current.next;
			location++;
		}
		current.last.next = current.next;
		current.next.last = current.last;
//		current.last = null;
//		current.next = null;
	}
	
	//根据number删除结点
	public void deleteByNumber(int number)
	{
		Node current = beginning.next;
		
		while (number != current.number)
		{
			current = current.next;
		}
		current.last.next = current.next;
		current.next.last = current.last;
//		current.last = null;
//		current.next = null;
	}
	
	//根据index查找number，name
	public void searchByIndex(int index)
	{
		int location = 0;
		Node current = beginning.next;
		
		while (location != index)
		{
			current = current.next;
			location++;
		}
		current.display();
	}
	
	//根据name删除结点
	public void deleteByName(String name)
	{
		Node current = beginning.next;
		
		while (!(current.name.equals(name)))
		{
			current = current.next;
		}
		current.last.next = current.next;
		current.next.last = current.last;
//		current.last = null;
//		current.next = null;
	}
	
	
	//打印链表
	public void printLinkedList()
	{
		Node current = beginning.next;
		
		while (current.next != null)
		{
			current.display();
			current = current.next;
		}
		System.out.println();
	}
}
