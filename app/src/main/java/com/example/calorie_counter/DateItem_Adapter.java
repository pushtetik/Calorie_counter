package com.example.calorie_counter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DateItem_Adapter extends RecyclerView.Adapter<DateItem_Adapter.ItemViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<DateItem> itemList;

    DateItem_Adapter(List<DateItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag2_date_item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        DateItem item = itemList.get(i);
        if (item != null) {
            itemViewHolder.tvItemTitle.setText(item.getitemDate());

            // Create layout manager with initial prefetch item count
            LinearLayoutManager layoutManager = new LinearLayoutManager(
                    itemViewHolder.rvSubItem.getContext(),
                    LinearLayoutManager.VERTICAL,
                    false
            );

            List<itemfrag1> subItemList = item.getSubItemList();
            if (subItemList != null) {
                layoutManager.setInitialPrefetchItemCount(subItemList.size());

                itemAdapter_frag1 subItemAdapter = new itemAdapter_frag1(itemViewHolder.itemView.getContext(), subItemList);


                itemViewHolder.rvSubItem.setLayoutManager(layoutManager);
                itemViewHolder.rvSubItem.setAdapter(subItemAdapter);
                itemViewHolder.rvSubItem.setRecycledViewPool(viewPool);
            }
        }
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemTitle;
        private RecyclerView rvSubItem;

        ItemViewHolder(View itemView) {
            super(itemView);
            tvItemTitle = itemView.findViewById(R.id.date);
            rvSubItem = itemView.findViewById(R.id.data_list_calories);
        }
    }
}


