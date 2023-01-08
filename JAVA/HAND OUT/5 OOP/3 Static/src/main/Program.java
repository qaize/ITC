package main;

public class Program {
    /*
    * Di sini kita akan mencoba static dan non static member pada sebuah Class dan object.
    * */
	public static void main(String[] args) {
		/*
		* Seluruh static member bisa diakses langsung dari Class, karena tidak ada keragaman, sehingga tidak ada gunanya object harus
		* terlebih dulu ada.
		* */
		Item.setBrand("Blue Jay");
		Item.setMadeIn("Indonesia");
		System.out.println(Item.getMadeIn());

		Item mobilePhone = new Item("Mobile A", 12);
		Item laptop = new Item("Laptop A", 24);

		/*
		* Apa pun objectnya, brand akan sama semua, karena bersifat static.
		* */
		System.out.println(mobilePhone.getBrand());
		System.out.println(laptop.getBrand());

		//Ketika kita set dan update static lewat satu object, object yang lain akan ikut kena dampaknya.
		mobilePhone.setBrand("Red Cardinal");
		System.out.println(laptop.getBrand());

		mobilePhone.printInfo();
		mobilePhone.printInfoInStatic();
	}
}
