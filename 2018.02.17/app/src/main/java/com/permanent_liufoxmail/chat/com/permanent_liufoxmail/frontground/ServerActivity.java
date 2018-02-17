package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.frontground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.permanent_liufoxmail.chat.R;
import com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background.Adapter.MessageAdapter;
import com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background.Message;

import java.util.ArrayList;
import java.util.List;

import com.permanent_liufoxmail.chat.com.permanent_liufoxmail.background.Server;

public class ServerActivity extends AppCompatActivity
{
    public static List<Message> messageList = new ArrayList<>();

    private EditText inputText;

    private Button send;

    private RecyclerView messageRecyclerView;

    private MessageAdapter messageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        final Server server = new Server();

        initMessage();

        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        messageRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        messageRecyclerView.setLayoutManager(layoutManager);

        messageAdapter = new MessageAdapter(messageList);

        messageRecyclerView.setAdapter(messageAdapter);



        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String content = inputText.getText().toString();

                if (! "".equals(content))
                {
                    server.setContent(content);

                    Message message = new Message(content, Message.TYPE_SENT);
                    messageList.add(message);

                    messageAdapter.notifyItemInserted(messageList.size() - 1);
//                    messageRecyclerView.smoothScrollToPosition(messageList.size() - 1);

                    inputText.setText("");
                }
            }
        });

    }

    private void initMessage()
    {
        Message message2 = new Message("This is a test content (SENT)", Message.TYPE_SENT);
        messageList.add(message2);
        Message message1 = new Message("This is a test content (RECEIVED)", Message.TYPE_RECEIVED);
        messageList.add(message1);

    }
}
