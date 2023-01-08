package main;

import java.util.*;
import java.text.*;
import java.math.*;
import java.text.SimpleDateFormat;

public final class FinalPerson {
	/*Final class membuat class tidak bisa di inherit, kalau developer yakin agar class ini tidak diinherit,
	* atau tidak boleh diinherit, menggunakan final statement bukanlah hal buruk.
	*
	* Final class juga bisa mempercepat performance compiler, karena java tidak akan check lagi apakah ada class
	* yang memiliki relasi inheritance dengan class ini.
	* */
    protected String name;
    public FinalPerson() {
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getName() {
    	return this.name;
    }

    public void printPersonalInformation() {
        String completeInformation = String.format("Nama: %s", this.name);
        System.out.println(completeInformation); ;
    }
}
