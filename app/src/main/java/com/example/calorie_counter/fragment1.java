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

public class fragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<itemfrag1> items = new ArrayList<>();
    private String mParam1;
    private String mParam2;
    TextView textView, textView2;


    public static fragment1 newInstance(String param1, String param2) {
        fragment1 fragment = new fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // начальная инициализация списка

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        // Бегущая строка калорий в меню
        TextView text = view.findViewById(R.id.CaloriesCount);
        text.setSelected(true);

        textView = view.findViewById(R.id.date_textview);
        textView2 = view.findViewById(R.id.date);

        // Дата главного меню rectangle_round
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE, dd.MM.yy");
        String dateTime = simpleDateFormat.format(calendar.getTime());

        // Преобразуем первую букву в заглавную
        if (!dateTime.isEmpty()) {
            dateTime = Character.toUpperCase(dateTime.charAt(0)) + dateTime.substring(1);
        }
        textView.setText(dateTime);
        textView2.setText(dateTime);
        setInitialData();
        RecyclerView recyclerView = view.findViewById(R.id.frag1_list_calories);
        // создаем адаптер
        itemAdapter_frag1 adapter = new itemAdapter_frag1(getContext(), items);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        return view;
    }

    private void setInitialData(){
        items.add(new itemfrag1("Задача 1", "34 г", "90",R.drawable.icon1));


    }
}
