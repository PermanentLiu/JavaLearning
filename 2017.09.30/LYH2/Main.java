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
    }

}

