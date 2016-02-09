package com.pilotcraftmc.health;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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


        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = null;

                switch(position){
                    case 0:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:Rzxr9FeZf1g"));
                        break;
                    case 1:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:s_6QW9sNPEY"));
                        break;
                    case 2:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:cgymkPp6flg"));
                        break;
                    case 3:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:mLHnUjhzv9E"));
                        break;
                    default:
                        break;
                };
                startActivity(i);

            }
        });


        return rootView;
    }

}