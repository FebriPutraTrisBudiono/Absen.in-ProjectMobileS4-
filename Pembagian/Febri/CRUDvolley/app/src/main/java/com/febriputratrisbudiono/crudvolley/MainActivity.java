package com.febriputratrisbudiono.crudvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.febriputratrisbudiono.crudvolley.Absen.Absen;
import com.febriputratrisbudiono.crudvolley.Absenku.Absenku;
import com.febriputratrisbudiono.crudvolley.Anggota.Tampil_data;
import com.febriputratrisbudiono.crudvolley.Dashboard.Dashboard;
import com.febriputratrisbudiono.crudvolley.Profile.Profile;

public class MainActivity extends AppCompatActivity {

    CardView tampil_data, absen, absenku, profile, dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tampil_data = findViewById(R.id.tampil_data);
        absen = findViewById(R.id.absen);
        absenku = findViewById(R.id.absenku);
        profile = findViewById(R.id.profile);
        dashboard = findViewById(R.id.dashboard);

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

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
            }
        });
    }
}