package external;

public class Citizen {
    public String publicCitizenField;
    private String privateCitizenField;
    protected String protectedCitizenField;
    String defaultCitizenField;

    public void publicCitizenMethod() {
        System.out.println("Public Citizen Method");
    }

    private void privateCitizenMethod() {
    	System.out.println("Private Citizen Method");
    }

    protected void protectedCitizenMethod() {
    	System.out.println("Protected Citizen Method");
    }
    
    void defaultCitizenMethod() {
    	System.out.println("Default Citizen Method");
    }
}
