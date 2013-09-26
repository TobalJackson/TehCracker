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
			fr = new FileReader(dictFile, hashFile);
		}
		catch(FileInaccessible e){
			e.printStackTrace();
		}
		dictWords = fr.getDictEntries();
		hashWords = fr.getHashEntries();
		for (String word : dictWords){
			dictHashes.add(sh.hashTheString(word));
		}
	}
	/**
	 * Method to retrieve List<String> of all the hashed words in the dictionary.
	 * @retu)rn
	 */
	public List<String> getDictHashes(){
		return dictHashes;
	}
	public List<String> getDictWords(){
		return dictWords;
	}
	public List<String> getHashWords(){
		return hashWords;
	}
}
