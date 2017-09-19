package com.example.admin.w4d1weatherapp;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 9/18/2017.
 */

public class MyPageAdapter extends FragmentPagerAdapter {
    private List<WeatherFragment> fragments;
    public MyPageAdapter(FragmentManager fm, List<WeatherFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }
    @Override
    public WeatherFragment getItem(int position) {
        return this.fragments.get(position);
    }
    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
