import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.introcs.In;
import java.util.*;

public class WordNet {
    /** Creates a WordNet using files form SYNSETFILENAME and HYPONYMFILENAME */
    private class WordItem<I> { ////Q: what is the effect of putting public inside private?
      public int synsetID;
      public String[] words;
    }

    }
    public WordNet(String synsetFilename, String hyponymFilename) {

      In synsetFile  = new In("./wordnet/synsets11.txt");
      In hyponymFile  = new In("./wordnet/hyponyms11.txt");
      String[] rawSynsets = synsetFile.readAllLines();
      String[] rawHyponyms = hyponymFile.readAllLines();

      String[][] synset = new String[rawSynsets.length][];
      String[][] hyponym = new String[rawHyponyms.length][];
      String[][] synsetSplit = new String[rawHyponyms.length][15];

      for (int i = 0; i < rawSynsets.length; i++) {
        synset[i] = rawSynsets[i].split(",");
      }


      for (int i = 0; i < rawSynsets.length; i++) {
        synsetSplit[i] = synset[i][1].split(" ");
      }

      int flag;
      for (int i = 0; i < synset.length; i++) {
        int flag = synset[i][1].indexOf(" ");

        if (flag < 0) {
          synsetSplit[i][0] = synset[i][1];
        }
        else {
          synsetSplit[i] = synset[i][1].split(" ");
        }
      }      

      Map<String, int> WordtoIDMap = new HashMap<String, int> ();
      Map<int, String> IDtoWord = new HashMap<int, String> ();

      for (int i = 0; i < synset.length; i++) {
        WordtoIDMap.put(synsetSplit[i][0], i);
      }
      for (int i = 0; i < synset.length; i++) {
        IDtoWord.put(i, synsetSplit[i][0]);
      }

      for (int i = 0; i < rawHyponyms.length; i ++) {
        hyponym[i] = rawHyponyms[i].split(",");
      }

      Digraph g = new Digraph(synset.length);
      for(int i = 0; i < rawHyponyms.length; i ++) {
        for(int j = 1; j < hyponym[i].length; j ++) {
          g.addEdge(Integer.valueOf(hyponym[i][0]), Integer.valueOf(hyponym[i][j]));
        }        
      } 



    /* Returns true if NOUN is a word in some synset. */
    public boolean isNoun(String noun) {
      Integer a = WordtoIDMap.get(noun);
      return a != null;
    }

    /* Returns the set of all nouns. */
    public Set<String> nouns() {      
        Set<String> reSet = new HashSet<String>();
        reSet = WordtoIDMap.keySet();
        System.out.println(reSet);
    }

    /** Returns the set of all hyponyms of WORD as well as all synonyms of
      * WORD. If WORD belongs to multiple synsets, return all hyponyms of
      * all of these synsets. See http://goo.gl/EGLoys for an example.
      * Do not include hyponyms of synonyms.
      */
    public Set<String> hyponyms(String word) {

    }
      }
      }
}