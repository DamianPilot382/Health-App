package com.csastudent2015.health_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Il Duce on 1/14/16.
 */
public class EmergencyFragment extends FragmentActivity {
    private Button mDeathButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emergency);

        final Intent phoneIntent= new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:3236057803"));

        //Button the pressing of which will summon the emergency services to your door in the case that you have fallen or are having a heart attack or cant open a pickle jar or something
        mDeathButton = (Button) findViewById(R.id.death_button);
        mDeathButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startActivity(phoneIntent);
            }

        });
    }
}


