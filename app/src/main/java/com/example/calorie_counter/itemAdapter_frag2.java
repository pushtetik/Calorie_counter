package com.example.calorie_counter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class itemAdapter_frag2 extends RecyclerView.Adapter<itemAdapter_frag2.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<itemfrag2> items;

    itemAdapter_frag2(Context context, List<itemfrag2> items){
        this.items=items;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public itemAdapter_frag2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.frag2_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        itemfrag2 item = items.get(position);
        holder.TitleView.setText(item.getTitle());
        holder.CountView.setText(item.getCount());
        holder.CountCaloriesView.setText(item.getCountCalories());
        holder.ImageView.setImageResource(item.getimage());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView TitleView,CountView,CountCaloriesView;
        final ImageView ImageView;

        ViewHolder(View view){
            super(view);
            TitleView = view.findViewById(R.id.Name_product);
            CountView = view.findViewById(R.id.Count);
            CountCaloriesView = view.findViewById(R.id.Calories_count);
            ImageView=view.findViewById(R.id.imageView);

        }
    }}