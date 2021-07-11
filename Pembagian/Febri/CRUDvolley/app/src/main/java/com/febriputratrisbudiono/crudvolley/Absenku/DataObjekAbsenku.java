package com.febriputratrisbudiono.crudvolley.Absenku;

public class DataObjekAbsenku {

    String tgl="", waktu="", keterangan="", id_user="", longlat="";
    public DataObjekAbsenku(String tgl, String waktu, String keterangan, String id_user, String longlat) {
        this.tgl = tgl;
        this.waktu = waktu;
        this.keterangan = keterangan;
        this.id_user = id_user;
        this.longlat = longlat;
    }

    public String getTgl() {
        return tgl;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getId_user() {
        return id_user;
    }

    public String getLonglat() {
        return longlat;
    }
}
