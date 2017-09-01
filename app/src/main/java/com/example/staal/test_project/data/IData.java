package com.example.staal.test_project.data;


import java.util.List;
import java.util.Observable;

public interface IData<T> {

    default rx.Observable<List<T>> get(){
       return null;
     }
    default rx.Observable<List<T>> get(String name){
        return null;
    }
}
