import java.util.List;
import java.util.ArrayList;
public class MatchMaker {
	private ArrayList<String> dictWords = null;
	private ArrayList<String> dictHashes = null;
	private ArrayList<String> hashWords = null;
	private int index;
	private boolean moreWordsThanHashes;
	public MatchMaker(DictHasher dh){
		dictWords = (ArrayList<String>)dh.getDictWords();
		dictHashes = (ArrayList<String>)dh.getDictHashes();
		hashWords = (ArrayList<String>)dh.getHashWords();
		index = 0;
		moreWordsThanHashes = (dictHashes.size() > hashWords.size());
	}
	
}
