package com.java.basic;

import java.util.Arrays;
import java.util.Scanner;

public class A0 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		int arr1[] = new int [5];
		
		for(int j=0;j<arr1.length;j++) {
			arr1[j] = sc.nextInt();
		}
		
	
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr1.length;j++) {
				System.out.println(arr[i] + " " + arr1[j]);
			}
			
			System.out.println();
			
		}

		
	}

}
