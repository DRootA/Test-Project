package com.example.staal.test_project.view.view_holder;


import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.staal.test_project.DTO.Repository;
import com.example.staal.test_project.R;
import com.example.staal.test_project.view.OpenRepoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoryViewHolder extends BaseViewHolder<Repository> {

    @BindView(R.id.name_reposytory)
    TextView name_reposytory;
    @BindView(R.id.stars_value)
    TextView stars_value;
    @BindView(R.id.forks_value)
    TextView forks_value;
    @BindView(R.id.card_repo)
    CardView card_repo;

    public RepositoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindView(Repository obj) {
        name_reposytory.setText(obj.getName());
        stars_value.setText(String.valueOf(obj.getStargazers_count()));
        forks_value.setText(String.valueOf(obj.getForks_count()));
        card_repo.setOnClickListener(view -> {
            Intent intent=new Intent(context, OpenRepoActivity.class);
            intent.putExtra("name",obj.getName());
            intent.putExtra("id",obj.getId());
            intent.putExtra("description",obj.getDescription());
            context.startActivity(intent);
        });
    }
}
