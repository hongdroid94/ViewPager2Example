package com.example.viewpager2.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager2.R;
import com.example.viewpager2.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager2;
    private TabLayout mTabLayout;
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialize();
    }

    private void setInitialize() {
        mViewPager2 = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
        mAdapter = new ViewPagerAdapter(this);
        mViewPager2.setAdapter(mAdapter);

        // attach tabLayout
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (null != mAdapter)
                    tab.setText(mAdapter.getItemPosTitle(position));
            }
        });
        tabLayoutMediator.attach();
    }
}