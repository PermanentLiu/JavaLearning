package com.permanent_liufoxmail.calculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;


import android.widget.Button;
import android.widget.TextView;


public class FirstActivity extends AppCompatActivity implements OnClickListener
{
    private TextView textView;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button devide;
    private Button mod;
    private Button c;
    private Button point;
    private Button equal;
    private Button back;

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textView = (TextView) findViewById(R.id.textView);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiply = (Button) findViewById(R.id.multiply);
        devide = (Button) findViewById(R.id.devide);
        mod = (Button) findViewById(R.id.mod);
        c = (Button) findViewById(R.id.c);
        point = (Button) findViewById(R.id.point);
        equal = (Button) findViewById(R.id.equal);
        back = (Button) findViewById(R.id.back);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        devide.setOnClickListener(this);
        mod.setOnClickListener(this);
        c.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
//            case R.id.textView:break;
            case R.id.button0:
                this.textView.append("0");
                break;
            case R.id.button1:
                this.textView.append("1");
                break;
            case R.id.button2:
                this.textView.append("2");
                break;
            case R.id.button3:
                this.textView.append("3");
                break;
            case R.id.button4:
                this.textView.append("4");
                break;
            case R.id.button5:
                this.textView.append("5");
                break;
            case R.id.button6:
                this.textView.append("6");
                break;
            case R.id.button7:
                this.textView.append("7");
                break;
            case R.id.button8:
                this.textView.append("8");
                break;
            case R.id.button9:
                this.textView.append("9");
                break;
            case R.id.plus:
                this.textView.append("+");
                break;
            case R.id.minus:
                this.textView.append("-");
                break;
            case R.id.multiply:
                this.textView.append("*");
                break;
            case R.id.devide:
                this.textView.append("/");
                break;
            case R.id.mod:
                this.textView.append("%");
                break;
            case R.id.c:
                this.textView.setText(null);
                break;
            case R.id.point:
                this.textView.append(".");
                break;

            case R.id.equal:
                this.textView.append("=");
                break;
            case R.id.back:
                this.text = this.textView.getText().toString();

//                Log.i("length", String.valueOf(this.text.length()));

                if (this.text.length() == 0)
                {
                    this.textView.setText(null);
                }
                else
                {
                    char[] temp = new char[this.text.length() - 1];
                    this.text.getChars(0, this.text.length() - 1, temp, 0);
                    this.textView.setText(String.valueOf(temp));
                }

                break;

        }
    }
}

