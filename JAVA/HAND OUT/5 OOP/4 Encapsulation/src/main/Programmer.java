package main;
import external.Citizen;

public class Programmer extends Citizen {
	
    //tidak bisa meng inherit Employee karena employee adalah internal
    public String publicProgrammerField;
    private String privateProgrammerField;
    protected String protectedProgrammerField;
    String defaultProgrammerField;

    public void publicProgrammerMethod() {
        System.out.println("Public Programmer Method");
    }

    private void privateProgrammerMethod() {
    	System.out.println("Private Programmer Method");
    }

    protected void protectedProgrammerMethod() {
    	System.out.println("Protected Programmer Method");
    }
    
    void defaultProgrammerMethod() {
    	System.out.println("Default Programmer Method");
    }

    //Menggunakan member dari citizen
    public void usingFieldOfCitizen() {
        String receivePublicField = publicCitizenField;
        String receiveProtectedField = protectedCitizenField;
        //Tidak bisa menggunakan private dan default field dari citizen.
    }

    public void usingMethodOfCitizen() {
        publicCitizenMethod();
        protectedCitizenMethod();
        //Tidak bisa menggunakan private dan default method dari citizen.
    }
}
