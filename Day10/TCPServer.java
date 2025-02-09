package com.java.NOI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	    public static void main(String[] args) {
	        int port = 5000;  // Server port

	        try (ServerSocket serverSocket = new ServerSocket(port)) {
	            System.out.println("Server is listening on port " + port);

	            while (true) {
	                Socket socket = serverSocket.accept();
	                System.out.println("Client connected.");

	                // Handle client request in a new thread
	                new Thread(() -> handleClient(socket)).start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void handleClient(Socket socket) {
	        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
	             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {

	            // Receive object from client
	            SerializableClass operation = (SerializableClass) inputStream.readObject();
	            double result = performCalculation(operation);

	            // Send result back to client
	            outputStream.writeObject(result);
	            System.out.println("Processed: " + operation.getNum1() + " " + operation.getOperator() + " " + operation.getNum2() + " = " + result);
	            
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                socket.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private static double performCalculation(SerializableClass op) {
	        double num1 = op.getNum1();
	        double num2 = op.getNum2();
	        String operator = op.getOperator();

	        return switch (operator) {
	            case "+" -> num1 + num2;
	            case "-" -> num1 - num2;
	            case "*" -> num1 * num2;
	            case "/" -> (num2 != 0) ? num1 / num2 : Double.NaN;
	            default -> Double.NaN;
	        };
	    }
	}

