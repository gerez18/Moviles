package com.example.moviles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnClase1,btnClase2,btnClase3,btnClase4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_blank);
        btnClase1 = (Button) findViewById(R.id.btn_clase1);
        btnClase2 = (Button) findViewById(R.id.btn_clase2);
        btnClase3=  (Button)findViewById(R.id.btn_clase3);
        btnClase4=  (Button)findViewById(R.id.btn_clase4);
        btnClase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ActivityClase1.class);
                startActivityForResult(intent, 0);
            }
        });

        btnClase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityClase2.class);
                startActivityForResult(intent, 0);
            }
        });
        btnClase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),ActivityClase3.class);
                startActivityForResult(intent,0);
            }
        });
        btnClase4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),ActivityClase4.class);
                startActivityForResult(intent,0);
            }
        });
    }
}
