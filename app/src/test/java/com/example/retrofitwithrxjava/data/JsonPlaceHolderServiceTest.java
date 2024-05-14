package com.example.retrofitwithrxjava.data;

import static org.junit.Assert.*;

import android.util.Log;

import com.example.retrofitwithrxjava.domain.AlbumModel;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonPlaceHolderServiceTest {

    private static final String tag = "JsonPlaceHolderServiceTest";


    @Test
    public void getAlbums() throws IOException {
        JsonPlaceHolderService service = ApiClient.createService(JsonPlaceHolderService.class);
        service.getAlbums().enqueue(new Callback<List<AlbumModel>>() {
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response) {
                Log.d(tag, "onResponse: " + response.body().size());
                assertNotNull("Not Null", "" +  response);
            }

            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable throwable) {
                Log.d(tag, "onResponse: " + throwable.getMessage());
            }
        });

    }
}