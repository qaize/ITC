package com.company;
/*

field sama dengan kolom di sql
 */

import java.time.LocalDate;

public class karyawan {

  private String idKaryawan;
  private String namaLengkap;
  private String tempatLahir;
  private LocalDate tanggalLahir;
  private String kelamin;
  private String noTelepon;
  private String alamat;

    public karyawan(){};
    public karyawan(String idKar, String namaLengkap, String tempatLahir, LocalDate tgl,String kelamin, String noTelepon,String Alamat){
        this.idKaryawan = idKar;
        this.namaLengkap = namaLengkap;
        this.tanggalLahir = tgl;
        this.kelamin = kelamin;
        this.noTelepon = noTelepon;
        this.alamat = Alamat;
    }

      public void setId(String idKaryawn){
          this.idKaryawan = idKaryawn;
      }
      public String getIdKaryawan(){

          return this.idKaryawan;
      }

      public void setNamaLengkap(String namaLengkap1){
          this.namaLengkap = namaLengkap1;

      }
      public String getNamaLengkap (){
          return this.namaLengkap;
      }

    public void setTempatLahir(String TempatLahir){
        this.tempatLahir = TempatLahir;

    }
    public String getTempatLahir (){
        return this.tempatLahir;
    }

    public void setTanggalLahir(LocalDate tglLahir){
        this.tanggalLahir = tglLahir;

    }
    public LocalDate getTanggalLahir (){
        return this.tanggalLahir;
    }

    public void setNoTelepon(String notlpn){
        this.noTelepon = notlpn;

    }
    public String getNoTelepon (){
        return this.noTelepon;
    }

    public void setAlamat(String Alamat){
        this.alamat = Alamat;

    }
    public String getAlamat (){
        return this.alamat;
    }

    public void printInformasi (){

        System.out.println(String.format("Id : %s",this.idKaryawan));
        System.out.println(String.format("namaLengkap : %s",this.namaLengkap));
        System.out.println(String.format("TempatLahir : %s",this.tempatLahir));
        System.out.println(String.format("tanggal lahir : %s",this.namaLengkap));
        System.out.println(String.format("Id : %s",this.namaLengkap));
        System.out.println(String.format("Id : %s",this.namaLengkap));
        System.out.println(String.format("Id : %s",this.namaLengkap));
        System.out.println(String.format("Id : %s",this.namaLengkap));

    }
  }

