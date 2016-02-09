package com.pilotcraftmc.health.FirstAid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pilotcraftmc.health.R;

/**
 * Created by csastudent2015 on 2/1/16.
 * csastudent2015 is super cool.
 */
public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3_layout, container, false );

        TextView t = (TextView)v.findViewById(R.id.fireText);
        String s = "<br><b>1. STOP</b> where you are—moving or running feeds air to the flames and worsens the fire.<br><br>" +
                "<b>2. DROP</b> to the floor—if you stand up, the fire can burn your face. Fold your arms high on your chest to protect your face.<br><br>" +
                "<b>3. ROLL</b> slowly on the floor or ground, in a rug or blanket if you can.<br><br>" +
                "<b>4. COOL</b> off as soon as possible with water for first and second degree burns.<br><br>";

        t.setText(Html.fromHtml(s));

        return v;
    }
}
