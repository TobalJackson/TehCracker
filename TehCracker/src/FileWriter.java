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
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileWriter {
	public static void main(String[] args){
		FileWriter fw = new FileWriter();
		List<String> sitKeys = new ArrayList<String>();
		String sitPrefix = "SIT-";
		try {
			for(int i = 0; i < 1000000; i++){
				String key = Integer.toHexString(i);
				StringBuilder keyPad = new StringBuilder(12);
				keyPad.append(sitPrefix);
				while((key.length() + keyPad.length()) < 12){
					keyPad.append("0");
				}
				keyPad.append(key);
				sitKeys.add(keyPad.toString());
			}
			fw.writeTextFile("sitkeys", sitKeys);
			System.out.println("wrote some lines");
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Integer.MAX_VALUE);
	}
	void writeTextFile(String fileName, List<String> linesToWrite) throws IOException{
		Path path = Paths.get(fileName);
		try {
			BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
			for(String line : linesToWrite){
				//System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
			writer.close(); //adding close() wrote the lines.  I'm guessing that it won't write to the file until either the buffer is filled (8k?) or the stream is closed?
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
