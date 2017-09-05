import java.util.Scanner;
import java.util.Vector;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> now = new Vector<Integer>();
		Vector<Integer> last = new Vector<Integer>();
		
		last.add(0, 1);
		last.add(1, 1);
		
		int base = 1;
		int temp = 0;
		int temp1 = 0;
		int temp2 = 0;
		int k = 1;
//		int temp3 = 0;
		last.add(1);
		
		
		int hang = scanner.nextInt();
		if (hang == 1)
		{
			System.out.println(1);
			System.exit(0);
		}
		for (int i = 3; i <= hang; i++)
		{
				
			if (i % 2 != 0)
			{
				now.clear();
				now.add(0, 1);
				for (int j = 0; j < (i / 2 + 1); j++)
				{
					temp1 = (int) last.get(j);
					temp2 = (int) last.get(j + 1);
					now.add(j + 1, temp1 + temp2);
					temp = j;
				}
				for (int j = i - 1; j > temp; j--)
				{
					now.add(j, now.get(i - 1 - j));
				}
				last.clear();
				for (int j = 0; j < i; j++)
				{
					System.out.print(now.get(j) + " ");
					last.add(j, now.get(j));
				}
				System.out.println();
			}
			else
			{
				now.clear();
				now.add(0, 1);
				for (int j = 0; j < (i / 2); j++)
				{
					temp1 = (int) last.get(j);
					temp2 = (int) last.get(j + 1);
					now.add(j + 1, temp1 + temp2);
					temp = j;
				}
				for (int j = i - 1; j > temp; j--)
				{
					now.add(j, now.get(i - 1 - j));
				}
				last.clear();
				for (int j = 0; j < i; j++)
				{
					System.out.print(now.get(j) + " ");
					last.add(j, now.get(j));
				}
				System.out.println();
			}
		}
		
		
		scanner.close();
	}
}
