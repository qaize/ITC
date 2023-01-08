package main;

import java.time.*;
import java.math.*;

/* Interface adalah kontrak atau template keharusan dari setiap class atau interface lain yang mewariskannya untuk mengikuti setiap member yang interface tuliskan.
 * Sifat-sifat interface adalah:
 * 1.Semua class yang mewariskan interface harus memiliki method yang dituliskan interface.
 * 2.Interface hanya bisa inherit dari interface lain.
 * 3.Seluruh method di dalam interface hanya bisa di deklarasi, tetapi tidak bisa diimplementasikan.
 * 4.Naming convention dari interface sama seperti class, bedanya ada huruf I besar di depan namanya.
 * 5.Interface gak bisa di instantiate atau dibuat objectnya secara langsung.
 * 6.Satu class bisa inherit lebih dari satu interface.
 */

/* Abstract class adalah campuran daripada interface dan base class biasa.
 * Sifat-sifat abstract class kurang lebih:
 * 1. Tidak bisa di instantiate seperti Interface, karena tidak ada gunanya membuat object dari class yang sifatnya abstrak.
 * 2. Tidak seperti Interface, abstract bisa memiliki member yang diimplementasi
 * 3. Method yang tidak diimplementasi dan menjadi contract, di label sebagai abstract.
 * 4. Method abstract wajib di override di class yang menjadi keturunannya.
 * 5. Sisa method yang tidak di declare abstract akan bersifat seperti member dari super class biasa.
 */

//Tidak bisa instantiate Electronic, Employee, ICitizen, IMobilePhone, IPerson, IResident, Item

public class Program {

	public static void main(String[] args) {
//
//		Customer alexa = new Customer();
//		alexa.setFirstName("Alexa");
//		alexa.setLastName("Red");
//		alexa.setGender("Female");
//		alexa.setBirthDate(LocalDate.of(1989, Month.OCTOBER, 21));
//		alexa.setBirthPlace("Jakarta");
//		alexa.setIDCardNumber("314999006788");
//		alexa.setCitizenship("Indonesia");
//		alexa.setMaritalStatus("Single");
//		alexa.setMemberCode("KC8371934");
//		alexa.setBalance(new BigDecimal(500000));
//
////		IPerson a = new IPerson();
//
//		IPerson susan = new Customer("KC8371934", new BigDecimal(500000)); //Bisa di set di constructor saja.
//		susan.setFirstName("Susan");
//		susan.setLastName("Ryle");
//		susan.setGender("Female");
//		susan.setBirthDate(LocalDate.of(1978, Month.OCTOBER, 21));
//		susan.setBirthPlace("Jakarta");
//		susan.setIDCardNumber("314999006788");
//		susan.setCitizenship("Indonesia");
//		susan.setMaritalStatus("Single");
////		susan.setMemberCode("KC8371934");
////		susan.setBalance(new BigDecimal(500000));
//
//	    System.out.println("==================== ALEXA THE CUSTOMER ======================");
//	    long umurAlexa = alexa.calculateAge();
//	    alexa.printBiodata();
//	    alexa.printPersonIdentity();
//	    alexa.printMemberInformation();
//	    System.out.println("==============================================================\n");
//
//	    System.out.println("==================== SUSAN THE IPERSON, CUSTOMER ======================");
//	    long umurSusan = susan.calculateAge();
//	    susan.printBiodata();
//	    susan.printPersonIdentity();
//	    System.out.println("==============================================================\n");
//
//	    TaxResident john = new TaxResident();
//	    john.setVisaStatus("Citizen");
//	    john.setTaxFileNumber("HG768324XNN");
//	    john.setVisaGrantTime(LocalDate.of(1978, Month.OCTOBER, 21));
//	    john.setFirstName("John");
//	    john.setLastName("Connor");
//	    john.setGender("Male");
//	    john.setBirthDate(LocalDate.of(1978, Month.OCTOBER, 21));
//		john.setBirthPlace("Jakarta");
//		john.setIDCardNumber("314999006788");
//	    john.setCitizenship("United States of America");
//		john.setMaritalStatus("Married");
//		john.setCitizenMedicalInsuranceProgram(true);
//	    john.setCitizenLifeInsuranceProgram(false);
//		john.setCitizenRetirementProgram(false);
//
//	    System.out.println("==================== JOHN THE TAX RESIDENT ======================");
//	    long umurJohn = john.calculateAge();
//	    john.printBiodata();
//	    john.printPersonIdentity();
//	    john.payTax();
//	    john.residencyInformation();
//	    System.out.println("==============================================================\n");
//
//	    IResident andre = new TaxResident();
//	    ICitizen silvia = new TaxResident();
//	    IPerson sumandi = new TaxResident();
//
//	    Manager sheldon = new Manager("Temporary Resident", "JK7998714VVN", LocalDate.of(2012, Month.NOVEMBER, 12), "Sheldon",
//	            "Cooper", "Male", LocalDate.of(1967, Month.NOVEMBER, 8), "Texas", "93417923741093824", "USA", "Single");
//	    sheldon.setEmployeeNumber("123");
//	    sheldon.setHireDate(LocalDate.of(2012, Month.JULY, 22));
//	    sheldon.setSalary(new BigDecimal(7000000));
//
//        System.out.println("==================== SHELDON THE MANAGER ======================");
//        long umurSheldon = sheldon.calculateAge();
//        sheldon.employeeInformation();
//        sheldon.payTax();
//        sheldon.printBiodata();
//        sheldon.printPersonIdentity();
//        sheldon.residencyInformation();
//        sheldon.getAnnualSalary();
//        sheldon.yearsOfWorking();
//        System.out.println("==============================================================\n");

//		Employee vina = new Employee();

        Employee brian = new Manager("Temporary Resident", "JK799KJDLFJ", LocalDate.of(2012, Month.NOVEMBER, 12), "Brian",
                "Soprano", "Male", LocalDate.of(1967, 10, 8), "Texas", "93417923741093824", "USA", "Single");
        IResident mustafa = new Manager("Temporary Resident", "JK788KDFJFJ", LocalDate.of(2012, Month.NOVEMBER, 12), "Mustafa",
            "Mamfud", "Male", LocalDate.of(1987, 10, 8), "Saudi Arabia", "93417923741093824", "Saudi Arabia", "Married");
            
        Item permata = new Jewelries("9837592734", "gelang permata", "brumani", new BigDecimal(50000000), "platinum");
        Item iphone = new SmartPhone("7491273941", "iphone 6", "Apple", new BigDecimal(10000000), 2, "GSM", "IOS");
        Item cocaCola = new SoftDrink("874917234829", "coca-cola", "Coca Cola", new BigDecimal(5000), LocalDate.of(2019, Month.OCTOBER, 19));

		//Item laptop = new Item("356148156435", "Laptop Lenovo G40", "Lenovo", new BigDecimal(12000000));
		Electronic hp = (Electronic) iphone;
		System.out.println(hp.getYearsOfWarranty());

		Electronic ip = (SmartPhone) iphone;
		System.out.println(ip.getPrice());
		SmartPhone smartIp = (SmartPhone) iphone;
		System.out.println(smartIp.getPrice());
	}	
}
