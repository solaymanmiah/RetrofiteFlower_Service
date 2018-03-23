package com.example.hi.retrofiteflower_service.ModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hi on 1/20/2018.
 */

public interface FlowerService {
    @GET("feeds/flowers.json")
    Call<List<FlowerResponse>> getAllFlowerResponse();
}
