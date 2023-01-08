package main;

public class Program {
    /* Function adalah dasar dari procedural programming, dimana semua eksekusi program dipisah-pisahkan dan dikelompokan ke dalam modul-modul kecil.
     * Dengan adanya function semua exekusi lebih mudah dibaca dan dimengerti oleh sesama programmer, tetapi lebih pentingnya lagi function juga digunakan untuk mencegah terjadinya duplicate code.
     * Sehingga baik satu atau lebih programmer yang bekerja dalam satu kelompok tidak membuat program yang sama.
     *
     * Bagian-bagian function adalah:
     * public: merupakan VISIBILITY atau ACCESS LEVEL, ini membatasi apa yang boleh menggunakan dan tidak boleh menggunakan functionini. Akan dijelaskan lebih dalam di chapter Ecapsulation dan Object Oriented Programming
     * int: merupakan RETURN VALUE. Ini menjelaskan tipe data output dari function ini.
     * static: akan dijelaskan lebih lanjut di chapter Object Oriented Programming.
     * int angkaPertama dan int angkaKedua: ini disebut PARAMETER. parameter merupakan pen-definisian input dari function ini.
     * return hasil: merupakan hasil yang akan menjadi output dari function ini. return hasil akan di pass ke RETURN VALUE pada saat di invoke.*/
    public static int penjumlahan(int angkaPertama, int angkaKedua) {
        int hasil = angkaPertama + angkaKedua;
        return hasil;
    }	
	
	public static void main(String[] args) {
        //Invoking/Calling function: adalah proses menggunakan function
        int result = penjumlahan(5, 4);
        System.out.printf("Hasil: %d\n", result);
        
        //Invoking function dimana function tersebut invoke function yang lain
        int hasilPerkalian = perkalian(5, 4, 6);
        System.out.printf("Hasil: %d\n", hasilPerkalian);
		
        printHelloWorld();
        String name = "Boby";
        printHelloFriend(name);

        String[] wordCollection = new String[5];
        wordCollection[0] = "Hello";
        wordCollection[1] = "Friend";
        wordCollection[2] = "May be";
        wordCollection[3] = "I Should";
        wordCollection[4] = "Give";
	}
	
    /* Function yang meng-invoke function lain.
     * Function tidak sama seperti deklarasi variable, function bisa ditulis setelah line dimana function tersebut di invoke.*/
    public static int perkalian(int bilanganPertama, int bilanganKedua, int bilanganKetiga) {
        int hasilJumlah = penjumlahan(bilanganPertama, bilanganKedua);
        int hasil = hasilJumlah * bilanganKetiga;
        return hasil;
    }	
    
    /* Function void tidak mengembalikan nilai apa pun. Tapi tetap memproses seluruh statement di dalamnya.*/
    public static void printHelloWorld() {
        System.out.println("Hello World!");
    }
    
    public static void printHelloFriend(String name) {
    	System.out.printf("Hello %s, Welcome back!\n", name);
    }
}
