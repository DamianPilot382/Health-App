package com.pilotcraftmc.health.FirstAid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pilotcraftmc.health.R;

import java.util.Vector;

/**
 * Created by csastudent2015 on 2/1/16.
 * csastudent2015 is super cool.
 */
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1_layout, container, false );

        return v;
    }
}
