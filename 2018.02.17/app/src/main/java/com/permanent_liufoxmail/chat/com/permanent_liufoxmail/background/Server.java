package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

/**
 * Created by 10142 on 2018/2/5.
 */

public class Server
{
    private boolean flag = true;

    private String content;

//    private ServerSocket serverSocket = new ServerSocket(8080);
//
//    private Socket socket = serverSocket.accept();
//
//    private PrintWriter out = new PrintWriter(socket.getOutputStream());
//
//    private ThreadReverse threadReverse = new ThreadReverse(socket);



    public Server()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(8081);

            Socket socket = serverSocket.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream());

            ThreadReverse threadReverse = new ThreadReverse(socket);


            while (flag)
            {
                threadReverse.start();
                out.println(content);
                out.flush();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }



    public void setContent(String content)
    {
        this.content = content;
    }
}
