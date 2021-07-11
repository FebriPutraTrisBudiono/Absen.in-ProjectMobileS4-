package com.febriputratrisbudiono.crudvolley.Anggota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.febriputratrisbudiono.crudvolley.R;

public class Lihat_data extends AppCompatActivity {

    TextView nama, jenis_kelamin, kelas, no_handphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_data);
        nama = findViewById(R.id.nama);
        jenis_kelamin = findViewById(R.id.jenis_kelamin);
        kelas = findViewById(R.id.kelas);
        no_handphone = findViewById(R.id.no_handphone);

        //ambil data dari intent
        nama.setText(getIntent().getStringExtra("nama"));
        kelas.setText(getIntent().getStringExtra("kelas"));
        jenis_kelamin.setText(getIntent().getStringExtra("jenis_kelamin"));
        no_handphone.setText(getIntent().getStringExtra("no_handphone"));
    }
}