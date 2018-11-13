package com.example.luismauricio.architecturecomponentsudemy.Lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class LifecycleFragment extends Fragment {

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
      //  Log.d(TAG, methodName + afterCallingFather + mLifecycle.getCurrentState().name() + " name: " + name);
    }

    public LifecycleFragment() {
        name = name.concat(" " + String.valueOf(++numInstances));
        mLifecycle = getLifecycle();
        mLifecycle.addObserver(new FragmentLifecyclerObserver());
    }

    @Override
    public void onAttach(Context context) {
        beforeFather("onAttach");
        super.onAttach(context);
        afterFather("onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        beforeFather("onCreate");
        super.onCreate(savedInstanceState);
        afterFather("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        beforeFather("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        beforeFather("onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        afterFather("onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        beforeFather("onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        afterFather("onActivityCreated");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        beforeFather("onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
        afterFather("onConfigurationChanged");
    }


    @Override
    public void onStart() {
        beforeFather("onStart");
        super.onStart();
        afterFather("onStart");
    }

    @Override
    public void onStop() {
        beforeFather("onStop");
        super.onStop();
        afterFather("onStop");
    }

    @Override
    public void onDestroy() {
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
    public void onPause() {
        beforeFather("onPause");
        super.onPause();
        afterFather("onPause");
    }


    @Override
    public void onResume() {
        beforeFather("onResume");
        super.onResume();
        afterFather("onResume");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        beforeFather("onSaveInstanceState");
        super.onSaveInstanceState(outState);
        afterFather("onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        beforeFather("onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
        afterFather("onViewStateRestored");
    }

    @Override
    public void onDestroyView() {
        beforeFather("onDestroyView");
        super.onDestroyView();
        afterFather("onDestroyView");
    }

    @Override
    public void onDetach() {
        beforeFather("onDetach");
        super.onDetach();
        afterFather("onDetach");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        beforeFather("onOptionsItemSelected");
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        beforeFather("onCreateOptionsMenu");
        super.onCreateOptionsMenu(menu, menuInflater);
        afterFather("onCreateOptionsMenu");
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        beforeFather("onPrepareOptionsMenu");
        super.onPrepareOptionsMenu(menu);
        afterFather("onPrepareOptionsMenu");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        beforeFather("onAttachFragment");
        super.onAttachFragment(fragment);
        afterFather("onAttachFragment");
    }
}
