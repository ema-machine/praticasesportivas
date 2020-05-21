package com.example.praticasesportivas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sh = getSharedPreferences("lista",MODE_PRIVATE);


        Button btEnviar = findViewById(R.id.btEnviar);
        Button btCalcular = findViewById(R.id.btCalcular);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText txtIdade = findViewById(R.id.txtIdade);
                String idade = txtIdade.getText().toString();

                MainActivity.this.sh.edit().putString("msg", idade).apply();
                Toast.makeText(MainActivity.this, "Enviado!", Toast.LENGTH_SHORT).show();

            }
        });

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idade = MainActivity.this.sh.getString("msg", "default");

                Intent intent = new Intent(MainActivity.this, FrequenciaCardiaca.class);
                startActivity(intent);
            }
        });


    }
}
