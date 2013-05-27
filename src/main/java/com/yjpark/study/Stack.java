package com.yjpark.study;

public class Stack {
	private int top;
	private int[] data;
	private int dataSize;
	
	public Stack() {
		this.top = 0;
		data = new int[10];
		this.dataSize = 10;
	}
	
	public Stack(int size) {
		this.top = 0;
		data = new int[size];
		this.dataSize = size;
	}
	
	public void push(int value) {
		if (!isFull()) {
			this.data[top++] = value;
		} else {
			System.out.println("스택이 풀입니다.");
		}
	}
	
	public int pop() {
		if (!isEmpty()) {
			top--;
			return data[top];
		}
		System.out.println("스택이 비어있습니다.");
		return 0;
	}
	
	private boolean isEmpty() {
		return (top == 0);
	}

	private boolean isFull() {
		return (this.top == dataSize - 1);
	}

	public static void main(String[] args) {
		
	}
}
