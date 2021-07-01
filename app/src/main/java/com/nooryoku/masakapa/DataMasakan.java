package com.nooryoku.masakapa;

public class DataMasakan {
    private String key;

    private String masakan;
    private String bahan_utama;

    public DataMasakan () {
    }

    public DataMasakan(String masakan, String bahan_utama) {
        this.masakan = masakan;
        this.bahan_utama = bahan_utama;
    }

    public String getMasakan() {
        return masakan;
    }

    public void setMasakan(String masakan) {
        this.masakan = masakan;
    }

    public String getBahan_utama() {
        return bahan_utama;
    }

    public void setBahan_utama(String bahan_utama) {
        this.bahan_utama = bahan_utama;
    }
}
