package com.example.cjeon.myapplication;

import android.content.Context;
import android.support.v4.view.ViewGroupCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLifeCycleActivity extends AppCompatActivity {
    private int score = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        textView = (TextView) findViewById(R.id.LifecycleScore);
        textView.setText(String.valueOf(score));
        showToast("created!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        showToast("started!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        showToast("resumed!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        showToast("paused!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        showToast("stopped!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        showToast("destroyed!");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        score += 1;
        textView.setText(String.valueOf(score));
        return super.onTouchEvent(event);
    }


    public void showToast(CharSequence message){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
