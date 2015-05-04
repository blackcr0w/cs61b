/**
 * Alphabet Sort
 * @author MJ
 */

import java.io.*;
import java.util.*;

public class AlphabetTrie {
	/* A triset supports upto R characters.*/
	public static int R;
	/*This is the array of the new Alphabet*/
	List<Character> abList = new ArrayList<Character>();
	/*A Node class inside the Trie.*/
	public class Node {
		boolean exists;
		Node[] links;

		public Node() {
			links = new Node[R];
			exists = false;
		}
	}
	public Node root;
	
	public AlphabetTrie(String s) {
		R = s.length();
		for (int i = 0; i < s.length(); i ++) {
         	char c = s.charAt(i);
         	abList.add(c);
         }
         root = new Node();
	}
	
	public AlphabetTrie() {
		root = new Node();
	}

	/*Below are methods in Trie*/
	public void put(String key) {
		put(root, key, 0);
	}
	public Node put(Node x, String key, int d) {
		//System.out.println("in the put.");
		if(key == null || key.length() == 0) 
			throw new IllegalArgumentException();
		if (x == null) {
			//System.out.println("1");
			x = new Node();
		}
		if (d == key.length()) {
			x.exists = true;
			return x;
		}
		char c = key.charAt(d);
		int index = abList.indexOf(c);
		/*System.out.println(index);
		System.out.println(R);*/
		x.links[index] = put(x.links[index], key, d + 1);
		return x;
	}	

    public boolean find(String s, boolean isFullWord) {
    	Node n = root;
    	Node t = new Node();
    	int index = 0;

    	for (int i = 0; i < s.length(); i += 1) {
    		char c = s.charAt(i);
    		index = abList.indexOf(c);
			if (n.links[index] == null) 
    			return false;
    		else n = n.links[index];

    	}

    	if ((isFullWord) == false)
    		return true;
    	else return n.exists;

    }

    public void insert(String s) {
    	put(s);
    }

    public void sort() {
    	for (int i = 0; i < R; i ++) {
    		
    		if (root.links[i] == null) continue;
    		else {
    			String s = new String();
    			s = s + i;
    			
    			sort(root.links[i], s);
    		}  		
    	}
    }

    public void sort(Node n, String s) {
    	//System.out.println("in the sort");
    	//System.out.println(s);
    	if (n.exists == true) {
    		for (int i =0; i < s.length(); i ++) {
    			char c = s.charAt(i);
    			//System.out.print(s);
    			System.out.print(abList.get(c - '0'));
    		}
    		System.out.println();
    		return;
    	}
    	/*if ((n.links).length == 0 || n.links == null) 
    		return;*/
    	for (int i = 0; i < R; i ++) {
    		if (n.links[i] != null) {
    			s = s + i;
    			sort(n.links[i], s);
    		}
    		else continue;
    	}
    }

    /*public static void main(String[] args) {
    	
	    try {
	    String s;
        BufferedReader br = 
          new BufferedReader(new InputStreamReader(System.in));
         s = br.readLine();

         AlphabetTrie myTrie = new AlphabetTrie(s);

         for (int i = 0; i < abList.size(); i ++) {
         	System.out.println(abList.get(i));
         }
        while ((s = br.readLine()) != null) {
        	System.out.println(s);
        	myTrie.insert(s);
        	
        }
       
    } catch (Exception e) {
        System.err.println("Error:" + e.getMessage());
    }
	}*/

}



