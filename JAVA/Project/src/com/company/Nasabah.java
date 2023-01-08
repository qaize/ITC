package com.company;

import com.company.Enum.JenisKelamin;
import com.company.Enum.MetodePembayaran;
import com.company.Enum.StatusKK;

import java.time.LocalDate;

public class Nasabah extends Person {
    private Integer noProspectCalon;
    private String noNasabah;
    private String noKtp;
    private StatusKK statusDiKK;
    private MetodePembayaran metodePembayaran;
    private Produk produk;

    public Nasabah(Integer noProspect, String noNasabah, String namaDpn, String namaBlkng,String noKtp, LocalDate tglLahir, String tempatLahir,
                   JenisKelamin jenisKelamin, String perkerjaan, StatusKK statusDiKK,MetodePembayaran metodePembayaran,Produk produk){
        super(namaDpn,namaBlkng,tglLahir,tempatLahir,jenisKelamin,perkerjaan);
        this.noProspectCalon = noProspect;
        this.noNasabah = noNasabah;
        this.noKtp = noKtp;
        this.statusDiKK = statusDiKK;
        this.metodePembayaran = metodePembayaran;
        this.produk = produk;

    }

    public Integer getNoProspectCalon() {
        return noProspectCalon;
    }

    public void setNoProspectCalon(Integer noProspectCalon) {
        this.noProspectCalon = noProspectCalon;
    }

    public String getNoNasabah() {
        return noNasabah;
    }

    public void setNoNasabah(String noNasabah) {
        this.noNasabah = noNasabah;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public StatusKK getStatusDiKK() {
        return statusDiKK;
    }

    public void setStatusDiKK(StatusKK statusDiKK) {
        this.statusDiKK = statusDiKK;
    }

    public MetodePembayaran getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(MetodePembayaran metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }
}
