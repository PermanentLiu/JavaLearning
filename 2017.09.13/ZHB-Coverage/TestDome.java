class A
{
	public void print()
	{
		System.out.println("Nice!!!");
	}
}
class B extends A
{
	public  void print()
	{
		super.print();
		System.out.println("Wonderful");
		super.print();
	}
}
public class TestDome {
     public static void main(String args[])
     {
    	 B b = new B();
    	 b.print();
     }
}
