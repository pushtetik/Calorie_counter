package com.example.calorie_counter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

import com.example.calorie_counter.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;
    ActivityMainBinding binding;
    ViewPager viewPager; // Переменная для ViewPager

    // Объявление констант
    private static final int FRAGMENT1_ID = R.id.frag1;
    private static final int FRAGMENT2_ID = R.id.frag2;
    private static final int FRAGMENT3_ID = R.id.frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Получаем ссылку на BottomNavigationView
        bottom_navigation = findViewById(R.id.bottomNavigationView);
        // Устанавливаем ItemIconTintList на null
        bottom_navigation.setItemIconTintList(null);

        // Начальная замена фрагмента
        replaceFragment(new fragment1());

        // Скрытие меню при поиске
        View frame_layout = findViewById(R.id.frame_layout);
        frame_layout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int screenHeight = frame_layout.getRootView().getHeight();
                int heightDiff = screenHeight - frame_layout.getHeight();
                int contentViewTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
                int statusBarHeight = contentViewTop - getStatusBarHeight();

                if (heightDiff > screenHeight / 4) {
                    // Клавиатура открыта
                    bottom_navigation.setVisibility(View.GONE);
                } else {
                    // Клавиатура закрыта
                    bottom_navigation.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == FRAGMENT1_ID) {
                replaceFragment(new fragment1());
            } else if (item.getItemId() == FRAGMENT2_ID) {
                replaceFragment(new fragment2());
            } else if (item.getItemId() == FRAGMENT3_ID) {
                replaceFragment(new fragment3());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
