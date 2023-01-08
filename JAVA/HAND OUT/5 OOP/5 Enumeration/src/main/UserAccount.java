package main;

public class UserAccount {
    private String username;
    private String password;
    private Gender gender;
    private Privileges privilege;
    private Religion religion;
    private EmployementStatus status;

    public UserAccount(String username, String password, Privileges privilege, Religion religion, EmployementStatus status) {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
        this.religion = religion;
        this.status = status;
    }

    public UserAccount(String username, String password, Privileges privilege, Religion religion, EmployementStatus status, Gender gender) {
    	this.username = username;
    	this.password = password;
    	this.privilege = privilege;
        this.religion = religion;
        this.status = status;
        this.gender = gender;
    }
    
    public String getUsername() {
    	return this.username;
    }
    public void setUsername(String username) {
    	this.username = username;
    }
    
    public String getPassword() {
    	return this.password;
    }   
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public Privileges getPrivilege() {
    	return this.privilege;
    }
    public void setPrivilege(Privileges privilege) {
    	this.privilege = privilege;
    }

    public Gender getGender(){ return  this.gender; }
    public void setGender(Gender gender){ this.gender = gender;}
    /* Kita tidak ingin selalu mem-print isi dari enum dengan screaming case
    *  dan kita sering kali ingin mendapatkannya dalam string dengan label yang berbeda.
    *
    * Karena itu di sini kita membuatkan method get yang mengembalikan dalam string.
    * Switch case dengan enum akan menjadi kombinasi yang baik.
    * */
    public String getPrivilageLabel(){
        switch (this.privilege) {
            case ADMIN:
                return "Administrator";
            case CONTENT_EDITOR:
                return "Content Editor";
            case MANAGER:
                return "Manager";
            case MODERATOR:
                return "Moderator";
            case USER:
                return "System User";
            default:
                return "N/A";
        }
    }

    public Religion getReligion() {
        return religion;
    }
    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public EmployementStatus getStatus() {
        return status;
    }

    public void setStatus(EmployementStatus status) {
        this.status = status;
    }
}
