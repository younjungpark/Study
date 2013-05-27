package com.yjpark.study;

import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int SIZE = 10;
		int[] arry = new int[SIZE];
		for (int i=0; i<SIZE; i++) {
			arry[i] = getRandom(arry);
			System.out.print(arry[i]+ " ");
		}
		new QuickSort().quickSort(0, SIZE-1, arry);
		
		System.out.println("\n정렬 후 ");
		for (int i=0; i<SIZE; i++) {
			System.out.print(arry[i]+ " ");
		}
	}

	public void quickSort(int left, int right, int[] arry) {
		int i,j,tmp, pivot;
		
		if (left < right) {
			i = left;
			j = right;
			pivot = arry[left];
			
			while (i < j) {
				while (arry[j] > pivot) j--;
				while (i < j && arry[i] <= pivot) i++;
				tmp = arry[i];
				arry[i] = arry[j];
				arry[j] = tmp;
			}
			arry[left] = arry[i];
			arry[i] = pivot;
			quickSort(left,	i-1, arry);
			quickSort(i+1, right, arry);
		}
	}

	private static int getRandom(int[] arry) {
		Random random = new Random();
		int randomNum;
		do {
			randomNum = random.nextInt(100);
		} while (isExist(arry, randomNum));
		
		for (int i=0; i<arry.length; i++) {
			if (arry[i] == randomNum) getRandom(arry);
		}
		return randomNum;
	}

	private static boolean isExist(int[] arry, int randomNum) {
		for (int i=0; i < arry.length; i++) {
			if (arry[i] == randomNum) return true;
		}
		return false;
	}
	
}
