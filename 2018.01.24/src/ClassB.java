
public class ClassB extends Thread
{
	String string = null;
	
	@Override
	public void run()
	{
		while(true)
		{
			System.out.println("线程三：" + "liu");
			try
			{
				Thread.sleep(1500);
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
			
			System.out.println("线程三：" + "yong");
			
			try
			{
				Thread.sleep(1500);
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
			
			System.out.println("线程三：" + "heng");
		}
		
	}
}
