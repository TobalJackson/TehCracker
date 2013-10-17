import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Object which gets passed a DictHasher to perform the matching operation to discover collisions between the hashed dictionary and the hashfile's extracted hashes.
 * @see getCollisions() - returns a HashMap<String, String> of all the matched hashes.
 * @see printCollisions() - prints to stdout all the matched hashes.
 * @author TobalJackson
 *
 */
public class MatchMaker {
	private ArrayList<String> dictWords = null;
	private ArrayList<String> dictHashes = null;
	private ArrayList<String> hashWords = null;
	private HashMap<String,String> hashTable = new HashMap<String,String>();
	private HashMap<String,String> matchTable = new HashMap<String,String>();
	private int index;
	private boolean moreWordsThanHashes;
	public MatchMaker(DictHasher dh){
		dictWords = (ArrayList<String>)dh.getDictWords();
		dictHashes = (ArrayList<String>)dh.getDictHashes();
		hashWords = (ArrayList<String>)dh.getHashWords();
		index = 0;
		moreWordsThanHashes = (dictHashes.size() > hashWords.size());
		for (int i = 0; i < dictWords.size(); i++){
			hashTable.put(dictHashes.get(i), dictWords.get(i));
		}
		System.out.println("Searching for collisions...");
		findCollisions();
	}
	
	public void findCollisions(){
		for (String hash : hashWords){
			if (dictHashes.contains(hash)){
				matchTable.put(hash, hashTable.get(hash));
			}
		}
	}
	/**
	 * Method which returns all the collisions between the dictfile and hashfile.
	 * @returns HashMap<String, String> of the collisions.
	 */
	public HashMap<String,String> getCollisions(){
		return matchTable;
	}
	/**
	 * prints the collision data out to stdout.
	 */
	public void printCollisions(){
		System.out.println("Matches Found:");
		for (String key : matchTable.keySet()){
			System.out.println("Hash: \"" + key + "\" Key: " + matchTable.get(key));
		}
	}
	
}
