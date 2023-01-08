package com.company;

import java.time.LocalDate;

public class company {
    private String nama;
    private LocalDate TanggalBerdiri;

    public void setName (String nama) {this.nama = nama;};
    public void setTanggalBerdiri (LocalDate date){this.TanggalBerdiri = date;}

    public String getName (){return this.nama;}
    public LocalDate getTanggalBerdiri(){return this.TanggalBerdiri;}
}
