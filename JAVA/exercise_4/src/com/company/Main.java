package com.company;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

//ini sudah fix

public class Main {
    public static String[][] bioskop = new String[5][7];
    public static LinkedList<String> history = new LinkedList();

    public static void main(String[] args) {
	// write your code here
        Scanner men1 = new Scanner(System.in);
        Scanner men1s = new Scanner(System.in);
        int pilihan = 0;

        Scanner inp = new Scanner(System.in);

        //make all vacant first
        for (int i = 0; i < bioskop.length; i++) {
            for (int j = 0; j < bioskop[i].length; j++) {
                bioskop[i][j] = "Vacant";

            }

        }


        do {

    String menu = """
            Menu
            1. Book kursi
            2. Lihat semua status kursi
            3. Lihat history log booked
            4. Exit           
            """;
        System.out.println(menu);
    try {
        System.out.print("Pilihan anda : ");
        pilihan = inp.nextInt();
        if (pilihan > 5){
            System.out.println("Maaf, Hanya bisa menginputkan 1 - 4");

            try {
                System.out.println(menu);
                System.out.print("Pilihan anda : ");
                pilihan = inp.nextInt();

            } catch (Exception exception) {
                System.out.println("Maaf, Hanya bisa menginputkan 1 - 4");
                break;
            }

        }

    }
    catch (Exception exception){
        System.out.println("Maaf, Hanya bisa menginputkan 1 - 4");
        break;

    }

    switch (pilihan){
        case 1 : {
            int row = 0;
            try {
                System.out.print("Pilih baris  : ");
                row = men1.nextInt();
                if (row > 5 || row<=0 ) {
                    System.out.println("Maaf Mohon Inputkan Nilai 1-5");
                    try {
                        System.out.print("Pilih baris  : ");
                        row = men1.nextInt();
                    } catch (Exception exception) {
                        System.out.println("Masukan nilai yang 1-5");
                        break;
                    }

                }

            } catch (Exception exception) {

                System.out.println("Masukan nilai yang 1-5");
                break;

            }
            System.out.print("Pilih Kolom : ");
            int col = men1.nextInt();
            if (col > 8 || col <=0) {
                System.out.println("Maaf Mohon Inputkan Nilai 1-7");
                System.out.print("Pilih kolom  : ");
                col = men1.nextInt();
            }
            LocalDate waktu = LocalDate.now();
                if(bioskop[row-1][col-1] == "Vacant" || bioskop[row-1][col-1] == null){
                    System.out.print("Nama : ");
                    String name = men1s.nextLine();

                    bioskop[row-1][col-1] = name;
                    System.out.println("Berhasil Boking");
                    history.add("Pada Tanggal "+waktu+ " Row "+(row)+" Kursi "+(col)+" Berhasil dibook oleh "+bioskop[row-1][col-1]);
                    break;}
                else{
                    System.out.println("Maaf kursi sudah di booked");
                    history.add("Pada Tanggal "+waktu+ " Row "+(row)+" Kursi "+(col)+" Gagal dibook oleh seseorang ");
                    break;}

        }

        case 2 :{


            for (int i = 0; i < bioskop.length; i++) {
                for (int j = 0; j < bioskop[i].length; j++) {
                    if(bioskop[i][j] != "Vacant"){
                        System.out.print("Row "+(i+1)+" Kursi "+(j+1) + " : Booked");
                    }
                    if (bioskop[i][j] == "Vacant"){
                        System.out.print("Row "+(i+1)+" Kursi "+(j+1) + " : Vacant");

                    }
                    System.out.println();
                }

                System.out.println();
            }
            break;

        }

        case 3 : {

            for (String nama : history){

                System.out.println(nama);
            }
            break;


        }

        case 4 : {
            System.exit(0);
            break;
        }
        default:{
            System.out.println("Maaf Hanya Bisa menginput angka 1-4");
        }}

        }while(pilihan!=4);

    }





}

