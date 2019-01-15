package ch14;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class G_TryWithResource {
	public static void main(String[] args) {
		Path file = Paths.get("D:\\jbisne\\java\\simple.txt");
				
		try (BufferedWriter writer = Files.newBufferedWriter(file);) {
			writer.write('A');
			writer.write('B');
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}