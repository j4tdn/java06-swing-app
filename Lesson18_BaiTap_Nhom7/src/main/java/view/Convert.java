/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public class Convert {
    	public static String countDuplicateWord(String st) {
		String ress="";
		String[] a=st.trim().split("\\s+");
		Map<String, Integer> res= new HashMap<>();
                for (String a1 : a) {
                    res.put(a1, count(a1, a));
                }
		
		for ( Map.Entry<String, Integer> entry : res.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		   ress=ress+key+": "+value+" lần\n";
		}
		return ress;
		
	}
	
	private static int count(String input,String[] st) {
		int count=0;
                for (String st1 : st) {
                    if (input.equals(st1)) {
                        count++;
                    }
                }
		return count;
	}

	public static String countWord(String st) {
		String[] a=st.trim().split("\\s+");
		return a.length+"";
		
	}
	
	public static String convertString(String st) {
		String temp = Normalizer.normalize(st, Normalizer.Form.NFD);
                Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "d");
	}
}
