import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;

/**
 * object which will open a file and get the lines from the file into List<String>s for both the dictionary and hashfile. Provides getter methods for the dictFile and HashFile which return List<String>s. 
 * @throws FileInaccessible on default constructor if either dictFile or hashFile are not-readable
 * @author tobaljackson
 *
 */

public class FileReader {
	private List<String> dictEntries = null;
	private List<String> hashEntries = null;
	private Path dictFile = null;
	private Path hashFile = null;
	/**
	 * Validates that both the dictFile and hashFile exist and are readable before allowing the reading of them into a list.
	 * @param dictFile
	 * @param hashFile
	 * @throws FileInaccessible
	 */
	public FileReader(String dictFile, String hashFile) throws FileInaccessible{
		this.dictFile = FileSystems.getDefault().getPath(dictFile);
		this.hashFile = FileSystems.getDefault().getPath(hashFile);
		if (!Files.exists(this.dictFile)){
			throw new FileInaccessible("File: \"" + this.dictFile.toString() + "\" does not exist!");
		}
		else if(!Files.isReadable(this.dictFile)){
			throw new FileInaccessible("File: \"" + this.dictFile.toString() + "\"is not readable!");			
		}
		if (!Files.exists(this.hashFile)){
			throw new FileInaccessible("File: \"" + this.hashFile.toString() + "\" does not exist!");
		}
		else if(!Files.isReadable(this.hashFile)){
			throw new FileInaccessible("File: \"" + this.hashFile.toString() + "\" is not readable!");			
		}
	}
	/**
	 * Method which will return a List<String> of all the lines in the dictFile.
	 * @return
	 */
	public List<String> getDictEntries(){
		try{
			this.dictEntries = Files.readAllLines(this.dictFile, StandardCharsets.UTF_8);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return this.dictEntries;
	}
	/**
	 * Method which will return a List<String of all the lines in the hashFile.
	 * @return
	 */
	public List<String> getHashEntries(){
		try{
			this.hashEntries = Files.readAllLines(this.hashFile, StandardCharsets.UTF_8);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return this.hashEntries;
	}
}
