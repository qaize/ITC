package com.indocyber;

public class Main {

    public static void main(String[] args) {
        /* Kita bisa merubah data type setiap variable dengan beberapa metode:
         * Implicit Conversions
         * Explicit Conversions (Cast)
         * Conversion with Wrapper class: Ini merupakan salah satu kegunaan dari wrapper class.
         */

        /* Implicit Conversion adalah conversi yang sebenarnya tidak membutuhkan metode tertentu karena 2 variable memiliki format yang serupa
         * dan tidak memungkinkannya ada data yang hilang.
         */
        short bilangan16Bit = 34;
        int bilangan32Bit = bilangan16Bit;
        int bilanganInteger = 450;
        int bilangan64Bit = bilanganInteger;

        /* Explicit Conversion adalah conversi yang menggunakan (cast). Explicit Conversion bisa melakukan perubahan format dimana ada kemungkinan lost data.*/
        double bilanganDesimal = 56.78;
        int bilanganBulat = (int)bilanganDesimal;
        System.out.println(bilanganBulat);

        //Integer Parse
        int integer = 56;
        String integerToString = Integer.toString(integer); //Membutuhkan Wrapper class untuk conversion
        Integer objectInteger = integer; //Menggunakan Integer Wrapper class untuk conversion
        short integerToShort =  objectInteger.shortValue();
        long integerToLong = objectInteger.longValue();
        double integerToDouble = objectInteger.doubleValue();
        float integerToFloat = objectInteger.floatValue();

        //Double Parse
        double nilaiDouble = 45.67;
        String doubleToString = Double.toString(nilaiDouble);
        Double objectDouble = nilaiDouble;
        short doubleToShort = objectDouble.shortValue();
        long doubleToLong = objectDouble.longValue();
        int doubleToInt = objectDouble.intValue();
        float doubleToFloat = objectDouble.floatValue();

        //String Parse
        String integerText = "34";
        String floatingText = "34.56";
        int stringToInteger = Integer.parseInt(integerText);
        double stringToDouble = Double.parseDouble(floatingText);
    }
}
