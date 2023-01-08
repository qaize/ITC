package com.company;

import java.time.LocalDate;
import Enum.agama;
import Enum.JenisKelamin;

public class person {

    private String namaLengkap;
    private String tempatLahir;
    private LocalDate tanggalLahir;
    private JenisKelamin kelamin;
    private String noTelepon;
    private String alamat;
    private agama agama;


    public person(){}

    public person (String namaLengkap, String tmptLahir, LocalDate tgllhir, JenisKelamin klmin, String noTel, String almt, agama agma){

        this.namaLengkap = namaLengkap;
        this.tempatLahir = tmptLahir;
        this.tanggalLahir = tgllhir;
        this.kelamin = klmin;
        this.noTelepon =  noTel;
        this.alamat = almt;
        this.agama = agma;
    }

    public void setNamaLengkap(String namaLengkap1){this.namaLengkap = namaLengkap1;}
    public String getNamaLengkap (){
        return this.namaLengkap;
    }

    public void setTempatLahir(String TempatLahir){this.tempatLahir = TempatLahir;}
    public String getTempatLahir (){
        return this.tempatLahir;
    }

    public void setTanggalLahir(LocalDate tglLahir){this.tanggalLahir = tglLahir;}
    public LocalDate getTanggalLahir (){
        return this.tanggalLahir;
    }

    public void setNoTelepon(String notlpn){this.noTelepon = notlpn;}
    public String getNoTelepon (){
        return this.noTelepon;
    }

    public void setAlamat(String Alamat){this.alamat = Alamat; }
    public String getAlamat (){
        return this.alamat;
    }

    public void setAgama(agama agama){this.agama = agama; }
    public agama getAgama (){return this.agama;}

    public void setKelamin(JenisKelamin kelamin){this.kelamin = kelamin; }
    public JenisKelamin getKelamin (){
        return this.kelamin;
    }



}
