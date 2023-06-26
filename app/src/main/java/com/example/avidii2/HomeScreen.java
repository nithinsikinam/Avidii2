package com.example.avidii2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.avidii2.Adapter.FragmentAdapter;
import com.example.avidii2.Fragment.AskNowFragment;
import com.example.avidii2.Fragment.ScheduleSessionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeScreen extends AppCompatActivity {

    ViewPager2 viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        adapter.addFragment(new AskNowFragment(), "Ask Now");
        adapter.addFragment(new ScheduleSessionFragment(), "Schedule Session");

        viewPager.setAdapter(adapter);


        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getFragmentTitle(position))
        ).attach();
    }
}