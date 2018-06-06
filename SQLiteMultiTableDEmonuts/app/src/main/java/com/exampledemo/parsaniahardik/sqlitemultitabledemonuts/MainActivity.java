package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button voorraadButton = (Button) findViewById(R.id.gotodatabase);

        voorraadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivity.this, GetAllUsersActivity.class);
                startActivity(d);
            }
        });
    }
}
