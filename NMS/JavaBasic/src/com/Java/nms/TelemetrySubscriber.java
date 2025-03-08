package com.Java.nms;

public class TelemetrySubscriber {
	
	  public static String getTelemetryData() { 
	       // Dummy data - in real implementation, fetch from NETCONF device 
	       return "CPU Usage: 75%"; 
	   }


	public static void main(String[] args) {
		
		 while (true) { 
	           String telemetryData = getTelemetryData(); 
	           System.out.println("Telemetry Data: " + telemetryData); 
	  
	           try { 
	               Thread.sleep(2000); // Pause before next update 
	           } catch (InterruptedException e) { 
	               e.printStackTrace(); 
	           } 
	}
	}
	
}


