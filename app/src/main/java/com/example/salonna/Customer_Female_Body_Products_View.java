package com.example.salonna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Customer_Female_Body_Products_View extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__female__body__products__view);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Female_Body_Product");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Female_Body_Product> options = new FirebaseRecyclerOptions.Builder<Female_Body_Product>().setQuery(databaseReference, Female_Body_Product.class).build();

        FirebaseRecyclerAdapter<Female_Body_Product,Customer_Female_body_ViewHolder> adapter = new FirebaseRecyclerAdapter<Female_Body_Product, Customer_Female_body_ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Customer_Female_body_ViewHolder holder, int position, @NonNull Female_Body_Product model) {
                holder.tw_title.setText( "Name: " + model.getName());
                holder.tw_brand.setText("Brand: " + model.getBrand());
                holder.tw_price.setText("Price: " + "Rs. " + model.getPrice());
            }

            @NonNull
            @Override
            public Customer_Female_body_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row_customer_female_body,parent,false);
                Customer_Female_body_ViewHolder body_viewHolder = new Customer_Female_body_ViewHolder(view);
                return body_viewHolder;
            }

        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}