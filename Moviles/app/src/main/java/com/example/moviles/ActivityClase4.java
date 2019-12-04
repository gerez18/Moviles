package com.example.moviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityClase4 extends AppCompatActivity {
        Button btnIntentService,btnService,btnBoundService;
        TextView tvSalidaIS,tvSalidaService,tvSalidaBoundService;
        LocalBroadcastManager localBroadcastManager=null;
        public static final String LOCAL_BROADCAST_ACTION = "com.example.moviles.LOCAL_BROADCAST";
        public static final String TAG="ActivityClase4";
        int rango;
        private LocalService mService;
        private boolean mBound=false;


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
        tvSalidaService.setText("0");
        tvSalidaBoundService.setText("0");
        IntentFilter intentFilter=new IntentFilter(MyIntentService.RESULT_FOO);

        LocalBroadcastManager.getInstance(this).registerReceiver(msReceiver, intentFilter);
        btnIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rango=(int) (Math.random()*100);
                MyIntentService.startActionFoo( getApplicationContext(),1 ,rango);
                rango=(int) (Math.random()*100);
                MyIntentService.startActionFoo(getApplicationContext(),2 ,rango);
                rango=(int) (Math.random()*100);
                MyIntentService.startActionFoo(getApplicationContext(),3 ,rango);
                rango=(int) (Math.random()*100);
                MyIntentService.startActionFoo(getApplicationContext(), 4,rango);

            }
        });
        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rango=(int) (Math.random()*100);
                Intent msgIntent1=new Intent(ActivityClase4.this,MyService.class);
                msgIntent1.putExtra("Iteraciones",rango);
                startService(msgIntent1);
                rango=(int) (Math.random()*100);
                Intent msgIntent2=new Intent(ActivityClase4.this,MyService.class);
                msgIntent2.putExtra("Iteraciones",rango);
                startService(msgIntent2);
                rango=(int) (Math.random()*100);
                Intent msgIntent3=new Intent(ActivityClase4.this,MyService.class);
                msgIntent3.putExtra("Iteraciones",rango);
                startService(msgIntent3);
                rango=(int) (Math.random()*100);
                Intent msgIntent4=new Intent(ActivityClase4.this,MyService.class);
                msgIntent4.putExtra("Iteraciones",rango);
                startService(msgIntent4);
            }
        });
        IntentFilter filter=new IntentFilter();
        filter.addAction(MyService.ACTION_FIN);
        ProgressReciver rcv=new ProgressReciver();
        registerReceiver(rcv,filter);
        Intent intent=new Intent(this,LocalService.class);
        bindService(intent,connection,Context.BIND_AUTO_CREATE);
        btnBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Integer num=mService.getRandomNumber();
                    tvSalidaBoundService.setText(num.toString());
            }
        });
    }

    public class ProgressReciver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG,"llego gato");

           if(intent.getAction().equals(MyService.ACTION_FIN)){
                //Toast.makeText(ActivityClase4.this,"Tarea finalizada",Toast.LENGTH_SHORT).show();
                Integer prog = intent.getIntExtra("Progreso",0);
                //Integer id=intent.getIntExtra("ID",0);
                tvSalidaService.setText(prog.toString());
            }
        }
    }

    ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LocalService.LocalBinder binder=(LocalService.LocalBinder) service;
            mService=binder.getService();
            mBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound=false;
        }
    };


}
