package com.example.staal.test_project.data;


import com.example.staal.test_project.App;
import com.example.staal.test_project.DTO.Commits;

import java.util.List;

import rx.Observable;

public class DataCommit implements IData<Commits> {

    @Override
    public Observable<List<Commits>> get(String name) {
        return App.getApiService().getCommits(name);
    }
}
