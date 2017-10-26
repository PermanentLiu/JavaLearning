package com.permanent_liufoxmail.helloworld;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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


        Intent intent = getIntent();
        initNumber = intent.getIntExtra("intentNum", 0);


        textView1 = (TextView) findViewById(R.id.textview1);

        new initTextView1(textView1, initNumber);
    }
}

class initTextView1
{
    private int initNumber;
    private int result;
    private TextView textView;

    public initTextView1(TextView textView, int initNumber)
    {
        this.textView = textView;
        this.initNumber = initNumber;

        deal();
    }

    private void deal()
    {
        result = initNumber * 111;

        textView.setText("The old number is: " + initNumber + ", and it * 111 = " + result);
    }

}
