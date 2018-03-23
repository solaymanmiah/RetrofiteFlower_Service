package com.example.hi.retrofiteflower_service;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hi.retrofiteflower_service.ModelClass.FlowerResponse;
import com.squareup.picasso.Picasso;

public class FlowerDetaileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_detaile);
        ImageView imageView=findViewById(R.id.imageView);
        TextView textView=findViewById(R.id.textView);
        FlowerResponse flowerResponse= (FlowerResponse) getIntent().getSerializableExtra("Flower");
        String photoString=flowerResponse.getPhoto();
        Uri photoUri=Uri.parse(MainActivity.BASAE_URL+"photos/"+photoString);
        Picasso.with(this).load(photoUri).into(imageView);

        textView.setText(flowerResponse.getName()+"\n"
                +flowerResponse.getCategory()+"\n"
                +flowerResponse.getInstructions()+"\n"
                +flowerResponse.getPrice());
    }
}
