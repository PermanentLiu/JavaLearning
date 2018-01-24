import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.w3c.dom.ls.LSException;

public class Client
{
	public static void main(String[] args) 
	{
        // TODO Auto-generated method stub
		
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String aString = null;
        
        
        try 
        {
            //创建一个Socket，跟服务器的8080端口链接
            Socket socket = new Socket("192.168.31.227",8080);

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            
            Reserve reserve = new Reserve(socket);
            reserve.start();
            

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
            out.close();
            socket.close();
          
            

            
        } 
        catch (UnknownHostException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
