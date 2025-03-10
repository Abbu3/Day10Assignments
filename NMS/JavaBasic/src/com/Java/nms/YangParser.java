package com.Java.nms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class YangParser {
	
	public static void main(String[] args) {
		String filePath = "sample.yang"; // Path to YANG model file

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			
			String line;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

		} 

}
