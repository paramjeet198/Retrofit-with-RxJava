package com.example.retrofitwithrxjava;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.retrofitwithrxjava.data.ApiClient;
import com.example.retrofitwithrxjava.data.JsonPlaceHolderService;
import com.example.retrofitwithrxjava.databinding.ActivityMainBinding;
import com.example.retrofitwithrxjava.model.AlbumModel;
import com.example.retrofitwithrxjava.model.User;
import com.example.retrofitwithrxjava.view.DataAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private static final String tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        DataAdapter adapter = new DataAdapter(new ArrayList<>(), this);
        binding.recyclerView.setAdapter(adapter);



        JsonPlaceHolderService service = ApiClient.createService(JsonPlaceHolderService.class);
        service.getAlbums().enqueue(new Callback<List<AlbumModel>>() {
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response) {
                Log.d(tag, "onResponse: " + response.body().size());
            }

            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable throwable) {
                Log.d(tag, "onFailure: " + throwable.getMessage());
            }
        });


        service.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d(tag, "User onResponse: " + response.body().size());
                List<User> users = response.body();
                adapter.updateData(users);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {
                Log.d(tag, "onFailure: " + throwable.getMessage());
            }
        });


    }
}