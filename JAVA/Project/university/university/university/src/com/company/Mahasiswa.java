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

    public void printInfoMahasiswa1(){
        System.out.println(String.format("NIK : %s, Nama : %s %s ",this.getNIKmhs(),this.getNamaDpn(),this.getNamaBlkng()));
    }

    public void printDetailMahasiswa(){
        System.out.println(String.format("""
                Nama : %s %s
                Gender : %s
                Birth : %s,%s
                Agama : %s
                Gol.Darah : %s
                ID Card : %s
                Entry Date : %s
                """,this.getNamaDpn(),this.getNamaBlkng(),
                this.getKelamin(),this.getKotaLahir(),this.getTglLahir(),
                this.getAgama(),this.getGolDarah(),this.getNoKtp(),this.getTglMasuk()));

        System.out.println("Enrollment Information");
        for (Enrollment en: this.getEnrollment()
             ) {
            System.out.println(String.format("%s (%s-%s) +%d",en.getMk().getNamaMatkul(),en.getTglDftr(),en.getTglLulus() == null ? "N/A" : en.getTglLulus(),en.getMk().getPoin()));

        }
    }
}
