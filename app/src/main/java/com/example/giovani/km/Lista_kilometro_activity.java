package com.example.giovani.km;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Lista_kilometro_activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_kilometro_activity);

        //chama o km adapter para preencher a ListActivity com os dados contidos na lista de kms
        setListAdapter(new kilometro_adapter(this, Km_Activity.listakilometros));
    }
}
