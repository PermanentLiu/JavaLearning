package com.permanent_liufoxmail.helloworld;

        import android.content.Context;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class HelloWorldActivity extends AppCompatActivity
{
    private Button button1;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new PlusOne(this.button1, this.button2));
        button2.setOnClickListener(new MutiplyTwo(this.button2, this.button1));

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
        temp = temp + 1;
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
        temp *= 2;
        button_text = Integer.toString(temp);
        button2.setText(button_text);
    }
}
