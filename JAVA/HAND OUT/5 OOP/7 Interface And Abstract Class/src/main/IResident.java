package main;
import java.time.*;

/*
 * IResident adalah interface kependudukan. Penduduk belum tentu warga negara, penduduk hanyalah seseorang yang berada di satu negara karena
 * hal-hal tertentu seperti traveling, bekerja, atau belajar. Setiap penduduk pasti harus membayar pajak apabila bekerja dan beraktifitas di negara tersebut.
 */

public interface IResident extends IPerson{
	public String getVisaStatus();
	public void setVisaStatus(String visaStatus);
	
	public String getTaxFileNumber();
	public void setTaxFileNumber(String taxFileNumber);
	
	public LocalDate getVisaGrantTime();
	public void setVisaGrantTime(LocalDate visaGrantTime);

	public void payTax();
	public void residencyInformation();	 
}