package com.example.staal.test_project.view.view_holder;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected Context context;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindView(T obj);

    public BaseViewHolder<T> setContext(Context context) {
        this.context = context;
        return this;
    }

}
