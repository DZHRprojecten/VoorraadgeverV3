package com.example.remmy.project4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Voorraadlijst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voorraadlijst);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Voorraadlijst.this)
                        .setTitle("Maak uw keuze!")
                        .setMessage("Aan welke lijst wilt u iets toevoegen?")
                        .setPositiveButton("Voorraadlijst", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel(); //Zet hier de actie die je wilt uitvoeren als je op "Boodschappenlijst" drukt.
                            }
                        })
                        .setNegativeButton("Boodschappenlijst", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel(); //Zet hier de actie die je wilt uitvoeren als je op "Voorraadlijst" drukt.
                            }
                        })
                        .setNeutralButton("Standaard productenlijst", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        }).show();
            }
        });
    }

}
