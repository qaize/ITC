package com.company;

import Eksternal.Department;
import ListEnum.Agama;
import ListEnum.JenisKelamin;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Manager extends Employee{
    private BigDecimal insentifjabatan;

    public Manager(){
        super();
    }

    public Manager(BigDecimal insentif, String namadpn, String nmblkg, String tmptlhir,
                   LocalDate tgllahir, JenisKelamin gender, String notelp, String alamt,
                   String IdKaryawan, Department department, LocalDate tglmasuk, Agama agama){
        super(namadpn,nmblkg,tmptlhir,tgllahir,gender,notelp,alamt,IdKaryawan,department,tglmasuk, agama);
        this.insentifjabatan=insentif;
    }

    private BigDecimal TipThp(){
        BigDecimal result=getGaji().add(this.insentifjabatan);
        return result;
    }

    @Override
    public void Printinformasikaryawan(){
        System.out.println("Id Karyawan : "+getIdKaryawan()+"\nNama Depan"+getNamadepan());
        System.out.println("Gaji Pokok : "+getGaji());
        System.out.println("Gaji Total : "+TipThp());
    }
}
