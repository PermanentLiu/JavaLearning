import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		String aString = null;
		
        // TODO Auto-generated method stub
        try 
        {
            //创建一个ServerSocket监听8080端口
            ServerSocket server = new ServerSocket(8080);
            //等待请求
            Socket socket = server.accept();

            
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Reserve reserve = new Reserve(socket);
            reserve.start();
            
            
            
           System.out.println("Please input the message");
           
           while (flag)
           {
	           	aString = scanner.nextLine();
	           	
	           	if (! aString.equals("exit"))
				{
	           		out.println(aString);
	               	out.flush();
				}
	           	else
	           	{
	           		flag = false;
	           	}
           }
            
            out.close();
            socket.close();
            server.close();

        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
