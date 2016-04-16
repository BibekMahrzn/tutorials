/**
 * 
 */
package com.roufid.tutorials;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Append content to file using Apache Commons FileUtils.
 * 
 * @author Radouane ROUFID.
 *
 */
public class AppendToFileUsingFileUtils {

	public static void main(String[] args) {
		
		// File location.
		String filePath = "C:/dev/file.txt";

		File file = new File(filePath);
		
		// Content to append.
		String contentToAppend = "\nThis line was added at the end of the file !";
		
		try {
			//Set the third parameter to true to specify you want to append to file.
			FileUtils.write(file, contentToAppend, true);
		} catch (IOException e) {
			System.out.println("Problem occurs when deleting the directory : " + filePath);
			e.printStackTrace();
		}
	}

}
