package com.febriputratrisbudiono.crudvolley.Absenku;

public class DataObjekAbsenku {

    String tgl="", waktu="", keterangan="", id="", longlat="";
    public DataObjekAbsenku(String tgl, String waktu, String keterangan, String id, String longlat) {
        this.tgl = tgl;
        this.waktu = waktu;
        this.keterangan = keterangan;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public String getLonglat() {
        return longlat;
    }
}
