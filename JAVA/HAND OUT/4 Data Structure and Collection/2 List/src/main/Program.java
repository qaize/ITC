package main;

import java.util.*;

public class Program {

	public static void main(String[] args) {
        /*Pada chapter ini, kita akan mengenal 2 jenis collection List, yaitu Linked List dan Array List.
         Kedua collection ini memiliki cara pakai yang sangat mirip, tetapi berbeda keuntungan dan kerugian dari sisi performance pada kondisi tertentu.
         Baik LinkedList dan ArrayList yang akan diperkenalkan di sini memiliki tipe collection generic.
         Generic sendiri artinya satu collection ini hanya bisa menerima satu tipe macam tipe data yang bersifat non-primitive.
         Generic ditulis dengan menggunakan Generic bracket <>. Mengenai generic sendiri akan dijelaskan secara detail pemakaian lebih advancenya.

         Sebuah collection yang sanggup menerima beragam tipe data di dalamnya disebut juga tipe data dynamic, dan itu kurang best-practice
         sehingga tidak dicontohkan dan disarankan di sini. (Terkecuali untuk bahasa pemrograman dynamic declaration seperti JS).*/

        /* LinkedList: adalah collection dengan struktur datanya seperti rantai, terkait dari satu node dari ke node lain.
            Dimana setiap node dari collection ini memiliki index ke node lain.

            Kelebihan dari linked list adalah:
            1. Memiliki ukuran yang tidak fixed seperti array, sehingga jumlah node bisa flexible.
            2. Pertambahan data baru akan berlangsung cepat.

            Kerugian:
            1. Proses pencarian sebuah data lebih lambat dari array maupun array list
            2. Memory yang dibutuhkan heap sedikit lebih besar ketimbang array atau array list.

            LinkedList sangat baik digunakan saat developer belum yakin pasti banyaknya data yang ditampung pada collection ini, sehingga bisa terus bertambah,
            dan dimana developer tidak ingin melakukan pencarian satu node di tengah-tengah collection dengan kebutuhan untuk mencari, apa lagi untuk mengedit dan
            menghapus.
        */

        /*
        * Proses inisialisasi dari LinkedList bisa ditulis dengan
        * LinkedList<String> stringList = new LinkedList<String>();
        * atau...
        * LinkedList<String> stringList = new LinkedList<>(); (ini cara java versi baru yang lebih singkat)
        * */
        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("Hello");
        stringList.add("Friend");
        stringList.add("May be");
        stringList.add("I should");
        stringList.add("Give");
        stringList.add("You");
        stringList.add("A Name");

        /*
        * Ini adalah foreach, cara terbaik melakukan iteration pata LinkedList.
        * Pada proses iteration menggunakan iterator, linkedlist tidak akan terkena penalty peformance pencarian.
        * */
        for (String word : stringList) {
        	System.out.println(word);	
        }

        /*Index pada LinkedList bekerja berbeda dengan index pada array dan array list, sehingga pencarian
        * lewat index seperti ini memiliki performance yang lebih lemah pada linked list, terutama kalau
        * indexnya sudah sangat besar.
        * */
        System.out.println(stringList.get(2));

        /*
        * Saat ini java belum menyediakan syntatic sugar untuk melakukan one line initialization.
        * Tricknya harus menggunakan Arrays.asList.
        * */
        List<String> stringList2 = new LinkedList<>(Arrays.asList("Hello", "World", "And", "Everyone"));

        //Seperti dikatakan sebelumnya, generic <> pada linked list tidak menerima primitive data type.
        List<Integer> integerList = new LinkedList<>();
        integerList.add(3);
        integerList.add(21);
        integerList.add(14);

        LinkedList<String> elementList = new LinkedList<>();
        elementList.add("Argentina");
        elementList.add("Alabama");
        elementList.add("Bahama");
        elementList.add("California");
        
        /*Melakukan penyisipan dan penghapusan pada index tertentu seperti dibawah ini juga akan
        * menjadi penalty bagi performance linkedList.
        * */
        elementList.add(2, "Bermuda");
        elementList.remove("Bahama");
        elementList.remove(1);

        /*Tetapi untuk add, addFirst, dan addLast, performance tidak akan jadi masalah.*/
        elementList.addFirst("Texas");
        elementList.addLast("Brooklyn");
        
        /*Untuk mengetahui banyaknya node di dalam linked list, kita bisa menggunakan size.
        * size pada list konsepnya berbeda dengan length pada array.
        * Length berfokus pada berapa banyak collection bisa menampung, sedangkan size berfokus pada
        * berapa banyak yang ditampung saat ini.
        * */
        System.out.println(elementList.size());
        
        //Berikut ini adalah cara convert list jadi array.
        String[] converted = elementList.toArray(new String[elementList.size()]);
        System.out.println(converted[2]);


		/* Array List sesuai namanya adalah sebuah array yang berprilaku seperti list.
		 *  Secara syntax, cara code dan pemakaian array list sama seperti Linked List, tetapi performance array list sama seperti array.
		 *
		 * Performance pencarian pada array list secepat array, dan setiap node memiliki numeric index seperti array.
		 * Array List dibuat seolah-olah memiliki ukuran yang flexible, sebenarnya tidak.
		 * Ketika sebuah array list dibuat, system akan membuat array dengan length = 10.
		 *
		 * Performance array list akan sangat baik sampai data ke 10, ketika ada penambahan di data ke 11, array list dengan system dynamic sizenya akan
		 * membuat sebuah array list baru dengan ukuran data sampai 20, dan memindahkan 10 sebelumnya ke 20 yang baru, dan ini akan terkena penalty performance.
		 * Array list akan sangat cocok untuk seseorang yang menikmati code seperti Linked List, tetapi tau pasti kalau collectionnya jarang mengalami perubahan data
		 * melebihi kelipatan 10.
		 * */

		ArrayList<String> listOfString = new ArrayList<>();
		listOfString.add("Hello");
		listOfString.add("World");
		listOfString.add("Everyone");
		System.out.println(listOfString);
		
		for(String word : listOfString) {
			System.out.println(word);
		}

        //Performance pencarian seperti ini akan berlangsung lebih cepat dari linked list.
		String indexOne = listOfString.get(1);
		System.out.println("First Index is: " + indexOne);

        listOfString.add("Additional ke 4");
        listOfString.add("Additional ke 5");
        listOfString.add("Additional ke 6");
        listOfString.add("Additional ke 7");
        listOfString.add("Additional ke 8");
        listOfString.add("Additional ke 9");
        listOfString.add("Additional ke 10");

        //Add data pada step ke 11 akan mengalami penalty performance.
        listOfString.add("Additional ke 11");

        //Untuk menghindari penalty perubahan length, kita bisa menset initial capacity jadi lebih banyak.
		ArrayList<Integer> semuaAngka = new ArrayList<>(20);
	}
}
