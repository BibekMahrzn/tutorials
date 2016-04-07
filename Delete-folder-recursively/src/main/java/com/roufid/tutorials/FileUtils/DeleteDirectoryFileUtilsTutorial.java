package com.roufid.tutorials.FileUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Delete a directory recursively.
 * 
 * @author Radouane ROUFID.
 * 
 */
public class DeleteDirectoryFileUtilsTutorial {
	
	public static void main(String[] args) {
		
		// Directory path.
		String directoryPath = "C:/dev/directory";
		File file = new File(directoryPath);
		
		try {
			//Deleting the directory recursively using FileUtils.
			FileUtils.deleteDirectory(file);
			System.out.println("Directory has been deleted recursively !");
		} catch (IOException e) {
			System.out.println("Problem occurs when deleting the directory : " + directoryPath);
			e.printStackTrace();
		}
	}
}