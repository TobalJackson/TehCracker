import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
//1. import dictionary file
//2. import hashes to crack file
//3. hash the (entire Dictionary?) entries and check for matches per entry
//4. print out matching 
public class TehCracker {
	public static void main(String[] args){
		if (args.length != 2){
			printUsage();
		}
		DictHasher dh = new DictHasher(args[0], args[1]);
		MatchMaker mm = new MatchMaker(dh);
		mm.printCollisions();
		
		
//		StringHasher sh = new StringHasher();
//		System.out.print(sh.hashTheString("password"));
		
	}
	

	private static void printUsage() {
		System.out.println("Usage: java TehCracker <dictionary file> <hash file>");	
		System.exit(0);
	}
}
