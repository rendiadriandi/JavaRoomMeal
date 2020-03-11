package com.aurorasoft.javaroommeal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CardViewHolder> {

    private List<Data> datas;
    private Context context;

    public DataAdapter(List<Data> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    public List<Data> getDatas() {
        return datas;
    }

    @NonNull
    @Override
    public DataAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_layout, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.CardViewHolder holder, int position) {
        final String nama, image;
        nama =datas.get(position).getNama();
        image =datas.get(position).getImage();

        final int id = datas.get(position).getId();

        holder.tvNama.setText(nama);

        Glide.with(context)
                .load(image)
                .into(holder.imgImage);
    }

    @Override
    public int getItemCount() { return datas.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        ImageView imgImage;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = (TextView) itemView.findViewById(R.id.tx_meal);
            imgImage = (ImageView) itemView.findViewById(R.id.im_meal);
        }
    }
}
