package com.roufid.tutorials.nativeJava;

import java.io.File;
import java.io.IOException;

/**
 * Deleting recursively a directory with native Java.
 * 
 * @author Radouane ROUFID.
 *
 */
public class DeleteDirectoryNativeJavaTutorial {

	public static void main(String[] args) {

		// Directory path.
		String directoryPath = "C:/dev/directory";
		File file = new File(directoryPath);

		try {
			// Deleting the directory recursively.
			delete(file);
			System.out.println("Directory has been deleted recursively !");
		} catch (IOException e) {
			System.out.println("Problem occurs when deleting the directory : " + directoryPath);
			e.printStackTrace();
		}
	}

	/**
	 * Delete a file or a directory and its children.
	 * 
	 * @param file
	 *            The directory to delete.
	 * @throws IOException
	 *             Exception when problem occurs during deleting the directory.
	 */
	private static void delete(File file) throws IOException {

		for (File childFile : file.listFiles()) {

			if (childFile.isDirectory()) {
				delete(childFile);
			} else {
				if (!childFile.delete()) {
					throw new IOException();
				}
			}
		}

		if (!file.delete()) {
			throw new IOException();
		}
	}

}
