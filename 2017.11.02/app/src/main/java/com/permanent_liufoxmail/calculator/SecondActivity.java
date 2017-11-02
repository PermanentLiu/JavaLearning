package com.permanent_liufoxmail.calculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URI;
import java.net.URL;

public class SecondActivity extends AppCompatActivity implements OnClickListener
{
    private TextView web;
    private TextView introduce;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        web = (TextView) findViewById(R.id.web);
        introduce = (TextView) findViewById(R.id.introduce);

        web.setOnClickListener(this);

        initText();
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.web:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.permanentliu.cn"));
                startActivity(intent);
                break;
        }
    }

    private void initText()
    {
        introduce.setText
                (
                        "\n\n\n" +
                        "When other men are blindly \n\n" +
                        "follow the truth\n\n" +
                        "remember\n\n" +
                        "Nothing is true\n\n" +
                        "\n\n\n\n\n\n" +
                        "when other men are limited \n\n" +
                        "by morality or laws\n\n" +
                        "remember\n\n" +
                        "Everything is permitted\n\n" +
                        "\n\n\n\n\n\n" +
                        "we work in dark to serve the light\n\n" +
                        "we are Developers\n\n" +
                        "\n\n\n\n\n\n" +
                        "Nothing is true\n\n" +
                        "Everything is permitted\n\n" +
                        "\n\n\n"
                );
    }
}
