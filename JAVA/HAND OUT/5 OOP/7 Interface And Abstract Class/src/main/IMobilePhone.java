package main;

public interface IMobilePhone {
	
    public String getPhoneType();
    public void setPhoneType(String phoneType);
    
    public double getDisplaySize();
    public void setDisplaySize(double displaySize);
    
    public int getBatteryCapacity();
    public void setBatteryCapacity(int batteryCapacity);
    
    public String getOperatingSystem();
    public void setOperatingSystem(String operatingSystem);

    public void operatingSystemInformation();
    public void executeCalling(String phoneNumber);

}
