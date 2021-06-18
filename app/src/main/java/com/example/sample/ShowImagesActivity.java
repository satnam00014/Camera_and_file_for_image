package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ShowImagesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ShowImageRecyclerAdapter showImageRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_images);
        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view_image);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //change constructor of adapter accordingly ...
        //This constructor is just a sample ...
        showImageRecyclerAdapter = new ShowImageRecyclerAdapter(this);
        recyclerView.setAdapter(showImageRecyclerAdapter);

        this.setTitle("Folders");
    }

}