package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDeleteActivity2 extends AppCompatActivity {

    private UserModel2 userModel2;
    private EditText etname, ethobby, etcity;
    private Button btnupdate, btndelete;
    private DatabaseHelper2 databaseHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete2);

        Intent intent = getIntent();
        userModel2 = (UserModel2) intent.getSerializableExtra("user");

        databaseHelper2 = new DatabaseHelper2(this);

        etname = (EditText) findViewById(R.id.etname);
        ethobby = (EditText) findViewById(R.id.ethobby);
        etcity = (EditText) findViewById(R.id.etcity);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        etname.setText(userModel2.getProduct());
        ethobby.setText(userModel2.getAantal_dagen());
        etcity.setText(userModel2.getAantal_producten());


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper2.updateUser(userModel2.getId(),etname.getText().toString(),ethobby.getText().toString(),etcity.getText().toString());
                Toast.makeText(UpdateDeleteActivity2.this, "Wijzigingen opgeslagen!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteActivity2.this,Boodschappenlijst.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper2.deleteUSer(userModel2.getId());
                Toast.makeText(UpdateDeleteActivity2.this, "Product verwijderd!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteActivity2.this,Boodschappenlijst.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
