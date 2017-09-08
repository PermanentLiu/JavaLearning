import java.util.ArrayList;
import java.util.LinkedList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(0, 23);
		System.out.println(arrayList.get(1));
		System.out.println(arrayList.size());
		arrayList.clear();
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(0, 234);
		System.out.println(linkedList.getFirst());
		System.out.println(linkedList.get(1));
		System.out.println(linkedList.size());
		
	}
}
