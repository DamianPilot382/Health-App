package com.pilotcraftmc.health;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

/**
 * Created by Il Duce on 2/9/16.
 * splash screen
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splishy_splooshy);
        //extends time before switiching to main activity
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    //Intent switches activity to main activity
                    Intent intent= new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    //stops screen so you cannot go back
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
