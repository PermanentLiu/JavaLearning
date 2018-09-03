package com.example.wificlient;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    EditText edittext;
    Button button;
    Button joint_button;
    Button car_button;
    Button load_button;
    Button find;
    //Button break_button;
    EditText server;
    EditText portText;
    EditText send;
    TextView text;
    EditText phone;
    EditText num;
    static Socket socket = null;
    static PrintWriter writer = null;
    static InputStream inputStream = null;//定义输入流
    static OutputStream outputStream = null;//定义输出流
    public char flag =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        if (savedInstanceState != null) {
            String tempData = savedInstanceState.getString("server_ip");
            server.setText(tempData);
            //tempData = savedInstanceState.getString("port_text");
            portText.setText(savedInstanceState.getString("port_text"));
        }
        joint_button.setOnClickListener(JointButtonListener);
        button.setOnClickListener(ButtonListener);
        car_button.setOnClickListener(CarButtonListener);
        load_button.setOnClickListener(LoadButtonListener);
        find.setOnClickListener(FindListener);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("server_ip", server.getText().toString());
        outState.putString("port_text", portText.getText().toString());
    }

    private void findView() {
        //description = (TextView)findViewById(R.id.description);
        load_button=(Button)findViewById(R.id.car1);
        car_button=(Button) findViewById(R.id.car);
        button = (Button) findViewById(R.id.send);
        find=(Button)findViewById(R.id.sele) ;
        joint_button = (Button) findViewById(R.id.Button_joint);
        server = (EditText) findViewById(R.id.EditText_IP);
        portText = (EditText) findViewById(R.id.EditText_port);
        send = (EditText) findViewById(R.id.EditText_send);
        text = (TextView) findViewById(R.id.TextView_receive);
        phone=(EditText)findViewById(R.id.editText_P);
        num=(EditText)findViewById(R.id.editText_num);
        find.setEnabled(false);
        car_button.setEnabled(false);
        load_button.setEnabled(false);
    }

    //发送监听
    private View.OnClickListener ButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            try {
                String text;
                outputStream = socket.getOutputStream();
                text= "phone:"+phone.getText().toString()+":"+num.getText().toString()+":"+"enter";
//                outputStream.write(send.getText().toString().getBytes());
                outputStream.write(text.getBytes());
//                Toast.makeText(getApplicationContext(), "enter success", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private View.OnClickListener FindListener = new View.OnClickListener() {
        public void onClick(View v) {
            try {
                String text;
                outputStream = socket.getOutputStream();
                text= "phone:find:"+phone.getText().toString()+":";
//                outputStream.write(send.getText().toString().getBytes());
                outputStream.write(text.getBytes());
                Toast.makeText(getApplicationContext(), edittext.getText().toString(), Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private View.OnClickListener LoadButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            try {
                String text;
                outputStream = socket.getOutputStream();
                text= "phone:car1:"+phone.getText().toString()+":";
//                outputStream.write(send.getText().toString().getBytes());
                outputStream.write(text.getBytes());
                Toast.makeText(getApplicationContext(), edittext.getText().toString(), Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private View.OnClickListener CarButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            try {
                String text;
                outputStream = socket.getOutputStream();
                text= "phone:car2:"+phone.getText().toString()+":";
//                outputStream.write(send.getText().toString().getBytes());
                outputStream.write(text.getBytes());
                Toast.makeText(getApplicationContext(), edittext.getText().toString(), Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    //连接监听
    private View.OnClickListener JointButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            NearConnect_Thread nearConnect_thread = new NearConnect_Thread();
            nearConnect_thread.start();
        }
    };

    //连接线程
    class NearConnect_Thread extends Thread {
        public void run() {
            try {
                InetAddress ipAddress = InetAddress.getByName(server.getText().toString());
                int port = Integer.valueOf(portText.getText().toString());
                socket = new Socket(ipAddress, port);        //连接服务器
                if (socket != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "已成功连接！", Toast.LENGTH_SHORT).show();

                        }
                    });
                    String text="android";
                    outputStream = socket.getOutputStream();
                    outputStream.write(text.getBytes());
                } else {
                    Toast.makeText(MainActivity.this, "连接失败！", Toast.LENGTH_SHORT).show();
                }
                Receive_Thread receive_Thread = new Receive_Thread();
                receive_Thread.start();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    class Receive_Thread extends Thread {
        public void run()//重写run方法
        {
            try {
                while (true) {
                    final byte[] buffer = new byte[1024];
                    inputStream = socket.getInputStream();
                    final int len = inputStream.read(buffer);
                     runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                    {
                        public void run()
                        {
                            String data=new String(buffer);
                            //TODO Auto-generated method stub
//                            text.setText(new String(buffer,0,len));
//                            String txt=text.getText().toString();

                            if(data.indexOf("enable")!=-1)
                            {
                                Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
                                car_button.setEnabled(true);
                                find.setEnabled(true);
                                load_button.setEnabled(true);
                            }
                            else if(data.indexOf("success")!=-1)
                            {
                                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
                            }
                            else
                                text.setText(new String(buffer,0,len));

                        }
                    });
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
