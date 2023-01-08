package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class University {

    private static String nama;
    private static LocalDate tglberdiri;
    private static String kota;
    private static String Negara;

    private static HashMap<String,Dosen> listDosen;
    private static HashMap<String,Mahasiswa> listMahasiswa;
    private static HashMap<String,Matakuliah> listMatakuliah;



    public static void setUniversity(String nama, LocalDate tglberdiri, String kota,String negara){

        University.nama = nama;
        University.tglberdiri = tglberdiri;
        University.kota = kota;
        University.Negara = negara;

    }


    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        University.nama = nama;
    }

    public static LocalDate getTglberdiri() {
        return tglberdiri;
    }

    public static void setTglberdiri(LocalDate tglberdiri) {
        University.tglberdiri = tglberdiri;
    }

    public static String getKota() {
        return kota;
    }

    public static void setKota(String kota) {
        University.kota = kota;
    }

    public static String getNegara() {
        return Negara;
    }

    public static void setNegara(String negara) {
        Negara = negara;
    }

    public static HashMap<String, Matakuliah> getListMatakuliah() {

        return listMatakuliah;
    }

    public static void setListMatakuliah() {
        Matakuliah oop = new Matakuliah("Object Oriented Programming","Programming",20);
        Matakuliah DatStr = new Matakuliah("Data Structure","Programming",30);
        Matakuliah NetFun = new Matakuliah("Networking Fundamental","Networking",20);
        Matakuliah DatFun = new Matakuliah("Database Fundamental","Programming",30);
        Matakuliah PMP = new Matakuliah("Project Management Professional","Management and Analysis",40);
        Matakuliah UML = new Matakuliah("Unified Modeling Language","Management and Analysis",20);
        Matakuliah JAF = new Matakuliah("Java fundamental","Programming",30);
        Matakuliah INFD = new Matakuliah("Infrastructure Design","Networking",30);
        Matakuliah NS = new Matakuliah("Network and Security","Networking",20);

        listMatakuliah.put("oop",oop);
        listMatakuliah.put("DatStr",DatStr);
        listMatakuliah.put("NetFun",NetFun);
        listMatakuliah.put("DatFun",DatFun);
        listMatakuliah.put("PMP",PMP);
        listMatakuliah.put("UML",UML);
        listMatakuliah.put("JAF",JAF);
        listMatakuliah.put("INFD",INFD);
        listMatakuliah.put("NS",NS);

    }

    public static void setListDosen(){
        List<Matakuliah> listAntik = new LinkedList<>(Arrays.asList(listMatakuliah.get("oop"),listMatakuliah.get("DatStr")));

        Dosen antik =  new Dosen("T701",new BigDecimal(7500000),
                LocalDate.of(2016,3,8),"Antik","Haya",
                LocalDate.of(1988,11,12),"Jakarta","Perempuan",
                "312008912111988002","Islam","A",listAntik);

        List<Matakuliah> listCahya = new LinkedList<>(Arrays.asList(listMatakuliah.get("DatStr"),listMatakuliah.get("UML")));
        Dosen cahya =  new Dosen("T808",new BigDecimal(9500000),
                LocalDate.of(2016,4,4),"Cahya","Subroto",
                LocalDate.of(1989,1,7),"Surabaya","Laki-Laki",
                "312008907011989002","Islam","B",listCahya);

        List<Matakuliah> listMikha = new LinkedList<>(Arrays.asList(listMatakuliah.get("UML")));
        Dosen Mikha =  new Dosen("T904",new BigDecimal(6000000),
                LocalDate.of(2022, Month.JULY,8),"Mikha","Riana",
                LocalDate.of(1989,Month.JULY,4),"Jakarta","Permpuan",
                "317572993601980002","Kristen","A",listMikha);



    }

    public static  void setListMahasiswa(){
        LocalDate nullDate = null;

        List<Enrollment> enrolAlex = new LinkedList<>(Arrays.asList(
                new Enrollment(listMatakuliah.get("oop"),LocalDate.of(2018,4,12),LocalDate.of(2018,9,12)),
                new Enrollment(listMatakuliah.get("DatStr"),LocalDate.of(2018,8,18),LocalDate.of(2018,9,12))
        ));

        List<Enrollment> enroldesy = new LinkedList<>(Arrays.asList(
                new Enrollment(listMatakuliah.get("NF"),LocalDate.of(2018,4,12),nullDate),
                new Enrollment(listMatakuliah.get("DatStr"),LocalDate.of(2018,8,18),nullDate)
        ));

        List<Enrollment> enroljoko = new LinkedList<>(Arrays.asList(
                new Enrollment(listMatakuliah.get("UML"),LocalDate.of(2021,6,3),LocalDate.of(2021,11,1))

        ));


        Mahasiswa alex = new Mahasiswa("A021",
                LocalDate.of(2018, Month.APRIL,12),
                "Alex","Wirianata","Jakarta",LocalDate.of(1990,Month.NOVEMBER,23),"Laki-Laki","312008923111990002",
                "Kristen","A",enrolAlex);


        Mahasiswa Desy = new Mahasiswa("A022",
                LocalDate.of(2020, Month.APRIL,1),
                "Desy","Oktaviani","Bandung",LocalDate.of(1995,Month.MAY,11),"Perempuan","312008911051995002",
                "Islam","O",enroldesy);


        Mahasiswa Joko = new Mahasiswa("A023",
                LocalDate.of(2021, Month.MAY,14),
                "Joko","Davidson","Jakarta",LocalDate.of(1990,Month.JUNE,7),
                "Laki-Laki","3120089277889990002", "Islam","A",enroljoko);



    }
}
