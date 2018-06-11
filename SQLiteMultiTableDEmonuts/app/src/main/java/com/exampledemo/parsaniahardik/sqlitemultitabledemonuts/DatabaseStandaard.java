package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DatabaseStandaard extends AppCompatActivity {

    private ListView standaardLijst;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_standaard);

        standaardLijst = (ListView)this.findViewById(R.id.standaardlijst);

        databaseHelper = new DatabaseHelper(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        standaardLijst.setAdapter(arrayAdapter);

        arrayAdapter.add("Poep");
        arrayAdapter.add("Kak");
        arrayAdapter.add("Schijt");
        arrayAdapter.add("Stront");
        arrayAdapter.add("Mest");
        arrayAdapter.add("Klei");

        arrayAdapter.notifyDataSetChanged();

        standaardLijst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id){
                //ItemClicked item = adapter.getItemAtPosition(position);
                String item = ((TextView)view).getText().toString();
                Intent intent = new Intent(DatabaseStandaard.this,GetAllUsersActivity.class);
                //based on item add info to intent
                startActivity(intent);
                if(position == 1){
                    databaseHelper.addUser("Aardappels", "10", "20");
                }
                else if (position == 2){
                    databaseHelper.addUser("Piemels", "10", "20");
                }
            }
        });

    }
}
