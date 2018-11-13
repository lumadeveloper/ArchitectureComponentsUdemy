package com.example.luismauricio.architecturecomponentsudemy.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.luismauricio.architecturecomponentsudemy.Lifecycle.LifecycleFragment;
import com.example.luismauricio.architecturecomponentsudemy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ListFragment extends LifecycleFragment {

    private Unbinder mUnbinder;
    @BindView(R.id.recycler_view)
    RecyclerView listView;
    @BindView(R.id.tv_error)
    TextView errorView;
    @BindView(R.id.pb_downloading)
    ProgressBar loadingView;
    private ListViewModel mViewModel;

    public ListFragment() {
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        observeViewModel();
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        listView.setHasFixedSize(true);
        listView.setAdapter(new RepoAdapter(mViewModel, this));
    }

    private void observeViewModel() {

        mViewModel.getLoading().observe(this, isLoading -> {
            loadingView.setVisibility(isLoading ? View.VISIBLE : View.INVISIBLE);
            if (isLoading) {
                errorView.setVisibility(View.GONE);
                listView.setVisibility(View.GONE);
            }
        });

        mViewModel.getRepoloadError().observe(this, isError -> {
            if (isError != null && isError) {
                errorView.setVisibility(View.VISIBLE);
                errorView.setText(getString(R.string.connecting_error));
                listView.setVisibility(View.GONE);
            } else {
                errorView.setVisibility(View.GONE);
                errorView.setText(null);
                listView.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }
}
