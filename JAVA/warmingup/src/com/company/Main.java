package com.company;

import listEnum.Level;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Michael, Andrea, Bob
        Alamat almMichael = new Alamat("USA","California","Los Angles","Truman Street B34 Unit 5");
        Pembeli Michael = new Pembeli(23,"Michael","Jackson",
                LocalDate.of(1976,5,19),new BigDecimal(12000000),almMichael);

        Alamat almAndrea = new Alamat("Italy","Lazio","Rome","Saint Marcus Street C45 Unit 1");
        Pembeli Andrea = new Pembeli(25,"Andrea","Boceli",
                LocalDate.of(1973,11,23),new BigDecimal(15300000),almAndrea);
        Alamat almBob = new Alamat("Indonesia","DKI Jakarta","Jakarta","Daan Mogot C 9-10");
        Pembeli Bob = new Pembeli(27,"Bob","Marley",
                LocalDate.of(1968,3,1),new BigDecimal(2450000),almBob);

        Bob.setNamaDpn("Robert");
        Bob.printInfoPembeli();
        System.out.println("Konversi IDR "+Bob.FormatUang(new BigDecimal(100000)));

        List<Pembeli> listPembeli = new LinkedList<>(Arrays.asList(Michael,Andrea,Bob));
        for(Pembeli pb :listPembeli){
            pb.printInfoPembeli();

        }

        Penjual ali = new Penjual("Ali","Bin Walid",LocalDate.of(1976,2,12),"Ali Market",
                Level.GOLD);
        //Barang barangAli = new Barang("Minyak Sumbawa",new BigDecimal(15000),"Penguat");


        List<Barang> listBarangAli = new LinkedList<>();
        listBarangAli.add(new Barang("Minyak Sumbawa",new BigDecimal(15000),"Penguat"));
        listBarangAli.add(new Barang(" Madu",new BigDecimal(150000),"Badan sehat"));

        ali.printInfoPenjual();
        ali.setListJualan(listBarangAli);
        ali.printJumlahBarang();



    }
}
