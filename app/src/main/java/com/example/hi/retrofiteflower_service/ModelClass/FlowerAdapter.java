package com.example.hi.retrofiteflower_service.ModelClass;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hi.retrofiteflower_service.R;

import java.util.List;

/**
 * Created by Hi on 1/20/2018.
 */

public class FlowerAdapter extends ArrayAdapter<FlowerResponse> {
    private Context context;
    private List<FlowerResponse> flowerResponses;


    public FlowerAdapter(@NonNull Context context,  List<FlowerResponse> flowerResponses) {
        super(context, R.layout.row_flower,flowerResponses);
        this.context=context;

        this.flowerResponses = flowerResponses;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.row_flower,parent,false);
        TextView nameTv= convertView.findViewById(R.id.flwoerNm);
        TextView priceTv=convertView.findViewById(R.id.flwoerPric);
       nameTv.setText(flowerResponses.get(position).getName());
       priceTv.setText(String.valueOf(flowerResponses.get(position).getPrice()));

        return convertView;
    }
}
