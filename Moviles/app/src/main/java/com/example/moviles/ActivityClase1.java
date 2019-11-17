package com.example.moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityClase1 extends AppCompatActivity {
    Button btnContador,btnResetear;
    TextView tvSalida;
    int suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase1);
        btnContador=(Button) findViewById(R.id.btnPulsar);
        btnResetear=(Button) findViewById(R.id.btnResetC3);
        tvSalida=(TextView) findViewById(R.id.tvSalida);
        suma=0;

        btnContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre="Pulsaste:"+" "+suma;
                suma=suma+1;
                tvSalida.setText(nombre);
            }
        });
        btnResetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre="Pulsaste:"+" "+"0";
                suma=0;
                tvSalida.setText(nombre);
            }
        });

    }
}
