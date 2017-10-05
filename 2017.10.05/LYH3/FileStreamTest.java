import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileStreamTest
{
	public static void main(String[] args)
	{
		try
		{
			byte bWrite[] = {10, 20, 30, 40, 50};
			
			OutputStream os = new FileOutputStream("text.txt");
			for (int x = 0; x < bWrite.length; x++)
			{
				os.write(bWrite[x]);
			}
			os.close();
			
			InputStream is = new FileInputStream("test.txt");
			int size = is.available();
			
			for (int i = 0; i < size; i++)
			{
				System.out.print((char) is.read() + " ");
			}
			is.close();
		}
		catch(IOException e)
		{
			System.out.println("IOException");
		}
	}
}
