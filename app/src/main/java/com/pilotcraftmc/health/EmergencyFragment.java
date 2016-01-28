package com.pilotcraftmc.health;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by gshorr on 1/27/16.
 */
public class EmergencyFragment extends Fragment {
    Button mDeathButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment+
       View rootView= inflater.inflate(R.layout.fragment_emergency, container, false);

        //Button the pressing of which will summon the emergency services to your door in the case that you have fallen or are having a heart attack or cant open a pickle jar or something
        mDeathButton = (Button) rootView.findViewById(R.id.death_button);
        mDeathButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                try {

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+18189704180",null,"The person who sent this is currently dying",null,null);
                }
                catch (Exception e){

                    Log.e("Bananas", "Text messages cant send");

                }
                try {
                    Intent phoneIntent= new Intent(Intent.ACTION_CALL, Uri.parse("tel:8186699438"));

                    startActivity(phoneIntent);
                }catch (ActivityNotFoundException ex){
                    Log.e("this done messed up", "is my code working? sadly, no.");
                }
            }

        });
       return rootView;
    }

}
