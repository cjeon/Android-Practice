package com.example.cjeon.myapplication;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FragmentActivity extends Activity implements BlankFragment.OnClickListener{
    private int count = 0;
    public static final String COLOR_KEY = "color key";
    private static final String[] colors = new String[] {"#ffb3ba", "#ffdfba", "#ffffba", "#baffc9", "#bae1ff"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public void getFragment(View v){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_place_holder_0, new BlankFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void changeColor() {
        count += 1;
        count %= 5;
        TextView textView = (TextView) findViewById(R.id.fragment_blank_body);
        textView.setBackgroundColor(Color.parseColor(colors[count]));

    }
}
