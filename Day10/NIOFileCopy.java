package com.java.NOI;


	import java.io.IOException;
	import java.nio.ByteBuffer;
	import java.nio.channels.FileChannel;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.StandardOpenOption;

	public class NIOFileCopy {
	    public static void main(String[] args) {
	        Path sourceFile = Path.of("source.txt");   // Source file
	        Path destinationFile = Path.of("destination.txt"); // Destination file

	        // Ensure the destination file exists (create if not present)
	        try {
	            if (!Files.exists(destinationFile)) {
	                Files.createFile(destinationFile);
	            }
	        } catch (IOException e) {
	            System.err.println("Error creating file: " + e.getMessage());
	        }

	        // Using try-with-resources to ensure channels are closed properly
	        try (FileChannel sourceChannel = FileChannel.open(sourceFile, StandardOpenOption.READ);
	             FileChannel destinationChannel = FileChannel.open(destinationFile, StandardOpenOption.WRITE)) {

	            ByteBuffer buffer = ByteBuffer.allocate(1024); // Allocate a buffer of 1 KB

	            while (sourceChannel.read(buffer) > 0) { // Read data into buffer
	                buffer.flip(); // Switch to read mode
	                destinationChannel.write(buffer); // Write data from buffer to destination
	                buffer.clear(); // Clear buffer for next read
	            }

	            System.out.println("File copied successfully!");

	        } catch (IOException e) {
	            System.err.println("File operation error: " + e.getMessage());
	        }
	    }
	}

