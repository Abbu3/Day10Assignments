package com.java.httpServer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonReflection {
	
	public static void main(String[] args) {
        try {
            // Get Class object
            Class<?> personClass = PersonReflection.class;

            // Print class name
            System.out.println("Class Name: " + personClass.getName());

            // Get and print constructors
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : personClass.getDeclaredConstructors()) {
                System.out.println(constructor);
            }

            // Get and print methods
            System.out.println("\nMethods:");
            for (Method method : personClass.getDeclaredMethods()) {
                System.out.println(method);
            }

            // Get and print fields
            System.out.println("\nFields:");
            for (Field field : personClass.getDeclaredFields()) {
                System.out.println(field);
            }

            // Create an instance of Person
            Object personInstance = personClass.getDeclaredConstructor().newInstance();

            // Modify private field "name"
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true);  // Bypass private access
            nameField.set(personInstance, "John Doe");  // Set new value

            // Modify private field "age"
            Field ageField = personClass.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(personInstance, 30);

            // Invoke public method to check changes
            Method displayMethod = personClass.getMethod("display");
            displayMethod.invoke(personInstance);

            // Invoke private method using reflection
            Method secretMethod = personClass.getDeclaredMethod("secretMethod");
            secretMethod.setAccessible(true);
            secretMethod.invoke(personInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	   



class ReflectionDemo {
	
	 private String name;
	    private int age;

	    public ReflectionDemo() {
	        this.name = "Default Name";
	        this.age = 25;
	    }

	    public ReflectionDemo(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    private void secretMethod() {
	        System.out.println("This is a private method!");
	    }

	    public void display() {
	        System.out.println("Name: " + name + ", Age: " + age);
	    }
	}
}
    

