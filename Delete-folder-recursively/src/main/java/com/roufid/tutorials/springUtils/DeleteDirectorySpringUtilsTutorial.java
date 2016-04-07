package com.roufid.tutorials.springUtils;

import java.io.File;

import org.springframework.util.FileSystemUtils;

/**
 * Delete directory with Spring Util.
 * 
 * @author Radouane ROUFID.
 *
 */
public class DeleteDirectorySpringUtilsTutorial {

	public static void main(String[] args) {

		// / Directory path.
		String directoryPath = "C:/dev/directory";
		File file = new File(directoryPath);

		// Deleting the directory recursively with SpringUtil.
		if (!FileSystemUtils.deleteRecursively(file)) {
			System.out.println("Problem occurs when deleting the directory : " + directoryPath);
		}
	}

}