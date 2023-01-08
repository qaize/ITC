package com.company;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

//Interface isinya wajib digunakan oleh class yang mengimplementasikannya
public class Mahasiswa implements IPerson {
    private String namaDepan;
    private String  namaBelakang;
    private String TmptLahir;
    private LocalDate tglLahir;
    private String jenisKelamin;
    private String alamat;
    private String noTelepon;
    private List<Kendaraan> listkendaraan;


//    semua Method dari IPerson harus ada
    @Override
    public void setNamaDepan(String namaDepan){
        this.namaDepan = namaDepan;
    }
    @Override
    public  String getNamaDepan(){
        return this.namaDepan;
    }
    @Override
    public void setNamaBelakang(String namaBelakang){
        this.namaBelakang = namaBelakang;
    }
    @Override
    public  String  getNamaBelakang(){
        return this.namaBelakang;
    }
    @Override
    public  void  setTempatLahir(String tmpLahir){
        this.TmptLahir = tmpLahir;

    }
    public  String  getTempatLahir(){
        return this.TmptLahir;
    }

    public  void setTanggalLahir(LocalDate date){
        this.tglLahir = date;
    }
    public  LocalDate  getTanggalLahir(){
        return this.tglLahir;
    }

    public void  setJenisKelamin(String kelamin){
        this.jenisKelamin = jenisKelamin;
    }
    public  String  getJenisKelamin(){
        return this.jenisKelamin;
    }

    public  void  setAlamat(String Alamat){
        this.alamat = Alamat;
    }
    public  String  getAlamat(){
        return this.alamat;
    }
    @Override
    public  void  setNoTelepon(String noTelepon){
        this.noTelepon = noTelepon;
    }
    @Override
    public  String getNotelepon(){
        return this.noTelepon;
    }

    public void setListKendaraan(List<Kendaraan> ListKendaraan){
        this.listkendaraan = ListKendaraan;
    }

    public List<Kendaraan> getListKendaraan(){
        return this.listkendaraan;
    }

    public void PrintInfoMahasiswa (){
        System.out.println(String.format("Nama : %s %s",this.namaDepan,this.namaBelakang));
        System.out.println();

        System.out.println("List Kendaraan :");
        PrintListKendaraan();
    }

    private void PrintListKendaraan(){

        for(Kendaraan kendaraan : this.listkendaraan){
            kendaraan.printInfoKendaraan();
        }
    }

}
