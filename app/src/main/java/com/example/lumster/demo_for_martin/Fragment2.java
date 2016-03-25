package com.example.lumster.demo_for_martin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lumster on 27.02.2016.
 */
public class Fragment2 extends Fragment {

    Button button;
    MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2_layout, container, false);
        initGuiComponents(view);
        activity = ((MainActivity) getActivity());
        return view;
    }

    private void initGuiComponents(View view){

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new Fragment1(), "FRAGMENT1");
            }
        });
    }
}
