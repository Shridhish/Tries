import java.util.HashMap;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root=new TrieNode();
	}
	
	public void insert(String word) {
		
		TrieNode current=root;
		
		for(int i=0;i<word.length();i++) {
			char ch=word.charAt(i);
			if(current.children==null) {
				current.children=new HashMap<Character,TrieNode>();
			}
			if(!current.children.containsKey(ch)) {
				current.children.put(ch, new TrieNode(ch));
			}
			current=current.children.get(ch);
		}
		current.isLeaf=true;
	}
	
	public boolean search(String word) {
		
		TrieNode current=root;
		for(int i=0;i<word.length();i++) {
			char ch=word.charAt(i);
			if(!current.children.containsKey(ch)) {
				return false;
			}
			current=current.children.get(ch);
		}
		
		return current.isLeaf;
	}
	public boolean startsWith(String prefix) {
		TrieNode current=root;
		
		for(int i=0;i<prefix.length();i++) {
			char ch=prefix.charAt(i);
			
			if(!current.children.containsKey(ch)) {
				return false;
			}
			current=current.children.get(ch);
		}
		return true;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trie obj=new Trie();
		obj.insert("abc");
		obj.insert("abcd");
		obj.insert("cap");
		obj.insert("cap");
		obj.insert("pen");
		obj.insert("pencil");
		obj.insert("shri");
		
		System.out.println(obj.search("abcd")); //returns true
		System.out.println(obj.startsWith("pencil")); //returns true
		

	}

}
