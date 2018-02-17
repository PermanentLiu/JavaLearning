package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background;

import android.util.Log;
import android.widget.Toast;

import com.permanent_liufoxmail.chat.com.permanent_liufoxmail.frontground.ClientActivity;
import com.permanent_liufoxmail.chat.com.permanent_liufoxmail.frontground.ServerActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by 10142 on 2018/2/5.
 */

public class ThreadReverse extends Thread
{
    private Socket socket;

    public ThreadReverse(Socket socket)
    {
        this.socket = this.socket;
    }


    @Override
    public void run()
    {
        BufferedReader in = null;

        try
        {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (Exception e)
        {
            Log.d("error", e.toString());
        }


        try
        {
            ClientActivity.messageList.add(new Message(in.readLine(), Message.TYPE_RECEIVED));
            ServerActivity.messageList.add(new Message(in.readLine(), Message.TYPE_RECEIVED));
        }
        catch (Exception e)
        {
            Log.d("error", e.toString());
        }

    }
}
