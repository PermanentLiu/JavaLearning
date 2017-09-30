import java.util.Scanner;

public class Main
{
	public static void main(String args[]) 
	{
		int x1 = 0;
		int x2 = 1;
		int now = 0;
		
		for (int i = 3; i <= 23; i++)
		{
			now = x1 + x2;
			x1 = x2;
			x2 = now;
		}
		System.out.println(now);
    }

}

