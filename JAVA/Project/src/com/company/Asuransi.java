package com.company;

import com.company.Enum.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Asuransi {
    private static String namaPerusahaan;

    private static HashMap<Integer,Prospect> listProspect = new HashMap<>();
    private static HashMap<String,Nasabah> listNasabah = new HashMap<>();
//    private static List<Produk> listProduk = new LinkedList<>();
//    private static HashMap<String,Polis> listPolis = new HashMap<>();

    public static void showProspectAll(){

        if(listProspect != null) {
            for (Map.Entry prs : listProspect.entrySet()
            ) {
                Prospect prospect = (Prospect) prs.getValue();
                System.out.println(String.format(
                        " No : %d, %s %s, %s, %s(%s), %s, %s ",
                        prospect.getNoProspect(), prospect.getNamaDpn(), prospect.getNamaBlkng(),
                        prospect.getJenisKelamin(), Helper.FormatTanggal(prospect.getTglLahir(), "dd MMMM yyyy"), prospect.getTempatLahir(),
                        prospect.getPerkerjaan(), prospect.getStatus()
                ));

            }
        }
        else{
            System.out.println("Data belum ada");
        }

        String paragraf = """
                Pilih lah salah satu menu di bawah ini:
                1.	Add Prospect
                2.	Prospect To Customer
                3.	Main Menu
                4.	Exit Application
                                
                """;

        boolean check = false;
        Scanner inp = new Scanner(System.in);
        String pilih = "";
        do{
            try{
                System.out.println(paragraf);
                System.out.print("Pilih : ");
                pilih = inp.next();
                switch (Integer.parseInt(pilih)){
                    case 1 :{
                        System.out.println("Masukan data anda :");
                        Asuransi.setProspect();
                        check = false;
                        break;

                    }
                    case 2 : {
                        break;
                    }
                    case 3 : {
                        menuUtama();
                        break;
                    }
                    default:{
                        System.out.println("Input yang bener");
                        break;
                    }
                }
            }
            catch (Exception ex){
                System.out.println("Input angka");
                check = false;
            }
        }
        while(!check);
    }
    public static void setProspect(){
        Integer noProspect = Helper.generateNewNoProspect();
        Scanner addData = new Scanner(System.in);
        System.out.print(" Nama Depan : ");String namaDpn = addData.nextLine();
        System.out.print(" Nama Belakang : ");String namaBlkng = addData.nextLine();
        System.out.print(" Tanggal Lahir (dd/MM/yyyy) : ");String tglLahir = addData.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(tglLahir,formatter);
        System.out.print(" Tempat Lahir : ");String tmptLahir = addData.nextLine();
        System.out.print(" Jenis Kelamin (P/L) : ");String Kelamin = addData.nextLine();
        System.out.print(" Perkerjaan : ");String perkerjaan = addData.nextLine();

        Prospect obj = new Prospect(noProspect,namaDpn,namaBlkng,data,tmptLahir,Helper.getEnum(Kelamin),perkerjaan, Status.PROSPECT);

        listProspect.put(noProspect,obj);
    }

    public static HashMap<Integer,Prospect> getListPorspect(){
        return Asuransi.listProspect;
    }

    public static void menuUtama(){
        boolean check = false;
        Scanner inp = new Scanner(System.in);
        String pilih = "";
        do{
            try{
                String paragraf = """
                        Pilih lah salah satu menu di bawah ini:
                        1.	Menu Prospect
                        2.	Menu Customer
                        3.	Exit Application
                                                
                        """;
                System.out.print("Pilih : ");
                pilih = inp.next();
                switch (Integer.parseInt(pilih)){
                    case 1 :{
                        Asuransi.showProspectAll();
                        break;

                    }
                    case 2 : {
                        break;
                    }
                    case 3 : {
                        break;
                    }
                    default:{
                        System.out.println("Input yang bener");
                        break;
                    }
                }


            }
            catch (Exception ex){
                System.out.println("Input angka");
                check = false;
            }


        }
        while(!check);
    }




}
