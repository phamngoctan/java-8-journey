package com.tanpham.java8.journey;

import java.util.Scanner;

public class TestBiggestTotalSumOfHourGlass {
	 private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int[][] arr = new int[6][6];

	        for (int i = 0; i < 6; i++) {
	            String[] arrRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int j = 0; j < 6; j++) {
	            	if (arrRowItems[j] != null && arrRowItems[j].length() > 0) {
	            		int arrItem = Integer.parseInt(arrRowItems[j]);
		                arr[i][j] = arrItem;
	            	} else {
	            		arr[i][j] = 0;
	            	}
	            }
	        }
	        
	        int maxSumOfHourGlasses = Integer.MIN_VALUE;
	        for (int i = 0; i < arr.length; i++) {
	            for (int j = 0; j < arr.length; j++) {
	                if (isCenterOfHourglass(arr, i, j)) {
	                    //System.out.println("center of: " + arr[i][j]);
	                    int curSum = hourglassTotalItemValue(arr, i, j);
	                    if (curSum  > maxSumOfHourGlasses) {
	                        maxSumOfHourGlasses = curSum;
	                    }
	                }
	            }
	        }
	        System.out.println(maxSumOfHourGlasses);
	        scanner.close();
	    }
	    
	    public static Boolean isCenterOfHourglass(int[][] arr, int i, int j) {
	        if (i == 0 || i >= 5) {
	            return false;
	        }
	        if (j == 0 || j >= 5) {
	            return false;
	        }
	        // if (arr[i][j - 1] == 0 && arr[i][j + 1] == 0) {
	        //     return true;
	        // }
	        return true;
	    }
	    
	    public static int hourglassTotalItemValue(int[][] arr, int i, int j) {
	        return 
	            arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1]
	            //+ arr[i][j-1] 
	                    + arr[i][j] 
	            //                            + arr[i][j+1]
	            +
	            arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1]
	            ;
	    }
}
