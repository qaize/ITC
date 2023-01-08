package com.company;
/*
colection merupakan suatu hal yang jenis atau jumlahnya lebih dari satu
collection pada java disini tidak harus kosong

generic dan non gineric
- array memiliki index

int [ ] -> kalo dah array gini dia sudah fix integer

dah dapet objek kita dapat mengakses member dari class lain
*/

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        karyawan jona = new karyawan("Kar1","jona","mataram",LocalDate.of(2022,12,2),"Perempuan","081805508508","rahim ibu");
        karyawan dina = new karyawan("Kar1","dina","tokyp",LocalDate.of(2022,12,2),"Perempuan","081805508508","rahim ibu");


        List<karyawan> kumpulanKaryawan = new LinkedList<>();
        kumpulanKaryawan.add(jona);
        kumpulanKaryawan.add(dina);

        for(karyawan z : kumpulanKaryawan ){
            System.out.println(z);
        }




/*
        int[] arrayInteger = new int[5];
        arrayInteger[0] = 12;
        arrayInteger[1] = 13;
        arrayInteger[2] = 14;
        arrayInteger[3] = 15;
        arrayInteger[4] = 16;

        System.out.println(arrayInteger[4]);
        //nilainya bisa diset
        arrayInteger[3] = 11;
        System.out.println(arrayInteger[3]);

        System.out.println(arrayInteger.length);

        String [] hewan = new String[];
        hewan = "ikan","kucing","anjing","sapi";


        for(String namaHewan : hewan){
            System.out.println(namaHewan);

        }
*/

/*
        int [][] kumpulanInteger = new int [4][0];
        kumpulanInteger[0][1] = 1;
        kumpulanInteger[0][2] = 2;
        kumpulanInteger[0][3] = 3;
        kumpulanInteger [1] = new int[1];
        kumpulanInteger[1][0] = 12;
        kumpulanInteger[1][2] = 13;
        kumpulanInteger[1][3] = 14;
        kumpulanInteger [2] = new int[2];
        kumpulanInteger[2][0] = 100;
        kumpulanInteger[2][2] = 200;
        kumpulanInteger[2][3] = 300;
          kumpulanInteger [3] = new int[3];
        kumpulanInteger[3][0] = 1001;
        kumpulanInteger[3][2] = 2001;
        kumpulanInteger[3][3] = 3001;

        int [][] kumpulanAngka = new int [][] {

                new int[]{
                        14,23,7

                },
                new int[]{

                        100,200,300
                }
        };

        for(int[] z : kumpulanAngka){
            System.out.println(z);
        }
*/
/*
        for(int[] grupAngka : kumpulanInteger){
            for(int[] angka :)
        }

        //List, lebih mudah menambahkan data tapi lebih lambat dalam melakukan pencarian

        LinkedList<String> persons = new LinkedList<>();
        persons.add("awas");
        persons.add("andin");
        persons.add("andri");
        persons.add("aan");
        //ini untuk menambahkan/update value list berdasarkan index
        //persons.add(2,"demn");

        //untuk mnghapus yaitu persons.remove(2)

        for (String nama : persons){

            System.out.println(nama);
        }

        System.out.println(persons.getFirst());
        System.out.println(persons.getLast());
        System.out.println(persons.get(2));

        //String[] hasil = new String[];
        String[] convertPersonToArray = persons.toArray(new String[persons.size()]);


        //Kalo Generic itu tidak dapat dimasukan tipe data primitive, harus yang non primitive

        List<Integer> listAngka = new LinkedList<>(Arrays.asList(10,11,12));

        for(int angka : listAngka){
            System.out.println(angka);
        }

        ArrayList<String> arrayListName = new ArrayList<>();
        arrayListName.add("abd");
        arrayListName.add("abbbd");
        arrayListName.add("aaaaabd");
        arrayListName.add("abdddd");
        arrayListName.add("abdi");
        arrayListName.add("abdu");
        arrayListName.add("abdul");
        arrayListName.add("abdai");
        arrayListName.add("abdaii");
        arrayListName.add("abdaa");
        arrayListName.add("abdaaaa");
        arrayListName.add("abdeda");
        arrayListName.add("abdaiaia");

        for(String name : arrayListName){

            System.out.println(name);
        }

        //hashmap
        HashMap<Integer,String> namaHewan = new HashMap<>();
        namaHewan.put(1,"Kucing");
        namaHewan.put(2,"Anjing");
        namaHewan.put(3,"Ikan");
        namaHewan.put(4,"Luwak");
        namaHewan.put(5,"Sapi");

        System.out.println(namaHewan.get(2));
        System.out.println(namaHewan.size());

        for(Integer key : namaHewan.keySet()){
            System.out.println(key);

        }

        for(String val : namaHewan.values()){
            System.out.println(val);

        }

        for(Map.Entry hashmap : namaHewan.entrySet()){
            System.out.print(hashmap.getKey());
            System.out.println(". "+hashmap.getValue());

        };

        System.out.println(namaHewan.containsKey(1));
        System.out.println(namaHewan.containsValue("ikan"));
*/
//        OOP

    }
}
