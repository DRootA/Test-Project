package com.example.staal.test_project.view.view_holder;


import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.staal.test_project.DTO.Contributor;
import com.example.staal.test_project.R;
import com.example.staal.test_project.view.OpenCardActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContributorViewHolder extends BaseViewHolder<Contributor> {

    @BindView(R.id.iv_contributor_foto)
    ImageView iv_contributor_foto;
    @BindView(R.id.tv_name_contributor)
    TextView tv_name_contributor;
    @BindView(R.id.card_contributer)
    CardView cardView;

    public ContributorViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindView(Contributor obj) {
        Glide.with(context)
                .load(obj.getAvatar_url())
                .into(iv_contributor_foto);
        tv_name_contributor.setText(obj.getLogin());
        cardView.setOnClickListener(view -> {
            Intent intent=new Intent(context, OpenCardActivity.class);
            intent.putExtra("type",2)
                    .putExtra("name",obj.getLogin())
                    .putExtra("message",obj.getId())
                    .putExtra("url",obj.getAvatar_url());
            context.startActivity(intent);
        });
    }
}
