import java.util.ArrayList;
import java.util.List;
/**
 * Class which employs both the FileReader and StringHasher classes to hash the Dictionary File. Requires passing both
 * the DictFile and HashFile for the constructor to validate that both exist.
 * @author tobaljackson
 *
 */
public class DictHasher {
	private List<String> dictHashes = new ArrayList<String>();
	private List<String> dictWords = null;
	private List<String> hashWords = null;
	public DictHasher(String dictFile, String hashFile){
		FileReader fr = null; 
		StringHasher sh = new StringHasher();
		try{
			fr = new FileReader(dictFile, hashFile);  //tries since FileReader can throw FileInaccessible.
		}
		catch(FileInaccessible e){
			e.printStackTrace();
		}
		dictWords = fr.getDictEntries();
		hashWords = fr.getHashEntries();
		System.out.println("Hashing Dictionary...");
		for (String word : dictWords){
			dictHashes.add(sh.hashTheString(word));
		}
	}
	/**
	 * Method to retrieve List<String> of all the hashed words in the dictionary.
	 * @return List<String> dictHashes.
	 */
	public List<String> getDictHashes(){
		return dictHashes;
	}
	/**
	 * Method to retrieve List<String> of all the words in the dictionary.
	 * @return List<String> dictWords.
	 */
	public List<String> getDictWords(){
		return dictWords;
	}
	/**
	 * Method to retrieve List<String> of all the hashWords in the hash file. The hashwords are the enciphered-text which we are trying to break with the dictionary.
	 * @return List<String> dictWords.
	 */
	public List<String> getHashWords(){
		return hashWords;
	}
}
