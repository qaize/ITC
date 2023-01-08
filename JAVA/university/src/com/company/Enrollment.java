package com.company;

import java.time.LocalDate;

public class Enrollment {

    private Matakuliah mk;
    private LocalDate tglDftr;
    private LocalDate tglLulus;

    public Enrollment(){}
    public Enrollment(Matakuliah mk,LocalDate tglDftr,LocalDate tglLulus){
        this.mk = mk;
        this.tglDftr = tglDftr;
        this.tglLulus = tglLulus;
    }

    public Matakuliah getMk() {
        return mk;
    }

    public void setMk(Matakuliah mk) {
        this.mk = mk;
    }

    public LocalDate getTglDftr() {
        return tglDftr;
    }

    public void setTglDftr(LocalDate tglDftr) {
        this.tglDftr = tglDftr;
    }

    public LocalDate getTglLulus() {
        return tglLulus;
    }

    public void setTglLulus(LocalDate tglLulus) {
        this.tglLulus = tglLulus;
    }
}
