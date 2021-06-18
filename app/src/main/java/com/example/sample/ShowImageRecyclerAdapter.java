package com.example.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ShowImageRecyclerAdapter extends RecyclerView.Adapter<ShowImageRecyclerAdapter.ViewHolder>{


    Context context;
    List<ImageEntity> imageEntities;
    public ShowImageRecyclerAdapter(Context context) {
        this.context = context;
        imageEntities = ImageDatabase.getInstance(context).imageDAO().getAllImages();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is where where view in inflated and will return view holder with view(that means card)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_image_list, parent, false);
        return new ViewHolder((CardView) view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //instance of card on which we are performing operations.
        ImageEntity currentImage = imageEntities.get(position);
        CardView localCardView = holder.currentCardView;
        ImageView noteImageView = localCardView.findViewById(R.id.image_view_card);
        byte[] bytes = currentImage.getData();
        Bitmap bitmap= BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        Glide.with(context).load(bitmap).into(noteImageView);
    }

    @Override
    public int getItemCount() {
        return imageEntities.size();
    }

    // this is the view holder which holds the view
    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView currentCardView;

        public ViewHolder(@NonNull CardView cardView) {
            super(cardView);
            this.currentCardView = cardView;
        }
    }
}
