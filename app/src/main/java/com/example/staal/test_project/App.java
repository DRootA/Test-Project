package com.example.staal.test_project;


import android.app.Application;

import com.example.staal.test_project.data.IRetrofitApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class App extends Application {

    private static final String BASE_URL="https://api.github.com/";

    private static volatile IRetrofitApi retrofitApi;

    public static IRetrofitApi getApiService() {
        IRetrofitApi localInstance = retrofitApi;
        if (localInstance == null) {
            synchronized (IRetrofitApi.class) {
                localInstance = retrofitApi;
                if (localInstance == null) {
                    Retrofit retrofit = App.getRetrofit();
                    retrofitApi = localInstance = retrofit.create(IRetrofitApi.class);
                }
            }
        }
        return localInstance;
    }

    private static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);

        OkHttpClient client = builder.build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client)
                .build();
    }

}
