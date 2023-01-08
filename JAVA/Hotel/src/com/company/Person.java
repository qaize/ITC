package com.company;

import java.time.LocalDate;

import com.company.Enum.Kelamin;

public class Person {
    private String namaDpn;
    private String namaBlkng;
    private String tmptLahir;
    private LocalDate tglLahir;
    private Kelamin jenisKelamin;
    private String noKtp;

    public Person(){}
    public Person(String namaDpn,String namaBlkng,String tmptLahir,LocalDate tglLahir, Kelamin jenisKelamin,String noKtp){
        this.namaDpn = namaDpn;
        this.namaBlkng = namaBlkng;
        this.tglLahir = tglLahir;
        this.jenisKelamin = jenisKelamin;
        this.noKtp = noKtp;
        this.tmptLahir = tmptLahir;
    }

    public String getNamaDpn() {
        return namaDpn;
    }

    public void setNamaDpn(String namaDpn) {
        this.namaDpn = namaDpn;
    }

    public String getNamaBlkng() {
        return namaBlkng;
    }

    public void setNamaBlkng(String namaBlkng) {
        this.namaBlkng = namaBlkng;
    }

    public LocalDate getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(LocalDate tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Kelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Kelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }


    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getTmptLahir() {
        return tmptLahir;
    }

    public void setTmptLahir(String tmptLahir) {
        this.tmptLahir = tmptLahir;
    }
}
