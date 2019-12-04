package com.example.moviles;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyService extends Service {
    public static final String TAG="MyService";
    public static final String ACTION_PROGRESO="com.example.moviles.action.PROGRESO";
    public static final String ACTION_FIN="com.example.moviles.action.FIN";
    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG,"servicio creado...");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

       Log.d(TAG,"Servicio iniciado."+startId);
       int iter=intent.getIntExtra("Iteraciones",0);
       for(int i=0;i<iter;i++);
           try {
               Thread.sleep(3000);
               Intent bcIntent= new Intent();
               bcIntent.setAction(ACTION_FIN);
               bcIntent.putExtra("Progreso",iter);
               bcIntent.putExtra("ID",startId);
               sendBroadcast(bcIntent);
           } catch (InterruptedException e) { }


       return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
