package com.example.staal.test_project.data;
import com.example.staal.test_project.DTO.Commits;
import com.example.staal.test_project.DTO.Contributor;
import com.example.staal.test_project.DTO.Repository;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IRetrofitApi {

    @GET("users/square/repos")
    rx.Observable<List<Repository>> getRepos();

    @GET("repos/square/{name}/commits")
    rx.Observable<List<Commits>> getCommits(@Path("name")String name);

    @GET("repos/square/{name}/contributors")
    rx.Observable<List<Contributor>> getContributors(@Path("name")String name);

}
