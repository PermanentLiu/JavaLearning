package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background;

import android.content.SyncStatusObserver;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by 10142 on 2018/2/5.
 */

public class ThreadReverse extends Thread
{
    Socket socket;

    public ThreadReverse(Socket socket)
    {
        this.socket = socket;
    }


    @Override
    public void run()
    {
        BufferedReader in = null;

        try
        {
            in = new BufferedReader(new InputStreamReader(socket));
        }
        catch (Exception e)
        {
            Log.d("error", e.toString());
        }

        while (true)
        {
            try
            {

            }
            catch (Exception e)
            {
                Log.d("error", e.toString());
            }
        }
    }
}
