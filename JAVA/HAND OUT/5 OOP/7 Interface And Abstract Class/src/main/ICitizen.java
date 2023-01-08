package main;

public interface ICitizen {
    public boolean getCitizenMedicalInsuranceProgram();
    public void setCitizenMedicalInsuranceProgram(boolean citizenMedicalInsuranceProgram);
    
    public boolean getCitizenLifeInsuranceProgram();
    public void setCitizenLifeInsuranceProgram(boolean citizenLifeInsuranceProgram);
    
    public boolean getCitizenRetirementProgram();
    public void setCitizenRetirementProgram(boolean citizenRetirementProgram);
}
