import org.omg.CORBA.PUBLIC_MEMBER;

public class ClassA extends Thread
{
	int a = 1;
	
	@Override
	public void run()
	{
		while(true)
		{
			System.out.println("�߳�һ��" + a);
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
