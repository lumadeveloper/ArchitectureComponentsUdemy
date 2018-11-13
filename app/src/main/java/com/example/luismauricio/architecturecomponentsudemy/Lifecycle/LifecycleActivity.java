package com.example.luismauricio.architecturecomponentsudemy.Lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class LifecycleActivity extends AppCompatActivity {

    private static int numInstances = 0;
    private String name = getClass().getSimpleName();
    private String methodName = "";
    private String beforeCallingFather = " before father is called. ";
    private String afterCallingFather = " after father is called. ";
    protected static final String TAG = "31416";

    Lifecycle mLifecycle;

    private void beforeFather(String methodName) {
        this.methodName = methodName;
        Log.d(TAG, methodName + beforeCallingFather + mLifecycle.getCurrentState().name() + " name: " + name);
    }

    private void afterFather(String methodName) {
    //    Log.d(TAG, methodName + afterCallingFather + mLifecycle.getCurrentState().name() + " name: " + name);
    }

    public LifecycleActivity() {
        name = name.concat(" " + String.valueOf(++numInstances));
        mLifecycle = getLifecycle();
        mLifecycle.addObserver(new ActivityLifecycleObserver());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        beforeFather("onCreate");
        super.onCreate(savedInstanceState);
        afterFather("onCreate");
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        beforeFather("onPostCreate");
        super.onPostCreate(savedInstanceState);
        afterFather("onPostCreate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        beforeFather("onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
        afterFather("onConfigurationChanged");
    }

    @Override
    protected void onPostResume() {
        beforeFather("onPostResume");
        super.onPostResume();
        afterFather("onPostResume");
    }

    @Override
    protected void onStart() {
        beforeFather("onStart");
        super.onStart();
        afterFather("onStart");
    }

    @Override
    protected void onStop() {
        beforeFather("onStop");
        super.onStop();
        afterFather("onStop");
    }

    @Override
    protected void onDestroy() {
        beforeFather("onDestroy");
        super.onDestroy();
        afterFather("onDestroy");
    }

    @Override
    public void onLowMemory() {
        beforeFather("onLowMemory");
        super.onLowMemory();
        afterFather("onLowMemory");
    }

    @Override
    protected void onPause() {
        beforeFather("onPause");
        super.onPause();
        afterFather("onPause");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        beforeFather("onNewIntent");
        super.onNewIntent(intent);
        afterFather("onNewIntent");
    }

    @Override
    protected void onResume() {
        beforeFather("onResume");
        super.onResume();
        afterFather("onResume");
    }

    @Override
    protected void onRestart() {
        beforeFather("onRestart");
        super.onRestart();
        afterFather("onRestart");
    }

    @Override
    public void onAttachedToWindow() {
        beforeFather("onAttachedToWindow");
        super.onAttachedToWindow();
        afterFather("onAttachedToWindow");
    }

    @Override
    public void onDetachedFromWindow() {
        beforeFather("onDetachedFromWindow");
        super.onDetachedFromWindow();
        afterFather("onDetachedFromWindow");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        beforeFather("onSaveInstanceState");
        super.onSaveInstanceState(outState);
        afterFather("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        beforeFather("onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        afterFather("onRestoreInstanceState");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        beforeFather("onOptionsItemSelected");
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                Toast.makeText(this, "HOME", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        beforeFather("onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        beforeFather("onPrepareOptionsMenu");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onContentChanged() {
        beforeFather("onContentChanged");
        super.onContentChanged();
        afterFather("onContentChanged");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        beforeFather("onAttachFragment");
        super.onAttachFragment(fragment);
        afterFather("onAttachFragment");
    }
}
