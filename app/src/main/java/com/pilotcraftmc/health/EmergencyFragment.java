package com.pilotcraftmc.health;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by gshorr on 1/27/16.
 */
public class EmergencyFragment extends Fragment {
    Button mDeathButton;
    Button mContactButton;
    TextView phoneEntry;
    public static final String DEBUG_TAG="Shit's broke yo";
    private static final int CONTACT_PICKER_RESULT= 1001;
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
                SmsManager smsManager = SmsManager.getDefault();
                try {


                    if(phoneEntry.getText()!=null){
                        String rawPhone=phoneEntry.getText().toString();
                        String smsNumber= "+"+rawPhone.substring(0,1)+rawPhone.substring(2,5)+rawPhone.substring(6,9)+rawPhone.substring(10,14);
                        smsManager.sendTextMessage(smsNumber,null, "The person who sent this is currently dying", null, null);
                        Log.v(DEBUG_TAG,smsNumber);
                    }else {

                        smsManager.sendTextMessage("+18189704180", null, "The person who sent this is currently dying", null, null);

                    }
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
        mContactButton=(Button) rootView.findViewById(R.id.contact_button);
        mContactButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent contactPickerIntent= new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(contactPickerIntent,CONTACT_PICKER_RESULT);

            }
        });

       return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode== Activity.RESULT_OK){
            switch(requestCode){
                case CONTACT_PICKER_RESULT:
                    //handle results
                    Cursor cursor=null;
                    String phoneNumber="";
                    try{
                        Uri result=data.getData();
                        Log.v(DEBUG_TAG, "Got a contact result: "
                                + result.toString());

                        // get the contact id from the Uri
                        String id = result.getLastPathSegment();
                        //query for phone info
                        cursor= getActivity().getContentResolver().query(Phone.CONTENT_URI,
                                null, Phone.CONTACT_ID+"=?",new String[]{id},null);

                        int phoneIDX= cursor.getColumnIndex(Phone.DATA);

                        //getting the first phone number
                        if(cursor.moveToFirst()){
                            phoneNumber=cursor.getString(phoneIDX);
                            Log.v(DEBUG_TAG,"Got phone: "+phoneNumber);
                        }else{
                            Log.w(DEBUG_TAG,"No results");
                        }

                    }catch(Exception e){
                        Log.w(DEBUG_TAG, "Failed to get email data",e);
                    } finally{
                        if(cursor!=null){
                            cursor.close();
                        }
                        phoneEntry= (TextView) getView().findViewById(R.id.phone);
                        phoneEntry.setText(phoneNumber);
                        }
                    break;


            }
        }else{
            // gracefully handle failure
            Log.w(DEBUG_TAG, "Warning: activity result not ok");
        }
    }


}
