
public class Mian
{
	public static <T> void printArray(T[] objects)
	{
		if (objects != null)
		{
			for (T element : objects)
			{
				System.out.printf("%s", element);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Integer[] intArray = new Integer[]{1, 2, 3, 4, 5, 6};
		Character[] charArray = new Character[]{'t', 'i', 'm', 'a'};
		
		printArray(intArray);
		printArray(charArray);
	}
}
