import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reserve extends Thread
{
	Socket socket;
	
	public Reserve(Socket socket)
	{
		this.socket = socket;
	}
	
	@Override
	public void run()
	{
		BufferedReader in = null;
		try
		{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Error");
		}
		while (true)
		{
			try
			{
				System.out.println("received from server: \n" + in.readLine());
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Error");
			}
		}
	}
	

}
