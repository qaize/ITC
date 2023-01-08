package com.company;

import com.company.Enum.Darah;
import com.company.Enum.Kelamin;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    static boolean check=false;
    static List<Room> listRoom = new LinkedList<>();
    static List<Guest> listGuest = new LinkedList<>();

    public static void main(String[] args) {
	// write your code here
        /* Data */
        DataAll();
        /* Menu */
        menuUtama();
    }

    /*All Data*/
    public static void DataAll(){


        /* Room List */
        Room r301 = new Room("301",3,"Regular Single Bed",new BigDecimal(800000));
        Room r302 = new Room("302",3,"Regular Double Bed",new BigDecimal(1000000));
        Room r303 = new Room("303",3,"Regular Twin Bed",new BigDecimal(1200000));
        Room r401 = new Room("401",4,"VIP Single Bed",new BigDecimal(1200000));
        Room r402 = new Room("402",4,"VIP Double Bed",new BigDecimal(1300000));
        Room r403 = new Room("403",4,"VIP Twin Bed",new BigDecimal(1400000));

        listRoom.add(r301);
        listRoom.add(r302);
        listRoom.add(r303);
        listRoom.add(r401);
        listRoom.add(r402);
        listRoom.add(r403);


        /* Data Guest */
        Guest Danny = new Guest("A021","Danny","Tan","Beijing", LocalDate.of(1990,11,23),
                Kelamin.LAKI_LAKI,"312008923111990002",LocalDate.of(2022,4,12),LocalDate.of(2022,4,14),r301);

        Guest Dessy = new Guest("A022","Dessy","Wang","Beijing", LocalDate.of(1990,11,1),
                Kelamin.PEREMPUAN,"312008661111990004",LocalDate.of(2022,4,12),LocalDate.of(2022,4,14),r301);

        Guest Sunarti = new Guest("A023","Sunarti","Wijaya","Bandung", LocalDate.of(1985,4,18),
                Kelamin.PEREMPUAN,"312007023111990003",LocalDate.of(2022,5,15),LocalDate.of(2022,5,17),r302);

        Guest Ardi = new Guest("A024","Ardi","Wijaya","Bandung", LocalDate.of(1985,4,18),
                Kelamin.LAKI_LAKI,"312008901081990017",LocalDate.of(2022,5,15),LocalDate.of(2022,5,17),r302);

        Guest Muliawan = new Guest("A025","Muliawan","Sanjaya","Jakarta", LocalDate.of(2000,10,10),
                Kelamin.LAKI_LAKI,"3120085660102000889",LocalDate.of(2022,5,15),LocalDate.of(2022,5,17),r302);

        Guest Tirta = new Guest("A026","Tirta","Raharja","Jakarta", LocalDate.of(1985,10,14),
                Kelamin.LAKI_LAKI,"31200344014101988334",LocalDate.of(2022,5,15),LocalDate.of(2022,5,20),r401);

        Guest bana = new Guest("A027","ikhwani","syahbana","Jakarta", LocalDate.of(1985,10,14),
                Kelamin.LAKI_LAKI,"31200344014101988336",LocalDate.of(2022,5,21),LocalDate.of(2022,5,23),r301);

        listGuest.add(Danny);
        listGuest.add(Dessy);
        listGuest.add(Sunarti);
        listGuest.add(Ardi);
        listGuest.add(Muliawan);
        listGuest.add(Tirta);


        /* List Keluarga */
        List<Guest> FamDanny = new LinkedList<>();
        FamDanny.add(Dessy);
        Danny.setFamily(FamDanny);

        List<Guest> FamDessy = new LinkedList<>();
        FamDessy.add(Danny);
        Dessy.setFamily(FamDessy);

        List<Guest> FamSunarti = new LinkedList<>();
        FamSunarti.add(Ardi);
        FamSunarti.add(Muliawan);
        Sunarti.setFamily(FamSunarti);

        List<Guest> FamArdi = new LinkedList<>();
        FamArdi.add(Sunarti);
        FamArdi.add(Muliawan);
        Ardi.setFamily(FamArdi);

        List<Guest> FamMuliawan = new LinkedList<>();
        FamMuliawan.add(Sunarti);
        FamMuliawan.add(Ardi);
        Muliawan.setFamily(FamMuliawan);


        /* History kamar */
        List<Guest> r301h = new LinkedList<>();
        r301h.add(Danny);
        r301h.add(Dessy);
        r301h.add(bana);
        r301.setHistory(r301h);

        List<Guest> r302h = new LinkedList<>();
        r302h.add(Sunarti);
        r302h.add(Ardi);
        r302h.add(Muliawan);
        r302.setHistory(r302h);

        List<Guest> r401h = new LinkedList<>();
        r401h.add(Tirta);
        r401.setHistory(r401h);

    }

    /*Menu*/
    public static void menuUtama(){
        Scanner inp = new Scanner(System.in);
        String pilih;
        do {
            try {
                menu();
                System.out.print("Pilih : ");
                pilih = inp.next();
                switch (filterInt(pilih)) {
                    case 1: {
                        showGuest();
                        break;
                    }
                    case 2: {
                        showRoom();
                        break;
                    }
                    case 3: {

                        hotelDetail();
                        System.out.println(ConvertEnum(Kelamin.LAKI_LAKI));
                        System.out.println(ConvertEnum(Darah.A));

//                        for(Room rm : listRoom) {
//                            printInfoPendapatanRoom(rm);
//                        }



                        /*Wajib instantiate sebuah collection*/
//                        HashMap<String, Guest> hashGuest = new HashMap<>();
//                        for (Guest gusion: listGuest
//                        ) {
//
//                            hashGuest.put(gusion.getNoReg(),gusion);
//
//                        }
//
//                        HashMap<String, Guest> hashmap2 ;
//                        hashmap2 = hashGuest;
//
//                        for (HashMap.Entry gus: hashmap2.entrySet()
//                        ) {
//                            Guest gue = (Guest) gus.getValue();
//                            System.out.println("Key : "+gus.getKey());
//                            gue.printInfoGuest1st();
//
//                        }
                        check = false;
                        break;
                    }
                    case 4:{

                        check = true;
                        break;
                    }
                    default: {
                        System.out.println("Input salah");
                        check = false;
                    }
                }
            } catch (Exception exception) {
                System.out.println("Masukan pilihan dengan benar");
                check = false;
            }
        }while(!check);
    }
    public static void hotelDetail(){
        System.out.println("Hotel Name : Silver Coast Hotel ");
        System.out.println("Established in 15 December 1978 on Australy, Queensland");
    }
    public static void menu(){
        System.out.println("\n\nPilih nomor menu untuk masuk ke menunya:");
        System.out.println("1. All Guest Data");
        System.out.println("2. All Room Data");
        System.out.println("3. About This Hotel");
        System.out.println("4. Exit Application");
    }
    public static void menuGuest(){
        System.out.println("\n\nPilih nomor menu untuk masuk ke menunya:");
        System.out.println("1. Guest Information");
        System.out.println("2. Back to Main Menu");
        System.out.println("3. Exit Application");

    }
    public static void menuGuestOpened(){
        System.out.println("\n\n\nPilih nomor menu untuk masuk ke menunya:");
        System.out.println("1. Back to All Guest Data");
        System.out.println("2. Back to Main Menu");
        System.out.println("3. Exit Application");

    }
    public static void menuRoom(){
        System.out.println("\n\n\nPilih nomor menu untuk masuk ke menunya:");
        System.out.println("1. Room Information");
        System.out.println("2. Back to Main Menu");
        System.out.println("3. Exit Application");

    }
    public static void menuRoomOpened(){
        System.out.println("\n\n\nPilih nomor menu untuk masuk ke menunya:");
        System.out.println("1. Back to All Room Data");
        System.out.println("2. Back to Main Menu");
        System.out.println("3. Exit Application");

    }

    /* Get Objek */
    static public Guest getGuest(List<Guest> listGuest, String noReg){
        Guest guest = new Guest();
        for (Guest gst:listGuest) {
            if(gst.getNoReg().equals(noReg)){
                return gst;
            }
        }
        return guest;
    }
    static public Room getRoom(List<Room> listroom, String roomNumber ){
        Room room = new Room();
        for (Room rm:listRoom) {
            if(rm.getRoomNumber().equals(roomNumber)){
                return rm;
            }
        }
        return room;
    }


    /*Room*/
    static public boolean cekRoom(List<Room> listRoom, String room){

        for (Room rm:listRoom) {
            if(rm.getRoomNumber().equals(room)){
                return true;
            }
        }
        return false;
    }
    static public void showRoom(){

        boolean checkRoom = false;
        Scanner inp = new Scanner(System.in);
        Room room;
        String bagRoom;

        do {
            System.out.println("All Room Data ");
            for (Room rm : listRoom) {
                rm.printInfoRoom1st();
            }
            try {
                menuRoom();
                System.out.print("pilih : ");
                bagRoom = inp.next();
                if (filterInt(bagRoom) == 1) {
                    String pilDetailroom;
                    String masuk;
                    System.out.print("Masukan nomor Room yang anda ingin lihat informasinya: ");
                    masuk = inp.next();
                    if(cekRoom(listRoom,masuk)){
                        room = getRoom(listRoom, masuk);
                        printInfoRoomFull(room);

                    }
                    else{
                        System.out.println("Room tidak tersedia");
                        checkRoom = false;
                    }

                    try {
                        menuRoomOpened();
                        System.out.print("Pilih :");
                        pilDetailroom = inp.next();
                        if (filterInt(pilDetailroom) == 1) {
                            checkRoom = false;

                        } else if (filterInt(pilDetailroom) == 2) {
                            checkRoom = true;
                        } else if (filterInt(pilDetailroom) == 3) {
                            checkRoom = true;
                            check = true;
                        } else {
                            System.out.println("Wrong input");
                            checkRoom = false;
                        }
                    }catch (Exception exception){
                        System.out.println("input salah");
                        checkRoom = false;
                    }
                } else if (filterInt(bagRoom) == 2) {
                    checkRoom = true;
                } else if (filterInt(bagRoom) == 3) {
                    checkRoom = true;
                    check = true;
                } else {
                    System.out.println("Cant defined! back to menu");
                    checkRoom = false;
                }
            }catch(Exception exception){
                System.out.println("Input nilai yang sesuai");
            }
        }
        while (!checkRoom);

    }

    /*Guest*/
    static public boolean cekGuest(List<Guest> listGuest, String guest){

        for (Guest gst:listGuest) {
            if(gst.getNoReg().equals(guest)){
                return true;
            }
        }
        return false;
    }
    static public void showGuest(){
        boolean checkGuest = false;
        Scanner inp = new Scanner(System.in);
        Guest guest ;
        String bagGuest;

        do {

            System.out.println("All Guest Data below");
            for (Guest g : listGuest) {
                g.printInfoGuest1st();
            }
            try {
                menuGuest();
                System.out.print("pilih : ");
                bagGuest = inp.next();
                if (filterInt(bagGuest) == 1) {
                    String pilDetailGuest;
                    String masuk;
                    System.out.print("Masukan nomor Register yang anda ingin lihat informasinya: ");
                    masuk = inp.next();
                    if(cekGuest(listGuest,masuk)){
                        guest = getGuest(listGuest, masuk);
                        guest.printInfoGuestFull();

                    }
                    else{
                        System.out.println("Data Guest Tidak ditemukan");
                        checkGuest = false;
                    }

                    try {
                        menuGuestOpened();
                        System.out.print("Pilih :");
                        pilDetailGuest = inp.next();
                        if (filterInt(pilDetailGuest) == 1) {
                            checkGuest = false;

                        } else if (filterInt(pilDetailGuest) == 2) {
                            checkGuest = true;
                        } else if (filterInt(pilDetailGuest) == 3) {
                            checkGuest = true;
                            check = true;
                        } else {
                            System.out.println("Wrong input");
                            checkGuest = false;
                        }
                    }catch (Exception exception){
                        System.out.println("Input angka yang terssedia");
                        checkGuest = false;
                    }
                } else if (filterInt(bagGuest) == 2) {
                    checkGuest = true;
                } else if (filterInt(bagGuest) == 3) {
                    checkGuest = true;
                    check = true;
                } else {
                    System.out.println("Cant defined! back to menu");
                    checkGuest = false;
                }
            }catch (Exception exception){
                System.out.println("Input angka yang tersedia");
                checkGuest = false;

            }
        }
        while (!checkGuest);

    }

    /*Print Info*/
    public static void printInfoRoomFull(Room obj){
        Locale indonesia = new Locale("id", "ID");

        System.out.println("Room Number : "+obj.getRoomNumber());
        System.out.println("Floor : "+obj.getFloor());
        System.out.println("Price : "+ NumberFormat.getCurrencyInstance(indonesia).format(obj.getPricePerNight()));

        System.out.println("Reservation History : ");
        if(obj.getHistory() != null) {
            for (Guest gs : obj.getHistory()) {

                gs.printRoomHistory();

            }
        }
        else{
            System.out.println("Belum ada Reservation di Room ini");
        }


    }
    public static void printInfoPendapatanRoom(Room obj){

        HashMap<String,HashMap<LocalDate,BigDecimal>> Kamar = new HashMap<>();
        HashMap<LocalDate,BigDecimal> tmp = new HashMap<>();

        for(Guest list : listGuest){
            tmp = new HashMap<>();
            if(Kamar.containsKey(list.getRoom().getRoomNumber()) && tmp.containsKey(list.getCheckIn())){
                tmp.put(list.getCheckIn(), tmp.get(list.getCheckIn()).add(list.getPendapatan()));

                Kamar.put(list.getRoom().getRoomNumber(),tmp);

            }else{
                HashMap<LocalDate,BigDecimal> tmpOld = Kamar.get(list.getRoom().getRoomNumber());
                tmp = new HashMap<>();

                boolean cektmpOld = tmpOld != null;
                if(tmpOld!=null){
                    tmp = tmpOld;
                }
                tmp.put(list.getCheckIn(),list.getPendapatan());
                Kamar.put(list.getRoom().getRoomNumber(), tmp);

            }




        }


        }



    public static String convertTanggal(LocalDate tanggal, String pattern){
        Locale indo = new Locale("id","ID");
        DateTimeFormatter formatIndo = DateTimeFormatter.ofPattern(pattern,indo);
        String hasil = formatIndo.format(tanggal);

        return hasil;
    }

    /*convert Kelamin*/
    public static String ConvertEnum(Kelamin jk){

        String hasil = "";
        if(jk.equals(Kelamin.LAKI_LAKI)){
            hasil = "Pria";

        }
        else{
            hasil = "Wanita";
        }
        return hasil;
    }
    public static String ConvertEnum(Darah goldar){

        String hasil = "";
        if(goldar.equals(Darah.A)){
            hasil = "Gol A";
        }
        else if(goldar.equals(Darah.B)){
            hasil = "Gol B";
        }
        else if(goldar.equals(Darah.O)){
            hasil = "Gol AB";
        }
        else{
            hasil = "Gol O";
        }
        return hasil;
    }

    /*Convert String to int*/
    static public int filterInt(String number){
        int nomor = 0;
        try{
            nomor = Integer.parseInt(number);
        }catch(Exception exception){

        }
        return nomor;
    }

    /*soal andre*/
    public static void searchKamarByLantai(int floor) {
        int i=0;
        for(i=0;i<floor;i++){
            System.out.print("Lantai "+(i)+" : ");
            for(Room rm : listRoom){
                if(rm.getFloor()==i){
                    System.out.print(rm.getRoomNumber()+" ");
                }
            }
            System.out.println();
        }

    }

}
