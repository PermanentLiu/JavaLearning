import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		boolean bool = true;
		while(bool)
		{
			System.out.println();
			System.out.println("Press 'q' to over.");
			String ch_s = scanner.nextLine();
			char ch_c = ch_s.charAt(0);
			if (ch_c == 'q')
			{
				break;
			}
			else
			{
				
				int x1 = Integer.parseInt(String.valueOf(ch_s.charAt(0)));
				char op = ch_s.charAt(1);
				int x2 = Integer.parseInt(String.valueOf(ch_s.charAt(2)));
				int result = 0;
				
				Calculator calculator = new Calculator(x1, x2, op);
				
				result = calculator.getResult();
				System.out.println("The result is :");
				System.out.printf("%d%c%d=%d", x1, op, x2, result);
			}
			
		}
		System.out.println("Thanks for use!");
		
		scanner.close();
	}
}
