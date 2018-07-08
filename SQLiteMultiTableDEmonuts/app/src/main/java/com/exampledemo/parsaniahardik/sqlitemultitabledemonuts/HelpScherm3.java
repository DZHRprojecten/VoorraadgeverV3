package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpScherm3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_scherm3);

        Button hoofdmenuButton = (Button) findViewById(R.id.hoofdmenu_pag3);

        hoofdmenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(HelpScherm3.this, MainActivity.class);
                startActivity(d);
            }
        });


        Button volgendeButton = (Button) findViewById(R.id.volgende_pag3);

        volgendeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(HelpScherm3.this, HelpScherm4.class);
                startActivity(d);
            }
        });
    }
}
