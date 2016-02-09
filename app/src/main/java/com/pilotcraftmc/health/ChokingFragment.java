package com.pilotcraftmc.health;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by someone on 1/27/16.
 */
public class ChokingFragment extends Fragment {
    String[] mItems;
    ListView mDrawerList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment+
       View rootView= inflater.inflate(R.layout.fragment_choking, container, false);

        String sourceString = "<h2>Title</h2><br><p>\u2022Description here</p>";
        TextView text = (TextView)rootView.findViewById(R.id.textChoke);
        text.setText(Html.fromHtml(sourceString));

        return rootView;
    }

}
