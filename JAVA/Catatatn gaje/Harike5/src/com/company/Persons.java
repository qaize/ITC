package com.company;

import ListEnum.Agama;
import ListEnum.JenisKelamin;

import java.time.LocalDate;

public class Persons {
    private String namadepan;
    private String namabelakang;
    private String tempatlahir;
    private LocalDate tanggallahir;
    private JenisKelamin jeniskelamin;
    private String notelp;
    private String alamat;
    private Agama agama;

    public Persons() {
    }

    public Persons(String namadpn, String nmblkg, String tmptlhir,
                   LocalDate tgllahir, JenisKelamin gender, String notelp, String alamt, Agama agama) {
        this.namadepan = namadpn;
        this.namabelakang = nmblkg;
        this.alamat = alamt;
        this.notelp = notelp;
        this.jeniskelamin = gender;
        this.tanggallahir = tgllahir;
        this.tempatlahir = tmptlhir;
        this.agama=agama;
    }

    public void setNamadepan(String nmdpn){
        this.namadepan=nmdpn;
    }
    public String getNamadepan(){
        return this.namadepan;
    }
    public void setNamabelakang(String nmblkg){
        this.namabelakang=nmblkg;
    }
    public String getNamabelakang(){
        return this.getNamabelakang();
    }

    public void setTempatlahir(String tmptlhir){
        this.tempatlahir=tmptlhir;
    }

    public String getTempatlahir(){
        return this.tempatlahir;
    }

    public void setAlamat(String alamat){
        this.alamat=alamat;
    }

    public String getAlamat(){
        return this.getAlamat();
    }

    public void setTanggallahir(LocalDate tgllahir){
        this.tanggallahir=tgllahir;
    }

    public LocalDate getTanggallahir(){
        return this.tanggallahir;
    }

    public void setJeniskelamin(JenisKelamin jk){
        this.jeniskelamin=jk;
    }

    public JenisKelamin getJeniskelamin(){
        return this.jeniskelamin;
    }

    public void setAgama(Agama agama){
        this.agama=agama;
    }

    public Agama getAgama(){
        return this.agama;
    }

    public void setNotelp(String notel){
        this.notelp=notel;
    }
    public String getNotelp(){
        return this.notelp;
    }


    public void PrintInformation(){
        System.out.println("Nama depan: "+this.namadepan);
        System.out.println("Nama belakang : "+this.namabelakang);
        System.out.println("Tempat, Tgl Lahir : "+this.tempatlahir+", "+this.tanggallahir);
        System.out.println("Jenis Kelamin : "+this.jeniskelamin);
        System.out.println("No Telf : "+this.notelp);
        System.out.println("Alamat : "+this.alamat);
        System.out.println("Agama : "+this.agama.getNamaagama());
    }

}
