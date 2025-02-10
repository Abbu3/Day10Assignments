package com.java.NOI;

import java.io.Serializable;

public class SerializableClass implements Serializable{

	    private static final long serialVersionUID = 1L;
	    private double num1;
	    private double num2;
	    private String operator;

	    public SerializableClass(double num1, double num2, String operator) {
	        this.num1 = num1;
	        this.num2 = num2;
	        this.operator = operator;
	    }

	    public double getNum1() {
	        return num1;
	    }

	    public double getNum2() {
	        return num2;
	    }

	    public String getOperator() {
	        return operator;
	    }
	}


