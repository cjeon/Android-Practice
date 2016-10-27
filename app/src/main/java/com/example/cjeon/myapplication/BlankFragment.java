package com.example.cjeon.myapplication;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlankFragment extends Fragment {
    private static final int[] colors = new int[] {0xffb3ba, 0xffdfba, 0xffffba, 0xbaffc9, 0xbae1ff};
    OnHeadlineSelectedListener mCallback;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO: fix this.
//        int color_key = getArguments().getInt(FragmentActivity.COLOR_KEY, 0);
//        int color = colors[color_key];
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
//        TextView textView = (TextView) view.findViewById(R.id.fragment_blank_body);
//        textView.setBackgroundColor(color);
        return view;
    }

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnHeadlineSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

}
