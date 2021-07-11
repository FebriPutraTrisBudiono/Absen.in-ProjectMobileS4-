package com.febriputratrisbudiono.crudvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.febriputratrisbudiono.crudvolley.Absen.Absen;
import com.febriputratrisbudiono.crudvolley.Absenku.Absenku;
import com.febriputratrisbudiono.crudvolley.Anggota.Tampil_data;

public class MainActivity extends AppCompatActivity {

    CardView tampil_data, absen, absenku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tampil_data = findViewById(R.id.tampil_data);
        absen = findViewById(R.id.absen);
        absenku = findViewById(R.id.absenku);

        tampil_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Tampil_data.class));
            }
        });

        absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Absen.class));
            }
        });

        absenku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Absenku.class));
            }
        });
    }
}