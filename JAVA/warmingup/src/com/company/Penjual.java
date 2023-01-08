package com.company;

import java.time.LocalDate;
import java.util.List;

import listEnum.Level;
public class Penjual extends Person {
    private String namaToko;
    private Level level;
    private List<Barang> listJualan;

    public Penjual (String namaDpn, String namaBlkng, LocalDate tglLahir, String namaToko, Level level){

        super(namaDpn,namaBlkng,tglLahir);
        this.namaToko = namaToko;
        this.level  = level;
    }

    public void setNamaToko (String namaToko){

        this.namaToko = namaToko;
    }
    public String getNamaToko(){return this.namaToko;}

    public void setListJualan(List<Barang> ListJualan){
        this.listJualan = ListJualan;
    }

    public void printJumlahBarang(){
        for(Barang brg : listJualan){
            brg.printBarang();
        }
    }

    public void printInfoPenjual(){
        System.out.println(String.format("Nama Pemilik Toko: %s %s ",getNamaDpn(),getNamaBlkg()));
        System.out.println(String.format("tgl.Lahir : %s",getTglLahir()));
        System.out.println("Level : "+level);
    }
}
