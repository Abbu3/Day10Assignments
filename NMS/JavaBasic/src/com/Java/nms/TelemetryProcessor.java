package com.Java.nms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelemetryProcessor {
	
	 public static void saveTelemetryData(List<String> data) { 
	       try (BufferedWriter writer = new BufferedWriter(new FileWriter("telemetryData.txt"))) { 
	           for (String record : data) { 
	               writer.write(record); 
	               writer.newLine(); 
	           } 
	           System.out.println("Telemetry data saved."); 
	       } catch (IOException e) { 
	           e.printStackTrace(); 
	       } 
	   } 

	public static void main(String[] args) {
		
		List<String> td = new ArrayList<String>();
		td.add("CPU Usage: 75%");
		td.add("Memory Usage: 60%");
		
		
		saveTelemetryData(td);
	}

}
