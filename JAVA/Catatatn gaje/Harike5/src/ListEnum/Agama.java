package ListEnum;

public enum Agama {
    Islam("Islam","I"),
    Kristen("Kristen Protestan","KP"),
    Katolik("Katolik","K"),
    Buddha("Buddha","B"),
    Hindu("Hindu", "H");

    private String namaagama;
    private String inisial;

    Agama(String nama, String Inisial){
        this.namaagama=nama;
        this.inisial=Inisial;
    }

    public String getNamaagama(){
        return this.namaagama;
    }
    public String getInisial(){
        return this.inisial;
    }
}
