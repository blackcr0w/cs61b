package proj1data;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.introcs.In;
import java.util.*;


public class ReadFile {
public static void main (String[] args) {
      In synsetFile  = new In("proj1data/wordnet/synsets11.txt");
      In hyponymFile  = new In("proj1data/wordnet/hyponyms11.txt");
      String[] rawSynsets = synsetFile.readAllLines();
      String[] rawHyponyms = hyponymFile.readAllLines();

      
      String[][] synsetSplit = new String[rawSynsets.length][15];
      String[][] synset = new String[rawSynsets.length][];
      String[][] hyponym = new String[rawHyponyms.length][];

/*      String space = " ";*/

      for (int i = 0; i < rawSynsets.length; i ++) {
        synset[i] = rawSynsets[i].split(",");
      }
      for (int i = 0; i < rawSynsets.length; i ++) {
       // System.out.println(synset[i][1]);
      }

      for (int i = 0; i < synset.length; i++) {
      	int flag = synset[i][1].indexOf(" ");
/*      	System.out.println(synset[i][1]);
      	
      	//synsetSplit[i] = new String[20];
      	
      	System.out.println(synsetSplit[i][0]);*/

      	if (flag < 0) {
      		synsetSplit[i][0] = synset[i][1];
      		System.out.println(synsetSplit[i][0]);

      	}
      	else {
      		synsetSplit[i] = synset[i][1].split(" "); 
      	     System.out.println(synsetSplit[i][0]);

      	}
      }

      Map<String, Integer> WordtoIDMap = new HashMap<String, Integer> ();
      Map<Integer, String> IDtoWordMap = new HashMap<Integer, String> ();

      for (int i = 0; i < synset.length; i++) {
        WordtoIDMap.put(synsetSplit[i][0], i);
      }
      for (int i = 0; i < synset.length; i++) {
      	for (int j = 0; j < synsetSplit[i].length; j ++)
        IDtoWordMap.put(i, synsetSplit[i][j]);
      } 

      for (int i = 0; i < rawHyponyms.length; i ++) {
        hyponym[i] = rawHyponyms[i].split(",");
      }
/*      for (int i = 0; i < rawHyponyms.length; i ++)
      	System.out.println(hyponym[i][0]);*/

      	Integer aa = WordtoIDMap.get("change");
      	System.out.println(aa != null);

      Digraph g = new Digraph(synset.length);
      for(int i = 0; i < rawHyponyms.length; i ++) {
        for(int j = 1; j < hyponym[i].length; j ++) {
          g.addEdge(Integer.valueOf(hyponym[i][0]), Integer.valueOf(hyponym[i][j]));
        }        
      } 

      //System.out.println(g);
        Set<Integer> five = new TreeSet<Integer>();
        five.add(5);

        //System.out.println("Descendants of 5: ");
        Set<Integer> a = new TreeSet<Integer>();
        a = GraphHelper.descendants(g, five);

        Set<String> reSet = new HashSet<String>();
        reSet = (HashSet<String>)IDtoWordMap.values();
        System.out.println(reSet);

       // Iterator it= a.iterator();
/*
        while(it.hasNext())
       {
           Integer fruit=(Integer)it.next();
           System.out.println(fruit);
       }*/



 /*       TreeSet<Integer> back = GraphHelper.descendants(g, five);

        System.out.println(back);


        String c = IDtoWordMap.get(5);
        System.out.println(c);
*/


      //System.out.println(g);

/*
      String a = IDtoWordMap.get(5);
      int b = WordtoIDMap.get("augmentation");
      System.out.println(a + b);*/



/*      for (int i = 0; i < rawSynsets.length; i++) {
      	for (int j = 0; synsetSplit[i][j+1] != null; j++)
      		System.out.println(synsetSplit[i][j]);
      }*/

/*      for (int i = 0; i < rawSynsets.length; i++) {
        if(i != Integer.valueOf(synset[i][0]))
          System.out.println(i);
      }*/      
  }

}

/*	In file  = new In("./wordnet/synsets11.txt");
	String[] synsets = file.readAllLines();
	String[][] splitString;
	splitString = new String[synsets.length][];
	for (int i = 0; i < synsets.length; i ++) {

		splitString[i] = synsets[i].split(",");
		for (int j = 0; j < synsets[i].length(); j ++) {
			if (j == 3) {
				j = 0;
				break;
			}
			System.out.println(splitString[i][j]);
		}
		
	}

	}	*/

