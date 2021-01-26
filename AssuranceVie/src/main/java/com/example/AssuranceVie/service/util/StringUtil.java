package com.example.AssuranceVie.service.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
    public static boolean isEmpty(String value){return value==null || value.isEmpty();}

    public static boolean isNotEmpty(String value){return !isEmpty(value);}

    public static Integer toInteger(String value){
        if (isNotEmpty(value)) {
            return Integer.parseInt(value);
        }
        return null;
    }

    public static Long toLong(String value){
        if (isNotEmpty(value)) {
            return Long.parseLong(value);
        }
        return null;
    }
    public static Double toDouble(String value){
        if (isNotEmpty(value)) {
            return Double.parseDouble(value);
        }
        return null;
    }
    public static Date toDate(String value) throws ParseException{
        if (value!=null){
        	 return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(value);  
        }
        return null;
    }

    public static String toString(Long value){
        if (value!=null){
            return value.toString();
        }
        return null;
    }
    public static String toString(Double value){
        if (value!=null){
            return value.toString();
        }
        return null;
    }

    public static String toString(Integer value){
        if (value!=null){
            return value.toString();
        }
        return null;
    }
    public static String toString(Date value){
        if (value!=null){
        	 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
             return dateFormat.format(value); 
        }
        return null;
    }
  
   
    



}