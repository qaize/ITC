package com.company;

public class Matakuliah {
    private String namaMatkul;
    private String Penjurusan;
    private int poin;

    public Matakuliah(){}
    public Matakuliah(String namaMatkul,String penjurusan,int poin){
        this.namaMatkul = namaMatkul;
        this.Penjurusan = penjurusan;
        this.poin = poin;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getPenjurusan() {
        return Penjurusan;
    }

    public void setPenjurusan(String penjurusan) {
        Penjurusan = penjurusan;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }
}
