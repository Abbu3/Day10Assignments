package com.java.httpServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HttpClient {

	public static void main(String[] args) {
	
	
	try {
		Socket s = new Socket("localhost", 6666);
		DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
		dataOutputStream.writeUTF("Hello, I am from client");
		dataOutputStream.writeUTF("I am Abdul Shaik from Railway Kodur");
		dataOutputStream.flush();
		//System.out.println(dataOutputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

	}

}
