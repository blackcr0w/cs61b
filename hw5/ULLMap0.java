import java.util.Set; /* java.util.Set needed only for challenge problem. */

/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key. 
 *
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */ 
public class ULLMap<K, V> implements Map61B<K, V> { //FIX ME
    /** Keys and values are stored in a linked list of Entry objects.
      * This variable stores the *first pair* in this linked list. You may
      * point this at a sentinel node, or use it as a the actual front item
      * of the linked list. 
      */
    private Entry front;
    private int mapNum;

/*    public ULLMap (Entry f) { ////Q1: should constructor be? Q2: How to chose the sentinal node and linked list?
        front = f;
        mapNum = 1;
    }*/

    @Override
    public V get(K key) { //FIX ME
    //FILL ME IN
        Entry p = front;
        if (p != null && p.key != key) {
            p = p.next;
        }
        if (p == null) 
            return null;
        else return p.val;
    }

    @Override
    public void put(K key, V val) { //FIX ME
    //FILL ME IN
        Entry p = front;
        if (containsKey(key)) {
            p = p.get(key);
            p.val = val;
        }
        else {
            p.val = val;
            p.key = key;
            p.next = front;
            front = p;
        }
/*        if (p != null && p.key != key) 
            p = p. next;
        if (p != null)
            p.val = val;
        else {
            p = new Entry(key, val, null);
        }*/
        mapNum += 1;
    }

    @Override
    public boolean containsKey(K key) { //FIX ME
    //FILL ME IN
        Entry p = front;
        if (p.equals(null))
            return false;
        if (p != null && p.key != key) {
            p = p.next;       
        }
        if (p != null)
            return true;
        return false; //FIX ME
    }

    @Override
    public int size() {
        return mapNum; // FIX ME (you can add extra instance variables if you want)
    }

    @Override
    public void clear() { ////Q4: How to remove all? Remove front.
    //FILL ME IN
        front = null;
        mapNum = 0;
    }


    /** Represents one node in the linked list that stores the key-value pairs
     *  in the dictionary. */
    private class Entry {
    
        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K k, V v, Entry n) { //FIX ME  ////Constructor
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry get(K k) { //FIX ME ////Method of Entry
            //FILL ME IN (using equals, not ==)
            Entry p = front;
            if (p != null && p.key != key) {
                p = p.next;
            }
            if (p.equals(null)) 
             return null;
            else return p;
                    
        }

        /** Stores the key of the key-value pair of this node in the list. */
        private K key; //FIX ME done
        /** Stores the value of the key-value pair of this node in the list. */
        private V val; //FIX ME done
        /** Stores the next Entry in the linked list. */
        private Entry next;
    
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


}