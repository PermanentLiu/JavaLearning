import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInOut
{
	public static void main(String[] args) throws IOException
	{
		InputStreamReader inputStreamReader = null;
		
		try
		{
			inputStreamReader = new InputStreamReader(System.in);
			System.out.println("Enter characters, 'q' to quit");
			
			char c;
			
			do
			{
				c = (char) inputStreamReader.read();
				System.out.print(c);
			} 
			while (c != 'q');
		}
		finally
		{
			if (inputStreamReader != null)
			{
				inputStreamReader.close();
			}
		}
	}
}
