package com.example.retrofitwithrxjava.data;

import com.example.retrofitwithrxjava.model.AlbumModel;
import com.example.retrofitwithrxjava.model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonPlaceHolderService {

    @GET("/albums")
    public Call<List<AlbumModel>> getAlbums();

    @GET("/users")
    public Call<List<User>> getUsers();

    @GET("/users")
    public Observable<List<User>> getUsersObservable();


}
