package com.example.compassmod1;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.location.Location;
import android.app.Activity;

public class CompassService {
	 private OrientationMngr mOrientationManager;
	 
	 /*public class CompassBinder extends Binder {
		 	public double getHeading(){
		 		return mOrientationManager.getHeading();
		 	}
		 	
		 	public Location getLocation(){
		 		return mOrientationManager.getLocation();
		 	}
	        
	 }
	 private final CompassBinder mBinder = new CompassBinder();
	 
	 @Override
	 public IBinder onBind(Intent intent) {
	        return mBinder;
	 }
	 */
	    public CompassService(Activity mActivity) {
	 
	      
	        SensorManager sensorManager = (SensorManager) mActivity.getSystemService(Context.SENSOR_SERVICE);
	        LocationManager locationManager = (LocationManager) mActivity.getSystemService(Context.LOCATION_SERVICE);

	        mOrientationManager = new OrientationMngr(sensorManager, locationManager);
	        mOrientationManager.start();
	  }
	    
	  public double getHeading(){
		  return mOrientationManager.getHeading();
	  }
	  
	  public Location getLocation(){
		  return mOrientationManager.getLocation();
	  }
}
