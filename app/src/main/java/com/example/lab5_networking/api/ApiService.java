package com.example.lab5_networking.api;

import com.example.lab5_networking.model.Items;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    //link : https://rapidapi.com/contextualwebsearch/api/web-search/
    //https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI?q=taylor%20swift&pageNumber=1&pageSize=10&autoCorrect=true
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService callApi = new Retrofit.Builder()
            .baseUrl("https://contextualwebsearch-websearch-v1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @Headers({
            "x-rapidapi-key:d4ec3e42f8msh2e20f2ee0cfd385p17010ajsne21468b8e35f",
            "x-rapidapi-host:contextualwebsearch-websearch-v1.p.rapidapi.com"
    })
    @GET("api/Search/ImageSearchAPI")
    Call<Items> Call(@Query("q") String title);

}
