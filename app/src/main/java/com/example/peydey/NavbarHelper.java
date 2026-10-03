package com.example.peydey;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.widget.ImageViewCompat;

public class NavbarHelper {

    public static void setup(Activity activity, int selectedId) {
        int[] items = {R.id.nav_home, R.id.nav_history, R.id.nav_ranking, R.id.nav_achievements};
        int[] icons = {R.id.ic_nav_home, R.id.ic_nav_history, R.id.ic_nav_ranking, R.id.ic_nav_achievements};
        int[] labels = {R.id.label_nav_home, R.id.label_nav_history, R.id.label_nav_ranking, R.id.label_nav_achievements};
        Class<?>[] destinos = {HomePageActivity.class, HistoryActivity.class, null, null};

        for (int i = 0; i < items.length; i++) {
            boolean selecionado = items[i] == selectedId;
            int cor = Color.parseColor(selecionado ? "#1A1A1A" : "#8A8A80");

            ImageView icon = activity.findViewById(icons[i]);
            if (icon != null) {
                ImageViewCompat.setImageTintList(icon, ColorStateList.valueOf(cor));
            }
            TextView label = activity.findViewById(labels[i]);
            if (label != null) {
                label.setTextColor(cor);
            }

            Class<?> destino = destinos[i];
            android.view.View itemView = activity.findViewById(items[i]);
            if (itemView != null) {
                itemView.setOnClickListener(v -> {
                    if (selecionado) return; // já está nessa tela
                    if (destino == null) return; // tela ainda não existe
                    Intent intent = new Intent(activity, destino);
                    if (destino == HomePageActivity.class) {
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        activity.startActivity(intent);
                    } else {
                        activity.startActivity(intent);
                        if (!(activity instanceof HomePageActivity)) {
                            activity.finish(); // evita empilhar telas ao trocar de aba
                        }
                    }
                });
            }
        }
    }
}