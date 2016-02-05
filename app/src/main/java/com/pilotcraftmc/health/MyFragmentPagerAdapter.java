package com.pilotcraftmc.health;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by csastudent2015 on 2/1/16.
 * csastudent2015 is super cool.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

    List<Fragment> listFragments;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> listFragments){
        super(fm);
        this.listFragments = listFragments;
    }
    @Override
    public Fragment getItem(int position){
        return listFragments.get(position);
    }

    @Override
    public int getCount(){
        return listFragments.size();
    }
}
