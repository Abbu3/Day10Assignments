package com.java.httpServer;
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.util.List;
	import java.util.Map;

	public class SimpleHttpClient {
	    public static void main(String[] args) {
	        String urlString = "https://jsonplaceholder.typicode.com/posts/1"; // Example API

	        try {
	            URL url = new URL(urlString);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");

	            // Print response headers
	            System.out.println("Response Headers:");
	            for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
	                System.out.println(header.getKey() + ": " + header.getValue());
	            }
	            System.out.println("\nResponse Body:");

	            // Read and print the response body
	            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    System.out.println(line);
	                }
	            }

	            connection.disconnect();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


