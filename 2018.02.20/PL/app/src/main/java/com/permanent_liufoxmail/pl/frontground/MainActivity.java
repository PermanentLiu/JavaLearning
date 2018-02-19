package com.permanent_liufoxmail.pl.frontground;


import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.permanent_liufoxmail.pl.R;
import com.permanent_liufoxmail.pl.background.Adapter.RecyclerAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private EditText content;
    private Button send;
    private Socket socket;
    private ArrayList<com.permanent_liufoxmail.pl.background.Message> list;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        content = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.sent);
        list = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(this);

        final Handler handler = new MyHandler();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    socket = new Socket("192.168.31.227", 10010);
                    InputStream inputStream = socket.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer)) != -1)
                    {
                        String data = new String(buffer, 0, len);
                        // 发到主线程中 收到的数据
                        Message message = Message.obtain();
                        message.what = 1;
                        message.obj = data;
                        handler.sendMessage(message);
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final String data = content.getText().toString();
                content.setText("");

                if (! data.equals(""))
                {
                    new Thread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                OutputStream outputStream = socket.getOutputStream();
                                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                                outputStream.write((socket.getLocalPort() + "//" + data + "//" + df.format(new Date())).getBytes("utf-8"));
                                outputStream.flush();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }

            }
        });
    }

    private class MyHandler extends Handler
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            if (msg.what == 1)
            {
                int localPort = socket.getLocalPort();
                String[] split = ((String) msg.obj).split("//");

                if (split[0].equals(localPort + ""))
                {
                    com.permanent_liufoxmail.pl.background.Message bean = new com.permanent_liufoxmail.pl.background.Message(split[1], 1, split[2], "我：");
                    list.add(bean);
                }
                else
                {
                    com.permanent_liufoxmail.pl.background.Message bean = new com.permanent_liufoxmail.pl.background.Message(split[1], 2, split[2], ("来自：" + split[0]));
                    list.add(bean);
                }

                // 向适配器set数据
                recyclerAdapter.setMessage(list);
                recyclerView.setAdapter(recyclerAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(manager);

            }

        }

    }

}