package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DatabaseStandaard2 extends AppCompatActivity {

    private ListView standaardLijst2;
    private DatabaseHelper2 databaseHelper2;

    private String[] producten = {"Aanmaakblokjes",
            "Aanmaaklimonade",
            "Aardappelen",
            "Aardbeien",
            "Afbakbroodjes",
            "Afwasmiddel",
            "Afwassponzen",
            "Appels",
            "Appelmoes",
            "Augurken",
            "Babymelkpoeder",
            "Babypoeder",
            "Babyvoeding",
            "Bami",
            "Bananen",
            "Bapao",
            "Barbecuekooltjes",
            "Barbecuesaus",
            "Beschuit",
            "Bier (blikje)",
            "Bier (flesje)",
            "Bitterballen",
            "Bloemkool",
            "Boerenkool",
            "Boter (bakken en braden)",
            "Boter (room)",
            "Boter (vloeibaar)",
            "Boter (voor boterhammen)",
            "Boterhammenworst",
            "Boterhammenzakjes",
            "Broccoli",
            "Brood",
            "Broodjes",
            "Bruine bonen",
            "Carrero's",
            "Cervelaatworst",
            "Chilisaus",
            "Chips",
            "Chocola",
            "Chocolademelk",
            "Chocoladepasta",
            "Cola",
            "Cola Light",
            "Cola Zero",
            "Condooms",
            "Cornflakes",
            "Cruesli",
            "Curry",
            "Deodorant",
            "Doperwten",
            "Douchegel",
            "Drop",
            "Druiven",
            "Eieren",
            "Eierkoeken",
            "Eiersalade",
            "Energy drink",
            "Flosdraad",
            "Frikandellen",
            "Frikandellenbroodje",
            "Frites",
            "Fritessaus",
            "Frituurvet",
            "Gehakt",
            "Grillworst",
            "Haargel",
            "Haarwax",
            "Hagelslag",
            "Ham",
            "Hamburgers",
            "Hamstervoer",
            "Handzeep",
            "Hondenbrokken",
            "Hondenvlees",
            "Honing",
            "Hotdogs",
            "Houtskool",
            "IJsjes",
            "Ice Tea",
            "Inlegkruisjes",
            "Jam",
            "Jenever",
            "Kaas(blok)",
            "Kaas(geraspt)",
            "Kaas(plakken)",
            "Karnemelk",
            "Kattenbakgrind",
            "Kattenbrokken",
            "Kattenvlees",
            "Kauwgom",
            "Ketchup",
            "Ketjap",
            "Keukenrollen",
            "Kip-kerriesalade",
            "Kipfilet",
            "Kipsaté salade",
            "Knakworstjes",
            "Knoflooksaus",
            "Koffiebonen",
            "Koffiecups",
            "Koffiefilters",
            "Koffiemelk",
            "Koffiemelkpoeder",
            "Koffiepads",
            "Koffiepoeder",
            "Komkommer",
            "Komkommersalade",
            "Konijnenvoer",
            "Krentenbollen",
            "Kroketten",
            "Lasagne",
            "Loempia's",
            "Luiers",
            "Maandverband",
            "Macaroni",
            "Mandarijn",
            "Mayonaise",
            "Melk",
            "Meloen",
            "Mexicano's",
            "Mineraalwater",
            "Mosterd",
            "Muesli",
            "Mueslirepen",
            "Muisjes",
            "Nasi",
            "Noodles",
            "Olijfolie",
            "Ontbijtcrackers",
            "Ontbijtkoek",
            "Pannenkoeken",
            "Paprika's",
            "Pedaalemmerzakken",
            "Peper",
            "Pepermunt",
            "Pina Colada",
            "Pinda's",
            "Pindakaas",
            "Pindasaus",
            "Pizza",
            "Pleisters",
            "Poedersuiker",
            "Poffertjes",
            "Reinigingsdoekjes",
            "Rijst",
            "Rode kool",
            "Rookworst",
            "Rozijnen",
            "Rum",
            "Salami (plakken)",
            "Salami (staaf)",
            "Sambal",
            "Sardientjes(blik)",
            "Saucijzenbroodje",
            "Scheermesjes",
            "Scheerschuim",
            "Schitnzels",
            "Shampoo",
            "Sigaretten (shaq)",
            "Sigaretten (pakje)",
            "Sigaretten (vloeitjes)",
            "Sigarettenfilters",
            "Sinaasappel",
            "Sinas",
            "Sla",
            "Sladressing",
            "Slagroom",
            "Slavinken",
            "Spaghetti",
            "Spruiten",
            "Stoofperen",
            "Stro",
            "Stroopwafels",
            "Suiker",
            "Suikerklontjes",
            "Sultana",
            "Tampons",
            "Tandenborstel",
            "Tandpasta",
            "Theezakjes",
            "Tissues",
            "Tomaten",
            "Tonijn",
            "Tuinbonen",
            "Uien",
            "Vaatwastabletten",
            "Vissticks",
            "Vitaminwater",
            "Vlammetjes",
            "Vodka",
            "Vogelzaad",
            "Vogelzand",
            "Vruchtenhagel",
            "Vruchtensap",
            "Vuilniszakken",
            "Wc-blokjes",
            "Wc-papier",
            "Wc-reiniger",
            "Wasmiddel",
            "Waspoeder",
            "Wasverzachter",
            "Wijn",
            "Witte bonen in tomatensaus",
            "Worstenbroodjes",
            "Wortelen",
            "Yoghurt",
            "Yoghurtdrink",
            "Zaagsel",
            "Zakdoekjes",
            "Zonnebloempitten",
            "Zout",
            "Testproduct"
    };

    private String[] aantalDagenInVoorraad = { "28",
            "28",
            "1",
            "14",
            "3",
            "7",
            "56",
            "28",
            "1",
            "7",
            "14",
            "14",
            "14",
            "1",
            "7",
            "3",
            "1",
            "28",
            "28",
            "7",
            "1",
            "1",
            "56",
            "7",
            "7",
            "7",
            "28",
            "56",
            "14",
            "7",
            "200",
            "7",
            "4",
            "4",
            "7",
            "56",
            "7",
            "56",
            "4",
            "1",
            "3",
            "7",
            "10",
            "1",
            "4",
            "1",
            "4",
            "1",
            "4",
            "28",
            "7",
            "7",
            "14",
            "28",
            "7",
            "28",
            "7",
            "7",
            "1",
            "4",
            "7",
            "1",
            "42",
            "56",
            "7",
            "7",
            "14",
            "40",
            "7",
            "7",
            "7",
            "56",
            "28",
            "7",
            "7",
            "7",
            "100",
            "100",
            "21",
            "7",
            "56",
            "3",
            "28",
            "7",
            "4",
            "14",
            "14",
            "14",
            "28",
            "7",
            "4",
            "3",
            "21",
            "21",
            "4",
            "28",
            "21",
            "56",
            "28",
            "7",
            "7",
            "7",
            "7",
            "28",
            "7",
            "21",
            "4",
            "28",
            "28",
            "28",
            "14",
            "21",
            "7",
            "7",
            "28",
            "4",
            "56",
            "7",
            "56",
            "7",
            "14",
            "7",
            "1",
            "14",
            "5",
            "3",
            "7",
            "5",
            "56",
            "1",
            "4",
            "56",
            "7",
            "7",
            "14",
            "7",
            "1",
            "28",
            "7",
            "7",
            "28",
            "7",
            "21",
            "200",
            "28",
            "7",
            "4",
            "14",
            "7",
            "7",
            "28",
            "28",
            "7",
            "28",
            "28",
            "7",
            "7",
            "7",
            "14",
            "7",
            "28",
            "100",
            "7",
            "7",
            "100",
            "28",
            "7",
            "28",
            "3",
            "7",
            "2",
            "7",
            "1",
            "1",
            "4",
            "7",
            "28",
            "28",
            "7",
            "7",
            "7",
            "7",
            "56",
            "7",
            "28",
            "56",
            "5",
            "14",
            "56",
            "56",
            "7",
            "28",
            "7",
            "7",
            "7",
            "7",
            "28",
            "7",
            "1",
            "56",
            "14",
            "28",
            "28",
            "7",
            "5",
            "56",
            "28",
            "28",
            "56",
            "56",
            "56",
            "56",
            "7",
            "7",
            "7",
            "7",
            "3",
            "4",
            "28",
            "28",
            "7",
            "100",
            "0.0001"
    };

    private String[] aantalInVoorraad = { "1",
            "1",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "12",
            "1",
            "1",
            "1",
            "1",
            "4",
            "1",
            "5",
            "4",
            "1",
            "1",
            "1",
            "6",
            "6",
            "1",
            "1",
            "1",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "2",
            "2",
            "2",
            "1",
            "1",
            "1",
            "1",
            "12",
            "1",
            "2",
            "1",
            "6",
            "2",
            "6",
            "2",
            "6",
            "2",
            "1",
            "1",
            "1",
            "1",
            "2",
            "2",
            "1",
            "1",
            "1",
            "12",
            "1",
            "1",
            "6",
            "1",
            "1",
            "4",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "6",
            "1",
            "1",
            "1",
            "12",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "2",
            "1",
            "1",
            "6",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "2",
            "12",
            "1",
            "1",
            "2",
            "1",
            "1",
            "1",
            "6",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "4",
            "1",
            "1",
            "4",
            "1",
            "1",
            "1",
            "1",
            "4",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "2",
            "1",
            "12",
            "6",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "6",
            "1",
            "1",
            "1",
            "1",
            "1",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "2",
            "4",
            "1",
            "1",
            "1",
            "1",
            "4"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_standaard2);

        standaardLijst2 = (ListView)this.findViewById(R.id.standaardlijst2);

        databaseHelper2 = new DatabaseHelper2(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        standaardLijst2.setAdapter(arrayAdapter);

        for (int i = 0; i < producten.length; i++)
        {
            arrayAdapter.add(producten[i]);
        }




        arrayAdapter.notifyDataSetChanged();

        standaardLijst2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id){
                //ItemClicked item = adapter.getItemAtPosition(position);
                String item = ((TextView)view).getText().toString();
                Intent intent = new Intent(DatabaseStandaard2.this,Boodschappenlijst.class);
                //based on item add info to intent
                startActivity(intent);
                databaseHelper2.addUser(producten[position], aantalDagenInVoorraad[position], aantalInVoorraad[position], "");
            }
        });

    }
}
