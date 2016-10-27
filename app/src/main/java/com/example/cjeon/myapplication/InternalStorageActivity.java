package com.example.cjeon.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InternalStorageActivity extends AppCompatActivity {
    private String filename = "INTERNAL_IO_TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
    }

    public void saveItem(View v){

        EditText editText = (EditText) findViewById(R.id.editText4_1);
        String text = editText.getText().toString();
        editText.getText().clear();
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadItem(View v){

        TextView textView = (TextView) findViewById(R.id.display_board_4_1);
        FileInputStream inputStream;

        try {
            String data;
            inputStream = openFileInput(filename);
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            data = result.toString("UTF-8");

            textView.setText(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
