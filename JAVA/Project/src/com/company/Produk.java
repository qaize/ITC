package com.company;

import com.company.Enum.FrekuensiPembayaran;
import com.company.Enum.JenisProduk;

import java.util.List;

public class Produk {
    private String namaProduk;
    private JenisProduk jenisProduk;
    private FrekuensiPembayaran frekuensiPembayaran;
    private List<Iuran> iuran;
    private String manfaat;

    public Produk(String namaProduk,JenisProduk jenisProduk, FrekuensiPembayaran frekuensiPembayaran,List<Iuran> iuran,String manfaat){
        this.namaProduk = namaProduk;
        this.jenisProduk = jenisProduk;
        this.frekuensiPembayaran = frekuensiPembayaran;
        this.iuran = iuran;
        this.manfaat = manfaat;
    }


}
