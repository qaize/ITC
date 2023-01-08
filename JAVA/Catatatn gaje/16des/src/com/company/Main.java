package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import Enum.agama;
import Enum.JenisKelamin;
import eksternal.departemen;

/*
explisit adalah konversi pemaksaan
implisit adalah ga makasa dari int ke long contoh
*
* */

public class Main {

    public static void main(String[] args) {
	// write your code here
      Elektronik hpJIGI = new Smartphone("JIGI",2025,"HP GIMANG",
              "SAIKO",14,128);

      Smartphone smartphone = (Smartphone)hpJIGI;

      smartphone.PrintInfo();



        /*

        departemen laladept = new departemen();
        laladept.setName("Marketing");
        laladept.setName("Tukang bagi lembaran");
        Employee lala = new Employee("lala",JenisKelamin.PEREMPUAN,"Mataram",LocalDate.of(1998,12,12),"0829987672","Jogja","EMP01",
                LocalDate.of(2021,2,3),agama.ISLAM,laladept);
        lala.setGaji(new BigDecimal(100000));
        departemen jojodept = new departemen();
        jojodept.setName("Guru");
        jojodept.setName("guru mtk");
        Employee jojo = new Employee("bejo",JenisKelamin.PEREMPUAN,"Mataram",LocalDate.of(1998,12,12),"0829987672","Papua","EMP02",
                LocalDate.of(2021,2,3),agama.ISLAM,jojodept);
        jojo.setGaji(new BigDecimal(7000000));

        departemen soradept = new departemen();
        soradept.setName("Artis");
        soradept.setDescription("Melukis manga");
        manager sora = new manager("sora",JenisKelamin.PEREMPUAN,"Hokaido",LocalDate.of(1998,12,12),"0829987672","Tokyo","EMP02",
                LocalDate.of(2021,2,3),agama.KATOLIK,soradept,(new BigDecimal(100000)));
        sora.setGaji(new BigDecimal(10999998));


        LinkedList<Employee> listEmployee = new LinkedList<>();
        listEmployee.add(lala);
        listEmployee.add(jojo);
        listEmployee.add(sora);

        for(Employee emList : listEmployee){
            emList.printinfoKaryawan();
            System.out.println("");
        }


Mahasiswa sora = new Mahasiswa();
      sora.setNamaDepan("Sora");
      sora.setNamaBelakang("himawari");
      sora.setTempatLahir("Tokyo");
      sora.setTanggalLahir(LocalDate.of(1999,12,12));
      sora.setJenisKelamin("Perempuan");
      sora.setAlamat("JL.Senang");


      List<Kendaraan> lisKendaraanSora = new LinkedList<>();
      lisKendaraanSora.add(new Kendaraan("Mobil","Hinda Jazz",2020,"F2223"));


      sora.setListKendaraan(lisKendaraanSora);
      sora.PrintInfoMahasiswa();




 */


//        System.out.println(bana);



    }

}
