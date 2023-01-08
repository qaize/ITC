package main;

import java.time.LocalDate;
import java.util.*;
import java.math.*;
import java.text.*;

public class Program {
	public static void main(String[] args) {
//		Person michael = new Person("Michael Shanon", new GregorianCalendar(1988, 10, 20), "Jakarta", "Male", "31279523490088", "Christian", "O", 172, 69.55, "Indonesia");
        Student sarah = new Student("Sarah Brightman", new GregorianCalendar(1987, 11, 30), "California", "Female", "30334589793455", "Buddhist", "A", 180, 60.78, "USA", "MIT",
                "Massachusset", "IT", new GregorianCalendar(2018, 12, 27), 4);
//        Customer ricky = new Customer("Ricky Gervais", new GregorianCalendar(1984, 12, 12), "London", "Male", "234888890888909009", "Christian", "B", 145, 67.89, "England",
//                "R556", new BigDecimal(5600000.50), new BigDecimal(50500), new GregorianCalendar(2016, 10, 24));
        Employee rudy = new Employee("Rudy Wijaya", new GregorianCalendar(1987, 2, 5), "Bandung", "Male", "45677900004523422", "Moslem", "O", 170, 75.50, "Indonesia", "R2340888",
                "IT", 6, new BigDecimal(575000), new GregorianCalendar(2012, 11, 5));
        Employee damar = new Employee("Damar Sianturi", new GregorianCalendar(1987, 2, 5), "Aceh", "Male", "4567790000454552", "Moslem", "O", 170, 75.50, "Indonesia", "R2355888",
                "IT", 6, new BigDecimal(575000), new GregorianCalendar(2012, 11, 5));
        List<Employee> groupEmployees = new LinkedList<Employee>();
        groupEmployees.add(rudy);
        groupEmployees.add(damar);
//        Manager robert = new Manager("Robert Downey", new GregorianCalendar(1985, 2, 5), "Bali", "Male", "45677900002344422", "Moslem", "O", 175, 65.50, "Indonesia", "R2340888",
//                "IT", 6, new BigDecimal(575000), new GregorianCalendar(2012, 11, 5), 23.5, "Store Manager", "Legian", groupEmployees);
//
//        //Sarah bisa mengakses method Person maupun Student
//        System.out.println(sarah.getName());
//        System.out.println(sarah.getUniversity());
//        sarah.printPersonalInformation();
//        sarah.printEducationInformation();
////        sarah.printEmployeeInfo();
//
//        //Robert bisa mengakses method Person, Employee, dan Manager
//        System.out.println(robert.getName());
//
//        SimpleDateFormat fullFormat = new SimpleDateFormat("dd-MMMM-yyyy");
//        System.out.println(fullFormat.format(robert.getHiredDate().getTime()));
//        System.out.println(robert.getManagerType());
//        robert.printPersonalInformation();
//        robert.printManagerialInfo();
//
//        //overriding method
//        rudy.printEmployeeInfo();
//        robert.printEmployeeInfo();
//
//        /* Polymorphism: dalam bahasa yunani Poly dan Morph yang artinya banyak bentuk.
//         * Polymorphism memanfaatkan super class dari setiap jenis class object nya, sehingga semua bisa di declare ke dalam satu bentuk.
//         */
        Person cindy = new Student("Cindy Garcia", new GregorianCalendar(1987, 11, 30), "California", "Female", "30334589793455", "Buddhist", "A", 180, 60.78, "USA", "MIT",
            "Massachusset", "IT", new GregorianCalendar(2018, 12, 27), 4);
        Person garry = new Customer("Garry Oldman", new GregorianCalendar(1984, 12, 12), "London", "Male", "234888890888909009", "Christian", "B", 145, 67.89, "England",
            "R556", new BigDecimal(5600000.50), new BigDecimal(50500), new GregorianCalendar(2016, 10, 24));
        Person brian = new Employee("Brian Soprano", new GregorianCalendar(1987, 2, 5), "Medan", "Male", "456667000400422", "Christian", "O", 170, 75.50, "Indonesia", "R2340888",
            "IT", 8, new BigDecimal(577000), new GregorianCalendar(2010, 8, 5));
        Person arifin = new Manager("Arifin Nurwansa", new GregorianCalendar(1985, 2, 5), "Bali", "Male", "456779000444422", "Hindu", "O", 175, 65.50, "Indonesia", "R236788",
            "IT", 6, new BigDecimal(575000), new GregorianCalendar(2012, 11, 5), 23.5, "Store Manager", "Legian", groupEmployees);

        Person personRudi = rudy;
        List<Person> kelompokManusia = new LinkedList<Person>();
        kelompokManusia.add(cindy);
        kelompokManusia.add(garry);
        kelompokManusia.add(brian);
        kelompokManusia.add(arifin);
        kelompokManusia.add(sarah);

        Person michael = new Person("Michael Shanon", new GregorianCalendar(1988, 10, 20), "Jakarta", "Male", "31279523490088", "Christian", "O", 172, 69.55, "Indonesia");

        for (Person manusia : kelompokManusia) {
            manusia.printPersonalInformation();
        }
//
        //Polymorphism in overriding
        Employee aji = new Employee("Aji Sanjaya", new GregorianCalendar(1980, 2, 17), "Bandung", "Male", "45677900004523422", "Moslem", "O", 170, 75.50, "Indonesia", "R2340888",
            "IT", 6, new BigDecimal(575000), new GregorianCalendar(2012, 11, 5));

        Employee sakti = new Manager("Sakti Kutrapali", new GregorianCalendar(1985, 2, 5), "India", "Male", "45677900002344422", "Hindu", "O", 175, 65.50, "India", "R2340888",
            "IT", 6, new BigDecimal(575000), new GregorianCalendar(2012, 11, 5), 23.5, "Store Manager", "Legian", groupEmployees);

        //keduanya akan menggunakan method pada super class, yaitu employee class, karena deklarasi tipe datanya di parent.
        aji.printEmployeeInfo();
        sakti.printEmployeeInfo();

        Student jodi = new Student("Jodi Pusaka", new GregorianCalendar(1996, 12, 30), "Aceh", "Male", "30334589793455", "Moslem", "A", 180, 60.78, "USA", "MIT",
        		"Massachusset", "IT", new GregorianCalendar(2018, 12, 27), 4);
        Student ronald = new PhdStudent("Ronald Wijaya", new GregorianCalendar(1988, 10, 21), "Surabaya", "Male", "3133454345745", "Moslem", "A", 180, 60.78, "USA", "MIT",
                "Massachusset", "IT", new GregorianCalendar(2018, 12, 27), 4);

        jodi.printEducationInformation();
        ronald.printEducationInformation();

        Customer edo = new Customer("111111", "Edo",
                LocalDate.of(1990, 10,10), "Bandung", "Laki-laki", "1234567890");
	}
}
