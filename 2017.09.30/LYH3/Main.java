import java.util.Scanner;

public class Main
{
	public static void main(String args[]) 
	{
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
        	String command = scanner.next();
        	if (command.equals("exit"))
        	{
        		break;
        	}
        	System.out.println(command);
        }
        
        
        System.out.println("1到100所有偶数之和是: ");
        int sum = 0;
        for (int i = 0; i <= 100; i++)
        {
        	if (i % 2 != 0)
        	{
        		continue;
        	}
        	sum += i;
        }
        System.out.println(sum);
    }

}

