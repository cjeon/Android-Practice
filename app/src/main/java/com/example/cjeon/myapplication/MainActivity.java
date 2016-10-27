package com.example.cjeon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_1_3onClick(View view) {
        Intent intent = new Intent(this, SimpleUIActivity.class);
        startActivity(intent);
    }

    public void button_1_4onClick(View view) {
        Intent intent = new Intent(this, StartAnotherActivityActivity.class);
        startActivity(intent);
    }

    public void button_2_2onClick(View view) {
        Intent intent = new Intent(this, OrientationSensitiveActivity.class);
        startActivity(intent);
    }

    public void button_2_3onClick(View view) {
        Intent intent = new Intent(this, DifferentThemeActivity.class);
        startActivity(intent);
    }

    public void button_3_1onClick(View view) {
        Intent intent = new Intent(this, ActivityLifeCycleActivity.class);
        startActivity(intent);
    }

    public void button_3_2onClick(View view) {
        Intent intent = new Intent(this, ActivityLifeCycleActivity2.class);
        startActivity(intent);
    }

    public void button_4_1onClick(View view) {
        Intent intent = new Intent(this, FragmentActivity.class);
        startActivity(intent);
    }

    public void button_5_1onClick(View view) {
        Intent intent = new Intent(this, InternalStorageActivity.class);
        startActivity(intent);
    }
}