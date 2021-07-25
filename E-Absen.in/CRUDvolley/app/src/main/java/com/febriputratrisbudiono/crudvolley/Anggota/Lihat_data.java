package com.febriputratrisbudiono.crudvolley.Anggota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.febriputratrisbudiono.crudvolley.R;

public class Lihat_data extends AppCompatActivity {

    TextView name, jabatan, no_telepon, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_data);
        name = findViewById(R.id.name);
        jabatan = findViewById(R.id.jabatan);
        no_telepon = findViewById(R.id.no_telepon);
        alamat = findViewById(R.id.alamat);

        //ambil data dari intent
        name.setText(getIntent().getStringExtra("name"));
        jabatan.setText(getIntent().getStringExtra("jabatan"));
        no_telepon.setText(getIntent().getStringExtra("no_telepon"));
        alamat.setText(getIntent().getStringExtra("alamat"));
    }
}