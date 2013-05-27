package com.yjpark.study;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void testSort() {
		QuickSort quickSort = new QuickSort();
		int arry[] = new int [] {3, 21, 53, 34, 28, 11, 4, 19, 5, 10 };
		quickSort.quickSort(0, arry.length-1, arry);
		int result[] = new int [] {3, 4, 5, 10, 11, 19, 21, 28, 34, 53 };
		for (int i=0; i < arry.length; i++) {
			assertThat(arry[i], is(result[i]));
		}
	}

}