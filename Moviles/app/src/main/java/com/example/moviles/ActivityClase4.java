package com.example.moviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityClase4 extends AppCompatActivity {
        Button btnIntentService,btnService,btnBoundService;
        TextView tvSalidaIS,tvSalidaService,tvSalidaBoundService;
        LocalBroadcastManager localBroadcastManager=null;
        public static final String LOCAL_BROADCAST_ACTION = "com.example.moviles.LOCAL_BROADCAST";

        BroadcastReceiver msReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String content = intent.getStringExtra(MyIntentService.RESULT_FOO);
            Log.d("Clase 4", "receive: " + content);
            tvSalidaIS.setText(content);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase4);
        btnIntentService=findViewById(R.id.btnIntentService);
        btnService=findViewById(R.id.btnService);
        btnBoundService=findViewById(R.id.btnBoundService);
        tvSalidaIS=findViewById(R.id.tvSalidaIS);
        tvSalidaService=findViewById(R.id.tvService);
        tvSalidaBoundService=findViewById(R.id.tvBS);
        tvSalidaIS.setText("0");
        IntentFilter intentFilter=new IntentFilter(MyIntentService.RESULT_FOO);

        LocalBroadcastManager.getInstance(this).registerReceiver(msReceiver, intentFilter);
        btnIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rango=(int) (Math.random()*100);
                MyIntentService.startActionFoo( getApplicationContext(),1 ,rango);
                rango=(int) (Math.random()*100);
                MyIntentService.startActionFoo(getApplicationContext(),2 ,rango);
                rango=(int) (Math.random()*100);
                MyIntentService.startActionFoo(getApplicationContext(),3 ,rango);
                rango=(int) (Math.random()*100);
                MyIntentService.startActionFoo(getApplicationContext(), 4,rango);

            }
        });

    }




}
