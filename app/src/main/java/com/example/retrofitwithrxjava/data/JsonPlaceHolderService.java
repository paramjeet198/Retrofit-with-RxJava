package com.example.retrofitwithrxjava.data;

import com.example.retrofitwithrxjava.domain.AlbumModel;
import com.example.retrofitwithrxjava.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonPlaceHolderService {

    @GET("/albums")
    public Call<List<AlbumModel>> getAlbums();

    @GET("/users")
    public Call<List<User>> getUsers();




}
