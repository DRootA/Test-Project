package com.example.staal.test_project.view.view_holder;


import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.staal.test_project.DTO.Commits;
import com.example.staal.test_project.R;
import com.example.staal.test_project.view.OpenCardActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommitsViewHolder extends BaseViewHolder<Commits> {

    @BindView(R.id.tv_name_commit)
    TextView tv_commit;
    @BindView(R.id.tv_date_commit)
    TextView tv_date_commit;
    @BindView(R.id.card_commit)
    CardView cardView;

    public CommitsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindView(Commits obj) {
        tv_commit.setText(obj.getNameAuthor());
        tv_date_commit.setText(obj.getDateAdd().substring(0, 10));
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, OpenCardActivity.class);
            intent.putExtra("type", 1)
                    .putExtra("name",obj.getNameAuthor())
                    .putExtra("message",obj.message());
            context.startActivity(intent);
        });
    }
}
