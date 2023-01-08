package main;

import java.util.*;

public class Program {

    /*
     * Function Overloading adalah seni menggunakan function dengan nama yang sama.
     */

    //function number 1
	//Signature: calculateSomething()
    public static int calculateSomething() {
        System.out.println("Function number 1 invoked!");
        return 99;
    }

    //function number 2
    //Signature: calculateSomething(int)
    public static int calculateSomething(int argOne) {
    	System.out.println("Function number 2 invoked!");
        return argOne + 1;
    }

    //function number 3
    //Signature: calculateSomething(int, int)    
    public static int calculateSomething(int argOne, int argTwo) {
    	System.out.println("Function number 3 invoked!");
        return argOne + argTwo;
    }

    //function number 4
    //Signature: calculateSomething(int, int, int)    
    public static int calculateSomething(int argOne, int argTwo, int argThree) {
    	System.out.println("Function number 4 invoked!");
        int result = (argOne + argTwo) * argThree;
        return result;
    }

    //function number 5
    //Signature: calculateSomething(String)    
    public static int calculateSomething(String argOne) {
    	System.out.println("Function number 5 invoked!");
        int converted = Integer.parseInt(argOne);
        int result = converted * 10;
        return result;
    }

    //function number 6
    //Signature: calculateSomething(int, String)    
    public static int calculateSomething(int argOne, String argTwo) {
        System.out.println("Function number 6 invoked!");
        int twoConverted = Integer.parseInt(argTwo);
        int result = argOne * twoConverted;
        return result;
    }

    //function number 7
    //Signature: calculateSomething(String, int)    
    public static int calculateSomething(String argOne, int argTwo) {
    	System.out.println("Function number 7 invoked!");
        int oneConverted = Integer.parseInt(argOne);
        int result = oneConverted + argTwo;
        return result;
    }

    /* Tidak akan bisa, function overload membedakan function dari keunikan parameternya dilihat dari tipe data, banyak dan urutannya, bukan dari return typenya.
    public static string calculateSomething() {
        System.out.println("Function number 8 invoked!");
        return "Hello World";
    }

    public static string calculateSomething(int argOne) {
        System.out.println("Function number 9 invoked!");
        string converted = Integer.toString(argOne);
        return converted;
    }

    merubah nama argument pun tidak akan bisa
    public static int calculateSomething(int argumentSatu) {
        System.out.println("Function number 10 invoked!");
        return argumentSatu;
    }        
    */	
	
	public static void main(String[] args) {
		//Gunakan Intellisense saat invoking function untuk melihat setiap potensial pilihan function dari parameternya.
		
        int result = 0;
        
        result = calculateSomething();
        System.out.println(result);
        
        result = calculateSomething(5);
        System.out.println(result);
        
        result = calculateSomething(3,2);
        System.out.println(result);
        
        result = calculateSomething(3, 2, 4);
        System.out.println(result);
        
        result = calculateSomething("67");
        System.out.println(result);
        
        result = calculateSomething(4, "5");
        System.out.println(result);
        
        result = calculateSomething("5", 4);
        System.out.println(result);

	}

}
