package pl.andrzejszywala.samples.files;

import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class FileSamples {

	/**
	 * Print all lines in file to console
	 */
	@Test
	public void printAllLines() {
		try {
			Files.lines(Paths.get("file.txt")).forEach(out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
