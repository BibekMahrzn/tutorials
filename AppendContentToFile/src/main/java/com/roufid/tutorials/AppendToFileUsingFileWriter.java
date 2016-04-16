package com.roufid.tutorials;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Append content to file using FileWriter.
 * 
 * @author Radouane ROUFID.
 *
 */
public class AppendToFileUsingFileWriter {

	public static void main(String[] args) {
		
		// File location.
		String filePath = "C:/dev/file.txt";

		// Content to append.
		String contentToAppend = "\nThis line was added at the end of the file !";

		// Set the second parameter of FileWriter to "true" to append to file.
		try (Writer fileWriter = new FileWriter(filePath, true)){
			fileWriter.write(contentToAppend);
		} catch (IOException e) {
			System.out.println("Problem occurs when deleting the directory : " + filePath);
			e.printStackTrace();
		} 
	}
	
}
