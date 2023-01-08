package com.company;

import Eksternal.Department;
import ListEnum.Agama;
import ListEnum.JenisKelamin;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here

    /*    String nama="Aline";
        int angka=10;

        System.out.println("Nama sebelum diubah : "+nama);
        System.out.println("Angka sebelum diubah : "+angka);

        ReplaceValue(nama, angka);
        System.out.println("Nama setelah diubah : "+nama);
        System.out.println("Angka setelah diubah : "+angka);

     */
        Department andidept=new Department();
        andidept.setNama("Kebersihan");
        andidept.setDescription("Tukang ledeng");
        Employee Andi=new Employee("Andi","Jaya","Jakarta",LocalDate.of(1999,12,30),
                JenisKelamin.LAKI_LAKI,"08999928282","Jl.Paguyuban","K002",andidept,LocalDate.of(2018,12,9),Agama.Islam);

        Department ujangdept=new Department();
        ujangdept.setNama("IT");
        ujangdept.setDescription("Tukang Kabel");
        Employee Ujang=new Employee("Ujang","Kasmaran","Bandung",LocalDate.of(2001,02,9),
                JenisKelamin.LAKI_LAKI,"090820202","Jl.Yuk","K001",ujangdept,LocalDate.of(2011,11,12),Agama.Islam);

        Ujang.setGaji(new BigDecimal(100000));
        Andi.setGaji(new BigDecimal(900000));

        Department laladept=new Department();
        laladept.setNama("Manajer");
        laladept.setDescription("Manajer asik");
        Manager lala=new Manager(new BigDecimal(20000),"Lala","Marion","Mekkah",LocalDate.of(2000,12,1),
                JenisKelamin.PEREMPUAN, "089888812","Jl.jl","K005",laladept,LocalDate.of(2017,03,3), Agama.Kristen);

        lala.setGaji(new BigDecimal(10000000));

        LinkedList<Employee> daftarkaryawan=new LinkedList<>();
        daftarkaryawan.add(Ujang);
        daftarkaryawan.add(Andi);
        daftarkaryawan.add(lala);

        for (Employee list:daftarkaryawan){
            list.PrintInformation();
            System.out.println("");
        }

    }
/*
    public static void ReplaceValue(String kata, int angka){
       kata="halo";
       angka=100;

        System.out.println(kata);
        System.out.println(angka);
    }

 */
}
