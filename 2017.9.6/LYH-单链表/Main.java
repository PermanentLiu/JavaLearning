import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		LinkedListt linkedListt = new LinkedListt();
		linkedListt.addFirstNode(111);
		linkedListt.addFirstNode(222);
		linkedListt.addFirstNode(333);
		linkedListt.displayLinkedList();
		
		linkedListt.addNode(1, 2);
		linkedListt.addNode(3, 4);
		linkedListt.displayLinkedList();
		
		linkedListt.deleteFirstNode();
		linkedListt.displayLinkedList();
		
		linkedListt.deleteByData(111);
		linkedListt.displayLinkedList();
		
		linkedListt.deleteByIndex(2);
		linkedListt.displayLinkedList();
		
		linkedListt.deleteFirstNode();
		linkedListt.displayLinkedList();
		
		
		linkedListt.findByLocation(scanner.nextInt());
		linkedListt.displayLinkedList();
		
		scanner.close();
		
	}
}
