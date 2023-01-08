package main;

import java.util.*;

public class PhdStudent extends Student {
    public PhdStudent(){
    	super();
    }
    public PhdStudent(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber,
        String university, String universityLocation, String faculty, Calendar enrollmentDate, int gpa){
    	super(name, birthDate, birthPlace, gender, identityCardNumber, university, universityLocation, faculty, enrollmentDate, gpa);    	
    }
    public PhdStudent(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber, String religion, String bloodType, int height, double weight, String citizenship,
        String university, String universityLocation, String faculty, Calendar enrollmentDate, int gpa){  	
    	super(name, birthDate, birthPlace, gender, identityCardNumber, religion, bloodType, height, weight, citizenship, university, universityLocation, faculty, enrollmentDate, gpa);
    }
    
    @Override
    public void printEducationInformation() {
    	super.printEducationInformation(); 	
        int semester = getSemesterOfStudyDuration();
        String educationInfo = String.format("%s has research in %s", this.name, this.university);
        System.out.println(educationInfo);
    }
}
