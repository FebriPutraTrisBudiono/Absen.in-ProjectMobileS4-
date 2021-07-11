package com.febriputratrisbudiono.crudvolley.Anggota;

public class DataObjek {
    String nama="", kelas="", no_handphone="", jenis_kelamin="";
    public DataObjek(String nama, String kelas, String no_handphone, String jenis_kelamin) {
        this.nama = nama;
        this.kelas = kelas;
        this.no_handphone = no_handphone;
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getNo_handphone() {
        return no_handphone;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }
}
