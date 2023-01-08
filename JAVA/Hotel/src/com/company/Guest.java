package com.company;

import com.company.Enum.Kelamin;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import com.company.Main;

public class Guest extends Person {
    private String noReg;
    private LocalDate CheckIn;
    private LocalDate CheckOut;
    private Room Room;
    private List<Guest> family;
    private BigDecimal pendapatan;

    public Guest (){super();}
    public Guest (String noReg, String namaDpn, String namaBlkng, String tmptLahir, LocalDate tglLahir, Kelamin jenisKelamin, String noKtp,
                  LocalDate checkIn, LocalDate checkOut, Room room){
        super(namaDpn,namaBlkng,tmptLahir,tglLahir,jenisKelamin,noKtp);
        this.noReg = noReg;
        this.CheckIn = checkIn;
        this.CheckOut = checkOut;
        this.Room = room;


    }


    public String getNoReg() {
        return noReg;
    }

    public void setNoReg(String noReg) {
        this.noReg = noReg;
    }

    public LocalDate getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        CheckIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        CheckOut = checkOut;
    }

    public void printInfoGuest1st(){
        System.out.println(String.format("%s %s dengan Nomor Register : %s",getNamaDpn(),getNamaBlkng(),getNoReg()));
    }

    public List<Guest> getFamily() {
        return family;
    }

    public void setFamily(List<Guest> family) {
        this.family = family;
    }
    public Room getRoom(){
         return this.Room;
    }

    Locale indonesia = new Locale("id", "ID");
    DateTimeFormatter indoFormat = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", indonesia);
    DateTimeFormatter indoFormatNoDayName = DateTimeFormatter.ofPattern("dd MMMM yyyy", indonesia);

    public void printInfoGuestFull(){
        Locale indonesia = new Locale("id", "ID");
        BigDecimal multi = new BigDecimal(ChronoUnit.DAYS.between(getCheckIn(), getCheckOut()));
        BigDecimal gain = Room.getPricePerNight().multiply(multi);
        setPendapatan(gain);
        System.out.println("First Name : "+getNamaDpn());
        System.out.println("Last Name : "+getNamaBlkng());
        System.out.println("Gender : "+getJenisKelamin());
        System.out.println("Birth Information : "+Main.convertTanggal(getTglLahir(),"dd MMMM yyyy")+" ( "+ChronoUnit.YEARS.between(getTglLahir(), LocalDate.now())+" Tahun )");
        System.out.println("ID Card : "+getNoKtp());
        System.out.println("Menginap selama : "+ChronoUnit.DAYS.between(getCheckIn(), getCheckOut())+" Hari ");
        System.out.println("Biaya Penginap : "+(NumberFormat.getCurrencyInstance(indonesia).format(gain)));
        System.out.println("Menginap di : ");
        System.out.println("Room Number : "+Room.getRoomNumber());
        System.out.println("Floor : "+Room.getFloor());
        System.out.println("Room Type : "+Room.getType());
        System.out.println("Anggota Keluarga : ");

        if(this.family != null) {
            for (Guest gs : this.family) {
                gs.printInfoGuest1st();
            }
        }
        else{
            System.out.println("Tidak ada Anggota Keluarga alias SOLO");
        }

    }

    public void printRoomHistory(){
        System.out.println(String.format("%s - %s (%s %s, %s)",indoFormatNoDayName.format(getCheckIn()),indoFormatNoDayName.format(getCheckOut()),getNamaDpn(),getNamaBlkng(),getNoReg()));
    }


    public BigDecimal getPendapatan() {
        BigDecimal multi = new BigDecimal(ChronoUnit.DAYS.between(getCheckIn(), getCheckOut()));
        BigDecimal gain = Room.getPricePerNight().multiply(multi);
        setPendapatan(gain);
        return this.pendapatan;
    }

    private void setPendapatan(BigDecimal pendapatan) {
        this.pendapatan = pendapatan;
    }
}
