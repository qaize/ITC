package com.company;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static String strDate;
    public static String strDate1;

    // function filter int
    public static int filterInt(String inputan)
    {
        int number;
        try{
            number = Integer.parseInt(inputan);
        } catch(Exception exception)
        {
            System.out.println("Input salah, coba lagi");
            number = 0;
        }
        return number;
    }
    // function filter double
    public static boolean filterDouble(String inputan)
    {
        boolean check;
        try{
            double number = Double.parseDouble(inputan);
            check = true;
        } catch(Exception exception)
        {
            System.out.println("Input salah, coba lagi");
            check = false;
        }
        return check;
    }
    // function filter tanggal
    public static boolean filterDate(String inputan)
    {
        boolean check;
        try{
            int index = inputan.indexOf('/');
            String tanggal2 = inputan.substring(0, index);
            int date = Integer.parseInt(tanggal2);
            LocalDate tanggal1 = LocalDate.parse(inputan,format);
            int maxDate = tanggal1.lengthOfMonth();
            if (date <= maxDate)
            {
                check = true;
            }
            else
            {
                System.out.println("Input tanggal salah, melebihi tanggal maksimum pada bulan yang diinputkan");
                check = false;
            }
        }catch (Exception exception)
        {
            System.out.println("Input tanggal salah, coba lagi");
            check = false;
        }
        return check;
    }

    public static void menu()
    {
        System.out.println("Pilihlah salah satu menu pada aplikasi ini : ");
        System.out.println("1. Membuat ucapan idul fitri untuk anonymous");
        System.out.println("2. Membuat kartu ucapan idul fitri untuk seseorang");
        System.out.println("3. Menghitung lama hari dari jarak 2 tanggal");
        System.out.println("4. Menghitung kecepatan sebuah mobil");
        System.out.println("5. Menentukan apakah sebuah tahun merupakan tahun kabisat atau bukan");
        System.out.println("6. Menghitung perbedaan umur 2 orang pada hari ini");
        System.out.println("7. Keluar Aplikasi");
        System.out.println("Masukan Pilihan Anda : ");
    }

    public static void menu2(String nama)
    {
        System.out.println("Untuk Bapak/Ibu " + nama + "\nSelamat Hari Raya Idul Fitri, mohon maaf lahir dan batin\n");
    }

    public static void menu3()
    {
        System.out.println("Dari tanggal (dd/mm/yyyy) : ");
        strDate = scanner.nextLine();
        boolean cek = filterDate(strDate);
        if(cek == false){
            strDate = "01/01/2022";
            menu3();
        }
        else
        {
            menu3(strDate);
        }// end cek tanggal

    }

    public static void menu3(String strDari)
    {
        System.out.println("Hingga tanggal (dd/mm/yyyy) : ");
        strDate1 = scanner.nextLine();
        boolean cek1 = filterDate(strDate1);
        if(cek1 == false){
            strDate1 = "01/01/2022";
            menu3(strDari);
        }
        else
        {
            LocalDate dari = LocalDate.parse(strDari, format);
            LocalDate sampai = LocalDate.parse(strDate1, format);
            long daysPeriod = ChronoUnit.DAYS.between( dari, sampai);
            System.out.println("Jarak dari " + dari +" hingga "+ sampai + " adalah " + daysPeriod + " hari\n");
        }// end cek tanggal
    }

    public static void menu4()
    {
        System.out.println("Jarak yang ditempuh? (dalam km)");
        String strJarak = scanner.nextLine();
        boolean cek = filterDouble(strJarak);
        if(cek == false)
        {
            menu4();
        }
        menu4(strJarak);
    }

    public static void menu4(String strJarak)
    {
        System.out.println("Waktu yang ditempuh? (dalam hour)");
        String strWaktu = scanner.nextLine();
        boolean cek = filterDouble(strWaktu);
        if(cek == false)
        {
            menu4(strJarak);
        }
        double jarak = Double.parseDouble(strJarak);
        double waktu = Double.parseDouble(strWaktu);
        double result = jarak/waktu;
        System.out.println("Kecepatan mobil adalah " + result + " km/jam\n");
    }

    public static void menu5()
    {
        System.out.println("Tahun yang ingin dicek");
        String strTahun = scanner.nextLine();
        int cek = filterInt(strTahun);
        if (cek == 0)
        {
            menu5();
        }
        int tahun = Integer.parseInt(strTahun);
        if (tahun % 4 == 0)
        {
            System.out.println("Tahun " + tahun + " adalah tahun kabisat\n");
        }
        else
        {
            System.out.println("Tahun " + tahun + " adalah bukan tahun kabisat\n");
        }
    }

    public static void menu6()
    {
        System.out.println("Siapa orang pertama ?");
        String nama1 = scanner.nextLine();
        System.out.println("Tanggal lahirnya (dd/mm/yyyy)");
        String strTanggal1 = scanner.nextLine();
        boolean cek = filterDate(strTanggal1);
        if (cek == false)
        {
            menu6();
        }
        menu6(nama1, strTanggal1);
    }

    public static void menu6(String nama1, String strTanggal1)
    {
        System.out.println("Siapa orang kedua ?");
        String nama2 = scanner.nextLine();
        System.out.println("Tanggal lahirnya (dd/mm/yyyy)");
        String strTanggal2 = scanner.nextLine();
        boolean cek = filterDate(strTanggal2);
        if (cek == false)
        {
            menu6(nama1, strTanggal1);
        }
        LocalDate today = LocalDate.now();
        LocalDate tanggal1 = LocalDate.parse(strTanggal1, format);
        LocalDate tanggal2 = LocalDate.parse(strTanggal2, format);
        long daysPeriod1 = ChronoUnit.DAYS.between(tanggal1, today);
        Long yearPeriod1 = daysPeriod1/365;
        int res1 = yearPeriod1.intValue();
        long daysPeriod2 = ChronoUnit.DAYS.between(tanggal2, today);
        Long yearPeriod2 = daysPeriod2/365;
        int res2 = yearPeriod2.intValue();
        int result = 0;
        if (res1 < res2)
        {
            result = res2 - res1;
        }
        else
        {
            result = res1 - res2;
        }
        System.out.println("Perbedaan umur " + nama1 + " dan " + nama2 + " adalah " + result + " tahun pada hari ini\n");
    }

    public static void main(String[] args) {
        // write your code here
        int menu = 1;
        while(menu != 0)
        {
            menu();
            String strpilihan = scanner.nextLine();
            int pilihan = filterInt(strpilihan);
            if (pilihan == 1)
            {
                System.out.println("Selamat hari raya Idul Fitri, mohon maaf lahir dan batin\n");
            }
            else if(pilihan == 2)
            {
                System.out.println("Diucapkan untuk : ");
                String target = scanner.nextLine();
                menu2(target);
            }
            else if(pilihan == 3)
            {
                menu3();
            }
            else if(pilihan == 4)
            {
                menu4();
            }
            else if(pilihan == 5)
            {
                menu5();
            }
            else if(pilihan == 6)
            {
                menu6();
            }
            else if(pilihan == 7)
            {
                menu = 0;
                System.out.println("Program selesai... ");
            }
            else if(pilihan == 0)
            {
                System.out.println("Masukan pilihan angka antara 1 hingga 7");
            }
            else
            {
                System.out.println("Masukan pilihan antara 1 hingga 7");
            }

        } // end while
    } // end main
}
