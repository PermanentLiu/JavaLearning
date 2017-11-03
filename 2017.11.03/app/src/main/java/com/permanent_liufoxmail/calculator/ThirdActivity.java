package com.permanent_liufoxmail.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button shiftDayNight;

    public static int record = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

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
        Log.d("record:.......", Integer.toString(record));

        if (record == 0)
        {
            setTheme(R.style.dayTheme);
            record = 1;
        }
        else
        {
            setTheme(R.style.nightTheme);
            record = 0;
        }
    }
}


