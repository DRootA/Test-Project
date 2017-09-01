package com.example.staal.test_project.presenter;


import com.example.staal.test_project.Constants;
import com.example.staal.test_project.data.DataCommit;
import com.example.staal.test_project.data.DataContributor;
import com.example.staal.test_project.data.DataRepository;
import com.example.staal.test_project.data.IData;
import com.example.staal.test_project.view.ISetupRecycler;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class BasePresenter {

    private ISetupRecycler iSetupRecycler;
    private IData iData;
    private Subscriber<List> subscriber;

    public BasePresenter(ISetupRecycler iSetupRecycler, String type) {
        this.iSetupRecycler = iSetupRecycler;
        switch (type) {
            case Constants.REPOSITORY_HOLDER_TYPE:
                iData = new DataRepository();
                break;
            case Constants.COMMIT_HOLDER_TYPE:
                iData = new DataCommit();
                break;
            case Constants.CONTRIBUTOR_HOLDER_TYPE:
                iData = new DataContributor();
                break;
        }

        subscriber = getSubscriber();
    }

    public void startLoading() {
        iData.get().observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void startLoading(String name) {
        iData.get(name).observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    private Subscriber<List> getSubscriber() {
        return new Subscriber<List>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                iSetupRecycler.showToast();
            }

            @Override
            public void onNext(List list) {
                iSetupRecycler.setupRecycler(list);
            }
        };
    }
}
