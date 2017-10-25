package com.permanent_liufoxmail.helloworld;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import static android.support.v4.content.ContextCompat.startActivity;
        import static com.permanent_liufoxmail.helloworld.R.id.textview1;

public class HelloWorldActivity extends AppCompatActivity
{
    private Button button1;
    private Button button2;
    private Button button3;
    private EditText editText1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        editText1 = (EditText) findViewById(R.id.textview1);

        button1.setOnClickListener(new PlusOne(this.button1, this.button2));
        button2.setOnClickListener(new MutiplyTwo(this.button2, this.button1));
        button3.setOnClickListener(new textViewOnClick(button3, HelloWorldActivity.this, SecondActivity.class));

//        button3.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent hwToSecond = new Intent(HelloWorldActivity.this, SecondActivity.class);
//                startActivity(hwToSecond);
//            }
//        });


    }

}

class textMultiplyTwo implements View.OnClickListener
{
    private String number;

    public textMultiplyTwo(String number)
    {
        this.number = number;
    }

    @Override
    public void onClick(View view)
    {

    }
}


class textViewOnClick implements View.OnClickListener
{
    private Button button;
    private Context a1;
    private Class a2;

    public textViewOnClick(Button button, Context a1, Class a2)
    {
        this.button = button;
        this.a1 = a1;
        this.a2 = a2;
    }

    @Override
    public void onClick(View view)
    {
        Intent hwToSecond = new Intent(a1, a2);
        a1.startActivity(hwToSecond);
    }
}




class PlusOne implements View.OnClickListener
{
    private String button_text;
    private Button button1;
    private Button button2;
    private int temp;

    public PlusOne(Button button1, Button button2)
    {
        this.button1 = button1;
        this.button2 = button2;
    }


    @Override
    public void onClick(View view)
    {
        button_text = button2.getText().toString();
        temp = Integer.parseInt(button_text);
        temp *= 3;
        button_text = Integer.toString(temp);
        button2.setText(button_text);


    }
}

class MutiplyTwo implements View.OnClickListener
{
    private String button_text;
    private Button button1;
    private Button button2;
    private int temp;

    public MutiplyTwo(Button button1, Button button2)
    {
        this.button1 = button1;
        this.button2 = button2;
    }


    @Override
    public void onClick(View view)
    {
        button_text = button2.getText().toString();
        temp = Integer.parseInt(button_text);
        temp += temp;
        button_text = Integer.toString(temp);
        button2.setText(button_text);
    }
}
