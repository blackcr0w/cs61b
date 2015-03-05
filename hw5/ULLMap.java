import java.util.Iterator;
import java.util.*;
import java.util.Set; /* java.util.Set needed only for challenge problem. */

/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key. 
 *
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */ 
public class ULLMap<K, V> implements Map61B<K, V>, Iterable<K> { //FIX ME
    /** Keys and values are stored in a linked list of Entry objects.
      * This variable stores the first pair in this linked list. You may
      * point this at a sentinel node, or use it as a the actual front item
      * of the linked list. 
      */
    private Entry front;
    private int N;           // number of key-value pairs

    /** Represents one node in the linked list that stores the key-value pairs
     *  in the dictionary. */
    private class Entry {

         /** Stores the key of the key-value pair of this node in the list. */
        private K key; //FIX ME
        /** Stores the value of the key-value pair of this node in the list. */
        private V val; //FIX ME
        /** Stores the next Entry in the linked list. */
        private Entry next;
       
        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K k, V v, Entry n) { ////Q1: Can this be accessed by outside --Nope.
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry get(K k) { //FIX ME
            //FILL ME IN (using equals, not ==)
        for (Entry x = front; x != null; x = x.next) {
            if (key.equals(x.key)) return x;
        }
        return null;
        }
    }

/* add a constructor method and an instance variable to the ULLMapIter */
    public class ULLMapIter implements Iterator<K> { /////public Iterator<E> iterator()?? Whrer????
        public Entry e;

        public ULLMapIter(ULLMap<K, V> umap) {
             e = umap.front;
         }

         @Override
         public boolean hasNext() {
            return !e.equals(null);
        }

        @Override
        public K next() {

            if (e.equals(null)) {
            throw new NoSuchElementException();                       
            }
            K key = e.key;
            e = e.next;
            return key;
        }


        @Override
        public void remove() {
            throw new UnsupportedOperationException("Nice try, bozo.");
        }
    }

    public Iterator<K> iterator() { 
        return new ULLMapIter(this);
    }

    @Override
    public V get(K key) { //FIX ME
    //FILL ME IN
        for (Entry x = front; !x.equals(null); x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    @Override
    public void put(K key, V val) { //FIX ME
    //FILL ME IN
        for (Entry x = front; !x.equals(null); x = x.next)
            if (key.equals(x.key)) { x.val = val; return; }
        front = new Entry(key, val, front);
        N++;
    }

    @Override
    public boolean containsKey(K key) { //FIX ME
    //FILL ME IN
        return !get(key).equals(null); //FIX ME
    }

    @Override
    public int size() {
        return N; // FIX ME (you can add extra instance variables if you want)
    }

    @Override
    public void clear() {
        front = null;
    //FILL ME IN
    }

    /* Methods below are all challenge problems. Will not be graded in any way. 
     * Autograder will not test these. */
    @Override
    public V remove(K key) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }


    public static <K, V> ULLMap<V, K> invert(ULLMap<K, V> um) { /////Q: static
        ULLMap<V, K> invertMap = new ULLMap<V, K>();
        invertMap.front = invertMap.new Entry(um.front.val, um.front.key, null);////
        //ULLMap<V, K>.Entry p = invertMap.front;
        //Entry<V, K> eum = new Entry(um.front.val, um.front.key, null);
        um.front = um.front.next;
        while (!um.front.equals(null)) {
            if(invertMap.containsKey(um.front.val)) {
                um.front = um.front.next;
                continue;
            }
            invertMap.front.next = invertMap.new Entry(um.front.val, um.front.key, null);
            invertMap.front = invertMap.front.next;
            um.front = um.front.next;
        }
        return invertMap;

        ////Q: can this have access to private variables?
/*        for (Iterator i = um.iterator(); i.hasNext(); ) {
            Object o = i.next();
            System.out.println(o);
        }
        if (!front.equals(null)) {
            K tempK;
            temK = eum.key;
            eum.key = eum.val;
            eum.val = 

        }
        Iterator<K> umi = um.iterator();
        for (; umi.hasNext(); ) {
            K o = umi.next();
            System.out.println(o);
  }*/
    }


}