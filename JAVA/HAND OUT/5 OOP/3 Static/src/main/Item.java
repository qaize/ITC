package main;

public class Item {
    /*
    * static adalah suatu statement yang bisa diberikan pada member dari sebuah class kecuali constructor.
    * suatu member yang dinyatakan static akan bersifat tidak memiliki keragaman pada setiap object.
    * */

    //Setiap object memiliki nama yang berbeda-beda, oleh karena itu name non-static
    private String name;

    //Semua item yang diciptakan di class ini akan memiliki brand yang sama.
    private static String brand;
    private int stock;
    private static String madeIn;

    /*
    * static member tidak bisa exist di dalam constructor, karena ide membuat constructor sendiri adalah alat untuk
    * membuat keragaman object dengan menggunakan class ini.
    * */
    public Item() {
    }
    public Item(String name, int stock) {
        this.name = name;
        this.stock = stock;
        //this.brand static member tidak bisa menggunakan this statement, karena tidak ada konsep "this and that" (ini dan itu) dalam static, semuanya sama.
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static void setBrand(String argBrand) {
        brand = argBrand;
    }
    public static String getBrand() {
        return brand;
    }
    public static String getMadeIn() {
        return madeIn;
    }
    public static void setMadeIn(String madeIn) {
        Item.madeIn = madeIn;
    }

    /*
    * Member static dan non-static bisa digunakan pada member static.
    * Tetapi member static hanya bisa menerima member static lagi di dalamnya.
    * */
    public static void printInfoInStatic(){
        System.out.printf("Brand: %s, Made In: %s\n", brand, madeIn);
        //System.out.printf("Name: %s, Stock: %s\n", this.name, this.stock);
    }
    public void printInfo(){
        System.out.printf("Name: %s, Stock: %s\n", this.name, this.stock);
        System.out.printf("Brand: %s, Made In: %s\n", brand, madeIn);
    }
}
