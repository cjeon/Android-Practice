package com.example.cjeon.myapplication;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlankFragment extends Fragment implements View.OnClickListener {
    OnClickListener mCallBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        view.setOnClickListener(this);
        mCallBack = (OnClickListener) getActivity();

        return view;
    }

    @Override
    public void onClick(View v) {
        mCallBack.changeColor();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mCallBack = (OnClickListener) getActivity();
        try {
            mCallBack = (OnClickListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement OnClickListener");
        }
    }

    public interface OnClickListener{
        void changeColor();
    }

}
