package com.example.lumster.demo_for_martin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.LogRecord;

public class Fragment1 extends Fragment {

    private static String TAG = "lol";

    private static int brobotSpeed = 50;

    private Joystick joystick;
    private TextView textView;

    private int joystickWidth;
    private int joystickHeight;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        initGuiComponents(view);

        return view;
    }

    private void initGuiComponents(View view){
        textView = (TextView) view.findViewById(R.id.coordinates);
        joystick = (Joystick) view.findViewById(R.id.joystick);


        joystick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_MOVE){

                    joystickWidth = joystick.getWidth()/2;
                    joystickHeight = joystick.getHeight()/2;

                    int x = (int) (event.getX()-(joystickWidth));
                    int y = (int) (event.getY()-(joystickHeight));

                    updateText(String.valueOf(getX(x, joystickWidth)) + " x, " + String.valueOf(getY(y, joystickHeight))+ " y");
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    updateText("0 x , 0 y");
                }


                return true;
            }
        });

    }

    private int getX(int x, int joystickWidth){

        int outOfBoundsX = 0;

        if(x > joystickWidth){
            outOfBoundsX = (x - joystickWidth);
        }
        if(x < (-joystickWidth)){
            outOfBoundsX = -((-x) - joystickWidth);
        }
        return translateToBrobotSpeed(x-outOfBoundsX);
    }

    private int getY(int y, int joystickHeight){

        int outOfBoudsY = 0;

        if(y > joystickHeight){
            outOfBoudsY = (y - joystickHeight);
        }
        if(y < -(joystickHeight)){
            outOfBoudsY = -((-y) - joystickHeight);
        }
        return translateToBrobotSpeed(-(y-outOfBoudsY));
    }

    private int translateToBrobotSpeed(int i){
        double percentOfMeasuredValue = (i*100)/joystickHeight;
        return (int) ((percentOfMeasuredValue/100) * brobotSpeed);
    }

    private void updateText(String string){
        textView.setText(string);
    }
}
