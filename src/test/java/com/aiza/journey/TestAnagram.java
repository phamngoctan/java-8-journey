package com.aiza.journey;

import java.util.HashMap;
import java.util.Map;

public class TestAnagram {
	public static void main(String[] args) {
//		boolean ret = isAnagram("anagramm", "marganaa");
//		System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
		String s = "                        ";
        //String[] arr = s.split("\\s+|\\'|\\,\\s*|\\?\\s*|\\!\\s*|\\.\\s*|\\_\\s*|\\@\\s*");
        
		if (s.trim().length() == 0) {
            System.out.println(0);
            return;  
        }
        String[] arr = s.trim().split("[^A-Za-z]+");
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
	}
	
	private static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        a = b.toLowerCase();
        Map<Character, Integer> frequencyMapA = new HashMap<>();
        Map<Character, Integer> frequencyMapB = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (frequencyMapA.get(a.charAt(i)) == null) {
                frequencyMapA.put(a.charAt(i), 1);
            } else {
                frequencyMapA.put(a.charAt(i), frequencyMapA.get(a.charAt(i)) + 1);
            }
            if (frequencyMapB.get(b.charAt(i)) == null) {
                frequencyMapB.put(b.charAt(i), 1);
            } else {
                frequencyMapB.put(b.charAt(i), frequencyMapB.get(b.charAt(i)) + 1);
            }
        }

        return !frequencyMapA.entrySet().stream().filter(e -> e.getValue() != frequencyMapB.get(e.getKey())).findAny().isPresent();
    }
}
