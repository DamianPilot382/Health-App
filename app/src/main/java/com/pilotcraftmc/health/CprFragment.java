package com.pilotcraftmc.health;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by csastudent2015 on 2/9/16.
 * csastudent2015 is super cool.
 */
public class CprFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment+
        View rootView = inflater.inflate(R.layout.fragment_cpr, container, false);


        String s = "<b>1. CALL</b><br>" +
                "Check the victim for unresponsiveness. If the person is not responsive and not breathing or not breathing normally. Call 911 and return to the victim. In most locations the emergency dispatcher can assist you with CPR instructions.<br><br>" +
                "<b>2. PUMP</b><br>" +
                "If the victim is still not breathing normally, coughing or moving, begin chest compressions.  Push down in the center of the chest 2 inches 30 times. Pump hard and fast at the rate of at least 100/minute, faster than once per second.<br><br>" +
                "<b>3. BLOW</b><br>" +
                "Tilt the head back and lift the chin. Pinch nose and cover the mouth with yours and blow until you see the chest rise. Give 2 breaths.  Each breath should take 1 second.<br>";
        TextView cpr = (TextView) rootView.findViewById(R.id.cpr);
        cpr.setText(Html.fromHtml(s));

        return rootView;
    }
}
