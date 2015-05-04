/**
 * Alphabet Sort
 * @author MJ
 */

import java.io.*;
import java.util.*;

public class AlphabetSort {

    public static AlphabetTrie myTrie = new AlphabetTrie();
    public static String s = new String();

    public static void main(String[] args) {

	    try {
	    
        BufferedReader br = 
          new BufferedReader(new InputStreamReader(System.in));
         s = br.readLine();

         myTrie = new AlphabetTrie(s);

         /*for (int i = 0; i < abList.size(); i ++) {
         	System.out.println(abList.get(i));
         }*/
        while ((s = br.readLine()) != null) {
        	System.out.println(s);
        	myTrie.put(s);
        	
        }        
    } catch (Exception e) {
        System.out.println(e);
        System.err.println(e.getMessage());
    }
    myTrie.sort();
	}

}