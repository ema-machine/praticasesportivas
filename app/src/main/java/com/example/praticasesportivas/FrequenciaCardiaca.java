package com.example.praticasesportivas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.widget.TextView;

public class FrequenciaCardiaca extends AppCompatActivity {

    private SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequencia_cardiaca);

        TextView lbFrequencia = findViewById(R.id.lbFrequencia);
        TextView lbCaminhadaRf1 = findViewById(R.id.lbCaminhadaRf1);
        TextView lbCaminhadaRf2 = findViewById(R.id.lbCaminhadaRf2);
        TextView lbTrotef1 = findViewById(R.id.lbTrotef1);
        TextView lbTrotef2 = findViewById(R.id.lbTrotef2);
        TextView lbCorridaLf1 = findViewById(R.id.lbCorridaLf1);
        TextView lbCorridaLf2 = findViewById(R.id.lbCorridaLf2);
        TextView lbCorridaMf1 = findViewById(R.id.lbCorridaMf1);
        TextView lbCorridaMf2 = findViewById(R.id.lbCorridaMf2);
        TextView lbCorridaIf1 = findViewById(R.id.lbCorridaIf1);

        SharedPreferences sh = getSharedPreferences("lista", MODE_PRIVATE);

        //Cálculo FCM
        String idades = sh.getString("msg", "default");
        int idadeconvert = Integer.parseInt(idades);
        int fcm = 220 - idadeconvert;
        lbFrequencia.setText(String.valueOf(fcm));

        //Cálculo Percentual de Faixas Caminhada Rápida

        int percCRf1 = (55 * fcm)/100;
        lbCaminhadaRf1.setText(String.valueOf(percCRf1));

        int percCRf2 = (60 * fcm)/100;
        lbCaminhadaRf2.setText(String.valueOf(percCRf2));

        //Cálculo Percentual de Faixas Trote

        int percTrotef1 = (65 * fcm)/100;
        lbTrotef1.setText(String.valueOf(percTrotef1));

        int percTrotef2 = (70 * fcm)/100;
        lbTrotef2.setText(String.valueOf(percTrotef2));

        //Cálculo Percentual de Faixas Corrida Leve

        int percCorridaLf1 = (75 * fcm)/100;
        lbCorridaLf1.setText(String.valueOf(percCorridaLf1));

        int percCorridaLf2 = (80 * fcm)/100;
        lbCorridaLf2.setText(String.valueOf(percCorridaLf2));

        //Cálculo Percentual de Faixas Corrida Moderada

        int percCorridaMf1 = (85 * fcm)/100;
        lbCorridaMf1.setText(String.valueOf(percCorridaMf1));

        int percCorridaMf2 = (90 * fcm)/100;
        lbCorridaMf2.setText(String.valueOf(percCorridaMf2));

        //Cálculo Percentual de Faixas Corrida Intensa

        int percCorridaIf1 = (95 * fcm)/100;
        lbCorridaIf1.setText(String.valueOf(percCorridaIf1));


    }
}
