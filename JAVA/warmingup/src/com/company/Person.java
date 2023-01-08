package com.company;

import java.time.LocalDate;

public class Person {
    private String namaDpn;
    private String namaBlkng;
    private LocalDate tglLahir;

    public Person(String namaDpn, String namaBlkg, LocalDate tglLahir) {
        this.namaDpn = namaDpn;
        this.namaBlkng = namaBlkg;
        this.tglLahir = tglLahir;
    }

    public Person() {

    }

    public void setNamaDpn(String namaDpn){
        this.namaDpn = namaDpn;
    }
    public String getNamaDpn(){return this.namaDpn;}

    public void setNamaBlkg(String namaBlkg){
        this.namaBlkng = namaBlkg;
    }
    public String getNamaBlkg(){return this.namaBlkng;}

    public void setTglLahir(LocalDate tglLahir){
        this.tglLahir = tglLahir;
    }
    public LocalDate getTglLahir(){return this.tglLahir;}
}
