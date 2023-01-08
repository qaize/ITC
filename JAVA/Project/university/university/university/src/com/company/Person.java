package com.company;

import java.time.LocalDate;

public class Person {
    private String NamaDpn;
    private String NamaBlkng;
    private LocalDate tglLahir;
    private String KotaLahir;
    private String kelamin;
    private String noKtp;
    private String Agama;
    private String golDarah;

    public Person(){}
    public Person(String  namaDpn,String namaBlkng,LocalDate tglLahir,String kotaLahir, String kelamin,
                  String noKtp,String Agama,String golDarah){

        this.NamaDpn = namaDpn;
        this.NamaBlkng = namaBlkng;
        this.tglLahir = tglLahir;
        this.kelamin = kelamin;
        this.noKtp = noKtp;
        this.Agama = Agama;
        this.golDarah = golDarah;
        this.KotaLahir = kotaLahir;
    }

    public String getNamaDpn() {
        return NamaDpn;
    }

    public void setNamaDpn(String namaDpn) {
        NamaDpn = namaDpn;
    }

    public String getNamaBlkng() {
        return NamaBlkng;
    }

    public void setNamaBlkng(String namaBlkng) {
        NamaBlkng = namaBlkng;
    }

    public LocalDate getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(LocalDate tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getKotaLahir() {
        return KotaLahir;
    }

    public void setKotaLahir(String kotaLahir) {
        KotaLahir = kotaLahir;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getAgama() {
        return Agama;
    }

    public void setAgama(String agama) {
        Agama = agama;
    }

    public String getGolDarah() {
        return golDarah;
    }

    public void setGolDarah(String golDarah) {
        this.golDarah = golDarah;
    }
}
