package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Dosen extends Person {
    private String NIKDosen;
    private BigDecimal gaji;
    private LocalDate tglKerja;
    private List<Matakuliah> matkulDiampu = new LinkedList<>();

    public Dosen(){}
    public Dosen(String NIKDosen,BigDecimal gaji,LocalDate tglKerja,String namaDpn,String namaBlkng,LocalDate tglLahir,String kotaLahir, String kelamin,
                 String noKtp,String Agama,String golDarah,List<Matakuliah> matkul){

        super(namaDpn,namaBlkng,tglLahir,kotaLahir,kelamin,noKtp,Agama,golDarah);
        this.NIKDosen = NIKDosen;
        this.gaji = gaji;
        this.tglKerja = tglKerja;
        this.matkulDiampu = matkul;

    }

    public String getNIKDosen() {
        return NIKDosen;
    }

    public void setNIKDosen(String NIKDosen) {
        this.NIKDosen = NIKDosen;
    }

    public BigDecimal getGaji() {
        return gaji;
    }

    public void setGaji(BigDecimal gaji) {
        this.gaji = gaji;
    }

    public LocalDate getTglKerja() {
        return tglKerja;
    }

    public void setTglKerja(LocalDate tglKerja) {
        this.tglKerja = tglKerja;
    }

    public List<Matakuliah> getMatkulDiampu() {
        return this.matkulDiampu;
    }

    public void setMatkulDiampu(List<Matakuliah> matkulDiampu) {
        this.matkulDiampu = matkulDiampu;
    }


}
