package com.company;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Mahasiswa extends Person {
    private String NIKmhs;
    private LocalDate tglMasuk;
    private List<Enrollment> enrollment = new LinkedList<>();


    public Mahasiswa (){super();}
    public Mahasiswa(String NIKmhs,LocalDate tglMasuk,String  namaDpn,String namaBlkng,String tmptLahir,LocalDate tglLahir, String kelamin,
                     String noKtp,String Agama,String golDarah,List<Enrollment> enrol){

        super(namaDpn,namaBlkng,tglLahir,tmptLahir,kelamin,noKtp,Agama,golDarah);
        this.NIKmhs = NIKmhs;
        this.tglMasuk = tglMasuk;
        this.enrollment = enrol;

    }


    public String getNIKmhs() {
        return NIKmhs;
    }

    public void setNIKmhs(String NIKmhs) {
        this.NIKmhs = NIKmhs;
    }

    public LocalDate getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(LocalDate tglMasuk) {
        this.tglMasuk = tglMasuk;
    }


    public List<Enrollment> getEnrollment() {
        return this.enrollment;
    }

    public void setEnrollment(List<Enrollment> enrollment) {
        this.enrollment = enrollment;
    }
}
