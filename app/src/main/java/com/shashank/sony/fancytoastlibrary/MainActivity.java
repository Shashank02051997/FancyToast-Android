package com.shashank.sony.fancytoastlibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button)
            FancyToast.makeText(this, "This is Default Toast", FancyToast.LENGTH_LONG, FancyToast.DEFAULT, true).show();
        else if (v.getId() == R.id.button2)
            FancyToast.makeText(this, "Success Toast !", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
        else if (v.getId() == R.id.button3)
            FancyToast.makeText(this, "This is an Error Toast", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        else if (v.getId() == R.id.button4)
            FancyToast.makeText(this, "Beware of dog", FancyToast.LENGTH_LONG, FancyToast.WARNING, true).show();
        else if (v.getId() == R.id.button5)
            FancyToast.makeText(this, "Here is some Info for you", FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();
        else if (v.getId() == R.id.button6)
            FancyToast.makeText(this, "This is Confusing Toast", FancyToast.LENGTH_LONG, FancyToast.CONFUSING, false).show();
        else if (v.getId() == R.id.button7)
            FancyToast.makeText(this, "This is Custom Toast", FancyToast.LENGTH_LONG, FancyToast.CONFUSING, R.drawable.ic_android_black_24dp, true).show();
        else if (v.getId() == R.id.button8)
            FancyToast.makeText(this, "This is Custom Toast with no android icon", FancyToast.LENGTH_LONG, FancyToast.CONFUSING, R.drawable.ic_android_black_24dp, false).show();
        else if (v.getId() == R.id.button9)
            FancyToast.makeText(this, "This is a Success Toast", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
    }
}
