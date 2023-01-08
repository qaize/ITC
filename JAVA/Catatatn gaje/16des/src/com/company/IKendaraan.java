package com.company;

public interface IKendaraan {


    public void setTipe(String tipe);
    public String getTipe();

    public void setMerek(String merek);
    public String getMerek();

    public void setTahun(int tahun);
    public int getTahun();

    public void setNoPolisi(String noPolisi);
    public String getNoPolisi();

    public void printInfoKendaraan();
}
