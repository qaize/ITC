package main;

/*
* Pada java, enum bisa memiliki constructor dan method tersendiri.
* Sehingga dengan begini, kita tidak perlu membuat kan get label method di dalam class User Account.
* Kita bisa menggunakan method getLabelDalamIndonesia()
* */
public enum Religion {
    ISLAM("Islam", "I"),
    CATHOLIC("Kristen Katolik", "KK"),
    CHRISTIAN("Kristen Protestan", "KP"),
    BUDDIST("Buddha", "B"),
    HINDU("Hindu", "H");

    private String labelDalamIndonesia;
    private String inisial;

    Religion(String labelDalamIndonesia, String inisial) {
        this.labelDalamIndonesia = labelDalamIndonesia;
        this.inisial = inisial;
    }

    public String getLabelDalamIndonesia() {
        return labelDalamIndonesia;
    }

    public String getInisial() {
        return inisial;
    }
}
