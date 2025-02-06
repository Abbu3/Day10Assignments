package com.java.Singleton;

public class TestSingleton {
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.getSingletonObj(); 
		System.out.println(s1.hashCode());
	}
	
	

}
