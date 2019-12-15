package com.example.discover;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("bins/uxspi")
    Call < List <Post> > getPosts(@Query("q") String status);
}
