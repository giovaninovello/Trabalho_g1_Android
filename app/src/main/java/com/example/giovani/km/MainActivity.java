package com.example.giovani.km;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void Cadastrar_km (View v){

        Intent intent;
        intent = new Intent(this,Km_Activity.class);
        startActivity(intent);

    }
    public  void Lista (View v){

        Intent intent;
        intent = new Intent(this,Km_Activity.class);
        startActivity(intent);
    }
    public  void Novo (View v){

        Intent intent;
        intent = new Intent(this,Km_Activity.class);
        startActivity(intent);
    }
}
