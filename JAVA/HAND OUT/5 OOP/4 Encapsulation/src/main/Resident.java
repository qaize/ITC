package main;

public class Resident {
    public int publicResidentField;
    private int privateResidentField;
    protected int protectedResidentField;
    int defaultResidentField;

    public void publicResidentMethod() {
        System.out.println("Public Resident Method");
    }

    private void privateResidentMethod() {
    	System.out.println("Private Resident Method");
    }

    protected void protectedResidentMethod() {
    	System.out.println("Protected Resident Method");
    }
    
    void defaultResidentMethod() {
    	System.out.println("Default Resident Method");
    }

}
