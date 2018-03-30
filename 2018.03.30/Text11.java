import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class Text11
{
	public static void main(String[] args)
	{
		String url = "http://www.permanentliu.cn/";
		
		try
		{
			URL tempURL = new URL(url);
			URLConnection connection = tempURL.openConnection();
			InputStream inputStream = connection.getInputStream();
			
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			
			String content = "";
			while ((content = bufferedReader.readLine()) != null)
			{
				System.out.println(content);
			}
			
			
		}
		catch (Exception e)
		{
			System.out.println("catch error");
		}
	}
}