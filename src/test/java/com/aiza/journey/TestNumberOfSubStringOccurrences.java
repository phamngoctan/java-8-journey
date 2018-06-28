package com.aiza.journey;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestNumberOfSubStringOccurrences {
	public static void main(String[] args) {
		/*String str = "helloslkhellodjladfjhello";
		String findStr = "";
		int lastIndex = 0;
		int count = 0;

		while((lastIndex = str.indexOf(findStr, lastIndex)) != -1) {
		     count++;
		     lastIndex += findStr.length() - 1;
		}
		System.out.println(count);*/
		
		/*String str = "helloslkhellodjladfjhello";
		Pattern p = Pattern.compile("hello");
		Matcher m = p.matcher(str);
		int count = 0;
		while (m.find()) {
			count += 1;
		}
		System.out.println(count);     */
		String str = "23232";
		String findStr = "232";
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1){

		    lastIndex = str.indexOf(findStr,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += findStr.length();
		    }
		}
		System.out.println(count);


	}
}
