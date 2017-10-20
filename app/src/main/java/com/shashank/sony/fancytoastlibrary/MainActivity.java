package com.shashank.sony.fancytoastlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.button5);
        b6=(Button) findViewById(R.id.button6);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {   if(v.getId()==R.id.button)
        FancyToast.makeText(this,"This is Default Toast",FancyToast.LENGTH_LONG,FancyToast.DEFAULT).show();
        else if(v.getId()==R.id.button2)
        FancyToast.makeText(this,"Success Toast !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS).show();
        else if(v.getId()==R.id.button3)
        FancyToast.makeText(this,"This is an Error Toast",FancyToast.LENGTH_LONG,FancyToast.ERROR).show();
        else if(v.getId()==R.id.button4)
        FancyToast.makeText(this,"Beware of dog",FancyToast.LENGTH_LONG,FancyToast.WARNING).show();
        else if(v.getId()==R.id.button5)
        FancyToast.makeText(this,"Here is some Info for you",FancyToast.LENGTH_LONG,FancyToast.INFO).show();
        else if(v.getId()==R.id.button6)
        FancyToast.makeText(this,"This is Confusing Toast",FancyToast.LENGTH_LONG,FancyToast.CONFUSING).show();
    }
}
