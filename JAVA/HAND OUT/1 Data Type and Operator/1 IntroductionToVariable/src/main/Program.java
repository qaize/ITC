package main;
import java.util.Scanner;
import java.lang.Character;

public class Program {
	
	public static void main(String[] arguments) {
        /*
        * Variable adalah nama sebuah pointer yang dipakai sebagai penunjuk satu block memory yang di simpan secara temporary, atau
        * hanya digunakan selama proses. Variable akan di simpan dalam tipe data tertentu. Pada chapter ini kita akan melihat macam-macam tipe data.
        *
        * Tipe data pada java dibagi menjadi 2 macam tipe, yaitu primitive type dan non-primitive type.
        * Primitive type adalah tipe data basic yang ada pertama kali dan fungsinya pun sederhana.
        * Non-primitive type adalah tipe data custome yang dibuat oleh developer.
        * */

        /*
        * Di bawah ini adalah contoh-contoh tipe data primitive untuk menyimpan data bilangan bulat
        * */

		//byte: bilangan bulat negatif dan positif -128 to 127
		byte contohByte = 2;

        //short: bilangan bulat 16 bit (Int16) -32.767 to 32.768
        short contohShort = -30000;

        //int: bilangan bulat 32 bit (Int32) -2,147,483,648 to 2,147,483,647
        int contohInteger = 5;

        //long: bilangan bulat 64 bit (Int64) -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        long contohLong = 650000000000l; // apabila keluar dari batas integer menjadi long, l/L harus dituliskan di akhir angka.

        /*
         * Di bawah ini adalah contoh-contoh tipe data primitive untuk menyimpan data bilangan desimal.
         * */

        //double: 64 bit decimal -2.2x10308 to 2.2x10308
        double contohDouble = 3.45;
        
        //float: 32 bit decimal -3.4 x 10^38 to + 3.4 x 10^38
        float contohFloat = 3.5f; // lain dengan double, float harus diberi tanda f pada akhir valuenya apabila valuenya desimal.

        //Contoh primitive lainnya:

        //char: satu 16-bit Unicode character
        char contohChar = 'x';
        
        //boolean: true/false, default: false. Menyimpan hanya 1 bit, 0 untuk false, 1 untuk true.
        //boolean sangat hemat memory karena hanya menyimpan 1 bit data.
        boolean contohBool = true;
        
        /*Non-primitive data type*/
        
        //String: atau sederetan characters, merupakan tipe data non-primitive yang unik. String sebenarnya terdiri dari banyak character.
        //Walaupun string adalah sebuah Class (dipelajar di OOP nanti), string suka di sangka sebagai primitive data type karena cara pemakaiannya.
        String contohString = "Sebuah kata-kata";
        System.out.println(contohString);

        /*
         * Variable harus di deklarasi terlebih dahulu sebelum pemakaian.
         * Deklarasi adalah tindakan membuat nama variable dan me-reserve (menyewa) memory di temporary in-memory yang akan kita gunakan.
         * Deklarasi di lakukan dengan cara menulis tipe data dan nama variablenya.
         * */
        int sebuahInteger;
        sebuahInteger = 5; //Value assignment, proses assign value/ data ke dalamnya.
        System.out.println(sebuahInteger);

        //Kita bisa deklarasi terlebih dahulu nantinya baru set valuenya atau langsung initiate assignment seperti di bawah ini.
        int specificVariable = 56;
        int otherVariable = 99; //Di dalam satu scope variable harus memiliki nama yang berbeda-beda. Nama variable yang sama tidak boleh di deklarasi 2 kali.
        System.out.println("Sebelum di replace: " + specificVariable);

        //Ketika kita menulis ulang nama variable yang sudah ada tanpa deklarasi, kita hanya melakukan set value dari variable.
        //Set value adalah tindakan membuat/meng-edit isi value dari variable.
        specificVariable = 87;

        //Di bawah ini adalah contoh-contoh men-set value variable
        System.out.println("Setelah di replace: " + specificVariable);
        System.out.println("Setelah di replace: " + specificVariable);
        System.out.println("Other variable: " + otherVariable);
        otherVariable = specificVariable;
        System.out.println("Other variable setelah replace: " + otherVariable);
        specificVariable = 122;
        System.out.println("Specific variable: " + specificVariable);
        System.out.println("Other variable: " + otherVariable);

        //Deklarasi final bisa dipakai agar set atau initiate value dari variable hanya bisa untuk menciptakan, tidak bisa untuk edit.
        final double pi = 3.14;
        //pi = 56.7; ini akan error

        final String permanent;
        permanent = "First time";
        //permanent = "Second time"; ini akan error

        /* Setiap tipe data primitive memiliki versi non-primitivenya atau yang kita sebut dengan Wrapper Class.
         * Contoh-contoh wrapper class bisa dilihat di bawah.
         * Penggunaan Wrapper class akan dibahas lebih banyak lagi di chapter-chapter berikutnya.
         * */
        char primitiveChar = 'A';
        Character wrapperChar = primitiveChar; //Autoboxing (primitive to Wrapper)
        primitiveChar = wrapperChar; //Autounboxing (Wrapper to primitive) 
		System.out.println(wrapperChar.getClass().getName());//Bisa menggunakan method, misalnya untuk check tipe datanya.
        
		/*Semua Wrapper class dari setiap data primitive diawali huruf besar seperti layaknya Class, dan memiliki nama sama atau hampir sama dengan primitivenya:
		 * byte -> Byte
		 * short -> Short
		 * int -> Integer
		 * long -> Long
		 * char -> Character
		 * boolean -> Boolean
		 * float -> Float
		 * double -> Double
		 * */
        
        /*Pada console application, kita bisa menerima input user dengan menggunakan scanner.*/
        Scanner scanner = new Scanner(System.in);

        String kalimat = "Hello friend, Hello friend";
        System.out.println(kalimat);
        System.out.print("Masukan input (dalam String):");       
        kalimat = scanner.nextLine(); //Cara menerima input dari console (Selalu dalam string)
        System.out.println("Read input: " +  kalimat);
        
        scanner.close(); //Setelah di close, kita tidak akan bisa menggunakan fungsi Scanner lagi, terkecuali jika di instantiate lagi.    
	}
}
