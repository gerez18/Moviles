package com.example.moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCargarDatos extends AppCompatActivity {
    EditText numeroPrincipal,numeroSecundario;
    Button atras;
    String Resultado;
    String operador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_datos);

        numeroPrincipal=(EditText) findViewById(R.id.etNumero1);
        numeroSecundario=(EditText) findViewById(R.id.etNumero2);
        atras=(Button) findViewById(R.id.btnDone);
        Bundle bundle= new Bundle();
        bundle=getIntent().getExtras();
       operador=bundle.getString("Operador").toString();

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPasoValor=new Intent(getApplicationContext(),ActivityClase2.class);
                Resultado=Integer.toString(resultado()).toString();
                intentPasoValor.putExtra("Valor",Resultado);
                startActivity(intentPasoValor);
                finish();
            }
        });


    }
    public int resultado() {
        int dato1=0;
        int dato2=0;
        if (!numeroPrincipal.getText().toString().equals("")) {
            dato1 = Integer.parseInt(numeroPrincipal.getText().toString());
        }
           if (!numeroSecundario.getText().toString().equals("") ) {

             dato2 = Integer.parseInt(numeroSecundario.getText().toString());
        }

        if(operador.equals("+"))
            return dato1+dato2;
        else
            if(operador.equals("-"))
                return dato1-dato2;
            else
                if(operador.equals("/"))
                    return dato1/dato2;
                else
                    return dato1*dato2;
    }

}
