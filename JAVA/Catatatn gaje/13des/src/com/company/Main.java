package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here


//        Pengkodisiian  IF ELSE,IF ELSE IF ELSE, IF
    /*
        boolean cek = true;

        if (cek) {

            System.out.println("Ini pengkondisiian");

        }

        else {

            System.out.println("Statement Else");
        }

        Scanner angkaInput = new Scanner(System.in);
        int set = 2;

       // cek = angkaInput % 2 == 0 ? true : false;

        if (set % 2 == 0 )
        {

            System.out.println("Genap");

        }

        else {

            System.out.println("ganjil");

        }
        int angka = 1;

        switch(angka) {
            case 1: {
                System.out.println("case 1");
                break;
            }
            case 2:
                System.out.println("case 2");
                break;
            default:
                System.out.println("else");
                break;

        }


        BigDecimal hargabarang = new BigDecimal(100);
        BigDecimal DiskonBarang = new BigDecimal(2000);

        if (hargabarang.compareTo(DiskonBarang) == 0){
            System.out.println("sama besar");

        }

        if (hargabarang.compareTo(DiskonBarang) == 1){
            System.out.println("Harga Diskon Lebih mahal");

        }

        if (hargabarang.compareTo(DiskonBarang) == -1){

            System.out.println("Harga barang lebih mahal");

           // kebalik nih

            */

//        Looping

        int angkaL = 10;
        System.out.println(angkaL);
        angkaL++;
        System.out.println(angkaL);
        System.out.println(++angkaL);
        //kalo langsung di print dia gak melakukan operasi, jadi untuk increment
        //harus deklarasiin dulu operasinya misal : ++Angka, kalo angka++ ga kebaca kehitunganya di operasi selanjutnya
        angkaL+=3; // mirip kyk angkaL = angkaL + 3, hal ini sesuai sama operator apa yang digunakan * / -
        System.out.println(angkaL);

        System.out.println("For");
        for (int i = 0 ; i<10; i++)
        {
            System.out.println(i);

        }
        System.out.println("While");
        int cobs = 10;

        while (cobs>0){

            System.out.println(cobs);
            cobs --;

        }

//        do while,dimana dia akan jalanin dulu baru nge cek kondisnya
        //kalo dia do while dia kalo gak menyesuaikan kondisinya ya dia cmn jalan sekali doang
        int check = 0;
        System.out.println("Do while");
        do {

            System.out.println(check);
            check++;
        }
        while (check < 10);

//        Nested For
//kalo compiltaion error
//        Logic Error
//        Runtime Error
        for (int i = 0; i <10;i++)
        {
            System.out.print("Index i "+i);
            for (int j = 0; j <10;j++) {
                System.out.println("index j " + j);
            }

        }

//        pelajarin lagi break/continue

        //long angkaPertama = 200000l;
       // long angkaPertama = 200000l;


        try {

            int number = Integer.parseInt("12A");
        }
        catch (Exception exception)
        {
            System.out.println("Error parsing"+exception.getMessage());

        }

        try {

            int number = Integer.parseInt("12A");
        }
        catch (Exception exception)
        {
            System.out.println("Error parsing"+exception.getMessage());

        }

        finally {
            System.out.println("Keep going");
        }
        }
    }

