package com.example.cjeon.myapplication;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.View;

public class FragmentActivity extends Activity {
    private int count = 0;
    private static final int[] ids = new int[] {R.id.fragment_place_holder_0, R.id.fragment_place_holder_1,
                                                R.id.fragment_place_holder_2, R.id.fragment_place_holder_3,
                                                R.id.fragment_place_holder_4};
    public static final String COLOR_KEY = "color key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public void getFragment(View v){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_place_holder_0, new BlankFragment());
        fragmentTransaction.commit();


//        BlankFragment blankFragment = new BlankFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(COLOR_KEY, count);
//        blankFragment.setArguments(bundle);
//
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(0, blankFragment);
//        fragmentTransaction.commit();
//        if (count == 4) {count = 0;}
//        else {count += 1;}



    }
}
