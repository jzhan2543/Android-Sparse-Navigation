package com.thad.sparsenavigation;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.thad.sparse_nav_lib.WarehouseLocation;
import com.thad.sparse_nav_lib.WarehouseMap;
import com.thad.sparsenavigation.Communications.CommunicationHandler;
import com.thad.sparsenavigation.UI.UserInterfaceHandler;

/**
 * Created by theo on 3/25/18.
 */

public class GlassClient {
    private static final String TAG = "|GlassClient|";

    private Context context;
    private WarehouseMap mMap;

    private UserInterfaceHandler mUI;
    private CommunicationHandler mCommHandler;
    private SensorListener mSensorListener;

    public GlassClient(Context context){
        this.context = context;
        init();
    }

    private void init(){
        mSensorListener = new SensorListener(this);
        mUI = new UserInterfaceHandler((Activity)context);
        mCommHandler = new CommunicationHandler(this);
        mMap = new WarehouseMap();

        mUI.setMap(mMap);
    }

    public void resume(){ mSensorListener.resume(); }
    public void pause(){ mSensorListener.pause(); }

    public void onSensorUpdate(float heading){
        mUI.onHeadingChanged(heading);
    }

    public void onLocationUpdate(WarehouseLocation loc){
        Log.d(TAG, "Received "+loc.toString());
        mUI.onLocationUpdate(loc);
    }

    public void onConnected(){}
    public void onConnectionLost(){}


    public Context getContext(){ return context; }

}