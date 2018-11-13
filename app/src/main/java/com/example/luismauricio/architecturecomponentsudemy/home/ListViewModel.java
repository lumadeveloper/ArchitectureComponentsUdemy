package com.example.luismauricio.architecturecomponentsudemy.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.luismauricio.architecturecomponentsudemy.model.Repo;
import com.example.luismauricio.architecturecomponentsudemy.networking.RepoApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewModel extends ViewModel {

    private final MutableLiveData<List<Repo>> repos = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoloadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private Call<List<Repo>> mCall;

    public ListViewModel() {
        fetchRepos();
    }

    private void fetchRepos() {
        loading.setValue(true);
        mCall = RepoApi.getInstance().getRepositories();
        mCall.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                repoloadError.setValue(false);
                repos.setValue(response.body());
                loading.setValue(false);
                mCall = null;
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                repoloadError.setValue(true);
                loading.setValue(false);
                mCall = null;
            }
        });
    }

    @Override
    protected void onCleared() {
        if (mCall != null) {
            mCall.cancel();
        }
        mCall = null;
    }

    public LiveData<List<Repo>> getRepos() {
        return repos;
    }

    public LiveData<Boolean> getRepoloadError() {
        return repoloadError;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }
}
