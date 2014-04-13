package com.example.compassmod1;
//added this to test something
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.content.ServiceConnection;
import android.content.ComponentName;
import android.os.IBinder;
import android.content.Intent;
import android.os.Handler;

public class MainActivity extends Activity {
	
	TextView fHeading;
	private CompassService mCompassService;
	private Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fHeading = (TextView) findViewById(R.id.fHeading);
		mCompassService = new CompassService(this);
		
		handler.postDelayed(runnable, 1000);
	}

	private Runnable runnable = new Runnable() {
		   @Override
		   public void run() { 
			   fHeading.setText("Orientation: " + String.valueOf(mCompassService.getHeading()));
			   
		      handler.postDelayed(this, 1000);
		   }
		};
	
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    
}
