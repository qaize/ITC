package main;

public class Program {

	public static void main(String[] args) {
		
		/*
		  Variable dibagi menjadi 2 macam berdasarkan sifatnya, yaitu: Value Type dan Reference Type.
		  
		  Value Type: akan menciptakan duplikat pada saat pass nilainya di dalam argument/parameter. (Variable)
		  Reference Type: akan mem-passing alamat / referensi di argument/parameter pada saat invoking function
		 */
		
		int sebuahAngka = 56;
		String sebuahKata = "Hello";
		Person seseorang = new Person("Dmitri Ivannoski", 31);
		
		changeValue(sebuahAngka, sebuahKata, seseorang);

		System.out.println("\n==========Di dalam main function============\n");
		
		System.out.print("Sebuah angka: ");
		System.out.println(sebuahAngka);
		System.out.print("Sebuah kata: ");
		System.out.println(sebuahKata);
		System.out.printf("Nama orang: %s dan umurnya: %d\n", seseorang.getName(), seseorang.getAge());		
	}
	
	public static void changeValue(int integer, String word, Person orang) {
		System.out.print("Sebuah angka: ");
		System.out.println(integer);
		System.out.print("Sebuah kata: ");
		System.out.println(word);
		System.out.printf("Nama orang: %s dan umurnya: %d\n", orang.getName(), orang.getAge());
		
		System.out.println("\n==========Ubah Value di dalam Function============\n");
		
		integer = 99;
		word = "Goodbye";
		orang.setName("Michael Harris");
		orang.setAge(12);
		
		System.out.print("Sebuah angka: ");
		System.out.println(integer);
		System.out.print("Sebuah kata: ");
		System.out.println(word);
		System.out.printf("Nama orang: %s dan umurnya: %d\n", orang.getName(), orang.getAge());		
	}

}
