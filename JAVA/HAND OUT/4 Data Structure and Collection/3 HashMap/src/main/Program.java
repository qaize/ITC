package main;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		/* Hash Map adalah tipe generic collection, dimana kita dipersilahkan menyimpan 2 value, yaitu key dan value.
		 * key berperan seperti index dalam array, tetapi bedanya key di dalam hash map memiliki tipe data yang di define sendiri.
		 * 
		 * Keunggulan hash map adalah tipe collection yang memiliki keunggulan dalam hal seleksi dan penambahan, tetapi boros di memory,
		 * karena technically key merupakan index dengan chunk of memory sebesar variable value.
		 * */
        HashMap<Integer, String> mapOne = new HashMap<>();
        mapOne.put(3, "Tiga");
        mapOne.put(66, "Enam puluh enam");
        mapOne.put(12, "Twelve");        
        
        HashMap<String, String> mapTwo = new HashMap<>();
        mapTwo.put("Silver", "Penny");
        mapTwo.put("Gold", "Trophy");
        mapTwo.put("Platinum", "Card");
        
        System.out.printf("Dari dictionary satu, cari value dari 3: %s\n", mapOne.get(3));
        System.out.printf("Banyak item dari dicitionary one: %d\n", mapOne.size());
        System.out.printf("Dari dictionary three, cari value dari Gold: %s\n", mapTwo.get("Gold"));        

        //Cara iterate keynya saja
        for(Integer key : mapOne.keySet()){
            System.out.println(key);
        }

        //Cara iterate valuenya saja
        for(String value : mapOne.values()){
            System.out.println(value);
        }

        //Cara iterate keduanya.
        for(HashMap.Entry node : mapOne.entrySet()){
            System.out.println(node.getKey()+" "+node.getValue());    
        }

        //Key digunakan sebagai pengganti index
        mapOne.remove(66);

        //Menghapus total
        mapOne.clear();

        //Karena key bertindak sebagai index, pencarian dengan key akan jauh lebih cepat daripada pencarian value langsung.
        boolean containSilver = mapTwo.containsKey("Silver");
        boolean containTrophy = mapTwo.containsValue("Trophy");
	}
}