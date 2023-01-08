package main;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;

public class Program {

	public static void main(String[] args) {
		//Basic Math Operator
		int penjumlahan = 3 + 6;
		System.out.println(penjumlahan);

		int pengurangan = 8 - 4;
		System.out.println(pengurangan);

		int perkalian = 5 * 6;
		System.out.println(perkalian);

		int pembagian = 30 / 5;
		System.out.println(pembagian);

		int modulus = 26 % 5;
		System.out.println(modulus);

		double firstDouble = 56.43;
		double secondDouble = 12.35;
		double resultDouble = firstDouble + secondDouble;
		System.out.println(resultDouble);

		int mix = (3 + 7) / 2;
		System.out.println(mix);

		 /*  Big Decimal adalah salah satu tipe data class dari library java.math, yang sangat bagus terutama untuk kebutuhan mencatat dan menghitung
			 keuangan, karena space memorynya yang sangat besar dan jumlah angka dibelakang komanya yang sangat presisi.
		 */
		BigDecimal decimalSatu = new BigDecimal(35.47);
		System.out.println(decimalSatu);
			
		/* Converting to BigDecimal */
		int nilaiInteger = 45;
		double nilaiDouble = 45.68;
		String nilaiString = "56.89";
		
		BigDecimal decimalDua = new BigDecimal(nilaiInteger);
		System.out.println(decimalDua);
		
		BigDecimal decimalTiga = new BigDecimal(nilaiDouble);
		System.out.println(decimalTiga);
		
		BigDecimal decimalEmpat = new BigDecimal(nilaiString);
		System.out.println(decimalEmpat);
		
		/*Formatting ke dalam String*/
		BigDecimal decimalLima = new BigDecimal(55000.50);
		
		Locale indonesia = new Locale("id", "ID");
		String indoFormat = NumberFormat.getCurrencyInstance(indonesia).format(decimalLima);
		System.out.println(indoFormat);
		
		Locale usa = new Locale("en", "US");
		String usFormat = NumberFormat.getCurrencyInstance(usa).format(decimalLima);
		System.out.println(usFormat);
		
		BigDecimal decimalEnam = new BigDecimal(1200000.67824235);
		DecimalFormat twoNumbersDecimals = new DecimalFormat("#,###.###");
		String formatResult = twoNumbersDecimals.format(decimalEnam);
		System.out.println(formatResult);
		
		/* Converting from BigDecimal */
			
		BigDecimal decimalTujuh = new BigDecimal(78.493572345);
		double doubleTujuh = decimalTujuh.doubleValue();
		int integerTujuh = decimalTujuh.intValue();
		String stringTujuh = decimalTujuh.toString();
		
		System.out.println(doubleTujuh);
		System.out.println(integerTujuh);
		System.out.println(stringTujuh);
		
		/*Pembulatan*/

		BigDecimal decimalDelapan = new BigDecimal(53.93);
		BigDecimal decimalSembilan = new BigDecimal(53.12);
		
		System.out.print("Decimal delapan sebelum pembulatan: ");
		System.out.println(decimalDelapan);
		
		//3 adalah precision digit, menentukan jumlah digit hasil akhir
		BigDecimal ceilingEight = decimalDelapan.round(new MathContext(3, RoundingMode.CEILING));
		System.out.println(ceilingEight);
		
		BigDecimal floorEight = decimalDelapan.round(new MathContext(3, RoundingMode.FLOOR));
		System.out.println(floorEight);
		
		BigDecimal ceilingNine = decimalSembilan.round(new MathContext(3, RoundingMode.CEILING));
		System.out.println(ceilingNine);
		
		BigDecimal floorNine = decimalSembilan.round(new MathContext(3, RoundingMode.FLOOR));
		System.out.println(floorNine);
		
		/*	CEILING: Pembulatan ke atas, selalu menuju ke arah positif
		 	UP: Pembulatan ke atas, selalu ke digit yang lebih besar menjauhi 0, angka positif akan semakin besar, angka negatif akan semakin kecil.
		 	FLOOR: Pembulatan ke bawah, selalu menuju ke arah negatif
		 	DOWN: Pembulatan ke bawah, selalu ke digit yang lebih kecil mendekati 0, angka positif akan semakin kecil, angka negatif akan semakin besar.
			HALF_EVEN: Pembulatan dari nilai tengah.
		 	HALF_DOWN: Pembulatan dari nilai tengah ke bawah.
		 	HALF_UP: Pembulatan dari nilai tengah ke atas.

		 	Dokumentasi:
		 	https://docs.oracle.com/javase/7/docs/api/java/math/RoundingMode.html
		 */
		
		/*Calculating Big Decimal*/
		
		BigDecimal decimalSepuluh = new BigDecimal(120.50);
		BigDecimal decimalSebelas = new BigDecimal(20.50);
		
		//penjumlahan
		BigDecimal addResult = decimalSepuluh.add(decimalSebelas);
		System.out.println(addResult);
		
		//pengurangan
		BigDecimal subtractResult = decimalSepuluh.subtract(decimalSebelas);
		System.out.println(subtractResult);
		
		//perkalian
		BigDecimal multiplyResult = decimalSepuluh.multiply(decimalSebelas);
		System.out.println(multiplyResult);
		
		//pembagian
		//Lebih baik lakukan pembulatan ketika pembagia, karena hasilnya bisa arithmatic error apabila angkanya keluar dari bound.
		BigDecimal divisionResult = decimalSepuluh.divide(decimalSebelas, new MathContext(3, RoundingMode.HALF_EVEN));
		System.out.println(divisionResult);
	}
}
