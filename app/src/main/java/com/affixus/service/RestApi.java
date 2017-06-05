package com.affixus.service;

import android.util.Log;

import com.affixus.pojos.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by santosh on 6/3/17.
 */

public class RestApi {
    private static final String TAG = RestApi.class.getName();
    private static final String BASE_RUL = "http://192.168.225.129:8080/";

    public static Retrofit retrofit;
    public static AppApi appApi;


    static {
        try{
            retrofit = new Retrofit.Builder().baseUrl(BASE_RUL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();

            appApi = retrofit.create(AppApi.class);
        } catch(Exception e){
            Log.e(TAG, e.getMessage());
            throw e;
        }
    }

    public interface AppApi {

        @GET("/baba/springs/rest/post")
        public Call<List<Post>> getAllPost();
    }


}
