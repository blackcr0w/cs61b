/**
 * Prefix-Trie. Supports linear time find() and insert(). 
 * Should support determining whether a word is a full word in the 
 * Trie or a prefix.
 * @author MJ
 */
public class Trie {

	/* A triset supports upto 26 characters.*/
	public static final int R = 26;
	/*A Node class inside the Trie.*/
	public class Node {
		boolean exists;
		Node[] links;

		public Node() {
			links = new Node[R];
			exists = false;
		}
	}
	/* An instance of root node.*/
	/*public Node root = new Node();*/
	public Node root;

	public Trie() {
		root = new Node();
	}

	/*Below are methods in Trie*/
	public void put(String key) {
		put(root, key, 0);
	}
	public Node put(Node x, String key, int d) {
		if(key == null || key.length() == 0)
			throw new IllegalArgumentException();
		if (x == null) {
			x = new Node();
		}
		if (d == key.length()) {
			x.exists = true;
			return x;
		}
		char c = key.charAt(d);
		int index;
		if ((c - 'a') < 0)
			index = c - 'A';
		else index = c - 'a';
		//System.out.println(index);
		x.links[index] = put(x.links[index], key, d + 1) ;
		return x;
	}	

    public boolean find(String s, boolean isFullWord) {
    	Node n = root;
    	Node t = new Node();
    	int index = 0;

    	for (int i = 0; i < s.length(); i += 1) {
    		char c = s.charAt(i);

			if ((c - 'a') < 0)
				index = c - 'A';
			else index = c - 'a';
			if (n.links[index] == null) 
    			return false;
    		else n = n.links[index];

    	}

    	if ((isFullWord) == false)
    		return true;
    	else return n.exists;

    }

    public void insert(String s) {
    	put (s);
    }

/*    public static void main(String[] args) {
	    Trie t = new Trie();
	    t.insert("hello");
	    t.insert("hey");
	    t.insert("goodbye");
	    t.insert(null);
	    System.out.println(t.find("hell", false));
	    System.out.println(t.find("hello", true));
	    System.out.println(t.find("good", false));
	    System.out.println(t.find("bye", false));
	    System.out.println(t.find("heyy", false));
	    System.out.println(t.find("hell", true));
	}*/
}
