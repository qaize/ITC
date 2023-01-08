package com.company;

import java.time.LocalDate;

public class Person {

    private String nama;
    private String tempatLahir;
    private LocalDate tglLahir;
    private String alamat;

    public Person(){}
    public Person (String nama,String tempatLahir,LocalDate tglLahir,String alamat){
        this.nama = nama;
        this.tempatLahir=tempatLahir;
        this.tglLahir= tglLahir;
        this.alamat=alamat;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){return this.nama;}

    public void setTempatLahir(String tempatLahir){
        this.tempatLahir = tempatLahir;
    }

    public String getTempatLahir(){return this.tempatLahir;}

    public void setTglLahir(LocalDate date){
        this.tglLahir = date;
    }
    public LocalDate getTglLahir(){return this.tglLahir;}

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getAlamat(){return this.alamat;}


}
