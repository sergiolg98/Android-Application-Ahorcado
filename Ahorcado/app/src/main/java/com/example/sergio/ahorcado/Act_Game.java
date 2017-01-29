package com.example.sergio.ahorcado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Act_Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_game);

        final Act_Game m = this;
        Button but_ok = (Button) findViewById(R.id.id_but_ok);
        Button but_reset = (Button) findViewById(R.id.id_but_limpia);
        final EditText texto = (EditText) findViewById(R.id.id_escribe);


        but_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String palabra = texto.getText().toString();

                //Consigo el número de letras de la palabra para enviarlo al activity PLAY
                //También enviaré la palabra de un modo oculto
                if(!palabra.equals("")) {

                    int numero = palabra.length();
                    String cantidad = String.valueOf(numero);

                    Intent intent= new Intent(m,Play_1.class);
                    intent.putExtra("NUM",cantidad);
                    intent.putExtra("PAL", palabra);

                    startActivity(intent);

                }
                else{
                    TextView pide = (TextView) findViewById(R.id.id_pideme);
                    pide.setText("Debe haber una palabra: ");
                }

            }
        });

        but_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                texto.setText("");
            }
        });







    }
}
