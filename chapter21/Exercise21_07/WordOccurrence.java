import java.io.Serializable;
import java.util.HashMap;

public class WordOccurrence extends HashMap<String, Integer> implements 
	Comparable<WordOccurrence>, Serializable {
	
	private String word;
	private int count;
	
	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	@Override
	public int compareTo(WordOccurrence o) {
		
		if (this.count > o.count) {
			return 1;
		} else if (this.count < o.count) {
			return -1;
		} else {
			return 0;
		}	
	}
	
	@Override
	public String toString() {
		return "\n" + this.getWord() + "\t" + this.getCount();
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

