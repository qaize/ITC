package main;

import java.util.*;
import java.math.*;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		/* Seperti bahasa pemrograman lain, java juga memiliki operator pembanding, seperti:
		* ==, !=, > , <, >=, <=, &&, ||
		*
		* Seluruh operator pembandingan akan menghasilkan boolean result.
		* */
        boolean correct = 7 > 3;
        System.out.println(correct);

		/*  If statement akan melacak apakah isi dari statementnya adalah true atau false.
		*   Hasil true akan membuat if statement meloloskan process ke dalam scope.
		*   Apabila hasil false, maka process tidak akan masuk ke dalam if statement block.
		* */
        boolean conditionOne = true;
        if (conditionOne) {
            System.out.println("Condition one is true");
        }

        System.out.println("Fill condition two:");     
        String conditionTwo = scanner.nextLine();
        if (conditionTwo.equals("correct")) {// tidak bisa menggunakan == untuk String
        	System.out.println("Condition two is correct");
        }
        
        //Note: method compareTo bisa digunakan untuk membadingkan 2 string, apabila nilanya 0, maka string sama persis.
        int result = conditionTwo.compareTo("correct");
        System.out.println(result);
        
        int conditionThree = 5;
        int conditionFour = 5;
        int conditionFive = 20;
        double conditionSeven = 5.0;
       
        //Mencoba macam-macam kondisi
        if (conditionThree == conditionFour) {
        	System.out.println("Condition Three and Four are the same");
        }
        if (conditionThree != conditionFive) {
        	System.out.println("Condition Three and Five are not the same");
        }
        if (conditionFive > conditionThree) {
        	System.out.println("Condition Five is bigger that Condition Three");
        }
        if (conditionThree >= conditionFour) {
        	System.out.println("Condition Three is bigger than or the same as condition Four");
        }
        if (conditionFive >= conditionThree) {
        	System.out.println("Condition Five is bigger than or the same as Condition Three");
        }
        if (conditionFour < conditionFive) {
        	System.out.println("Condition Four is smaller than Condition Five");
        }
        if (conditionThree <= conditionFour) {
        	System.out.println("Condition Three is smaller than or the same as Condition Four");
        }
        if (conditionThree <= conditionFive) {
        	System.out.println("Condition Three is smaller than or the same as Condition Five");
        }

        //Atau (Or): salah satu (satu atau lebih) benar maka kondisi terpenuhi
        if (conditionOne == true || conditionThree > conditionFive || conditionThree != conditionFour) {
        	System.out.println("Condition Or reached");
        }
        if (conditionThree > conditionFive || conditionThree != conditionFour) {
        	System.out.println("Condition Or reached");
        }

        //Dan (And): semua harus benar untuk kondisi terpenuhi
        if (conditionFive > conditionThree && conditionFour < conditionFive && conditionOne == true) {
        	System.out.println("Condition And reached");
        }
        if (conditionOne == true && conditionThree > conditionFive && conditionThree != conditionFour) {
        	System.out.println("Condition And reached");
        }

        /*
        * And dan Or memiliki system lazy evaluation.
        * Lazy evaluation adalah mechanism malas dari java, yang digunakan untuk menghemat performance.
        * Dalam kasus OR, ketika statement pertama sudah true, java tidak akan memeriksa statement berikutnya, karena sudah pasti True.
        * Dalam kasus AND, ketika statement pertama sudah false, java tidak akan memeriksa statement berikutnya, karena sudah pasti False.
        * */

        /*Implicit coversion juga berlaku dalam comparison, sehingga memungkinkan membandingkan 2 variable
        dengan tipe data yang berbeda selama bisa melakukan implicit conversion*/
        if (conditionThree == conditionSeven) {
        	System.out.println("Integer and Decimal can be compared");
        }        
        
        /*Apabila if tidak terpenuhi, maka statement akan beralih ke alternatifnya dalam else.
        * Apabila if terpenuhi, else tidak akan dijalankan.
        * */
        if (conditionThree == 9) {
        	System.out.println("Condition three is 9");
        } else {
        	System.out.println("Condition three is not 9. (other than 9)");
        }

        System.out.println("Pilih minuman mu: 1.Coca-cola, 2.Sprite, 3.Fanta, 4.Lemon Tea");
        String caseString = scanner.nextLine();

        /*Multiple else if bisa digunakan diantara if dan else sebagai alternatif if yang kedua.*/
        if (caseString.equals("1")) {
        	System.out.println("Kamu mendapatkan Coca-cola");
        } else if (caseString.equals("2")) {
        	System.out.println("Kamu mendapatkan Sprite");
        } else if (caseString.equals("3")) {
        	System.out.println("Kamu mendapatkan Fanta");
        } else if (caseString.equals("4")) {
        	System.out.println("Kamu mendapatkan Lemon Tea");
        } else {
        	System.out.println("Error, kamu harus ketik 1, 2, 3, atau 4.");
        }        

        System.out.println("Pilih minuman mu: 1.Coca-cola, 2.Sprite, 3.Fanta, 4.Lemon Tea");
        String caseInput = scanner.nextLine();

        /*
        * Switch case menjadi alternatif yang lebih best practice daripada menggunakan else if
        * dalam kasus yang banyak. Silahkan di debug untuk membuktikannya.
        * */
        switch (caseInput) {
            case "1":
            	System.out.println("Kamu mendapatkan Coca-cola");
                break;
            case "2":
            	System.out.println("Kamu mendapatkan Sprite");
                break;
            case "3":
            	System.out.println("Kamu mendapatkan Fanta");
                break;
            case "4":
            	System.out.println("Kamu mendapatkan Lemon Tea");
                break;
            default:
            	System.out.println("Error, kamu harus ketik 1, 2, 3, atau 4.");
                break;
        }

        /* Ternary operator adalah cara alternatif secara syntactic sugar (syntax yang lebih singkat) untuk
        * menulis pernyataan if dan else (tidak bisa else if) dari satu hasil pernyataan.
        *
        * Disebut ternary karena di sini menggunakan 3 operator, yaitu: = ? :
        * */
        String hasil = (conditionThree == 5) ? "Hasilnya sama" : "Hasilnya beda";
        
        /* Membandingkan 2 buah BigDecimal value harus menggunakan compareTo:
			0  : Apabila 2 buah value sama besar.
			1  : Apabila object BigDecimal yang meng-invoke method lebih besar dari parameternya.
			-1 : Apabila object BigDecimal yang meng-invoke method lebih kecil dari parameternya.*/
        BigDecimal angkaPertama = new BigDecimal(100);
        BigDecimal angkaKedua = new BigDecimal(50);
        BigDecimal angkaKetiga = new BigDecimal(50);
        
        if(angkaPertama.compareTo(angkaKedua) == 1) {
        	System.out.println("Angka pertama lebih besar dari angka kedua");
        }
        
        if(angkaKedua.compareTo(angkaPertama) == -1) {
        	System.out.println("Angka kedua lebih kecil dari angka pertama");
        }
        
        if(angkaKedua.compareTo(angkaKetiga) == 0) {
        	System.out.println("Angka kedua dan angka ketiga sama besar.");
        }
	}
}
