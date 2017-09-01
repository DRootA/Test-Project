package com.example.staal.test_project.data;


import com.example.staal.test_project.App;
import com.example.staal.test_project.DTO.Contributor;

import java.util.List;

import rx.Observable;

public class DataContributor implements IData<Contributor> {

    @Override
    public Observable<List<Contributor>> get(String name) {
        return App.getApiService().getContributors(name);
    }
}
