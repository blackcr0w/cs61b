/**
 * Alphabet Sort
 * @author MJ
 */

import java.io.*;
import java.util.*;

public class AlphabetSort {
    public static void main(String[] args) {
    	
	    try {
	    String s;
        BufferedReader br = 
          new BufferedReader(new InputStreamReader(System.in));
         s = br.readLine();

         AlphabetTrie myTrie = new AlphabetTrie(s);

         /*for (int i = 0; i < abList.size(); i ++) {
         	System.out.println(abList.get(i));
         }*/
        while ((s = br.readLine()) != null) {
        	System.out.println(s);
        	myTrie.put(s);
        	
        }
       
    } catch (Exception e) {
        System.err.println("Error:" + e.getMessage());
    }
	}	
}