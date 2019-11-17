package com.example.moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityClase3 extends AppCompatActivity {
    boolean action=false;
    Button btnStop,btnStart,btnResetC3;
    EditText etValorStep;
    TextView tvDisplay;
    int contador=0;
    String TAG="mainActivity";
    public int valorStep=0;
    int valorDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clase3);
        btnResetC3=(Button) findViewById(R.id.btnResetC3);
        btnStart=(Button) findViewById(R.id.btnStart);
        btnStop=(Button) findViewById(R.id.btnStop);
        etValorStep=(EditText) findViewById(R.id.etValorStep);
        tvDisplay=(TextView) findViewById(R.id.tvDisplay);
        btnStop.setEnabled(false);
        tvDisplay.setText("0");
        valorDisplay=0;
        ///////////////boton start/////////////////////////
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Task().execute( etValorStep.getText().toString(),tvDisplay.getText().toString());
            }
        });
        //////////////////boton stop//////////////////////////////
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Stop");
                action=false;
            }
        });
        ////////////////////boton reset//////////////////////////
        btnResetC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador=0;
                tvDisplay.setText("0");
                btnStop.setEnabled(false);
            }
        });
    }


    ////////////////////////////////ASYNc////////////////////////////
    public class Task extends AsyncTask<String, Void, String>{
        int guardoDisplay;
        @Override
        protected String doInBackground(String... strings) {
            guardoDisplay=Integer.parseInt( strings[1].toString());
            valorStep = Integer.parseInt(strings[0].toString())* 1000;

            while (action) {
                Log.d(TAG,"valor de contador:"+contador);
                while (contador < valorStep) {
                    contador++;
                    //Log.d(TAG, "Segundos:" + contador);
                }
                contador = 0;
                guardoDisplay=guardoDisplay+1;
                //valorDisplay = valorDisplay + 1;
                Log.d(TAG,"valor display"+guardoDisplay);
                onProgressUpdate(guardoDisplay);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
                return strings[1];
        }


        protected void onProgressUpdate(Integer... progress){
                tvDisplay.setText(progress[0].toString());
            }




        @Override
        protected void onPreExecute() {
            btnStop.setEnabled(true);
            action=true;
        }



        @Override
        protected void onPostExecute(String s) {
            btnStop.setEnabled(true);
            action=false;
        }
    }


}
