package com.permanent_liufoxmail.calculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class FirstActivity extends AppCompatActivity implements OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.textView:break;
            case R.id.button0:break;
            case R.id.button1:break;
            case R.id.button2:break;
            case R.id.button3:break;
            case R.id.button4:break;
            case R.id.button5:break;
            case R.id.button6:break;
            case R.id.button7:break;
            case R.id.button8:break;
            case R.id.button9:break;
            case R.id.plus:break;
            case R.id.minus:break;
            case R.id.multiply:break;
            case R.id.devide:break;
            case R.id.mod:break;
            case R.id.c:break;
            case R.id.point:break;
            case R.id.equal:break;

        }
    }
}

class button0OnClick implements OnClickListener
{

    @Override
    public void onClick(View view)
    {

    }
}
