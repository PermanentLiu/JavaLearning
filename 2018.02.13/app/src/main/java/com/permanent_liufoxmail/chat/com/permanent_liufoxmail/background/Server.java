package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 10142 on 2018/2/5.
 */

public class Server extends ChatFather
{
    private boolean flag = true;

    private String content;

    private ServerSocket serverSocket = new ServerSocket(8080);

    private Socket socket = serverSocket.accept();

    private PrintWriter out = new PrintWriter(socket.getOutputStream());

    private ThreadReverse threadReverse = new ThreadReverse(socket);

    public void closeServer() throws IOException
    {
        out.close();
        socket.close();
        serverSocket.close();
    }

    public Server() throws Exception
    {
        while (flag)
        {
            threadReverse.start();
            out.println(content);
            out.flush();
        }
    }



    public void setContent(String content)
    {
        this.content = content;
    }
}
