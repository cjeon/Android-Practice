package com.example.cjeon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.os.Build.VERSION_CODES.M;

public class StartAnotherActivityActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_another_activity);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, EmptyActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText1_4);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
