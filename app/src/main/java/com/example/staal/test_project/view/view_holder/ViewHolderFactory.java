package com.example.staal.test_project.view.view_holder;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.staal.test_project.Constants;
import com.example.staal.test_project.R;
import com.example.staal.test_project.view.view_holder.BaseViewHolder;
import com.example.staal.test_project.view.view_holder.CommitsViewHolder;
import com.example.staal.test_project.view.view_holder.ContributorViewHolder;
import com.example.staal.test_project.view.view_holder.RepositoryViewHolder;

public class ViewHolderFactory {

    public BaseViewHolder getViewHolder(String type, ViewGroup parent){
        switch (type) {
            case Constants.REPOSITORY_HOLDER_TYPE:
                return new RepositoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_repos, parent, false)).setContext(parent.getContext());
            case Constants.COMMIT_HOLDER_TYPE:
                return new CommitsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_commits, parent, false)).setContext(parent.getContext());
            case Constants.CONTRIBUTOR_HOLDER_TYPE:
                return new ContributorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_contributors,parent,false)).setContext(parent.getContext());
            default:
                throw new RuntimeException("Unknown view holder type!");
        }
    }

}
