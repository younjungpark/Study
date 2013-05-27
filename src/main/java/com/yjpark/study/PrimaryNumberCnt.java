package com.yjpark.study;

public class PrimaryNumberCnt {

	public static void main(String[] args) {
		int primaryCnt= 0;
		int totalCnt = 0;
		boolean isPrimary = true;
		
		for (int i=2; i<=100; i++) {
			for (int j=2; j<=i-1; j++) {
				if ((i % j) == 0) {
					isPrimary = false;
					continue; 
				}
			}
			if (isPrimary) {
				System.out.println("primary number ===>" + i);
				primaryCnt++;
			}
			isPrimary = true;
			totalCnt++;
		}
		System.out.println("total cnt=====>"+totalCnt);
		System.out.println("total primary number=====>"+primaryCnt);
	}
	
}
