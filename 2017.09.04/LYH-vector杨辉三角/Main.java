import java.util.Scanner;
import java.util.Vector;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> now = new Vector();
		Vector<Integer> last = new Vector();
		
		int base = 1;
		int temp = 0;
		int temp1 = 0;
		int temp2 = 0;
		int k = 1;
//		int temp3 = 0;
		last.add(1);
		
		
		int hang = scanner.nextInt();
		for (int i = 1; i <= hang; i++)
		{
				
			if (i % 2 != 0)
			{
				now.add(0, 1);
				for (int j = 2; j <= (i / 2 + 1); j++)
				{
					temp1 = (int) last.get(i - 1);
					temp2 = (int) last.get(i);
					now.add(i - 1, temp1 + temp2);
					temp = j - 1;
				}
				for (int j = hang; j >= temp + 1; j--)
				{
					now.add(j - 1, now.get(k - 1));
					k++;
				}
				k = 0;
				for (int j = 1; j <= hang; j++)
				{
					System.out.println(now.get(j - 1));
					last.add(j - 1, now.get(j - 1));
				}
			}
			else
			{
				now.add(0, 1);
				for (int j = 2; j <= (i / 2); j++)
				{
					temp1 = (int) last.get(i - 1);
					temp2 = (int) last.get(i);
					now.add(i - 1, temp1 + temp2);
					temp = j;
				}
				for (int j = hang; j >= temp + 1; j--)
				{
					now.add(j - 1, now.get(k - 1));
					k++;
				}
				k = 0;
				for (int j = 1; j <= hang; j++)
				{
					System.out.println(now.get(j - 1));
					last.add(j - 1, now.get(j - 1));
				}
			}
		}
		
		
		scanner.close();
	}
}
