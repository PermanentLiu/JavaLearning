package com.permanent_liufoxmail.helloworld;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



/**
 * Created by 10142 on 2017/10/24.
 */

public class SecondActivity extends AppCompatActivity
{
    private TextView textView1;
    private int initNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textView1 = (TextView) findViewById(R.id.textview1);

        Intent intent = getIntent();
        initNumber = intent.getIntExtra("intentNumber",0);
    }
}

class initTextView1
{
    private int initNumber;
    private int result;
    private TextView textView;
    private Context context;

    public initTextView1(TextView textView, Context context, int initNumber)
    {
        this.textView = textView;
        this.context = context;
        this.initNumber = initNumber;

        deal();
    }

    private void deal()
    {
        result = initNumber * 111;

        textView.setText("The old number is: " + initNumber + ", and it * 111 = " + result);
    }
}
