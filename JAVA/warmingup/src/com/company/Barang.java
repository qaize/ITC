package com.company;

import java.math.BigDecimal;

public class Barang implements IBarang {
    private String nama;
    private BigDecimal harga;
    private String Deskripsi;


    public Barang (String nama, BigDecimal harga, String deskripsi){
        this.nama = nama;
        this.harga = harga;
        this.Deskripsi = deskripsi;

    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String getNama() {
        return this.nama;
    }

    @Override
    public void setHarga(BigDecimal harga) {
        this.harga = harga;

    }

    @Override
    public BigDecimal getHarga() {
        return this.harga;
    }

    @Override
    public void setDeskripsi(String deskripsi) {
        this.Deskripsi = deskripsi;

    }

    @Override
    public String getDeskripsi() {
        return this.Deskripsi;
    }

    public void printBarang(){
        System.out.println(String.format("Nama Barang : %s",this.nama));
        System.out.println(String.format(" Harga : %s",this.harga));
        System.out.println(String.format(" Deskripsi : %s\n",this.Deskripsi));
    }
}
