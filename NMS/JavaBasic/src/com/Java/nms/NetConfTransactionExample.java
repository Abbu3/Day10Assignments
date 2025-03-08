package com.Java.nms;

public class NetConfTransactionExample {
	
	   public static boolean editConfiguration() { 
	       // Simulate editing configuration 
	       // Return false to simulate error 
	       return false; 
	   } 
	  
	   public static void rollbackTransaction() { 
	       System.out.println("Transaction rolled back."); 
	   }
	
	public static void main(String[] args) {
		 try { 
	           // Start NETCONF session and transaction 
	           System.out.println("Starting transaction..."); 
	  
	           // Edit configuration (dummy example) 
	           boolean success = editConfiguration(); 
	           if (!success) { 
	               throw new Exception("Configuration error"); 
	           } 
	  
	           System.out.println("Transaction completed successfully."); 
	       } catch (Exception e) { 
	           System.out.println("Error occurred. Rolling back transaction."); 
	           rollbackTransaction(); 
	       } 
	}

}
