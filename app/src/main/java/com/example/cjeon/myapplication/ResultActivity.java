package com.example.cjeon.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        if (intent.getType() != null && intent.getType().equals("text/plain")) {
            String text = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView textView = (TextView) findViewById(R.id.text_6_3);
            textView.setText(text);
        }

    }

    public void pickNumber(View view) {
        Intent pickPhone = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickPhone.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(pickPhone, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Uri contactUri = data.getData();
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToFirst();
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);
                cursor.close();

                TextView textView = (TextView) findViewById(R.id.text_6_3);
                textView.setText(number);
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
