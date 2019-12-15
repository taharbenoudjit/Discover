package com.example.discover;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Controller {

    static final String BASE_URL = "https://api.myjson.com/";

    private HomeFragment view;

    public Controller(HomeFragment view) {
        this.view = view;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        JsonPlaceHolderApi gerritAPI = retrofit.create(JsonPlaceHolderApi.class);

        Call < List < Post > > call = gerritAPI.getPosts("status:open");
        call.enqueue(new Callback < List < Post > >() {
            @Override
            public void onResponse(Call < List < Post > > call, Response < List < Post > > response) {
                if (response.isSuccessful()) {
                    List < Post > changesList = response.body();
                    view.showList(changesList);
                } else {
                    view.showError();
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call < List < Post > > call, Throwable t) {
                t.printStackTrace();
                view.showError();
            }
        });
    }

    //public void onClickedButton() {
        //Fais sa logique
        //view.navigateToEcranB()
    }


