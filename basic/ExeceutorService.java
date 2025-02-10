package com.java.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeceutorService {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Runnable r1 = new Prime("Task 1");
		Runnable r2 = new Prime("Task 2");
		Runnable r3 = new Prime("Task 3");
		Runnable r4 = new Prime("Task 4");
		ExecutorService es1 = Executors.newFixedThreadPool(4);
		es1.execute(r1);
		es1.execute(r2);
		es1.execute(r3);
		es1.execute(r4);
	
		CompletableFuture<Integer> cf = CompletableFuture.supplyAsync( () -> {
			int num = 30;
			for(int i=1;i<=num;i++) {
				int count = 0;
				for(int j=1;j<=num;j++) {
					if(i % j == 0) {
						count++;
					}
				}
				if(count == 2) {
					System.out.println("Future " + " " +i);
				}
			}
			return 0;
			
		});
		
		System.out.println(cf.get());
	}

}

class Prime implements Runnable {
	
	final String name;
	
	public Prime(String name) {
		this.name = name;
	}

	@Override
	public void run() {
	
		int num = 30;
		
		for(int i=1;i<=num;i++) {
			int count = 0;
			for(int j=1;j<=num;j++) {
				if(i%j == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println(name + " " + " - " +i);
			}
		}
		
		
	}	
}