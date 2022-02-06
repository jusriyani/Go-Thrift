package com.example.gothrift.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gothrift.model.ModelList;

import java.util.List;

import com.example.gothrift.R;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ImageViewHolder> {
    private final List<ModelList> itemsList;
    private final Activity context;

    public AdapterList(List<ModelList> itemsList, Activity context) {
        this.itemsList = itemsList;
        this.context = context;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ImageViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {
        holder.judul.setText(itemsList.get(position).getJudul());
        Glide.with(context)
                .load(itemsList.get(position).getImages())
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(v -> {
            /*Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("id", itemsList.get(position).getId());
            intent.putExtra("title",itemsList.get(position).getJudul());
            intent.putExtra("images",itemsList.get(position).getImages());
            intent.putExtra("content", itemsList.get(position).getContent());
            context.startActivity(intent);*/
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        ImageView imageView;
        FrameLayout frameLayout;
        FrameLayout native_ap;
        CardView cardView;


        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            frameLayout = itemView.findViewById(R.id.fl_adplaceholder_lis);
            native_ap = itemView.findViewById(R.id.app_native);
            judul = itemView.findViewById(R.id.list_judul);
            cardView = itemView.findViewById(R.id.ads_c);
            imageView = itemView.findViewById(R.id.images_list);
        }

    }

}
