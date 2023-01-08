package com.company;

public abstract class Elektronik {
    /*TV, Monitor, Smartphone */
    private int tahunPembuatan;
    private String merek;
    private String tipe;
//    kons
    public Elektronik(){}
    public Elektronik(String merek, int tahunPembuatan,String tipe){
        this.merek = merek;
        this.tipe = tipe;
        this.tahunPembuatan = tahunPembuatan;
    }

    public void setMerek(String merek){
        this.merek = merek;
    }
    public String getMerek(){
        return this.merek;
    }

    public void setTahunPembuatan(int tahunPembuatan){
        this.tahunPembuatan = tahunPembuatan;
    }

    public int getTahunPembuatan(){
        return this.tahunPembuatan;
    }

    public void setTipe(String tipe ){
        this.tipe = tipe;
    }

    public String getTipe(){
        return tipe;
    }
}
