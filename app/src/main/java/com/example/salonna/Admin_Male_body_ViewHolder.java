package com.example.salonna;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import Interfaces.ItemClickListener;

public class Admin_Male_body_ViewHolder extends RecyclerView.ViewHolder{
    TextView tw_ID ,tw_title, tw_brand,tw_price;
    ImageView imageView;
    ItemClickListener itemClickListener;
    Button b1;

    public Admin_Male_body_ViewHolder(@NonNull View itemView) {
        super(itemView);
        tw_title = (TextView)itemView.findViewById(R.id.male_body_title);
        tw_brand = (TextView)itemView.findViewById(R.id.male_body_brand);
        tw_price = (TextView)itemView.findViewById(R.id.male_body_price);
        imageView = (ImageView)itemView.findViewById(R.id.image_male_body);
        b1=itemView.findViewById(R.id.btn_edit_male_body);
    }
}
