
public class Main
{
	public static void main(String[] args)
	{
		test(3, "liu", "Yong", "Heng");
	}
	
	public static void test(int a, String... books)
	{
		for (String temp : books)
		{
			System.out.println(temp);
		}
		System.out.println(a);
	}
}
