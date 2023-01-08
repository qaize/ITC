package com.company;

import java.math.BigDecimal;

public interface IBarang {

    public void setNama(String nama);
    public String getNama();

    public void setHarga(BigDecimal harga);
    public BigDecimal getHarga();

    public void  setDeskripsi(String deskripsi);
    public String getDeskripsi();
}
