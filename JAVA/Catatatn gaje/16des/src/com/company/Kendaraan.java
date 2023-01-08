package com.company;

public class Kendaraan implements IKendaraan {
    private String Tipe;
    private String Merek;
    private int tahun;
    private String NoPolisi;

    public Kendaraan (String tipe, String merek, int tahun, String noPolisi){
        this.Tipe = tipe;
        this.Merek = merek;
        this.tahun = tahun;
        this.NoPolisi = noPolisi;
    }


    public void setTipe(String tipe){
        this.Tipe = tipe;
    }
    public String getTipe(){
        return this.Tipe;
    }


    @Override
    public void setMerek(String merek) {
        this.Merek = merek;

    }

    @Override
    public String getMerek() {
        return this.Merek;
    }

    @Override
    public void setTahun(int tahun) {
        this.tahun = tahun;

    }

    @Override
    public int getTahun() {
        return this.tahun;
    }

    @Override
    public void setNoPolisi(String noPolisi) {
        this.NoPolisi = noPolisi;

    }

    @Override
    public String getNoPolisi() {
        return this.getNoPolisi();
    }

    @Override
    public void printInfoKendaraan() {

        System.out.println(String.format("Tipe %s ,Merek  : %s, Tahun : %s , No Polisi : %s ",this.Tipe,this.Merek,this.tahun,this.NoPolisi));

    }
}
