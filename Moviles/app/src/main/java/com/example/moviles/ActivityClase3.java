package com.example.moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
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
    int valorDisplay=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clase3);
        btnResetC3=(Button) findViewById(R.id.btnResetC3);
        btnStart=(Button) findViewById(R.id.btnStart);
        btnStop=(Button) findViewById(R.id.btnStop);
        etValorStep=(EditText) findViewById(R.id.etValorStep);
        tvDisplay=(TextView) findViewById(R.id.tvDisplay);
        //btnStop.setEnabled(false);
        tvDisplay.setText("0");
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                action=true;
                valorStep=Integer.parseInt(etValorStep.getText().toString())*1000;

                while(action){
                    while(contador<valorStep){
                    contador++;
                    Log.d(TAG,"Segundos:"+contador);
                }
                    contador=0;
                    valorDisplay=Integer.parseInt(tvDisplay.getText().toString());
                    valorDisplay=valorDisplay+1;
                    //System.out.println("sali del while del contador");
                    //System.out.println("valor es:"+valorDisplay);

                    tvDisplay.setText(Integer.toString(valorDisplay).toString());

            }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Stop");
                action=false;
            }
        });
        btnResetC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador=0;
            }
        });
    }
}
