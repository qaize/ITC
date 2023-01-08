package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import Enum.agama;
import Enum.JenisKelamin;
import eksternal.departemen;

public class Employee extends person {
    private String idKaryawan;
    private BigDecimal gaji;
    private LocalDate tanggalMasuk;
    private departemen departemen;

    public Employee () { super(); }

    public Employee (String namaLengkap, JenisKelamin jeniskelamin, String tempatlahir, LocalDate tglLahir, String
        notelpn, String alamat, String idkaryawan, LocalDate tglmasuk, agama agama,departemen departemen){

        super(namaLengkap,tempatlahir,tglLahir,jeniskelamin,notelpn,alamat,agama);
        this.idKaryawan = idkaryawan;
        this.tanggalMasuk = tglmasuk;
        this.departemen = departemen;

    }

    public void setGaji(BigDecimal gaji) {
        this.gaji = gaji;
    }
    public BigDecimal getGaji(){
        return  this.gaji;
    }

    public void setIdKaryawan (String setIdKar){
        this.idKaryawan = setIdKar;
    }
    public String getIdKaryawan(){ return this.idKaryawan;}

    public void printinfoKaryawan(){
        System.out.println("Nama Lengkap     : "+getNamaLengkap());
        System.out.println("ID               : "+this.idKaryawan);
        System.out.println("Gaji             : "+this.gaji);
        System.out.println("Departemen       : "+departemen.getName());
        System.out.println("tgl. Masuk       : "+tanggalMasuk);
        System.out.println("Tempat/Tgl.lahir : "+getTempatLahir()+","+getTanggalLahir());
        System.out.println("Jenis Kelamin    :"+getKelamin());
//        System.out.println("Gaji Total       :"+getGaji().add(manager.getInsentif()));
    }
}