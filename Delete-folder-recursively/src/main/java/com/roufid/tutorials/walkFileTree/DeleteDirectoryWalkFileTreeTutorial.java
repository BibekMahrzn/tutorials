package com.roufid.tutorials.walkFileTree;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Deleting recursively a directory with native Java.
 * 
 * @author Radouane ROUFID.
 *
 */
public class DeleteDirectoryWalkFileTreeTutorial {

	public static void main(String[] args) {

		// Directory path.
		String directoryPath = "C:/dev/directory";

		try {
			// Deleting the directory recursively.
			delete(directoryPath);
			System.out.println("Directory has been deleted recursively !");
		} catch (IOException e) {
			System.out.println("Problem occurs when deleting the directory : " + directoryPath);
			e.printStackTrace();
		}
	}

	/**
	 * Walk a directory and delete it and its children.
	 * 
	 * @param directoryName
	 *            Directory path
	 * @throws IOException
	 *             Exception when problem occurs during deleting the directory.
	 */
	private static void delete(String directoryPath) throws IOException {

		Path directory = Paths.get(directoryPath);
		Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
					throws IOException {
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}
}