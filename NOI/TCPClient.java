package com.java.NOI;

	import java.io.*;
	import java.net.*;

	public class TCPClient {
	    public static void main(String[] args) {
	        String serverAddress = "localhost";
	        int port = 5000;

	        try (Socket socket = new Socket(serverAddress, port);
	             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
	             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

	            // Create and send Operation object
	            SerializableClass operation = new SerializableClass(2, 2, "+");
	            outputStream.writeObject(operation);

	            // Receive result from server
	            double result = (double) inputStream.readObject();
	            System.out.println("Received result from server: " + result);

	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}


