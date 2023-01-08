package com.indocyber;

public class Main {

    //Pemakaian global variable di level class tidak diperbolehkan di dalam java. Variable yang di deklarasi di level member class akan menjadi field.
    //Penggunaan field akan dijelaskan di chapter lain.
    String superGlobal;

    public static void main(String[] args) {

        /*Pemakaian variable di dalam java dibatasi oleh scope.
        * Scope adalah satu lingkup dalam procedural programming yang dibatasi dengan code-block atau {}.
        * Variable yang di deklarasi di scope yang berbeda akan mendapat management memory yang berbeda.
        * */

        //deklarasi pada lain scope bisa sama karena di manage secara sendiri-sendiri.
        {
            String myVariable;
        }
        {
            String myVariable;
        }

        /*Variable global bersifat global terhadap scope dibawahnya
        * Itu artinya scope yang berada di level di bawahnya bisa mengakses level di atasnya.
        * Saat scope bisa mengakses global variablenya, itu artinya kita tidak boleh double declaration terhadap variable pada parentnya.
        * */
        String global = "Global";
        {
            System.out.println(global);
            //String global; ini akan error
            global = "Global Baru";
            String foreign = "Foreign";
        }
        {
            System.out.println(global); //Sudah berisikan "Global Baru"
            //System.out.println(foreign); tidak akan bisa mengakses foreign.
            String local = "Local";
            {
                //Lower level scope akan selalu bisa mengakses atasnya.
                System.out.println(global);
                System.out.println(local);
            }
        }
    }
}
