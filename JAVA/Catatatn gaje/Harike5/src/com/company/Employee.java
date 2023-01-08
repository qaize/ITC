package com.company;

import Eksternal.Department;
import ListEnum.Agama;
import ListEnum.JenisKelamin;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Persons {
    private String IdKaryawan;
    private Department department;
    private LocalDate tglmasuk;
    private BigDecimal gaji;

    public Employee(){ super();}

    public Employee(String namadpn, String nmblkg, String tmptlhir,
                    LocalDate tgllahir, JenisKelamin gender, String notelp, String alamt,
                    String IdKaryawan, Department department, LocalDate tglmasuk, Agama agama){
        super(namadpn,nmblkg,tmptlhir,tgllahir,gender,notelp,alamt, agama);
        //super(namadpn, nmblkg,tmptlhir,tgllahir, gender, notelp, alamt);//diambil dari Employee
        this.IdKaryawan=IdKaryawan;
        this.department=department;
        this.tglmasuk=tglmasuk;
    }

    public void setGaji(BigDecimal gaji){
        this.gaji=gaji;
    }

    public BigDecimal getGaji(){
        return this.gaji;
    }

    public void setIdKaryawan(String idkar){
        this.IdKaryawan=idkar;
    }

    public String getIdKaryawan(){
        return this.IdKaryawan;
    }

    public void Printinformasikaryawan(){
        System.out.println("IdKaryawan : "+ this.IdKaryawan);
        System.out.println("Departemen : "+department.getNama());
        System.out.println("Tanggal masuk : "+tglmasuk);
        System.out.println("Gaji : "+gaji);
    }
}
