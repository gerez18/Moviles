package com.example.moviles;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;


public class MyIntentService extends IntentService {
        int rand;
        private static final String ACTION_FOO="com.example.intent.action.progress";
        public static final String RESULT_FOO="com.example.intent.action.FIN";
        private static String FOO_ID = "com.example.extra.FOO.id";


    public MyIntentService() {
        super("MyIntentService");

    }

    public static void startActionFoo(Context context, Integer ID,int rango){
        System.out.println("Rango" + rango);
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(FOO_ID, ID);
        intent.putExtra("Iteraciones",rango);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            System.out.println("Entre al intent");
            final String action = intent.getAction();
            if(ACTION_FOO.equals(action)){
                System.out.println("Entre al action");
                int rand = intent.getIntExtra("Iteraciones", 0);
                System.out.println("rand: " + rand);

                for (int i = 0; i < rand; i++);
                    try {
                        Thread.sleep(3000);
                        Intent intencion = new Intent();
                        intencion.setAction(RESULT_FOO);
                        Integer rango = rand;
                        intencion.putExtra(RESULT_FOO, rango.toString());
                        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intencion);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

        }
        }
    }
}
