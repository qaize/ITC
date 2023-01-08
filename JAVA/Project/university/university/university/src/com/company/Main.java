package com.company;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

//    static List<Matakuliah> listMatkul = new LinkedList<>();
//    static  List<Mahasiswa> listMahasiswa = new LinkedList<>();
//    static  List<Dosen> listDosen = new LinkedList<>();
//    static LocalDate nullDate = null;
    public static void main(String[] args) {
	// write your code here
        University.Insialisasi();
        menu();


    }


    public static Mahasiswa getMahasiswa(List<Mahasiswa> listMahasiswa, String nik){
        Mahasiswa mhs = new Mahasiswa();
        for (Mahasiswa mahas : listMahasiswa
        ) {
            if(mahas.getNIKmhs().equals(nik)){
                return mahas;

            }

        }
        return mhs;
    }
    public static Matakuliah getMatakuliah (List<Matakuliah> listMatkul, String obj ){
        Matakuliah mk = new Matakuliah();
        for (Matakuliah mkul : listMatkul
             ) {
            if(mkul.getNamaMatkul().equals(obj)){
                return mkul;

            }

        }
        return mk;


    }


    public static void printMhsInfo(Mahasiswa obj){
        Locale indo = new Locale("id","ID");
        DateTimeFormatter indoFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy",indo);
        System.out.println("First Name : "+obj.getNamaDpn());
        System.out.println("Last Name : "+obj.getNamaBlkng());
        System.out.println("Gender : "+obj.getKelamin());
        System.out.println("Birth Information : "+obj.getKotaLahir()+", "+indoFormat.format(obj.getTglLahir()));
        System.out.println("Religion : "+obj.getAgama());
        System.out.println("Gol.Darah : "+ obj.getGolDarah());
        System.out.println("ID Card   : "+obj.getNoKtp());
        System.out.println("Entry Date : "+indoFormat.format(obj.getTglMasuk()));

        System.out.println("Enrollment Information");
        for(Enrollment en : obj.getEnrollment()){
            System.out.println(en.getMk().getNamaMatkul());
        }


    }
    public static void printMhsAll(Mahasiswa obj){
        System.out.println(String.format("NIK : %s, Name: %s %s",obj.getNIKmhs(),obj.getNamaDpn(),obj.getNamaBlkng()));
    }

    public static void printinfoDosen(Dosen obj){
        Locale indo = new Locale("id","ID");
        DateTimeFormatter indoFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy",indo);
        System.out.println("First Name : "+obj.getNamaDpn());
        System.out.println("Last Name : "+obj.getNamaBlkng());
        System.out.println("Gender : "+obj.getKelamin());
        System.out.println("Birth Information : "+obj.getKotaLahir()+", "+indoFormat.format(obj.getTglLahir()));
        System.out.println("Religion : "+obj.getAgama());

        System.out.println("Competency Information");
        for(Matakuliah mk : obj.getMatkulDiampu()){
            System.out.println(mk.getNamaMatkul());
        }


    }

    public static String IntToStr(int input){

        String data = "";
        data = Integer.toString(input);

        return data;
    }

    public static void menu(){
        Scanner inp = new Scanner(System.in);
        int pilih;
        boolean check = false;

       do {
           String menu = """
                   Pilih nomor menu untuk masuk ke menunya:
                   1.	All Student Data
                   2.	All Tutor Data
                   3.	About this University
                   4.	Exit Application
                                   
                   """;
           try {
               System.out.println(menu);
               System.out.print("Pilih : ");
               pilih = inp.nextInt();

               switch (IntToStr(pilih)){
                   case "1":{
                       University.showMahasiswa();
                       check = false;
                       break;

                   }
                   case "2":{break;}
                   case "3":{
                       break;
                   }
                   case "4":{

                            }
                   default:{
                       System.out.println("Salah Input");
                       break;
                   }
               }
           }catch (Exception ex){
               System.out.println("Masukan Angka !");
           }

       }
       while(!check);






    }

//    public static void DataMahasiswa(){
//
//        Mahasiswa alex = new Mahasiswa("A021",
//                LocalDate.of(2018, Month.APRIL,12),
//                "Alex","Wirianata","Jakarta",LocalDate.of(1990,Month.NOVEMBER,23),"Laki-Laki","312008923111990002",
//                "Kristen","A");
//
//        Enrollment alex1 = new Enrollment(
//                getMatakuliah(listMatkul,"Object Oriented Programming"),LocalDate.of(2018,4,12),LocalDate.of(2018,9,12));
//        Enrollment alex2 = new Enrollment(
//                getMatakuliah(listMatkul,"Data Structure"),LocalDate.of(2018,8,18),LocalDate.of(2018,9,12));
//
//        List<Enrollment> enrolAlex = new LinkedList<>();
//        enrolAlex.add(alex1);
//        enrolAlex.add(alex2);
//        alex.setEnrollment(enrolAlex);
//        listMahasiswa.add(alex);
//
//        Mahasiswa Desy = new Mahasiswa("A022",
//                LocalDate.of(2020, Month.APRIL,1),
//                "Desy","Oktaviani","Bandung",LocalDate.of(1995,Month.MAY,11),"Perempuan","312008911051995002",
//                "Islam","O");
//        Enrollment desy1 = new Enrollment(
//                getMatakuliah(listMatkul,"Networking Fundamental"),LocalDate.of(2021,4,12),nullDate);
//        Enrollment desy2 = new Enrollment(
//                getMatakuliah(listMatkul,"Data Structure"),LocalDate.of(2018,8,18),nullDate);
//
//        List<Enrollment> enroldesy = new LinkedList<>();
//        enroldesy.add(desy1);
//        enroldesy.add(desy2);
//        Desy.setEnrollment(enroldesy);
//        listMahasiswa.add(Desy);
//
//        Mahasiswa Joko = new Mahasiswa("A023",
//                LocalDate.of(2021, Month.MAY,14),
//                "Joko","Davidson","Jakarta",LocalDate.of(1990,Month.JUNE,7),"Laki-Laki","3120089277889990002", "Islam","A");
//
//        Enrollment joko1 = new Enrollment(
//                getMatakuliah(listMatkul,"Unified Modeling Language"),LocalDate.of(2021,6,3),LocalDate.of(2021,11,1));
//
//        List<Enrollment> enroljoko = new LinkedList<>();
//        enroljoko.add(joko1);
//        Joko.setEnrollment(enroljoko);
//        listMahasiswa.add(Joko);
//
//
//    }
//    public static void DataMatkul(){
//        Matakuliah oop = new Matakuliah("Object Oriented Programming","Programming",20);
//        Matakuliah DatStr = new Matakuliah("Data Structure","Programming",30);
//        Matakuliah NetFun = new Matakuliah("Networking Fundamental","Networking",20);
//        Matakuliah DatFun = new Matakuliah("Database Fundamental","Programming",30);
//        Matakuliah PMP = new Matakuliah("Project Management Professional","Management and Analysis",40);
//        Matakuliah UML = new Matakuliah("Unified Modeling Language","Management and Analysis",20);
//        Matakuliah JAF = new Matakuliah("Java fundamental","Programming",30);
//        Matakuliah INFD = new Matakuliah("Infrastructure Design","Networking",30);
//        Matakuliah NS = new Matakuliah("Network and Security","Networking",20);
//
//        listMatkul.add(oop);
//        listMatkul.add(DatStr);
//        listMatkul.add(NetFun);
//        listMatkul.add(DatFun);
//        listMatkul.add(PMP);
//        listMatkul.add(UML);
//        listMatkul.add(JAF);
//        listMatkul.add(INFD);
//        listMatkul.add(NS);
//
//
//    }
//    public static void DataDosen(){
//        Dosen antik =  new Dosen("T701",new BigDecimal(7500000),
//                LocalDate.of(2016,3,8),"Antik","Haya",
//                LocalDate.of(1988,11,12),"Jakarta","Perempuan",
//                "312008912111988002","Islam","A");
////        List<Matakuliah> listAntik = new LinkedList<>();
////        listAntik.add(getMatakuliah(listMatkul,"Unified Modeling Language"));
////        listAntik.add(getMatakuliah(listMatkul,"Network and Security"));
////        antik.setMatkulDiampu(listAntik);
//
//        Dosen cahya =  new Dosen("T808",new BigDecimal(9500000),
//                LocalDate.of(2016,4,4),"Cahya","Subroto",
//                LocalDate.of(1989,1,7),"Surabaya","Laki-Laki",
//                "312008907011989002","Islam","B");
////        List<Matakuliah> listCahya = new LinkedList<>();
////        listCahya.add(getMatakuliah(listMatkul,"Object Oriented Programming"));
////        listCahya.add(getMatakuliah(listMatkul,"Java fundamental"));
////        listCahya.add(getMatakuliah(listMatkul,"Database Fundamental"));
////        cahya.setMatkulDiampu(listCahya);
//
//        Dosen Mikha =  new Dosen("T904",new BigDecimal(6000000),
//                LocalDate.of(2022,Month.JULY,8),"Mikha","Riana",
//                LocalDate.of(1989,Month.JULY,4),"Jakarta","Permpuan",
//                "317572993601980002","Kristen","A");
////
////        List<Matakuliah> listMikha = new LinkedList<>();
////        listMikha.add(getMatakuliah(listMatkul,"Infrastructure Design"));
////        listMikha.add(getMatakuliah(listMatkul,"Data Structure"));
////        Mikha.setMatkulDiampu(listMikha);
//
//        listDosen.add(antik);
//        listDosen.add(cahya);
//        listDosen.add(Mikha);
//
//
//
//
//    }
}
