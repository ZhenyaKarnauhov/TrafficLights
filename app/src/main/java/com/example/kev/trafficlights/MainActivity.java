package com.example.kev.trafficlights;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG;
    private Button redBtn;
    private Button yellowBtn;
    private Button greenBtn;
    private LinearLayout linearLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBtn = (Button) findViewById(R.id.redBtn);
        yellowBtn = (Button) findViewById(R.id.yellowBtn);
        greenBtn = (Button) findViewById(R.id.greenBtn);
        linearLayout = (LinearLayout) findViewById(R.id.background);

    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.redBtn):
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case (R.id.yellowBtn):
                linearLayout.setBackgroundColor(Color.YELLOW);
                break;
            case (R.id.greenBtn):
                linearLayout.setBackgroundColor(Color.GREEN);
                break;
        }
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        View view = findViewById(R.id.background);
        int color = Color.TRANSPARENT;
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();
        outState.putInt("background" , color);
    }
    protected void onRestoreInstanceState( Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        View view = findViewById(R.id.background);

        if (savedInstanceState != null && savedInstanceState.containsKey("background")) {
            view.setBackgroundColor(savedInstanceState.getInt("background"));
        }
    }
}

