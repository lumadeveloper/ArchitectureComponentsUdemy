package com.example.luismauricio.architecturecomponentsudemy.Lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class ActivityLifecycleObserver implements LifecycleObserver {
    private static int numInstances = 0;
    private String name = getClass().getSimpleName();
    private static final String TAG = "31416";

    public ActivityLifecycleObserver() {
        name = name + String.valueOf(++numInstances);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void myOnCreate() {
        Log.d(TAG, "myOnCreate: " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void myOnStart() {
        Log.d(TAG, "myOnStart: " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void myOnResume() {
        Log.d(TAG, "myOnResume: " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void myOnStop() {
        Log.d(TAG, "myOnStop: " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void myOnDestroy() {
        Log.d(TAG, "myOnDestroy: " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void myOnPause() {
        Log.d(TAG, "myOnPause: " + name);
    }

}
