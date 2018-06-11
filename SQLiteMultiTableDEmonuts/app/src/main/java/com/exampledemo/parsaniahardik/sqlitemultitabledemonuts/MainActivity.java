package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        databaseHelper.addUser("Aardappels", "10", "20");

        Button boodschappenButton = (Button) findViewById(R.id.boodschappenlijst);

        boodschappenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivity.this, GetAllUsersActivity.class);
                startActivity(d);
            }
        });

        Button voorraadButton = (Button) findViewById(R.id.voorraadlijst);

        voorraadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivity.this, GetAllUsersActivity.class);
                startActivity(d);
            }
        });

        Button helpButton = (Button) findViewById(R.id.help);

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Deze functionaliteit wordt nog toegevoegd", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
