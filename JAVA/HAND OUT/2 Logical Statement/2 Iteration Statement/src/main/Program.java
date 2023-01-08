package main;

public class Program {

	public static void main(String[] args) {
        /*Sebelum mempelajari iteration ada baiknya kita mengenal increment, decrement dan assignment operator
        * */

        //Increment operator
        int initializationOne = 5;
        System.out.println(initializationOne++); //Post-increment, ditambahkan setelah statement berakhir
        System.out.println(initializationOne);

        int initializationTwo = 9;
        System.out.println(++initializationTwo); //Pre-increment, ditambahkan sebelum statement berakhir.
        System.out.println(initializationTwo);

        //Decrement operator juga bisa dilakukan dengan pre dan post calculation.
        int initializationThree = 7;
        System.out.println(initializationThree--);
        System.out.println(initializationThree);

        /*
        * Math operator bisa dikombinasikan dengan assignment operator.
        * Note: post dan pre calculation hanya bisa dilakukan lewat increment dan decrement, perkalian dan pembagian harus dengan
        * assignment operator.
        * */
        int initializationFour = 34;
        initializationFour += 3;
        System.out.println(initializationFour);
        initializationFour += 3;
        System.out.println(initializationFour);

        int initializationFive = 44;
        initializationFive *= 5;
        System.out.println(initializationFive);

        /*
        * Iteration adalah cara menulis statement dalam bahasa pemrograman, dimana statement akan dijalankan berulang-ulang.
        * Di setiap iteration, selalu ada 4 element:
        * - Kondisi awal
        * - Persyaratan tetap diulang
        * - Perubahan kondisi
        * - Body statement
        * */

        /*
        * For loop adalah sebuah iteration sederhana dimana ditulis dengan syntax
        * for (kondisi awal; persyaratan diulang; perubahan kondisi){
        *       body statement
        * }
        *
        * Note: kondisi awal, yang di deklarasi di dalam for() di perlakukan sebagai local variable terhadap scope.
        * */
        for (int index = 0; index < 10; index++) {
        	System.out.printf("This is for loop for index %d\n", index);
        }

        for (int index = 0; index < 10; index += 1) {
        	System.out.printf("This is for loop for index %d\n", index);
        }

        for (int index = 10; index > 0; index--) {
        	System.out.printf("This is for loop for index %d\n", index);
        }

        /*
        * While adalah iteration paling flexible dan yang paling awal ada.
        *
        * kondisi awal:
        * while(persyaratan diulang){
        *       perubahan kondisi ?
        *       body statement
        *       perubahan kondisi ?
        * }
        * */
        int sequence = 0;
        while (sequence < 10) {
        	System.out.printf("This is for loop for sequence %d\n", sequence);
            sequence++;
        }

        /*
        * Do while adalah sebuah while yang diproses terlebih dahulu, baru membaca persyaratan diulangnya.
        *
        * kondisi awal;
        * do{
        *       perubahan kondisi ?
        *       body statement
        *       perubahan kondisi ?
        * } while (persyaratan diulang)
        * */
        int identification = 0;
        do {
        	System.out.printf("This is for loop for identification %d\n", identification);
            identification++;
        } while (identification < 10);

        //Nested Loop
        for (int xIndex = 0; xIndex < 10; xIndex++) {
            for (int yIndex = 1; yIndex < 20; yIndex *= 2) {
            	System.out.printf("X index is %d, Y index is %d\n", xIndex, yIndex);
            }
        }

        /* Java memiliki 2 macam iteration lagi, yaitu foreach dan recursive.
        * Keduanya akan dijelaskan di chapter lain.
        * */
	}
}
