package Enum;

public enum agama {
    ISLAM("Islam","I"),
    KRISTEN("Kristen","KP"),
    KATOLIK("Katolik","K");


    private String nama;
    private String inisial;

    agama (String nama, String inisial){
        this.nama = nama;
        this.inisial = inisial;
    }

    public String getName(){return this.nama;}
    public String getInisial () {return this.inisial;}


}
