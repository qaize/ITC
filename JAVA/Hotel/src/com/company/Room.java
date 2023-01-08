package com.company;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class Room {
  private String RoomNumber;
  private int floor;
  private String type;
  private BigDecimal PricePerNight;
  private List<Guest> history;

  public Room(){}
  public Room (String RoomNumber,int floor,String type,BigDecimal pricePerNight){
      this.RoomNumber = RoomNumber;
      this.floor = floor;
      this.type = type;
      this.PricePerNight = pricePerNight;
  }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPricePerNight() {
        return PricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        PricePerNight = pricePerNight;
    }

    public List<Guest> getHistory() {
        return history;
    }

    public void setHistory(List<Guest> history) {
        this.history = history;
    }

    public void printInfoRoom1st(){
        System.out.println(String.format("Lantai %d:%s",getFloor(),getRoomNumber()));
    }


}
