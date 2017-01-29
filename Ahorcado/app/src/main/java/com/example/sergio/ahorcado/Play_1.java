package com.example.sergio.ahorcado;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Play_1 extends AppCompatActivity {

    LinearLayout layout;
    //ConstraintLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_1);

        layout = (LinearLayout) findViewById(R.id.id_campo_grilla);
        //canvas = (ConstraintLayout) findViewById(R.id.id_campo_dibujo);

        Intent intent=getIntent();
        String word = intent.getStringExtra("PAL");
        String n = intent.getStringExtra("NUM");
        int times = Integer.parseInt(n);

        String grilla = "";

        for(int i = 0; i < times; i++){
            grilla += " __ ";
        }

        final TextView texto = new TextView(this);
        texto.setText(grilla);
        texto.setTextSize(16);
        layout.addView(texto);

        final TextView pedido = (TextView) findViewById(R.id.id_label_escribe);
        final Button but_verifica = (Button) findViewById(R.id.id_but_GO);
        final EditText campo = (EditText) findViewById(R.id.id_campo_suponer);
        final TextView attempt = (TextView) findViewById(R.id.id_vidas);

        //Partes del cuerpito
        final ImageView cabeza = (ImageView) findViewById(R.id.id_head);
        final ImageView cuerpo = (ImageView) findViewById(R.id.id_body);
        final ImageView derbrazo = (ImageView) findViewById(R.id.id_arm_right);
        final ImageView izqbrazo = (ImageView) findViewById(R.id.id_arm_left);
        final ImageView derpierna = (ImageView) findViewById(R.id.id_leg_right);
        final ImageView izqpierna = (ImageView) findViewById(R.id.id_leg_left);
        final ImageView cuerda = (ImageView) findViewById(R.id.id_killer);



        String adivina = word;
        final Grilla game1 = new Grilla(adivina);

        but_verifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!campo.getText().toString().equals("")) {

                    char c = campo.getText().toString().charAt(0); //Consigo lo que escribe
                    //Tendre al final un array de chars, que lo unire en un String
                    //Y al final lo sustituire de una en mi TextView
                    game1.modificaGrilla(game1.devuelvePosiciones(c));
                    char[] temporal = game1.adivina;
                    //Si gana
                    if (game1.yaGano() == true) {
                        int fallas = 7 - Integer.parseInt(game1.getIntentos());
                        attempt.setText("=D");
                        texto.setTextSize(18);
                        texto.setText("Palabra: " +  game1.getPalabra() + ". Con " + fallas + " falla(s)!");
                        campo.setText("");
                        pedido.setText("Yeah!");
                        campo.setEnabled(false);
                        but_verifica.setEnabled(false);

                    }
                    //Si atina o no atina pero queda con vida
                    else {
                        int restante = Integer.parseInt(game1.getIntentos());
                        if(quedanMasIntentos(restante) == true) {
                            attempt.setText(game1.getIntentos());
                            String impresion = generateString(temporal);
                            texto.setText(impresion);
                            campo.setEnabled(false); //Para que el teclado baje
                            campo.setText("");
                            campo.setEnabled(true); //Lo volvemos a activar para que se pueda escribir =)
                            switch (restante){
                                case 6 :{
                                    cuerda.setVisibility(View.VISIBLE);
                                }
                                break;
                                case 5: {
                                    cabeza.setVisibility(View.VISIBLE);
                                }
                                break;
                                case 4: {
                                    cuerpo.setVisibility(View.VISIBLE);
                                }
                                break;
                                case 3: {
                                    derbrazo.setVisibility(View.VISIBLE);
                                }
                                break;
                                case 2: {
                                    izqbrazo.setVisibility(View.VISIBLE);
                                }
                                break;
                                case 1: {
                                    derpierna.setVisibility(View.VISIBLE);
                                }
                                break;
                            }
                        }
                        //Si pierde
                        else{
                            attempt.setText("=(");
                            izqpierna.setVisibility(View.VISIBLE); //El que falta
                            texto.setTextSize(18);
                            texto.setText("Era: " + game1.getPalabra());
                            campo.setText("");
                            campo.setEnabled(false);
                            pedido.setText("Sorry");
                            but_verifica.setEnabled(false);

                        }


                    }
                }
                else{
                    pedido.setText("Escribe");

                }
            }
        });
        ;



    }
    public String generateString(char[] array){
        String str = "";
        for(int i = 0; i < array.length; i++) {
            if(array[i] == '0'){
                str = str + " __ ";
            }
            else {
                str = str + " " + array[i] + " ";
            }
        }
        return str;
    }
    public boolean quedanMasIntentos(int num){

        if(num == 0)
            return false;
        else
            return true;


    }
}
