package com.romansg.curso3semana3;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by roman on 13/03/18.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    private ArrayList<Mascota> mascotas;
    private Activity activity;

    /**
     * Crea un adaptador para mascotas
     *
     * @param mascotas Lista de mascotas
     * @param activity Activity que contiene a la lista de mascotas
     */
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas  = mascotas;
        this.activity = activity;
    }

    @Override
    /**
     * Crea un MascotaViewHolder a partir del layout (XML) para la mascota
     */
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    /**
     * Llena los datos del MascotaViewHolder correspondiente a position
     */
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.ivPetPhoto.setImageResource(mascota.getFoto());
        holder.tvPetName.setText(mascota.getNombre());
        holder.tvPetLikes.setText(mascota.getLikes() + "");

        holder.btnPetLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int likes = mascota.getLikes() + 1;
                mascota.setLikes(likes);
                holder.tvPetLikes.setText(likes + "");

                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPetPhoto;
        private ImageButton btnPetLike;
        private TextView tvPetName;
        private TextView tvPetLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            ivPetPhoto = itemView.findViewById(R.id.ivPetPhoto);
            btnPetLike = itemView.findViewById(R.id.btnPetLike);
            tvPetName = itemView.findViewById(R.id.tvPetName);
            tvPetLikes  = itemView.findViewById(R.id.tvPetLikes);
        }
    }
}
