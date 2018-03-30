import java.util.HashMap;

public class TrieNode {

	 HashMap<Character,TrieNode> children;
	 char val;
	 boolean isLeaf;


	public TrieNode() {
		isLeaf=false;
		children=new HashMap<>();
	}

	public TrieNode(char c) {
		
		val=c;
	}


}
