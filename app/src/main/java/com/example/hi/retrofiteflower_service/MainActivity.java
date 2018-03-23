package com.example.hi.retrofiteflower_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hi.retrofiteflower_service.ModelClass.FlowerAdapter;
import com.example.hi.retrofiteflower_service.ModelClass.FlowerResponse;
import com.example.hi.retrofiteflower_service.ModelClass.FlowerService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static  final  String BASAE_URL="http://services.hanselandpetal.com/";
   private FlowerService service;
   private FlowerResponse flowerResponse;
   private FlowerAdapter flowerAdapter;
   ListView listView;
   List<FlowerResponse>flowers=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listV);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                  flowerResponse=flowers.get(position);
               startActivity(new Intent(MainActivity.this,FlowerDetaileActivity.class)
               .putExtra("Flower",flowerResponse));

            }
        });

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASAE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    service=retrofit.create(FlowerService.class);
        Call<List<FlowerResponse>> call= service.getAllFlowerResponse();
        call.enqueue(new Callback<List<FlowerResponse>>() {
            @Override
            public void onResponse(Call<List<FlowerResponse>> call, Response<List<FlowerResponse>> response) {
              if(response.code()==200){
                 flowers= response.body();
                  flowerAdapter = new FlowerAdapter(MainActivity.this,flowers);
                  listView.setAdapter(flowerAdapter);
                  Log.e(TAG, "onResponse: "+ flowers.size() );
              }
            }

            @Override
            public void onFailure(Call<List<FlowerResponse>> call, Throwable t) {

            }
        });

    }
}
