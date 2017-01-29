package com.example.sergio.ahorcado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MainActivity m=this;
        Button but_inicio = (Button) findViewById(R.id.id_but_comienzo);
        Button but_opciones = (Button) findViewById(R.id.id_but_opciones);


        but_inicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(m,Act_Game.class);
                startActivity(intent);
            }
        });


        but_opciones.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(m,Act_Options.class);
                startActivity(intent);
            }
        });





    }
}
