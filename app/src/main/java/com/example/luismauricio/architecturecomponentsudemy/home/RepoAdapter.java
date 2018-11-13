package com.example.luismauricio.architecturecomponentsudemy.home;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luismauricio.architecturecomponentsudemy.R;
import com.example.luismauricio.architecturecomponentsudemy.model.Repo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<Repo> data = new ArrayList<>();

    public RepoAdapter(ListViewModel listViewModel, LifecycleOwner lifecycleOwner) {
        listViewModel.getRepos().observe(lifecycleOwner, repos -> {
            data.clear();
            if (repos != null) {
                data = repos;
                notifyDataSetChanged();
            }
        });
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RepoViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_repo_listitem, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder repoViewHolder, int i) {
        repoViewHolder.bind(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static final class RepoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_repo_name)
        TextView nameTextView;
        @BindView(R.id.tv_repo_description)
        TextView descriptionTextView;
        @BindView(R.id.tv_stars)
        TextView startsTextView;
        @BindView(R.id.tv_forks)
        TextView forksTextView;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Repo repo) {
            nameTextView.setText(repo.name);
            descriptionTextView.setText(repo.description);
            startsTextView.setText(String.valueOf(repo.stars));
            forksTextView.setText(String.valueOf(repo.forks));
        }
    }
}
