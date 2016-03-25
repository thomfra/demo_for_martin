package com.example.lumster.demo_for_martin;

import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (FrameLayout) findViewById(R.id.fragment_container);

        initFragment();

    }

    public void initFragment(){
        fragmentManager = getFragmentManager();
        changeFragment(new Fragment1(), "FRAGMENT1");
    }

    public void changeFragment(Fragment fragment, String tag){

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment_container, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

}
