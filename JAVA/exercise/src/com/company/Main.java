package com.company;

import java.math.BigDecimal;

import java.text.NumberFormat;
import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here


//        Soal No 1 “System akan menghitung ((X +Y + Z) x (Z / 2)) - Z”

        {
            int x;
            int y;
            double z;
            Scanner inp1 = new Scanner(System.in);
            System.out.print(" Masukan Nilai X : ");
            x = inp1.nextInt();
            System.out.print(" Masukan Nilai Y : ");
            y= inp1.nextInt();
            System.out.print(" Masukan Nilai Z : ");
            z = inp1.nextDouble();

            double hasil = ((x+y+z) * (z/2)) - z;
            System.out.println("Hasil Perhitungan ((X +Y + Z) x (Z / 2)) - Z = "+hasil);

            System.out.print(" Masukan Nilai X : ");
            x = inp1.nextInt();
            System.out.print(" Masukan Nilai Y : ");
            y= inp1.nextInt();
            System.out.print(" Masukan Nilai Z : ");
            z = inp1.nextDouble();


            Integer inX = x;
            Integer inY = y;
            Double inZ = z;

            //Bilangan baru
            double NewParseX = inX.doubleValue();
            System.out.println("Bilangan baru X = "+NewParseX);
            double NewParseY = inY.doubleValue();
            System.out.println("Bilangan baru Y = "+NewParseY);
            double NewParseZ = inZ.doubleValue();
            System.out.println("Bilangan baru Z = "+NewParseZ);

           double hasilParse = ((NewParseX+NewParseY+NewParseZ) * (NewParseZ/2)) - NewParseZ;
            System.out.println("Hasil Perhitungan ((X +Y + Z) x (Z / 2)) - Z = "+hasilParse);
        }



//      Soal 2 Buatlah sebuah aplikasi yang mengeluarkan sebuah text pada console

        {
            int tanggal;
            int bulan;
            int tahun;
            String Nama ;

            Scanner inp2 = new Scanner(System.in);
            System.out.print(" Masukan Tanggal Lahir : ");
            tanggal = inp2.nextInt();
            System.out.print(" Masukan Bulan Lahir  : ");
            bulan= inp2.nextInt();
            System.out.print(" Masukan Tahun Lahir  : ");
            tahun = inp2.nextInt();

            Scanner inSt = new Scanner(System.in);
            System.out.print(" Masukan Nama Anda  : ");
            Nama = inSt.nextLine();

            LocalDate BirthDay = LocalDate.of(tahun,bulan,tanggal);
            LocalDate Today = LocalDate.now();
            long YearsDiff = ChronoUnit.YEARS.between(BirthDay,Today);

            System.out.println(Nama);
            System.out.println("Umur anda adalah "+ YearsDiff);

        }


//      Soal 3 Buatlah sebuah aplikasi yang mengeluarkan sebuah text pada console:

            {


                Locale indo = new Locale("id", "ID");
                Scanner inp3 = new Scanner(System.in);
                System.out.print("Masukan nilai Harga Barang : ");
                int harga = inp3.nextInt();
                System.out.print("Masukan Persentase Diskon : ");
                int diskon = inp3.nextInt();


                BigDecimal HargaBarang = new BigDecimal(harga);
                String formatHargaBarang = NumberFormat.getCurrencyInstance(indo).format(HargaBarang);
                System.out.println("Harga Barang = " + formatHargaBarang);
                System.out.println("Diskon = " + diskon + " %");


                BigDecimal Diskonya = new BigDecimal(diskon);
                double hDiskon = harga * diskon / 100;
                BigDecimal PersentaseDiskonya = Diskonya.divide(new BigDecimal(100));
                BigDecimal PerkalianDiskonharga = PersentaseDiskonya.multiply(HargaBarang);

                String formatDiskon = NumberFormat.getCurrencyInstance(indo).format(PerkalianDiskonharga);
                System.out.println("Total harga Diskon = " + formatDiskon);

                BigDecimal Totalharga = HargaBarang.subtract(PerkalianDiskonharga);
                System.out.println("Harga Setelah Diskon = " + NumberFormat.getCurrencyInstance(indo).format(Totalharga));


            }


        }
    }

