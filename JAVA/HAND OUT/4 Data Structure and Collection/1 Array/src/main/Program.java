package main;

public class Program {

	public static void main(String[] args) {

        /* Array adalah jenis collection yang ukurannya fixed dengan index yang berurutan dengan tipe data yang sama.
         * Array mudah dicari, performancenya juga baik dalam mencari satu index yang diketahui
         * Kelemahan array adalah ukurannya yang harus fixed
         */

        /*1.Single dimensional Array*/
        //Contoh: inisialisasi 1
        int[] arrayOfInteger = new int[5];
        arrayOfInteger[0] = 34;
        arrayOfInteger[1] = 56;
        arrayOfInteger[2] = 45;
        arrayOfInteger[3] = 79;
        arrayOfInteger[4] = 109;
        System.out.printf("Isi dari index 3: %d\n", arrayOfInteger[3]);
        System.out.printf("Panjang dari array: %d\n", arrayOfInteger.length);
        
        //Contoh: inisialisasi 2
        double[] arrayOfDouble = { 2340.0, 4523.69, 3421.9 };
        System.out.printf("Isi dari index 2: %.2f\n", arrayOfDouble[2]);     
        
        String[] arrayOfString = new String[] { "Hello", "Friend", "Maybe", "I Should", "Give", "You", "A Name" };
        System.out.printf("Isi dari index 3: %s\n", arrayOfString[3]);
        
        
        /*2. Multi dimensional Array / Jagged Array*/
        int[][] jaggedArray = new int[3][3];
        jaggedArray[0][0] = 23;
        jaggedArray[0][1] = 45;
        jaggedArray[0][2] = 22;      
        jaggedArray[1][0] = 67;
        jaggedArray[1][1] = 55;
        jaggedArray[1][2] = 88;        
        jaggedArray[2][0] = 134;
        jaggedArray[2][1] = 100;
        jaggedArray[2][2] = 220;        
        System.out.printf("Isi dari index 2,0: %d\n", jaggedArray[2][0]);

        //Contoh inisialisasi 1
        int[][] jaggedArray1 = new int[3][];    
        jaggedArray1[0] = new int[3];
        jaggedArray1[0][0] = 23;
        jaggedArray1[0][1] = 45;
        jaggedArray1[0][2] = 22;
        jaggedArray1[1] = new int[3];
        jaggedArray1[1][0] = 67;
        jaggedArray1[1][1] = 55;
        jaggedArray1[1][2] = 88;
        jaggedArray1[2] = new int[4]; // bisa berbeda size untuk column 2
        jaggedArray1[2][0] = 134;
        jaggedArray1[2][1] = 100;
        jaggedArray1[2][2] = 220;
        jaggedArray1[2][3] = 720;
        System.out.printf("Isi dari index 1,2: %d\n", jaggedArray1[1][2]);
        
        //Contoh inisialisasi 2
        int[][] jaggedArray2 = new int[][] {
            new int[] { 92, 93, 94 },
            new int[] { 85, 66, 87 }
        };
        
        //Contoh inisialisasi 3
        int[][] jaggedArray3 = new int[][] {{ 92, 93, 94 }, { 85, 66, 87 }};        
        
        //Looping through array
        String[] collectionStr = new String[6];
        collectionStr[0] = "Abdul";
        collectionStr[1] = "Rheza";
        collectionStr[2] = "Anita";
        collectionStr[3] = "Nia";
        collectionStr[4] = "Ben";
        collectionStr[5] = "Roland";
        
        for(int index = 0; index < collectionStr.length; index++) {
            System.out.printf("Nama di Index %d adalah %s\n", index, collectionStr[index]);
        }
        
        //Iteration yang digunakan di dalam collection. Tidak perlu iterate berdasarkan index yang diketahui
        for (String nama : collectionStr) {
            System.out.printf("Nama yang tertera adalah: %s\n", nama);
        }    
        
	}

}
