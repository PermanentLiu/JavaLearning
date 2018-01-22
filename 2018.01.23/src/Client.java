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
            
            
            
            //使用PrintWriter和BufferedReader进行读写数据
            
            
            BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            
            
            
            
            while (flag)
            {
            aString = scanner.nextLine();
            	if (aString.equals("exit"))
            	{
            		flag = false;
            		break;
            	}
            	else
            	{
            		
            		out.println(aString);
            		out.flush();
            		System.out.println("received from server: \n" + in.readLine());
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
