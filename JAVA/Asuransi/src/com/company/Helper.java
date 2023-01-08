package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.company.Asuransi;
import com.company.Enum.JenisKelamin;

public class Helper {

    public String generateNewNoNasabah(Integer noProspect){
        String result = "";
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatingBulan = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter formatingTahun = DateTimeFormatter.ofPattern("yyyy");
        result = String.format("%s/%s/%d",formatingBulan.format(now),formatingTahun.format(now),noProspect);

        return result;
    }
    public static JenisKelamin getEnum(String input){

        if(input=="L"){
            return JenisKelamin.LAKI_LAKI;
        }

        return JenisKelamin.PEREMPUAN;

    }

    public  static Integer generateNewNoProspect(){
        Integer data=0;
        for (Map.Entry pt : Asuransi.getListPorspect().entrySet()){
            if(pt.getKey()==null || pt.getKey()==data) {
                data++;
            }
            else{
                return data;
            }

        }
        return data;
    }

    public static String FormatTanggal(LocalDate tanggal,String pattern){
        Locale indo = new Locale("id","ID");
        DateTimeFormatter formatan = DateTimeFormatter.ofPattern(pattern,indo);
        return formatan.format(tanggal);
    }
}
