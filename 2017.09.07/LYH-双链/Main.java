
public class Main
{
	public static void main(String[] args)
	{
		LinkList linkList = new LinkList();
		
		linkList.insertNode(1, 44, "qwe");
//		linkList.printLinkedList();
		linkList.insertNode(1, 77, "ert");
//		linkList.printLinkedList();
		
		linkList.insertNode(1, 55, "ijk");
		linkList.insertNode(3, 88, "ref");
		linkList.insertNode(2, 66, "nvb");
		linkList.insertNode(1, 33, "iuy");
		linkList.printLinkedList();
		
		System.out.println("del name");
		linkList.deleteByName("ert");
		linkList.printLinkedList();
		
		linkList.searchByIndex(2);
		
		
		System.out.println("del index");
		linkList.deleteByIndex(2);
		linkList.printLinkedList();
		
		System.out.println("del number");
		linkList.deleteByNumber(88);
		linkList.printLinkedList();
		


		
		
	}
}
