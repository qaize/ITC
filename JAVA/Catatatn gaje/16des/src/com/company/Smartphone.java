package com.company;

public class Smartphone extends Elektronik{

    private String OS;
    private int RAM;
    private int penyimanan;

    public void setO(String os){this.OS = os;}
    public String getOS(){return  this.OS;}

    public void setRAM(int ram){this.RAM = ram;}
    public int getRAM(){return this.RAM;}

    public void setPenyimanan(int penyimanan){this.penyimanan=penyimanan;}
    public int getPenyimanan(){return this.penyimanan;}

    public Smartphone(String merek, int tahunPembuatan, String tipe,String os, int ram, int penyimpanan){
        super(merek,tahunPembuatan,tipe);
        this.OS = os;
        this.RAM = ram;
        this.penyimanan = penyimpanan;
    }

    public void PrintInfo(){
        System.out.println("MREK "+getMerek());
        System.out.println(String.format("Smartphone dengan OS %s, RAM %d, dan Kapasitas Penyimpanan sebesar %d",
                this.OS,this.RAM,this.penyimanan));
    }

}
