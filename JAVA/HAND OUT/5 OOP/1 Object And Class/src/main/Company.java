package main;

public class Company {
	
	//Field adalah variable exclusive milik sebuah object yang di deklarasi di class.
    private String name;
    private String owner;
    
    //Function constructor, function yang digunakan untuk membantu dalam pembuatan field-field object pada saat instantiate.
    public Company(String name, String owner) { 
    	this.name = name;
    	this.owner = owner;
    }
    
    //Getter & Setter method digunakan untuk mengambil dan merubah field dari sebuah object.
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;	
    }
    
    public void setOwner(String owner) {
    	this.owner = owner;
    }
    
    public String getOwner() {
    	return this.owner;
    }
}
