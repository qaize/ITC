package com.company.Enum;

public enum MetodePembayaran {
    CREDIT_CARD(" Credit Carrd","CC"),
    AUTO_DEBIT("Auto Debit","AD"),
    VOUCHER_PRABAYAR("Voucher Prabayar","VP");

    private String pembayaran;
    private String inisial;

     MetodePembayaran(String pembayaran,String inisial){
        this.pembayaran = pembayaran;
        this.inisial = inisial;
    }


    public String getPembayaran() {
        return this.pembayaran;
    }

    public String getInisial() {
        return this.inisial;
    }

}
