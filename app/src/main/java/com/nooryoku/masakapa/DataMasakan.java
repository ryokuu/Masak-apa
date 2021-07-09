package com.nooryoku.masakapa;

public class DataMasakan {

    private String mMasakan;
    private String mBahanUtama;
    private String mRempah;
    private String mTanggal;

    public DataMasakan () {
    }

    public DataMasakan(String masakan, String bahanUtama, String rempah, String tanggal) {
        this.mMasakan = masakan;
        this.mBahanUtama = bahanUtama;
        this.mRempah = rempah;
        this.mTanggal = tanggal;
    }

    public String getmMasakan() {
        return mMasakan;
    }

    public String getmBahanUtama() {
        return mBahanUtama;
    }

    public String getmRempah() {
        return mRempah;
    }

    public String getmTanggal() {
        return mTanggal;
    }

}
