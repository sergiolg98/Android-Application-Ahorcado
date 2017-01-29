package com.example.sergio.ahorcado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Act_Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_options);

        final Act_Options m=this;
        Button but_volver = (Button) findViewById(R.id.id_but_volver);

        but_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(m,Act_Game.class);
                startActivity(intent);
            }
        });
    }
}
