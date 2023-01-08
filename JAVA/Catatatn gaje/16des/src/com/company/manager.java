package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;

import eksternal.departemen;
import Enum.*;

public class manager extends Employee {
    private BigDecimal insentifGaji;
    public manager() { super(); }
    public manager (String namaLengkap, JenisKelamin jenisKelamin, String tempatLahir, LocalDate tglLahir, String notlpn,
                String alamat, String idKaryawan, LocalDate tglMasuk, agama agama,departemen departemen,BigDecimal insentifGaji){

        super(namaLengkap,jenisKelamin,tempatLahir,tglLahir,notlpn,alamat,idKaryawan,tglMasuk,agama,departemen);
        this.insentifGaji = insentifGaji;
    }

    public BigDecimal getInsentifGaji(){BigDecimal res=getGaji().add(this.insentifGaji); return res;}

    @Override
    public void printinfoKaryawan(){
        System.out.println("Nama Lengkap : "+getNamaLengkap());
        System.out.println("Gaji         : "+getGaji());
        System.out.println("Gaji Total   : "+getGaji().add(getInsentifGaji()));
    }
}



