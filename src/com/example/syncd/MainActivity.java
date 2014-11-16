package com.example.syncd;

import java.util.List;

import com.example.syncd.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 public void onClicklaunchCamera(View view) { 
	    	//Start sensor data
	    	
	    	Context context = getApplicationContext();
	    	if(checkCameraHardware(context))
	    	{ 
	    		Camera c = getCameraInstance();
	    	}
	    } 
	 
	 private boolean checkCameraHardware(Context context) {
	        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
	            // this device has a camera
	            return true;
	        } else {
	            // no camera on this device
	            return false;
	        }
	    }
	    
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
            Camera.Parameters cp = c.getParameters();

            List<Size> sl = cp.getSupportedPictureSizes();
            
            int w = 0,h = 0;
            for(Size s : sl){
               //if s.width meets whatever criteria you want set it to your w
               //and s.height meets whatever criteria you want for your h
            	if(s.width == 2592 && s.height == 1944)
            	{
	               w = s.width;
	               h = s.height;
	               break;
            	}
            }
            cp.setPictureSize(w, h);
            c.setParameters(cp);
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
    
    

}
