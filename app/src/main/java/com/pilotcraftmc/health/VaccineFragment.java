package com.pilotcraftmc.health;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by gshorr on 1/27/16.
 */
public class VaccineFragment extends Fragment {
    String[] mItems;
    ListView mDrawerList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment+
       View rootView= inflater.inflate(R.layout.fragment_vaccine, container, false);

        mItems = getResources().getStringArray(R.array.vaccine);

        mDrawerList = (ListView) rootView.findViewById(R.id.listVaccine);   //activity_main.xml

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.vaccine_list_item, mItems));
        return rootView;
    }

}
