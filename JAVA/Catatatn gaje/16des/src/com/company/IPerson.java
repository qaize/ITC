package com.company;

import java.time.LocalDate;

/*
interface tidak memikiliki isi


        */
public interface IPerson {
    /*namadepan,namabelakang, tempatlahir, tanggalLahir, JenisKelamin, Alamat,
    * noTelpom */


    public void setNamaDepan(String namaDepan);
    public  String getNamaDepan();

    public void setNamaBelakang(String namaBelakang);
    public  String  getNamaBelakang();

    public  void  setTempatLahir(String tmpLahir);
    public  String  getTempatLahir();

    public  void setTanggalLahir(LocalDate date);
    public  LocalDate  getTanggalLahir();

    public void  setJenisKelamin(String kelamin);
    public  String  getJenisKelamin();

    public  void  setAlamat(String Alamat);
    public  String  getAlamat();

    public  void  setNoTelepon(String noTelepon);
    public  String getNotelepon();
}
