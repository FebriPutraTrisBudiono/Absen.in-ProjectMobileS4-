package com.febriputratrisbudiono.crudvolley.Anggota;

public class DataObjek {
    String name="", jabatan="", no_telepon="", alamat="";
    public DataObjek(String name, String jabatan, String no_telepon, String alamat) {
        this.name = name;
        this.jabatan = jabatan;
        this.no_telepon = no_telepon;
        this.alamat = alamat;
    }

    public String getName() {
        return name;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public String getAlamat() {
        return alamat;
    }
}
