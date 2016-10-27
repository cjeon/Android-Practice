package com.example.cjeon.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SQLiteActivity extends AppCompatActivity {
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
    }

    public void saveItem(View v){
        EditText editText = (EditText) findViewById(R.id.editText4_1);
        String text = editText.getText().toString();
        editText.getText().clear();

        db = openOrCreateDatabase("Temp.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        try {
            final String CREATE_TABLE_CONTAIN = "CREATE TABLE IF NOT EXISTS sqlite ("
                    + "ID INTEGER primary key AUTOINCREMENT,"
                    + "VALUE TEXT);";
            db.execSQL(CREATE_TABLE_CONTAIN);
            String sql = String.format("INSERT INTO sqlite (VALUE) VALUES('%s')", text);
            db.execSQL(sql);
        }
        catch (Exception e) {
            Toast.makeText(this, "ERROR "+e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void loadItem(View v){

        TextView textView = (TextView) findViewById(R.id.display_board_4_1);

        try {
            Cursor c = db.rawQuery("select * from sqlite order by ID desc limit 1", new String[] {});
            if (c.moveToFirst()) {
                String value = c.getString(c.getColumnIndex("VALUE"));
                textView.setText(value);
            }
            c.close();

        } catch (Exception e) {
            Toast.makeText(this, "ERROR "+e.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
