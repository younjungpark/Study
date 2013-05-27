package com.yjpark.study;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoMachine {

	public static void main(String args[]) {
		SortedSet<Integer> pickedNumber = new TreeSet<Integer>();
		Random random = new Random();
		while (pickedNumber.size() < 6) pickedNumber.add(random.nextInt(45)+1);
		System.out.println("lotto number is " + pickedNumber);
	}
	
}