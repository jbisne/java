import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class D3_IOExceptionCase3 {
	public static void main(String[] args) {
		try {
			md1();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void md1() throws IOException {
		md2();
	}
	public static void md2() throws IOException {
		Path file = Paths.get("D:\\jbisne\\java\\simple.txt");
		BufferedWriter writer = null;
		writer = Files.newBufferedWriter(file);
		writer.write('O');
		writer.write('Z');
		
		if(writer != null)
			writer.close();
	}

}
