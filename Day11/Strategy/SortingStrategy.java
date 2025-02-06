package com.java.Strategy;

public class SortingStrategy implements Items{

	@Override
	public void listItems() {
		
		Items i = new ItemsImpl();
		i.listItems();
		
	} 
	
	public static void main(String[] args) {
		SortingStrategy ss = new SortingStrategy();
		ss.listItems();
	}

}
