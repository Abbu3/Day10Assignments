package com.Java.nms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestConfCrudExample {
	
	  private static final String BASE_URL = "http://localhost:8080/restconf/data/";
	
	 public static void createResource() throws IOException { 
	       String data = "{ \"config\": { \"name\": \"example\" } }"; 
	       sendRequest("POST", data); 
	   } 
	  
	   public static void readResource() throws IOException { 
	       sendRequest("GET", null); 
	   } 
	  
	   public static void updateResource() throws IOException { 
	       String data = "{ \"config\": { \"name\": \"updatedExample\" } }"; 
	       sendRequest("PUT", data); 
	   } 
	  
	   public static void deleteResource() throws IOException { 
	       sendRequest("DELETE", null); 
	   } 
	  
	   public static void sendRequest(String method, String data) throws IOException { 
	      
		URL url = new URL(BASE_URL); 
	       HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
	       conn.setRequestMethod(method); 
	       conn.setRequestProperty("Content-Type", "application/json"); 
	       conn.setDoOutput(true); 
	  
	       if (data != null) { 
	           try (OutputStream os = conn.getOutputStream()) { 
	               os.write(data.getBytes()); 
	           } 
	       } 
	  
	       System.out.println("Response Code: " + conn.getResponseCode()); 
	       BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
	       String inputLine; 
	       while ((inputLine = in.readLine()) != null) { 
	           System.out.println(inputLine); 
	       } 
	       in.close(); 
	   }
	
	public static void main(String[] args) throws IOException {
		
		  createResource(); 
	       readResource(); 
	       updateResource(); 
	       deleteResource(); 
		
	}

}
