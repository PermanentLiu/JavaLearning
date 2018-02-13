package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background;

import android.util.Log;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by 10142 on 2018/2/5.
 */

public class Client extends ChatFather
{

    private String content;

    private boolean flag = true;

    private Socket socket = new Socket("192.168.31.227", 8080);

    private PrintWriter out = new PrintWriter(socket.getOutputStream());

    private ThreadReverse threadReverse = new ThreadReverse(socket);

    public void setContent(String content)
{
    this.content = content;
}

    public void closeClient() throws IOException
    {
        out.close();
        socket.close();
    }

    public Client() throws IOException
    {
        while (flag)
        {
            threadReverse.start();
            out.println(content);
            out.flush();
        }
    }
}
