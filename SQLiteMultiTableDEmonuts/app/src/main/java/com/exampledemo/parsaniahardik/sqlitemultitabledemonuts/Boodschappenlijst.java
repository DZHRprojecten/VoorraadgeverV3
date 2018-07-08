package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class Boodschappenlijst extends AppCompatActivity {

    private ListView listView;
    private ArrayList<UserModel2> userModelArrayList2;
    private CustomAdapter2 customAdapter2;
    private DatabaseHelper2 databaseHelper2;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boodschappenlijst);

        listView = (ListView) findViewById(R.id.lv2);

        databaseHelper2 = new DatabaseHelper2(this);
        databaseHelper = new DatabaseHelper(this);

        userModelArrayList2 = databaseHelper2.getAllUsers();

        customAdapter2 = new CustomAdapter2(this,userModelArrayList2);
        listView.setAdapter(customAdapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Boodschappenlijst.this, UpdateDeleteActivity2.class);
                intent.putExtra("user", userModelArrayList2.get(position));
                startActivity(intent);
            }
        });

        Button toevoegenButton = (Button) findViewById(R.id.toevoegen);
        toevoegenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(Boodschappenlijst.this, ToevoegenBoodschappen.class);
                startActivity(d);
            }
        });

        Button homeButton = (Button) findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(Boodschappenlijst.this, MainActivity.class);
                startActivity(d);
            }
        });

        Button doneButton = (Button) findViewById(R.id.done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = userModelArrayList2.size();
                String string = size + "";
                Log.i(string, "size van array");
                for(int i = 0; i < 100; i++){
                    //databaseHelper2.moveProducts();
                    if(i < userModelArrayList2.size()) {
                        databaseHelper.addUser(userModelArrayList2.get(i).getProduct(), userModelArrayList2.get(i).getAantal_dagen(), userModelArrayList2.get(i).getAantal_producten(), "");
                    }

                    Log.i(i + "", "Dit is i");

                    databaseHelper2.deleteUSer(i+1);
                }
                userModelArrayList2.clear();
                userModelArrayList2.addAll(databaseHelper2.getAllUsers());
                customAdapter2.notifyDataSetChanged();
            }
        });

    }
}