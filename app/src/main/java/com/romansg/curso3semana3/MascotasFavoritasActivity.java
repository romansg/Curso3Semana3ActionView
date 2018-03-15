package com.romansg.curso3semana3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;

public class MascotasFavoritasActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    RecyclerView rvMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Bundle extras = getIntent().getExtras();

        Toolbar appbar = findViewById(R.id.appbar);
        setSupportActionBar(appbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotasFavoritas = findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);rvMascotasFavoritas.setLayoutManager(llm);

        inicializarMascotas();
        inicializarAdaptador();
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bunny", R.drawable.bunny));
        mascotas.add(new Mascota("Fiona", R.drawable.fiona));
        mascotas.add(new Mascota("Morgan", R.drawable.morgan));
        mascotas.add(new Mascota("Puffy", R.drawable.puffy));
        mascotas.add(new Mascota("Scooter", R.drawable.scooter));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adpatador = new MascotaAdaptador(mascotas, this);
        rvMascotasFavoritas.setAdapter(adpatador);
    }
}
