import java.util.List;
import java.util.ArrayList;
public class MatchMaker {
	private List<String> dictWords = null;
	private List<String> dictHashes = null;
	private List<String> hashWords = null;
	public MatchMaker(DictHasher dh){
		dictWords = dh.getDictWords();
		dictHashes = dh.getDictHashes();
		hashWords = dh.getHashWords();//test
	}
}
