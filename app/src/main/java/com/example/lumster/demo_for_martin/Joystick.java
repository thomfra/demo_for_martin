package com.example.lumster.demo_for_martin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by lumster on 27.02.2016.
 */
public class Joystick extends LinearLayout {

    private Context context;

    public Joystick(Context context, AttributeSet attr) {
        super(context, attr);
        this.context = context;
        inflate();
    }

    private void inflate(){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.joystick_layout, this, true);
    }

}
