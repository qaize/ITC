package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
     /*
        int sw = 0;
        int z = 0;
        int x = 0;
        double y = 0;
        Scanner inp = new Scanner(System.in);
        boolean cektrue = false;
        try {


            System.out.print("Use Should Input 1,2,3 Value : ");
            sw = inp.nextInt();
            cektrue = true;

        } catch (Exception exception) {

            System.out.println("Try Again, Just Input Number only 1,2 or 3" + exception.getMessage());

        }


        try {
            System.out.print("Input x :  ");
            z = inp.nextInt();
            System.out.print("Input y : ");
            x = inp.nextInt();

            System.out.print("Input z : ");
            y = inp.nextDouble();
        } catch (Exception exception) {

            System.out.println("Insert The value with Number is not should " + exception.getMessage());

        }
        switch (sw) {
            case 1: {
                double valR1 = (z * y) + (z * y);
                System.out.println("Hasil dari (z * y) + (z *y) = " + valR1);
                break;
            }
            case 2: {
                double valR2 = (x - y + z) / x;
                System.out.println("Hasil dari (x - y + z) / x = " + valR2);
                break;

            }
            case 3: {
                double valR3 = (x - z) * y;
                System.out.println("Hasil dari (x-z)*y = " + valR3);
                break;
            }
            default: {

                System.out.println("Maaf Formula yang anda pilih tidak tersedia, coba lagi");
            }


        }
    */
//        soal 2
        int tahun = 0;
        int bulan = 0;
        int sw = 0;
        Locale indo = new Locale("id","ID");
        Scanner inp2 = new Scanner(System.in);
        try {

            System.out.print("Masukan Bulan : ");
            bulan = inp2.nextInt();
            if (bulan < 0 && bulan > 13)
            {
                System.out.println("input harus 1-12 ");
                try {
                    System.out.println("Bulan yang anda Input harus 1-12");
                    System.out.print("Masukan     ");
                    bulan = inp2.nextInt();
                }

                    catch (Exception exception) {
                    System.out.println("Bulan yang anda Input Salah");   }
                }

             }
            catch (Exception exception){

                    System.out.println("Bulan yang anda Input Salah");
            }
        try {

            System.out.print("Masukan Tahun : ");
            tahun = inp2.nextInt();

            }


        catch (Exception exception){

            System.out.println("Tahun yang anda Input Salah");
        }

        try {
            System.out.println("Pilih nomor 1,2,3 ");
            sw = inp2.nextInt();
            switch (sw){
                case 1 :
                {

                }
                case 2 : {

                }
                case 3 : {

                }

            }
        catch (Exception ){

                System.out.println("Yang anda inpustkan kurang tepat");
            }



        }
        LocalDate tahunbaru = LocalDate.of(tahun, bulan, 1);
        long MonthPeriod = ChronoUnit.MONTHS.between(tahunbaru,LocalDate.now());
        System.out.println(MonthPeriod+ " Bulan");


    }

}
