package com.company;

import java.math.BigDecimal;

public class Nasabah {
    private String noKartu;
    private String pin;
    private BigDecimal saldo;

    public Nasabah(){}

    public  Nasabah(String noKartu,String pin,BigDecimal saldo){
        this.noKartu = noKartu;
        this.pin = pin;
        this.saldo = saldo;
    }
}
