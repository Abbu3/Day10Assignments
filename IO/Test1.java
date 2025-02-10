package com.java.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
		try {
			FileWriter fileWriter = new FileWriter("Output.txt");
			
			FileReader fileReader = new FileReader("Input.txt");
			int n = 0;
			while( (n = fileReader.read()) != -1)  {
				System.out.print((char)n);
				fileWriter.write(fileReader.read());
				fileWriter.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	
	}

}

