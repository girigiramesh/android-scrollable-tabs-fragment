package com.fragment_scrollable_tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }
}

class MyAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = ".MainActivity";

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        Log.d(TAG, "getItem: +position");
        Fragment fragment = null;
        if (position == 0) {
            fragment = new FragmentA();
        }
        if (position == 1) {
            fragment = new FragmentB();
        }
        if (position == 2) {
            fragment = new FragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
//        Log.d(TAG, "get count is called");
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = new String();
        if(position == 0){
            return "Tab 1";
        }
        if(position == 1){
            return "Tab 2";
        }
        if(position == 2){
            return "Tab 3";
        }
        return null;
    }
}