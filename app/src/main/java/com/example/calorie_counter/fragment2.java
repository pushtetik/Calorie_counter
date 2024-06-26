package com.example.calorie_counter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment2 extends Fragment {
    TextView textView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment2 newInstance(String param1, String param2) {
        fragment2 fragment = new fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        RecyclerView rvItem = view.findViewById(R.id.search_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        DateItem_Adapter itemAdapter = new DateItem_Adapter(buildItemList());
        rvItem.setAdapter(itemAdapter);
        rvItem.setLayoutManager(layoutManager);

        return view;
    }

    private List<DateItem> buildItemList() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");
        String dateTime = simpleDateFormat.format(calendar.getTime());

        List<DateItem> itemList = new ArrayList<>();
        itemList.add(new DateItem(dateTime,buildSubItemList() ));
        itemList.add(new DateItem(dateTime,buildSubItemList() ));
        return itemList;
    }
//Функция для заполнения калорий:
    private List<itemfrag2> buildSubItemList() {
        List<itemfrag2> subItemList = new ArrayList<>();
        subItemList.add(new itemfrag2("Задача 1", "34 г", "90",R.drawable.icon1));
        subItemList.add(new itemfrag2("Задача 1", "34 г", "90",R.drawable.icon1));
        subItemList.add(new itemfrag2("Задача 1", "34 г", "90",R.drawable.icon1));
        subItemList.add(new itemfrag2("Задача 1", "34 г", "90",R.drawable.icon1));
        subItemList.add(new itemfrag2("Задача 1", "34 г", "90",R.drawable.icon1));

        return subItemList;
    }
}
