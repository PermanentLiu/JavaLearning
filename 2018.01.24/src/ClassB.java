
public class ClassB extends Thread
{
	String string = null;
	
	public void run()
	{
		System.out.println("liu");
		try
		{
			Thread.sleep(1500);
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		
		System.out.println("yong");
		
		try
		{
			Thread.sleep(1500);
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		
		System.out.println("heng");
		
		
	}
}
