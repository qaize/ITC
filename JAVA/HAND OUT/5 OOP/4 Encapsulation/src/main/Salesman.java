package main;

public class Salesman extends Resident {
	
    public int publicSalesmanField;
    private int privateSalesmanField;
    protected int protectedSalesmanField;
    int defaultSalesmanField;

    public void publicSalesmanMethod() {
        System.out.println("Public Resident Method");
    }

    private void privateSalesmanMethod() {
    	System.out.println("Private Resident Method");
    }

    protected void protectedSalesmanMethod() {
    	System.out.println("Protected Resident Method");
    }
    
    void defaultSalesmanMethod() {
    	System.out.println("Default Salesman Method");
    }

    //Menggunakan member dari Resident
    public void usingPropertyOfResident() {
        int receivePublicField = publicResidentField;
        int receiveProtectedField = protectedResidentField;
        int receiveDefaultField = defaultResidentField;
    }

    public void usingMethodOfResident() {
        publicResidentMethod();
        protectedResidentMethod();
        defaultResidentMethod();
    }
}
