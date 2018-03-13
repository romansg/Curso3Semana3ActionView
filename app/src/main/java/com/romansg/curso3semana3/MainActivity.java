package com.romansg.curso3semana3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);rvMascotas.setLayoutManager(llm);

        inicializarMascotas();
        inicializarAdaptador();
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Abby", R.drawable.abby));
        mascotas.add(new Mascota("Bunny", R.drawable.bunny));
        mascotas.add(new Mascota("Carrot", R.drawable.carrot));
        mascotas.add(new Mascota("Clifford", R.drawable.clifford));
        mascotas.add(new Mascota("Dakota", R.drawable.dakota));
        mascotas.add(new Mascota("Dexter", R.drawable.dexter));
        mascotas.add(new Mascota("Fiona", R.drawable.fiona));
        mascotas.add(new Mascota("Loki", R.drawable.loki));
        mascotas.add(new Mascota("Milo", R.drawable.milo));
//        mascotas.add(new Mascota("Morgan", R.drawable.morgan));
        mascotas.add(new Mascota("Oscar", R.drawable.oscar));
        mascotas.add(new Mascota("Puffy", R.drawable.puffy));
        mascotas.add(new Mascota("Rabito", R.drawable.rabito));
        mascotas.add(new Mascota("Rex", R.drawable.rex));
        mascotas.add(new Mascota("Scooter", R.drawable.scooter));
        mascotas.add(new Mascota("Squirtle", R.drawable.squirtle));
        mascotas.add(new Mascota("Tiger", R.drawable.tiger));
        mascotas.add(new Mascota("Tucky", R.drawable.tucky));
        mascotas.add(new Mascota("Wilson", R.drawable.wilson));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adpatador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adpatador);
    }
}
