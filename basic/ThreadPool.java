package com.java.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		System.out.println("====================First one==================");
		Runnable r1 = new Task("Task 1");
		Runnable r2 = new Task("Task 2");
		Runnable r3 = new Task("Task 3");
		Runnable r4 = new Task("Task 4");
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
		newFixedThreadPool.execute(r1);
		newFixedThreadPool.execute(r2);
		newFixedThreadPool.execute(r3);
		newFixedThreadPool.execute(r4);
		
		
		
		System.out.println("====================Second one==================");
		Runnable task1 = new Task1("C:/Linux_Practice/folder1/file1.txt", "Task 1");
		Runnable task2 = new Task1("C:/Linux_Practice/folder1/file2.txt", "Task 2");
		Runnable task3 = new Task1("C:/Linux_Practice/folder1/file3.txt", "Task 3");
		Runnable task4 = new Task1("C:/Linux_Practice/folder1/employeeewh.txt", "Task 4");
		ExecutorService newFixedThreadPool2 = Executors.newFixedThreadPool(4);
		newFixedThreadPool2.execute(task1);
		newFixedThreadPool2.execute(task2);
		newFixedThreadPool2.execute(task3);
		newFixedThreadPool2.execute(task4);
		
		

	}

}


class Task implements Runnable{
	final String taskName;
	
	public Task(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
		System.out.println(taskName+ " " + " - " +simpleDateFormat.format(d));
	}
	
}


class Task1 implements Runnable {
	
	final String name;
	final String task1Name;
	
	public Task1(String name, String task1Name) {
		this.name = name;
		this.task1Name = task1Name;
	}
	
	
	

	@Override
	public void run() {
		
		try {
			File f1 = new File(name);
			f1.canRead();
			System.out.println(task1Name + " - " + " " +f1.canRead());
		} catch(Exception e) {
			e.getMessage();
		}
		
	}
	
}