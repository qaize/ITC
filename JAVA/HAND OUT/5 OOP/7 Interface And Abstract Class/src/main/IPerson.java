package main;
import java.time.*;

public interface IPerson {
	
    public String getFirstName();
    public void setFirstName(String firstName);
    
    public String getLastName();
    public void setLastName(String lastName);
    
    public String getGender();
    public void setGender(String gender);
    
    public LocalDate getBirthDate();
    public void setBirthDate(LocalDate birthDate);
    
    public String getBirthPlace();
    public void setBirthPlace(String birthPlace);
    
    public String getIDCardNumber();
    public void setIDCardNumber(String idCardNumber);

    public String getCitizenship();
    public void setCitizenship(String citizenship);
    
    public String getMaritalStatus();
    public void setMaritalStatus(String maritalStatus);

    public void printBiodata();
    public void printPersonIdentity();
    public long calculateAge();
}
