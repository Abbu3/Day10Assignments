package com.java.NOI;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SocketChannelServer {

	public static void main(String[] args) throws IOException {
		 SocketChannel server = null;
		try {
			server = SocketChannel.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//IPv4 Address: 192.168.212.49
	      InetSocketAddress socketAddr = new InetSocketAddress("192.168.212.49", 5010);  // server address and port
	      server.connect(socketAddr);
	      Path path = Paths.get("C:/Test/input.txt");
	      FileChannel fileChannel = FileChannel.open(path);
	      ByteBuffer buffer = ByteBuffer.allocate(1024);
	      while(fileChannel.read(buffer) > 0) {
	         buffer.flip();
	         server.write(buffer);
	         buffer.clear();
	      }
	      fileChannel.close();
	      System.out.println("File Sent");
	      server.close();

	}

}
