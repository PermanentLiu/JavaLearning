import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input the months:");
		int months = scanner.nextInt();
		int sum;
		int temp = 0;
		int m1 = 1;
		int m2 = 2;
		
		if (months == 1)
		{
			System.out.println("The " + months + " month is: " + m1);
		}
		else if (months == 2)
		{
			System.out.println("The " + months + " month is: " + m2);
		}
		else
		{
			for (int i = 3; i < months; i++)
			{
				temp = m1 + m2;
				m1 = m2;
				m2 = temp;
			}
			System.out.println("The " + months + " months is: " + temp);
		}
		
		
		
		scanner.close();
	}
}
