package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ToevoegenBoodschappen extends AppCompatActivity {

    private Button btnStore, btnGetall, btnStandaard;
    private EditText etname, ethobby, etcity;
    private DatabaseHelper2 databaseHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toevoegen_boodschappen);

        databaseHelper2 = new DatabaseHelper2(this);

        btnStore = (Button) findViewById(R.id.btnstore);
        btnGetall = (Button) findViewById(R.id.btnget);
        btnStandaard = (Button) findViewById(R.id.btnstandaard);
        etname = (EditText) findViewById(R.id.etname);
        ethobby = (EditText) findViewById(R.id.ethobby);
        etcity = (EditText) findViewById(R.id.etcity);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
                String output = sdf1.format(c.getTime());
                databaseHelper2.addUser(etname.getText().toString(), ethobby.getText().toString(), etcity.getText().toString(), output);
                etname.setText("");
                ethobby.setText("");
                etcity.setText("");
                Toast.makeText(ToevoegenBoodschappen.this, "Product toegevoegd!", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToevoegenBoodschappen.this, Boodschappenlijst.class);
                startActivity(intent);
            }
        });

        btnStandaard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToevoegenBoodschappen.this, DatabaseStandaard2.class);
                startActivity(intent);
            }
        });
    }
}
