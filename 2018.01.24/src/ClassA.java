import org.omg.CORBA.PUBLIC_MEMBER;

public class ClassA extends Thread
{
	int a = 1;
	
	@Override
	public void run()
	{
		while(true)
		{
			System.out.println("œﬂ≥Ã“ª£∫" + a);
			a++;
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
				System.out.println("Error");
			}
		}
	}
	
	
}
