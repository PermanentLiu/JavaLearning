package com.permanent_liufoxmail.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button shiftDayNight;




    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

//        if (theme == R.style.nightTheme)
//        {
//            setTheme(R.style.nightTheme);
//        }
//        else
//        {
//            setTheme(R.style.dayTheme);
//        }
//        Log.d("theme", String.valueOf(theme));
//        Log.d("theme", String.valueOf(R.style.nightTheme));
//        Log.d("theme", String.valueOf(R.style.dayTheme));

        super.onCreate(savedInstanceState);
//        if (theme == R.style.nightTheme)
//        {
//            setContentView(R.layout.activity_third_nighttheme);
//        }
//        else
//        {
//            setContentView(R.layout.activity_third_daytheme);
//        }
        setTheme(FirstActivity.theme);
        setContentView(R.layout.activity_third);


        Log.d("theme = daytheme", String.valueOf(FirstActivity.theme == R.layout.activity_third_daytheme));
        Log.d("theme = nighttheme", String.valueOf(FirstActivity.theme == R.layout.activity_third_nighttheme));


        shiftDayNight = (Button) findViewById(R.id.shiftDayNight);

        shiftDayNight.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.shiftDayNight:
                shiftDayNightOnClicked();
                break;
        }
    }

    private void shiftDayNightOnClicked()
    {


        if (FirstActivity.theme == R.style.nightTheme)
        {
            FirstActivity.theme = R.style.AppTheme;

            this.recreate();
        }
        else
        {
            FirstActivity.theme = R.style.nightTheme;

            this.recreate();
        }

    }
}


