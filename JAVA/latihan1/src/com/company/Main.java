package com.company;
// List Nasabah, informasi detail nasabahnya, sapldonya berapa..person....bank =>

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
	// write your code here
        /*Bank*/
        Bank BNI = new Bank("001","Bank Negara Indonesia",new BigDecimal(6500),new BigDecimal(10000));
        Bank BRI = new Bank("002","Bank Rakyat Indonesia",new BigDecimal(6500),new BigDecimal(10000));
        Bank BSI = new Bank("003","Bank Syariah Islam",new BigDecimal(0),new BigDecimal(0));



        /*Nasabah*/
        Nasabah iwan = new Nasabah("001","111111",new BigDecimal(1000000),"Ikhwani","Mataram",
                LocalDate.of(1998,12,2),"JL GOTONG ROYONG",BNI);
        Nasabah  deni = new Nasabah("002","222222",new BigDecimal(2000000),"Deni","Sedau",
                LocalDate.of(1999,12,22),"JL SENANG-SENANG",BRI);
        Nasabah aldy = new Nasabah("003","333333",new BigDecimal(3000000),"Aprialdy","Mataram",
                LocalDate.of(1999,6,6),"JL SELAGALAS",BSI);



        /* Aplikasi */
        List<Nasabah> listNasabah = new LinkedList<>(Arrays.asList(iwan,deni,aldy));

        LinkedList<String> History = new LinkedList<>();
        LocalDate Today = LocalDate.now();
        Scanner inp = new Scanner(System.in);
        String inputRekening,inputPassword;
        Nasabah nasabah = new Nasabah();
        Nasabah nasabahT;
        int pilih = 0;

        boolean cekInput = false;
        boolean reset = false;

        do {

            do {
                try {
                    System.out.println("ATM SEDERHANA");
                    System.out.print("Masukan No Rekening :");
                    inputRekening = inp.nextLine();
                    if (cekNoKartu(listNasabah, inputRekening)) {
                        nasabah = getNasabah(listNasabah, inputRekening);
                        cekInput = true;
                    } else {
                        System.out.println("Kartu tidak tersedia");
                        cekInput = false;
                    }
                } catch (Exception exception) {
                    cekInput = false;
                }
            }
            while (!cekInput);

            do {
                try {
                    System.out.print("Masukan Password :");
                    inputPassword = inp.nextLine();
                    if (cekPassword(nasabah, inputPassword)) {
                        cekInput = true;
                    } else {
                        System.out.println("Password Salah");
                        cekInput = false;
                    }
                } catch (Exception exception) {
                    cekInput = false;
                }
            }
            while (!cekInput);

            do {
                try {
                    String menu = """
                            Menu :
                            1.Saldo
                            2.Tarik Tunai
                            3.Setor Tunai
                            4.Transfer
                            5.Ganti pin
                            6.History
                            7.Menu Utama
                            8.Exit
                            """;

                    System.out.println(menu);
                    System.out.print("Pilih 1-7 :");
                    pilih = inp.nextInt();
                    switch (pilih) {
                        case 1: {
                            /* cek Saldo */
                            System.out.println("Saldo Anda adalah " + nasabah.getSaldo());
                            break;
                        }
                        case 2: {
                            /* Tarik uang  */
                            do {
                                try {

                                    BigDecimal tarik;
                                    BigDecimal total;
                                    System.out.println("Saldo Anda adalah " + nasabah.getSaldo());
                                    System.out.print("Masukan Nominal yang akan ditarik : ");
                                    tarik = inp.nextBigDecimal();
                                    /* obBD.CompareTo(obBD)*/
                                    if (tarik.compareTo(nasabah.getSaldo()) == 1) {
                                        System.out.println("Maaf jumlah tarikan melebihi saldo");
                                        cekInput = false;
                                    } else {

                                        total = nasabah.getSaldo().subtract(tarik);
                                        System.out.println("Selamat Anda berhasil Mernarik Uang sebesar " + tarik);
                                        nasabah.setSaldo(total);
                                        System.out.println("Sisa Saldo " + nasabah.getSaldo());
                                        History.add("Penarikan dari saldo " + tarik + " Pada Tanggal " + Today);
                                        cekInput = true;
                                    }


                                } catch (Exception exception) {
                                    cekInput = false;
                                }
                            }
                            while (!cekInput);
                            break;
                        }
                        case 3: {
                            /*Setor Uang*/
                            do {
                                try {
                                    BigDecimal store;
                                    BigDecimal total;
                                    System.out.println("Setor Tunai");
                                    System.out.print("Masukan Nominal : ");
                                    store = inp.nextBigDecimal();
                                    total = nasabah.getSaldo().add(store);
                                    nasabah.setSaldo(total);
                                    System.out.println("Selamat Uang sebesar " + store + " Berhasil Ditambahkan ke Tabungan Anda");
                                    System.out.println("Saldo :" + nasabah.getSaldo());
                                    History.add("Setor tunai sebesar +" + store + " Pada Tanggal " + Today);
                                    cekInput = true;


                                } catch (Exception exception) {
                                    cekInput = false;
                                }
                            }
                            while (!cekInput);
                            break;
                        }
                        case 4: {
                            /*Transfer*/

                            do {
                                try {

                                    BigDecimal TotalYangDitransfer;
                                    String Tujuan;
                                    System.out.println("Pilih Bank tujuan : ");

                                    System.out.println("Masukan No Rekening Tujuan : ");
                                    Tujuan = inp.next();
                                    System.out.println("Masukan Nominal Transfer   : ");
                                    TotalYangDitransfer = inp.nextBigDecimal();
                                    nasabahT = getNasabah(listNasabah, Tujuan);
                                    if (nasabahT == nasabah) {
                                        System.out.println("Anda tidak bisa Transfer ke diri sendiri! Coba lagi");
                                        cekInput = false;
                                    } else if (TotalYangDitransfer.compareTo(nasabah.getSaldo()) == 1) {
                                        System.out.println("Saldo anda tidak mencukupi");
                                        cekInput = false;
                                    } else {
//                                    BigDecimal biayaAdmin = nasabahT.
                                        BigDecimal total = nasabah.getSaldo().subtract(TotalYangDitransfer);
                                        nasabah.setSaldo(total);
                                        System.out.println("Anda telah mentransfer uang ke " + nasabahT.getNama() + " Sebesar" + TotalYangDitransfer);
                                        System.out.println("Saldo Tersisa : " + nasabah.getSaldo());
                                        History.add("Transfer uang " + TotalYangDitransfer + " ke " + nasabahT.getNama() + " Pada Tanggal " + Today);
                                        cekInput = true;
                                    }


                                } catch (Exception exception) {
                                    cekInput = false;
                                }
                            }
                            while (!cekInput);
                            break;
                        }
                        case 5: {
                            System.out.print("Masukan Pin baru :");
                            String pin = inp.next();
                            nasabah.setPassword(pin);
                            History.add(LocalDate.now() + " || Pin diubah");
                            break;

                        }
                        case 6: {
                            /* History */
                            System.out.println("History Transaksi");
                            for (String list : History) {
                                System.out.println(list);
                            }
                            nasabah.showPrevLog();

                            break;

                        }
                        case 7:{

                            for(String log : History){
                                nasabah.addLog(log);
                            }
                            History.clear();
                            pilih=8;

                            break;
                        }



                        default: {
                            System.out.println("Hanya bisa memilih 1-7");
                            break;
                        }

                    }
                } catch (Exception exception) {
                    break;
                }
            }


            while (pilih != 8);
        }while(!reset);




    }


    static public boolean cekNoKartu(List<Nasabah> listNasabah, String kartu){

        for (Nasabah nsb:listNasabah) {
            if(nsb.getNoRekening().equals(kartu)){
                return true;
            }
        }
        return false;
    }

    static public Nasabah getNasabah(List<Nasabah> listNasabah, String kartu){
        Nasabah nasabah = new Nasabah();
        for (Nasabah nsb:listNasabah) {
            if(nsb.getNoRekening().equals(kartu)){
                return nsb;
            }
        }
        return nasabah;
    }


    static public boolean cekPassword(Nasabah objek, String Password){

        return objek.getPassword().equals(Password);
    }



}

