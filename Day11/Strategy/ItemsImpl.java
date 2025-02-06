package com.java.Strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ItemsImpl implements Items{

	@Override
	public void listItems() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.add(34);
		al.add(0);
		al.add(32);
		al.add(1);
		al.add(21);
		al.add(2);
		al.add(45);
		
		Collections.sort(al);
		System.out.println(al);
	}

}
