package com.company;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Pembeli extends Person {
    private int noCustomer;
    private BigDecimal cash;
    Locale indo = new Locale("id","ID");
    private Alamat alamat;

    public Pembeli() { super(); }

    public Pembeli(int noCustomer, String namaDpn, String namaBlkg,LocalDate tglLahir,BigDecimal cash,Alamat alamat){
        super(namaDpn,namaBlkg,tglLahir);
        this.noCustomer = noCustomer;
        this.cash = cash;
        this.alamat = alamat;
    }

    public  void setNoCustomer(int noCustomer){
        this.noCustomer = noCustomer;
    }
    public int getNoCustomer(){return  this.noCustomer;}


    public void setCash(BigDecimal cash ){
        this.cash = cash;
    }
    public BigDecimal getCash(){return this.cash;}



    public String HitungUmur(){
        LocalDate Today = LocalDate.now();
        long usia = ChronoUnit.YEARS.between(getTglLahir(),Today);
        String hasil = Long.toString(usia);
        return hasil;

    }

    public String FormatUang(BigDecimal duit){

        String formatIndonesia = NumberFormat.getCurrencyInstance(indo).format(duit);

        return formatIndonesia;

    }

    public void printInfoPembeli(){
        System.out.println(String.format("Customer nomor: %d, %s %s. Sekarang berumur %s tahun dengan digital Cash %s"
                ,this.noCustomer,getNamaDpn(),getNamaBlkg(),(HitungUmur()),(FormatUang(this.cash))));


    }


}
