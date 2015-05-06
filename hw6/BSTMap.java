import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
//MJ
    private BSTMap<K, V> root;

    private K k;
    private V v;
    private BSTMap<K, V> smaller, bigger;
    private int n; // Record number of nodes

    public BSTMap() {
        root = null;
    }

    public BSTMap(K key, V value, int num, BSTMap<K, V> s, BSTMap<K, V> b) {
        k = key;
        v = value;
        smaller = s;
        bigger = b;
        n = num;
    }
    /** Removes all of the mappings from this map. */
    public void clear() {
        root.n = 0;
        root = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
    public V get(K key) {
        return get(root, key);
    }

    private V get(BSTMap<K, V> x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.k);
        if (cmp < 0) {
            return get(x.smaller, key);
        } else if (cmp > 0) {
            return get(x.bigger, key);
        } else {
            return x.v;
        }
    }

   /* Returns the number of key-value mappings in this map. */
    public int size() {
        if (root == null) {
            return 0;
        }
        return root.n;
    }

    private int size(BSTMap<K, V> x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    private BSTMap<K, V> put(BSTMap<K, V> x, K key, V value) {
        if (x == null) {
            return new BSTMap(key, value, 1, null, null);
        }
        int cmp = key.compareTo(x.k);
        if (cmp < 0) {
            x.smaller = put(x.smaller, key, value);
        } else if (cmp > 0) {
            x.bigger = put(x.bigger, key, value);
        } else {
            x.v = value;
        }
        x.n = 1 + size(x.smaller) + size(x.bigger);
        return x;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private void printInOrder(BSTMap<K, V> x) {
        if (x.smaller == null && x.bigger == null) {
            System.out.print(x.k);
            System.out.println(" " + x.v);
        } else if (x.smaller == null) {
            System.out.print(x.k);
            System.out.println(" " + x.v);
            printInOrder(x.bigger);
        } else if (x.bigger == null) {
            printInOrder(x.smaller);
            System.out.print(x.k);
            System.out.println(" " + x.v);            
        } else {
            printInOrder(x.smaller);
            System.out.print(x.k);
            System.out.println(" " + x.v);
            printInOrder(x.bigger);
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for HW6. */
    public V remove(K key) {
        return null;
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for HW6a. */
    public V remove(K key, V value) {
        return null;
    }

    /* Returns a Set view of the keys contained in this map. Not required for HW6. */
    public Set<K> keySet() {
        return null;
    }
}
