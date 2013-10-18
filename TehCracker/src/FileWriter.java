import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileWriter {
	public static void main(String[] args){
		FileWriter fw = new FileWriter();
		List<String> someLines = Arrays.asList("Hello thar", "You too!");
		
		try {
			fw.writeTextFile("test", someLines);
			System.out.println("wrote some lines");
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	void writeTextFile(String fileName, List<String> linesToWrite) throws IOException{
		Path path = Paths.get(fileName);
		try {
			BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
			for(String line : linesToWrite){
				System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
