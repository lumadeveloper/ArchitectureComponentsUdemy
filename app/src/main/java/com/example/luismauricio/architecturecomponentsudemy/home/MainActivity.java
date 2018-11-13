package com.example.luismauricio.architecturecomponentsudemy.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.luismauricio.architecturecomponentsudemy.Lifecycle.LifecycleActivity;
import com.example.luismauricio.architecturecomponentsudemy.R;

public class MainActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.screen_container, new ListFragment())
                    .commit();
        }
    }
}
