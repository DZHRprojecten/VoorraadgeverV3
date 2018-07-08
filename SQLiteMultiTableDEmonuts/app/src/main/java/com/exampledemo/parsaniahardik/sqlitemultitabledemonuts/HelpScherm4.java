package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpScherm4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_scherm4);

        Button hoofdmenuButton = (Button) findViewById(R.id.hoofdmenu_pag4);

        hoofdmenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(HelpScherm4.this, MainActivity.class);
                startActivity(d);
            }
        });
    }
}
