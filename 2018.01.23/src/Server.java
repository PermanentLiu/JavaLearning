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
            
            
            
            
            
            //接受请求后使用Socket进行通信，创建BufferedReader用于读取数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            
            
            
            
           System.out.println("Please input the message");
           
            while (flag)
            {
            	aString = scanner.nextLine();
            	if (aString.equals("exit"))
            	{
            		flag = false;
            		System.out.println("received frome client:\n" + is.readLine());
            		pw.println("对方已经离开");
                	pw.flush();
            		break;
            	}
            	else
            	{
            		
            		pw.println(aString);
                	pw.flush();
                	System.out.println("received frome client:\n" + is.readLine());
            	}

 
            }
            
            pw.close();
            is.close();
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
