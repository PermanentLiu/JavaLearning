
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileByte
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		
		try
		{
			inputStream = new FileInputStream("C:\\myData\\formalFiles\\codes\\myCodes\\JAVA\\Text50\\src\\input.txt");
			outputStream = new FileOutputStream("C:\\myData\\formalFiles\\codes\\myCodes\\JAVA\\Text50\\src\\output.txt");
			
			int c;
			
			while ((c = inputStream.read()) != -1)
			{
				outputStream.write(c);
			}
		}
		finally
		{
			if (inputStream != null)
			{
				inputStream.close();
			}
			
			if (outputStream != null)
			{
				outputStream.close();
				
			}
		}
	}
}
