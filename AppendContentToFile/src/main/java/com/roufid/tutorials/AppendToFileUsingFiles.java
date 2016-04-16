package com.roufid.tutorials;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Append content to file using java.nio.file.Files.
 * 
 * @author Radouane ROUFID.
 *
 */
public class AppendToFileUsingFiles {

	public static void main(String[] args) {
		
		// File location.
		String filePath = "C:/dev/file.txt";
		
		// Content to append.
		String contentToAppend = "\nThis line was added at the end of the file !";
		
		try {
			Files.write(Paths.get(filePath), contentToAppend.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Problem occurs when deleting the directory : " + filePath);
			e.printStackTrace();
		}
	}

}
