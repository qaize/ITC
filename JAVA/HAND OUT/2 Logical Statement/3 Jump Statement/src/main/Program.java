package main;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
        //Break: Hentikan proses iteration
        for (int index = 1; index < 10; index++) {
            if (index == 3) {
                break;
            }
            System.out.printf("Index is %d\n", index);
        }

        for (int xIndex= 0; xIndex < 6; xIndex++) {
            if (xIndex == 3) {
                break;
            }

            System.out.printf("Index X is %d\n", xIndex);
            for (int yIndex = 0; yIndex < 6; yIndex++) { //Hanya break di lapisan paling bawah saja, atau yang bersangkutan
//                if (yIndex == 3) {
//                    break;
//                }
            	System.out.printf("Index Y is %d\n", yIndex);
            }
        }
//
//        //Continue: skip ke iteration berikutnya
        for (int index = 1; index <= 10; index++) {
            if (index < 9) {
                continue;
            }
            System.out.printf("Get index %d\n", index);
        }

        //Return akan diajarkan kemudian setelah mempelajari function.
	}

}
