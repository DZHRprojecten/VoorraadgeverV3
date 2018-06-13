package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class Boodschappenlijst extends AppCompatActivity {

    private ListView listView;
    private ArrayList<UserModel> userModelArrayList;
    private CustomAdapter customAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boodschappenlijst);

        listView = (ListView) findViewById(R.id.lv2);

        databaseHelper = new DatabaseHelper(this);

        userModelArrayList = databaseHelper.getAllUsers(false, true);

        customAdapter = new CustomAdapter(this,userModelArrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Boodschappenlijst.this, UpdateDeleteActivity.class);
                intent.putExtra("user", userModelArrayList.get(position));
                startActivity(intent);
            }
        });

        Button toevoegenButton = (Button) findViewById(R.id.toevoegen);
        toevoegenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(Boodschappenlijst.this, DatabaseMain.class);
                startActivity(d);
            }
        });

    }
}