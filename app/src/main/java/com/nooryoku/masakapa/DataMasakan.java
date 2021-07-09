package com.nooryoku.masakapa;

import java.util.Date;

public class DataMasakan {

    private String mMasakan;
    private String mBahanUtama;
    private String mRempah;
    private Date mTanggal;

    public DataMasakan () {
    }

    public DataMasakan(String masakan, String bahanUtama, String rempah) {
        this.mMasakan = masakan;
        this.mBahanUtama = bahanUtama;
        this.mRempah = rempah;
        //this.mTanggal = tanggal;
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

    public Date getmTanggal() {
        return mTanggal;
    }

}
