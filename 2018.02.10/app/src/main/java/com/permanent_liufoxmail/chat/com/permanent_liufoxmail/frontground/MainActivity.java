package com.permanent_liufoxmail.chat.com.permanent_liufoxmail.frontground;

import android.content.Context;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.permanent_liufoxmail.chat.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button ButtonA;
    private Button ButtonB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonA = (Button) findViewById(R.id.ButtonA);
        ButtonB = (Button) findViewById(R.id.ButtonB);

        ButtonA.setOnClickListener(this);
        ButtonB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.ButtonA:
                //open Activity A
                Intent intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ButtonB:
                //open Activity B
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();


        }
    }
}
