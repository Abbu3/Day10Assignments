package com.java.basic;

public class CounterClass {
	public static void main(String[] args) {
		
		IncrementAndDecrement incrementAndDecrement = new IncrementAndDecrement();
		
		Thread t1 = new Thread(new ThreadSafety(incrementAndDecrement), "Thread - 1");
		
		Thread t2 = new Thread(new ThreadSafety(incrementAndDecrement), "Thread - 2");
		
		t1.start();
		t2.start();
		
		
	}
}

class IncrementAndDecrement {
	
	public void increment(int value) {
		for(int i=0;i<=10;i++) {
			if(value == i) {
				value ++;
				System.out.println(Thread.currentThread().getName() + " " + "->" + " " +value);
			}
		}
		System.out.println("Total incremented value is " +value);
	}
	
	public void decrement(int value) {
		for(int i=10;i>=0;i--) {
			if(value == i) {
				value --;
			}
		}
		System.out.println("Total Decremented value is " +value);
		
	}
}

class ThreadSafety implements Runnable {
	IncrementAndDecrement iad;
	

	public ThreadSafety(IncrementAndDecrement iad) {
		this.iad = iad;
	}
	
	@Override
	public void run() {
		try {
		iad.increment(0);
		iad.decrement(10);
		} catch(Exception e) {
			e.getMessage();
		}
		
	}
	
}