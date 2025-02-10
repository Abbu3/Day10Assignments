package com.java.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
	public static int countWordFrequency(String filePath, String word) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+"); 
                for (String w : words) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
	public static void main(String[] args) {
		
	
			String filePath = "Input.txt";
			String word = "Developers";
	        int frequency = countWordFrequency(filePath, word);
	        System.out.println("The word '" + word + "' appears " + frequency + " times in the file.");
	}

}
