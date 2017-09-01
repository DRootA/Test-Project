package com.example.staal.test_project.data;


import com.example.staal.test_project.App;
import com.example.staal.test_project.DTO.Repository;

import java.util.List;

import rx.Observable;

public class DataRepository implements IData<Repository>{

    @Override
    public Observable<List<Repository>> get() {
       return App.getApiService().getRepos();
    }
}
