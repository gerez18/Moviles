package com.example.moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityClase2 extends AppCompatActivity {
    Button botonSuma,botonResta,botonDivision,botonMulticacion;
    TextView vistaResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase2);
        botonSuma=(Button) findViewById(R.id.btnSuma);
        botonResta=(Button) findViewById(R.id.btnResta);
        botonDivision=(Button) findViewById(R.id.btnDivision);
        botonMulticacion=findViewById(R.id.btnMultiplicacion);
        vistaResultado=(TextView) findViewById(R.id.tvResultado);
        vistaResultado.setText("Resultado");
        if (savedInstanceState == null) {
            asignacionBotton();
        Bundle bundleResult= new Bundle();
        bundleResult=getIntent().getExtras();
        if(bundleResult!=null)
        vistaResultado.setText("El resultado es:"+bundleResult.getString("Valor"));}
        else{
            asignacionBotton();
        Bundle bundleResult= new Bundle();
        bundleResult=getIntent().getExtras();

        if(bundleResult!=null)
            vistaResultado.setText("El resultado es:"+bundleResult.getString("Valor"));}
    }

    public void asignacionBotton(){
        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPasoOperador = new Intent(getApplicationContext(),ActivityCargarDatos.class);
                intentPasoOperador.putExtra("Operador", botonSuma.getText().toString());
                startActivity(intentPasoOperador);
                finish();
            }
            ;
        });

        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPasoOperador = new Intent(getApplicationContext(),ActivityCargarDatos.class);
                intentPasoOperador.putExtra("Operador", botonResta.getText().toString());
                startActivity(intentPasoOperador);
                finish();
            }
            ;
        });
        botonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPasoOperador = new Intent(getApplicationContext(),ActivityCargarDatos.class);
                intentPasoOperador.putExtra("Operador", botonDivision.getText().toString());
                startActivity(intentPasoOperador);
                finish();
            }
            ;
        });

        botonMulticacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPasoOperador = new Intent(getApplicationContext(),ActivityCargarDatos.class);
                intentPasoOperador.putExtra("Operador", botonMulticacion.getText().toString());
                startActivity(intentPasoOperador);
                finish();
            }
        });

    }
}
