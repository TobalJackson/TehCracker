import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
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
		findCollisions();
	}
	
	public void findCollisions(){
		for (String hash : hashWords){
			if (dictHashes.contains(hash)){
				matchTable.put(hash, hashTable.get(hash));
			}
		}
	}
	
	public HashMap<String,String> getCollisions(){
		return matchTable;
	}
	
	public void printCollisions(){
		System.out.println("Matches Found:");
		for (String key : matchTable.keySet()){
			System.out.println("Key: \"" + key + " Matched Hash: " + matchTable.get(key));
		}
	}
	
}
