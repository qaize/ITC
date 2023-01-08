package main;

import java.util.*;
import java.text.*;
import java.math.*;

public class Student extends Person {
	
	protected String university;
	protected String universityLocation;
	protected String faculty;
	protected Calendar enrollmentDate;
	protected int gpa;

    public Student(){
    	super();
    }
    public Student(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber, 
        String university, String universityLocation, String faculty, Calendar enrollmentDate, int gpa){  	
    	super(name, birthDate, birthPlace, gender, identityCardNumber); 	
        this.university = university;
        this.universityLocation = universityLocation;
        this.faculty = faculty;
        this.enrollmentDate = enrollmentDate;
        this.gpa = gpa;
    }
    public Student(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber, String religion, String bloodType, int height, double weight, String citizenship,
        String university, String universityLocation, String faculty, Calendar enrollmentDate, int gpa){ 	
    	super(name, birthDate, birthPlace, gender, identityCardNumber, religion, bloodType, height, weight, citizenship);
        this.university = university;
        this.universityLocation = universityLocation;
        this.faculty = faculty;
        this.enrollmentDate = enrollmentDate;
        this.gpa = gpa;
    }

    public void setUniversity(String university) {
    	this.university = university;
    }
    public String getUniversity() {
    	return this.university;
    }
    public void setFaculty(String faculty) {
    	this.faculty = faculty;
    }
    public String getFaculty() {
    	return this.faculty;
    }
    public void setEnrollmentDate(Calendar enrollmentDate) {
    	this.enrollmentDate = enrollmentDate;
    }
    public Calendar getEnrollmentDate() {
    	return this.enrollmentDate;
    }
    public void setGPA(int gpa) {
    	this.gpa = gpa;
    }
    public int getGPA() {
    	return this.gpa;
    }
    
    public int getYearsOfStudyDuration() {  	
    	GregorianCalendar hariIni = new GregorianCalendar(); 	
    	int tahunHariIni = hariIni.get(hariIni.YEAR);
    	int bulanHariIni = hariIni.get(hariIni.MONTH) + 1;
    	int tanggalHariIni = hariIni.get(hariIni.DAY_OF_MONTH);	
    	int tahunEnrollTahun = this.enrollmentDate.get(this.enrollmentDate.YEAR);
    	int bulanEnrollTahun = this.enrollmentDate.get(this.enrollmentDate.MONTH) + 1;
    	int tanggalEnrollTahun = this.enrollmentDate.get(this.enrollmentDate.DAY_OF_MONTH);  	
    	int durasi = tahunHariIni - tahunEnrollTahun;
    	if((bulanEnrollTahun < bulanHariIni) || (bulanEnrollTahun == bulanHariIni && tanggalEnrollTahun < tanggalHariIni)) {
    		--durasi;
    	}
		return durasi;
    }
    public int getSemesterOfStudyDuration() {
        int semester = getYearsOfStudyDuration() / 2;
        return semester;
    }
    public void printEducationInformation() {
        int semester = getSemesterOfStudyDuration();
        String educationInfo = String.format("%s is study in %s on Semester %d", this.name, this.university, semester);
        System.out.println(educationInfo);
    }	
	
}
