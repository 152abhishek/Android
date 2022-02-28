package com.example.newsx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome, mScience, mSports, mTech, mHealth, mEntertainment;
    PagerAdapter pagerAdapter;
    Toolbar mToolBar;

    String api = "35320ab00a2f4f3db0b9a37a49df28b5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        mHome = findViewById(R.id.home);
        mScience = findViewById(R.id.science);
        mSports = findViewById(R.id.sports);
        mTech = findViewById(R.id.technology);
        mHealth = findViewById(R.id.health);
        mEntertainment = findViewById(R.id.entertainment);

        ViewPager viewPager = findViewById(R.id.fragmentContainer);
        tabLayout = findViewById(R.id.include);


        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2
                        || tab.getPosition()==3 || tab.getPosition()==4 ||tab.getPosition()==5)
                {
                 pagerAdapter.notifyDataSetChanged();

                }



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}