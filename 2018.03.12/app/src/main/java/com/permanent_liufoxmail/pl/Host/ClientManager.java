package com.permanent_liufoxmail.pl.Host;

import com.permanent_liufoxmail.pl.Host.Thread.ServerThread;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10142 on 2018/2/17.
 */

public class ClientManager
{
    public static Map<String, Socket> clientList = new HashMap<>();
    private static ServerThread serverThread = null;

    //判断serverThread是否为空之后在startThread
    public static ServerThread startServer()
    {
        System.out.println("Start servise!");

        if (serverThread != null)
        {
            showDown();
        }

        serverThread = new ServerThread();
        new Thread(serverThread).start();

        System.out.println("Start servise succeed!");

        return serverThread;
    }

    //关闭map中的所有socket，thread，清空map
    public static void showDown()
    {
        for (Socket socket : clientList.values())
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        serverThread.stop();
        clientList.clear();
    }

    public static boolean sendMessageAll(String message)
    {
        try
        {
            for (Socket socket : clientList.values())
            {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(message.getBytes("utf-8"));
            }

            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
