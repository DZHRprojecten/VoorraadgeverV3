package com.example.remmy.project4;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class Zoekscherm extends AppCompatActivity {

    ListView productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview2);

        productList = (ListView)findViewById(R.id.Zoeklist);

        String test[] = {"Aardappels", "Appelmoes", "Brokken", "Chinees", "Drinken", "Eetsmakelijk", "Frikandellen", "Hondenvoer", "Ijs", "Jus", "Koekjes of knakworst", "Lachgas", "Magnetronmaaltijd", "Nasi", "Oliebollenmix", "Patatjes", "QWERTY"};
        //productList = (ListView)findViewById(R.id.Zoeklist);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, test);
        productList.setAdapter(arrayAdapter);

        //productList.setAdapter(arrayAdapter);

    }
}
