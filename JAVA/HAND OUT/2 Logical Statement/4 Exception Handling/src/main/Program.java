package main;

import java.sql.SQLOutput;
import java.util.*;

public class Program {

	public static void main(String[] args) {

        /*
        * Di dalam java programming, terdapat 3 macam error
        * 1 Compiler error: biasanya diakibatkan oleh syntax error, tapi tidak selalu.
        *   Error jenis ini di detect oleh compiler dan terjadi sebelum selesai compilation proses dari java ke run time language.
        *
        * 2 Runtime error: atau biasanya lebih dikenal dengan nama Exception.
        *   Error jenis ini terjadi di run time proses selesai hasil compilation. Error ini ditandai dengan adanya warning berupa exception type.
        *   Runtime error diakibatkan adanya tidak mampuan aplikasi untuk memproses sesuatu di dalam suatu kondisi.
        *
        * 3 Logic error: atau biasanya lebih dikenal dengan sebutan Bug.
        *   Logic error adalah di saat aplikasi miss-behave atau bertindak diluar seharusnya, tetapi tidak ada warning atau error message sama sekali.
        *   Aplikasi pun akan jalan tanpa ada halangan, hanya saja hasil prosesnya anomali. Logic error biasnya diakibatkan karena adanya kesalahan logika
        *   analyst atau developer. Logic error harus ditemukan dengan cara melakukan test pada aplikasi yang dilakukan oleh developer atau tester.
        * */

        //Berikut ini adalah contoh-contoh Compile error
        //variable = "halo"; lupa menulis deklarasi
        //int limited = 3000000000; menulis value lebih dari limit

        //Berikut ini adalah contoh logic error
        int angkaPertama = 2000000000;
        int angkaKedua = 2000000000;
        int hasilPenjumlahan = angkaPertama + angkaKedua;
        System.out.println(hasilPenjumlahan); //Hasilnya bukan 4 milliar karena melebihi batas integer

        //Berikut ini adalah contoh dari run-time error atau exception.
        String words = "Hello World";
        /*Apabila langsung di coba, error exception akan langsung terlihat*/
        //int angka = Integer.parseInt(words);
        //System.out.println(angka);

        /* Cara untuk mengendalikan run-time error atau exception adalah dengan menggunakan statement try dan catch.
        * try dan catch sifatnya seperti if dan else tapi khusus untuk exception.
        * Apabila terjadi exception pada sebuah statement di dalam try block, maka catch block akan dijalankan, dan exception tidak akan menghentikan
        * jalannya aplikasi java.
        * */
        try {
            int number = Integer.parseInt(words);
        } catch (Exception exception) { //Catch Exception: Adalah menangkap error informasi yang di detect oleh system.
            System.out.printf("Error, gagal convert, exceptionnya %s\n", exception.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Number 1: ");
            int numberOne = Integer.parseInt(scanner.nextLine());
            System.out.println("Number 2: ");
            int numberTwo = Integer.parseInt(scanner.nextLine());
            int result = numberOne / numberTwo;
            System.out.println(numberOne + " / " + numberTwo + " = " + result );
        } catch (ArithmeticException exception) {
            System.out.println("You cannot divided by zero!");
        } catch (NumberFormatException exception) {
            System.out.println("Please input only digits");
        } catch (Exception exception) {
            System.out.println("General exception"); //Tidak akan ke catch up!
        }
        
        /*
        * Finally, satu statement yang akan dijalankan dalam kondisi apa pun, baik try berhasil, exception berhasil di catch, dan
        * exception gagal catch sekalipun.
        * */
        try {
            System.out.println("Number 1: ");
            int numberOne = Integer.parseInt(scanner.nextLine());
            System.out.println("Number 2: ");
            int numberTwo = Integer.parseInt(scanner.nextLine());
            int result = numberOne / numberTwo;
            System.out.println(numberOne + " / " + numberTwo + " = " + result );
        } catch (ArithmeticException exception) {
            System.out.println("You cannot divided by zero!");
        } finally {
            System.out.println("Error ke catch atau tidak, finally tetap jalan.");
        }
        System.out.println("End of application.");

        scanner.close();
	}
}
