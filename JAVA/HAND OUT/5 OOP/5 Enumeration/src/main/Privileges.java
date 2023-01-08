package main;

/*
* Dengan kita menulis enumeration seperti ini, tidak ada pilihan lain
* untuk sebuah field atau variable yang menggunakan tipe data Privileges selain memberi nilai dalam
* ADMIN, MODERATOR, EDITOR, MANAGER atau USER
*
* Aturan naming convention dalam java untuk enum adalah dengan menggunakan Screaming Case.
* screaming case adalah naming convention dengan menggunakan seluruh upper case dengan under score sebagai pembatas katanya.
* */
public enum Privileges {
    ADMIN,
    MODERATOR,
    CONTENT_EDITOR,
    MANAGER,
    USER,
}
