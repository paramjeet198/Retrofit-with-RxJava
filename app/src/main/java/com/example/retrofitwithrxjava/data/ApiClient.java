package com.example.retrofitwithrxjava.data;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static final OkHttpClient httpClient = new OkHttpClient
            .Builder()
//            .addInterceptor()
            .build();

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
