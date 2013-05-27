package com.yjpark.study;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void testPush() {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(15);
		stack.push(21);
		assertThat(stack.pop(), is(21));
		assertThat(stack.pop(), is(15));
		assertThat(stack.pop(), is(10));
		assertThat(stack.pop(), is(0));
	}

}
