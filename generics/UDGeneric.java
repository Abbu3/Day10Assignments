package com.java.generics;

public class UDGeneric {

	public static void main(String[] args) {
		Test<String> test = new Test("Abdul");
		test.show();
		System.out.println(test.getObject());

	}

}


class Test<T> {
	T obj;

	public Test(T obj) {
		super();
		this.obj = obj;
	}
	
	public void show() {
		System.out.println("generic type : " +obj.getClass().getName());
	}
	
	public T getObject() {
		return obj;
	}
}