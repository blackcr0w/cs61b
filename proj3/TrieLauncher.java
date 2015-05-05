/**
 * Alphabet Sort
 * @author MJ
 */

import java.io.*;
import java.util.*;

public class TrieLauncher {

    public static void main (String[] args) {
        List<String> myList = new ArrayList<String>();
        System.out.println(myList);
        /*if (myList == []) 
            System.out.println("the list is []");*/


        String ss = new String();
        int a = 1;
        int b = 2;
        ss = ss + a;
        System.out.println(ss);
        System.out.println(" ");
        ss = ss + b;
        System.out.println(ss);
        System.out.println(" ");
    	Trie myTrie = new Trie();
    	int d = 0;
    	String key = "Beijing";
    	char c = key.charAt(d);

		//int a = (int)c;
		/*方法二：int i = Integer.parseInt(String.valueOf(a));*/
		//System.out.println(a);



    	myTrie.put("Beijing");
    	myTrie.put("Shanghai");
    	myTrie.put("Hello");
    	myTrie.put("Hell");
    	myTrie.put("He");
/*    	for(int i = 0; i < 26; i +=1) {
    		System.out.println(myTrie.root.links[i]);
            if (i == 1) {
                System.out.println(myTrie.root.links[i].links[4]);
                System.out.println(myTrie.root.links[i].links[5]);

            }
            if (myTrie.root.links[i] != null) {
                char ch = (char)(i + 'A');
                System.out.println(ch);
            }
            
    	}*/
        System.out.println(myTrie.find("beiji", false));
    }	
}