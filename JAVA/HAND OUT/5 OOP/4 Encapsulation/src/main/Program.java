package main;

import external.Citizen;
//tidak bisa import Employee

public class Program {

	public static void main(String[] args) {
        //Public : Dapat di akses oleh semuanya, baik lain assembly, lain class, dan lain-lain.
        //Private : Hanya bisa diakses oleh class yang sama.
        //Protected : Bisa dipakai dengan bebas seperti public oleh class satu package, tetapi hanya bisa digunakan keturunannya di class yang berada
            //di dalam package yang berbeda.
        //Default : Bisa diakses dimana saja selama berada di dalam satu package. Default tidak perlu ditulis apa-apa.

		//Hanya Public dan Default yang bisa digunakan pada Class.
        /* Mecoba memakai semua fungsi Resident dan Salesman*/
        Salesman salesman = new Salesman();

        int publicSalesmanProperty = salesman.publicSalesmanField;
        salesman.publicSalesmanMethod();
        salesman.usingMethodOfResident();
        //Tidak bisa akses private property dan method dari Salesman
        //Tidak bisa akses protected property dan method dari Salesman
        int defaultSalesmanField = salesman.defaultSalesmanField;
        salesman.defaultSalesmanMethod();
        int protectedInternalSalesmanField = salesman.protectedSalesmanField;

        Citizen city = new Citizen();
        String publicCitizenProperty = city.defaultCitizenField;


	}
}
