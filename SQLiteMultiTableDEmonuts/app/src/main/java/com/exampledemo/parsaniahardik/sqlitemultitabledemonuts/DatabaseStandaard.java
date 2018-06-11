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

    private String[] producten = {"Aanmaakblokjes",
            "Aanmaaklimonade(0.75L)",
            "Aardappelen(0.5KG)",
            "Aardappelen(5KG)",
            "Aardbijen",
            "Afbakbroodjes",
            "Afwasmiddel",
            "Afwassponzen",
            "Appel",
            "Appelmoes",
            "Augurken(350Gr uitgelekt)",
            "Babymelkpoeder",
            "Babypoeder",
            "Babyvoeding",
            "Bami",
            "Banaan",
            "Bapao",
            "Barbecuekooltjes",
            "Barbecuesaus",
            "Beschuit",
            "Bier(blikje)",
            "Bier(flesje)",
            "Bitterballen",
            "Bloemkool(500)",
            "Boerenkool",
            "Boter(bakken en braden)",
            "Boter(room)",
            "Boter(vloeibaar)",
            "Boter(voor boterhammen)",
            "Boterhamworst",
            "Boterhamzakjes",
            "Broccoli (500Gr)",
            "Brood",
            "Broodjes",
            "Bruine bonen",
            "Carrero's",
            "Cervelaatworst",
            "Chilisaus(0.5L)",
            "Chips(180Gr)",
            "Chips(28Gr)",
            "Chocola(200Gr)",
            "Chocolademelk(1L)",
            "Chocoladepasta",
            "Cola Zero(0.5L)",
            "Cola Zero(2L)",
            "Cola light(0.5L)",
            "Cola light(2L)",
            "Cola(0.5L)",
            "Cola(2L)",
            "Condooms",
            "Cornflakes",
            "Cruesli",
            "Curry(0.8L)",
            "Deodorant",
            "Doperwten",
            "Douchegel",
            "Drop",
            "Druiven",
            "Ei",
            "Eierkoeken",
            "Eiersalade",
            "Energy drink(blik)",
            "Flosdraad",
            "Frikandellen",
            "Frikandellenbroodje",
            "Frites",
            "Fritessaus",
            "Frituurvet",
            "Gehakt(1KG)",
            "Grillworst",
            "Groenten(0.3KG voor gerechten)",
            "Haargel",
            "Haarwax",
            "Hagelslag",
            "Ham",
            "Hamburgers(500Gr)",
            "Hamstervoer",
            "Handzeep",
            "Hondenbrokken",
            "Hondenvlees",
            "Honing",
            "Hotdogs",
            "Houtskool",
            "Ijsjes",
            "Ice Tea(1.5L)",
            "Inlegkruisjes",
            "Jam(400Gr)",
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
            "Kipfilet(500Gr)",
            "Kipsatesalade",
            "Knakworstjes",
            "Knoflooksaus",
            "Koekjes",
            "Koffiebonen",
            "Koffiecups",
            "Koffiefilters",
            "Koffiemelk(0.5L)",
            "Koffiemelkpoeder(1KG)",
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
            "Macaroni(0.5KG)",
            "Mandarijn",
            "Mayonnaise",
            "Melk(1.5L)",
            "Melk(1L)",
            "Melk(2L)",
            "Meloen",
            "Mexicano's",
            "Mineraalwater(0.5L)",
            "Mineraalwater(2L)",
            "Mosterd",
            "Muesli",
            "Mueslirepen",
            "Muisjes(broodbeleg)",
            "Nasi",
            "Noodles",
            "Olijfolie",
            "Ontbijtcrackers",
            "Ontbijtkoek",
            "Pannekoeken",
            "Paprika",
            "Pedaalemmerzakken",
            "Peper",
            "Pepermunt",
            "Pina calada",
            "Pinda's",
            "Pindakaas",
            "Pindasaus",
            "Pizza",
            "Pleisters",
            "Poedersuiker",
            "Poffertjes",
            "Reinigingsdoekjes",
            "Rijst(1KG)",
            "Rode kool",
            "Rookworst",
            "Rozijnen",
            "Rum",
            "Salami(plakken)",
            "Salami(staaf)",
            "Sambal",
            "Sardientjes(blik)",
            "Saucijzenbroodje",
            "Scheermesjes",
            "Scheerschuim",
            "Schitnzels(500Gr)",
            "Shampoo",
            "Sigaretten shaq",
            "Sigaretten vloeitjes",
            "Sigaretten(pakje)",
            "Sigarettenfilters",
            "Sinaasappel",
            "Sinas(0.5L)",
            "Sinas(2L)",
            "Sla",
            "Sladressing",
            "Slagroom",
            "Slavinken",
            "Spaghetti",
            "Spruiten",
            "Stoofperen",
            "Stro(voor huisdieren)",
            "Stroopwafels",
            "Suiker(klontjes)",
            "Suiker(zak)",
            "Sultana",
            "Tampons",
            "Tandenborstel",
            "Tandpasta",
            "Theezakjes",
            "Tissues",
            "Tomaten",
            "Tonijn(blik)",
            "Tuinbonen",
            "Uien",
            "Vaatwastabletten",
            "Vissticks",
            "Vitamine water(0.5L)",
            "Vlammetjes",
            "Vodka",
            "Vogelzaad",
            "Vogelzand",
            "Vruchtenhagel",
            "Vruchtensap(1.5L)",
            "Vuilniszakken",
            "WC-blokken",
            "WC-reiniger",
            "Wasmiddel",
            "Waspoeder",
            "Wasverzachter",
            "Wc-papier",
            "Wijn",
            "Witte bonen in tomatensaus",
            "Worstenbroodjes",
            "Wortelen(500Gr)",
            "Yoghurt",
            "Yoghurt drink",
            "Zaagsel(voorhuisdieren)",
            "Zakdoekjes",
            "Zonnebloempitten",
            "Zout(1KG)",
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
        setContentView(R.layout.activity_database_standaard);

        standaardLijst = (ListView)this.findViewById(R.id.standaardlijst);

        databaseHelper = new DatabaseHelper(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        standaardLijst.setAdapter(arrayAdapter);

        for (int i = 0; i < producten.length; i++)
        {
            arrayAdapter.add(producten[i]);
        }




        arrayAdapter.notifyDataSetChanged();

        standaardLijst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id){
                //ItemClicked item = adapter.getItemAtPosition(position);
                String item = ((TextView)view).getText().toString();
                Intent intent = new Intent(DatabaseStandaard.this,GetAllUsersActivity.class);
                //based on item add info to intent
                startActivity(intent);
                databaseHelper.addUser(producten[position], aantalDagenInVoorraad[position], aantalInVoorraad[position]);
            }
        });

    }
}
