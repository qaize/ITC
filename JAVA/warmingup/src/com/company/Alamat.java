package com.company;

public class Alamat {
    private String negara;
    private String state;
    private String kota;
    private String alamat;

    public Alamat(String negara,String state,String kota,String alamat){
        this.negara = negara;
        this.state = state;
        this.kota = kota;
        this.alamat = alamat;
    }

    public void setNegara(String negara){
        this.negara = negara;
    }
    public String getNegara(){return this.negara;}

    public void setState(String state){
        this.state = state;
    }
    public String getState(){return this.state;}

    public void setKota(String kota){
        this.kota = kota;
    }
    public String getKota(){return this.kota;}

    public void  setAlamat(String alamat){
        this.alamat = alamat;
    }
    public String getAlamat(){return this.alamat;}


    public void printAlamat(){
        System.out.println(String.format("Negara : %s,State : %s, Kota : %s, Alamat : %s",this.negara,this.state,this.kota,this.alamat));

    }
}
