package com.pilotcraftmc.health;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by gshorr on 1/27/16.
 */
public class BurnsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment+
       View rootView= inflater.inflate(R.layout.fragment_burns, container, false);


        String s = "<b>First-Degree Burns: red, non-blistered skin</b><br>" +
                " \u2022 Soak the wound in cool water for five minutes or longer<br>" +
                " \u2022 Take acetaminophen or ibuprofen for pain relief<br>" +
                " \u2022 Apply aloe vera gel or cream to soothe the skin<br>" +
                " \u2022 Use an antibiotic ointment and loose gauze to protect the affected area<br>";
        TextView first_burns = (TextView) rootView.findViewById(R.id.burns1);
        first_burns.setText(Html.fromHtml(s));



        String y = "<b>Second-Degree Burns: blisters and some thickening of the skin</b><br>" +
        " \u2022 running the skin under cool water for 15 minutes or longer<br>" +
        " \u2022 taking over-the-counter pain medication (acetaminophen or ibuprofen)<br>" +
        " \u2022 applying antibiotic cream to blisters<br>";
        TextView second_burns = (TextView) rootView.findViewById(R.id.burns2);
        second_burns.setText(Html.fromHtml(y));

        String m = "<b>Third-Degree Burns: widespread thickness with a white, leathery appearance</b><br>" +
        " \u2022 Call 911<br>";
        TextView third_burns = (TextView) rootView.findViewById(R.id.burns3);
        third_burns.setText(Html.fromHtml(m));

        return rootView;
    }

}
