package com.pilotcraftmc.health;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

import com.pilotcraftmc.health.FirstAid.Fragment1;
import com.pilotcraftmc.health.FirstAid.Fragment2;
import com.pilotcraftmc.health.FirstAid.Fragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csastudent2015 on 2/1/16.
 * csastudent2015 is super cool.
 */
public class FirstAidFragment extends Fragment implements ViewPager.OnPageChangeListener, OnTabChangeListener{
    ViewPager viewPager;
    TabHost tabHost;
    View rootView;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView= inflater.inflate(R.layout.fragment_first_aid, container, false);



        viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        List<Fragment> listFragments = new ArrayList<Fragment>();
        listFragments.add(new Fragment1());
        listFragments.add(new Fragment2());
        listFragments.add(new Fragment3());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getFragmentManager(),listFragments);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOnPageChangeListener(this);
        tabHost = (TabHost) rootView.findViewById(R.id.tabHost);
        tabHost.setup();

        String[] tabNames = {"Tab1", "Tab2", "Tab3"};
        for(int i=0; i<tabNames.length; i++){
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getActivity().getApplicationContext()));
            tabHost.addTab(tabSpec);
        }
        tabHost.setOnTabChangedListener(this);

        return rootView;
    }

    private void initTabHost(View rootView){

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class FakeContent implements TabHost.TabContentFactory
    {
        Context context;
        public FakeContent(Context mcontext){
            context = mcontext;
        //22.38
        }

        @Override
        public View createTabContent(String tag){
            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }
    public void onTabChanged(String tabId){
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);
        //View rootView= inflater.inflate(R.layout.fragment_first_aid, container, false);
        HorizontalScrollView hScrollView = (HorizontalScrollView) rootView.findViewById(R.id.h_scroll_view);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft()-(hScrollView.getWidth()-tabView.getWidth())/2;
        hScrollView.smoothScrollTo(scrollPos,0);
        //32.28
    }
}
