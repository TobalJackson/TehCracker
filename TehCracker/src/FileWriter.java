import java.util.List;
import java.util.ArrayList;

public class FileWriter {
	public static void main(String[] args){
		List<String> lines = new ArrayList<String>();
		lines.add("hello");
		lines.add("there");
		log(lines);
		
	}
	private static void log(Object aMsg){
	    System.out.println(String.valueOf(aMsg));
	  }
}
