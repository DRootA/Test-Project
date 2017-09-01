package com.example.staal.test_project.view;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.staal.test_project.MyDiffCallback;
import com.example.staal.test_project.view.view_holder.BaseViewHolder;
import com.example.staal.test_project.view.view_holder.ViewHolderFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    List<T> itemList;
    List<T> oldItemList;
    String typeHolder;
    ViewHolderFactory viewHolderFactory;

    public BaseRecyclerAdapter(String typeHolder) {
        this.typeHolder = typeHolder;
        itemList = new ArrayList<>();
        oldItemList = new ArrayList<>();
        viewHolderFactory=new ViewHolderFactory();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolderFactory.getViewHolder(typeHolder,parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        holder.bindView(itemList.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setupRecycle(List<T> list) {
        oldItemList.clear();
        list.removeAll(itemList);
        oldItemList.addAll(itemList);
        itemList.addAll(list);
        sort(itemList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffCallback<>(itemList, oldItemList));
        diffResult.dispatchUpdatesTo(this);
    }

    private void sort(List<T> list) {
        Collections.sort(list, (t, t1) -> {
            if (Integer.parseInt(t1.toString()) > Integer.parseInt(t.toString())) {
                return 1;
            } else if (Integer.parseInt(t1.toString()) < Integer.parseInt(t.toString())) {
                return -1;
            } else return 0;
        });
    }
}
