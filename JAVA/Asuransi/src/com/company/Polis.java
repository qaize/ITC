package com.company;

import com.company.Enum.TanggunganAsuransi;

import java.time.LocalDate;

public class Polis {
    private Nasabah pemilikPolis;
    private Nasabah TertanggunganAsuransi;
    private Produk produk;
    private LocalDate tanggalMulaiPolis;
    private String manfaatProduk;

    public Polis (Nasabah pemilikPolis,Produk produk,Nasabah tertanggunganAsuransi,
                  LocalDate tanggalMulaiPolis,String manfaatProduk){
        this.pemilikPolis = pemilikPolis;
        this.TertanggunganAsuransi = tertanggunganAsuransi;
        this.produk = produk;
        this.tanggalMulaiPolis = tanggalMulaiPolis;
        this.manfaatProduk = manfaatProduk;

    }

    public Nasabah getPemilikPolis() {
        return pemilikPolis;
    }

    public void setPemilikPolis(Nasabah pemilikPolis) {
        this.pemilikPolis = pemilikPolis;
    }

    public Nasabah getTertanggunganAsuransi() {
        return TertanggunganAsuransi;
    }

    public void setTertanggunganAsuransi(Nasabah tertanggunganAsuransi) {
        TertanggunganAsuransi = tertanggunganAsuransi;
    }

    public LocalDate getTanggalMulaiPolis() {
        return tanggalMulaiPolis;
    }

    public void setTanggalMulaiPolis(LocalDate tanggalMulaiPolis) {
        this.tanggalMulaiPolis = tanggalMulaiPolis;
    }

    public String getManfaatProduk() {
        return manfaatProduk;
    }

    public void setManfaatProduk(String manfaatProduk) {
        this.manfaatProduk = manfaatProduk;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }
}
