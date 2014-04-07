package com.example.compassmod1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.content.ServiceConnection;
import android.content.ComponentName;
import android.os.IBinder;
import android.content.Intent;

public class MainActivity extends Activity {
	
	TextView fHeading;
	 private CompassService.CompassBinder mCompassService;

	 private ServiceConnection mConnection = new ServiceConnection() {
		 @Override
	     public void onServiceConnected(ComponentName name, IBinder service) {
	            if (service instanceof CompassService.CompassBinder) {
	                mCompassService = (CompassService.CompassBinder) service;
	                
	            }
	     }

	        @Override
	     public void onServiceDisconnected(ComponentName name) {
	            // Do nothing.
	     }
	 };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 bindService(new Intent(this, CompassService.class), mConnection, 0);
		 fHeading.setText(String.valueOf(mCompassService.getHeading()));
		fHeading = (TextView) findViewById(R.id.fHeading);
	}

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    
}
