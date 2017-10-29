package com.permanent_liufoxmail.calculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;


import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


public class FirstActivity extends AppCompatActivity implements OnClickListener
{
    private TextView textView10;
    private TextView textView9;
    private TextView textView8;
    private TextView textView7;
    private TextView textView6;
    private TextView textView5;
    private TextView textView4;
    private TextView textView3;
    private TextView textView2;
    private TextView textView1;
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
    private ScrollView scrollView;

    private float lastNumber;
    private float thisNumber;
    private char operation;
    private float result;
    private int flag = 0;
    private int lastNumber_t = 0;

    private void calculate()
    {
        String text;

        switch (operation)
        {
            case '+':
                result = lastNumber + thisNumber;
                break;
            case '-':
                result = lastNumber - thisNumber;
                break;
            case '*':
                result = lastNumber * thisNumber;
                break;
            case '/':
                result = lastNumber / thisNumber;
                break;
            case '%':
                result = lastNumber % thisNumber;
                break;
        }



        Log.d("lastnumber: ", Float.toString(lastNumber));
        Log.d("thisnumber: ", Float.toString(thisNumber));
        Log.d("result: ", Float.toString(result));

        text = Float.toString(result);

        textView1.setText("= " + text);

        lastNumber_t = 0;

        flag = 1;
    }


    private void recordNumber()
    {
        if (lastNumber_t == 1)
        {
            String text;
            text = textView1.getText().toString();
            thisNumber = Integer.parseInt(text);
        }
        else if (lastNumber_t == 0)
        {
            String text;
            text = textView1.getText().toString();
            lastNumber = Integer.parseInt(text);

            lastNumber_t = 1;
        }
    }

    private void roll()
    {
        if (flag == 1)
        {
            up();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        textView10 = (TextView) findViewById(R.id.textView10);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView1 = (TextView) findViewById(R.id.textView1);
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
        scrollView = (ScrollView) findViewById(R.id.scrollView);

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


        scrollToButtom();


    }


    private void scrollToButtom()
    {
        scrollView.post(new Runnable()
        {
            @Override
            public void run()
            {
                scrollView.scrollTo(0, 5000);
            }
        });
    }

    private void up()
    {
        textView10.setText(textView9.getText());
        textView9.setText(textView8.getText());
        textView8.setText(textView7.getText());
        textView7.setText(textView6.getText());
        textView6.setText(textView5.getText());
        textView5.setText(textView4.getText());
        textView4.setText(textView3.getText());
        textView3.setText(textView2.getText());
        textView2.setText(textView1.getText());
        textView1.setText(null);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button0:
                scrollToButtom();
                roll();
                this.textView1.append("0");
                flag = 0;
                break;
            case R.id.button1:
                scrollToButtom();
                roll();
                this.textView1.append("1");
                flag = 0;
                break;
            case R.id.button2:
                scrollToButtom();
                roll();
                this.textView1.append("2");
                flag = 0;
                break;
            case R.id.button3:
                scrollToButtom();
                roll();
                this.textView1.append("3");
                flag = 0;
                break;
            case R.id.button4:
                scrollToButtom();
                roll();
                this.textView1.append("4");
                flag = 0;
                break;
            case R.id.button5:
                scrollToButtom();
                roll();
                this.textView1.append("5");
                flag = 0;
                break;
            case R.id.button6:
                scrollToButtom();
                roll();
                this.textView1.append("6");
                flag = 0;
                break;
            case R.id.button7:
                scrollToButtom();
                roll();
                this.textView1.append("7");
                flag = 0;
                break;
            case R.id.button8:
                scrollToButtom();
                roll();
                this.textView1.append("8");
                flag = 0;
                break;
            case R.id.button9:
                scrollToButtom();
                roll();
                this.textView1.append("9");
                flag = 0;
                break;
            case R.id.plus:
                recordNumber();
                scrollToButtom();
                roll();
                up();
                this.textView1.append("+");
                operation = '+';
                flag = 1;
                break;
            case R.id.minus:
                recordNumber();
                scrollToButtom();
                roll();
                up();
                this.textView1.append("-");
                operation = '-';
                flag = 1;
                break;
            case R.id.multiply:
                recordNumber();
                scrollToButtom();
                roll();
                up();
                this.textView1.append("*");
                operation = '*';
                flag = 1;
                break;
            case R.id.devide:
                recordNumber();
                scrollToButtom();
                roll();
                up();
                this.textView1.append("/");
                operation = '/';
                flag = 1;
                break;
            case R.id.mod:
                recordNumber();
                scrollToButtom();
                roll();
                up();
                this.textView1.append("%");
                operation = '%';
                flag = 1;
                break;
            case R.id.equal:
                recordNumber();
                scrollToButtom();
                roll();
                up();
//                this.textView1.append("=");
                calculate();
                flag = 1;
                break;
            case R.id.c:
                scrollToButtom();
                roll();
                this.textView1.setText(null);
                this.textView2.setText(null);
                this.textView3.setText(null);
                this.textView4.setText(null);
                this.textView5.setText(null);
                this.textView6.setText(null);
                this.textView7.setText(null);
                this.textView8.setText(null);
                this.textView9.setText(null);
                this.textView10.setText(null);
                break;
            case R.id.point:
                scrollToButtom();
                roll();
                this.textView1.append(".");
                flag = 0;
                break;

            case R.id.back:
                String text;
                text = this.textView1.getText().toString();

//                Log.i("length", String.valueOf(this.text.length()));

                if (text.length() == 0)
                {
                    this.textView1.setText(null);
                }
                else
                {
                    char[] temp = new char[text.length() - 1];
                    text.getChars(0, text.length() - 1, temp, 0);
                    this.textView1.setText(String.valueOf(temp));
                }

                break;

        }
    }


}

