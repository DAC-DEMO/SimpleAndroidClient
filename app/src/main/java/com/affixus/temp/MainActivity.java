package com.affixus.temp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.affixus.pojos.Post;
import com.affixus.service.RestApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getName();

    private RecyclerView rv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = (RecyclerView) findViewById(R.id.rv1);

        apiForPost();
    }



    public void apiForPost() {
        final Call<List<Post>> postCall = RestApi.appApi.getAllPost();

        postCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> postList = response.body();
                Log.i(TAG, postList.toString());

                MainActivityAdapter adapter = new MainActivityAdapter(postList);
                rv1.setAdapter(adapter);
                rv1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
