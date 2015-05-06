import java.util.AbstractList;
import java.util.List;

/** Stores a list of elements in an array that is dynamically resized. */
public class ArrayList61B<T> extends AbstractList<T> {

    /** The elements of this list. */
    private T[] vals;
    /** The number of elements in this list. */
    private int size;

    /** Initializes the internal array to have size INITIALCAPACITY. */
    public ArrayList61B(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be" +
                                               " a positive integer.");
        }
        vals = (T[]) new Object[initialCapacity]; ////一定要注意这里是怎么吧generic array初始化的
        size = 0;
    }

    /** Initializes internal array to have size 1. */
    public ArrayList61B() {
        this(1); ////直接调用上一个constructor
    }

    /** Returns the element I of this list. */
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        return vals[i];
    }

    /** Adds ITEM to the end of this list, resizing the internal array if
     *  necessary. Returns true. */
    public boolean add(T item) {
        vals[size] = item;
        size += 1;
        if (size >= vals.length) {
            resize();
        }
        return true;
    }

    /** Returns the number of elements in this list. */
    public int size() {
        return size;
    }

    /** Doubles the size of the internal array and copies all elements from
     *  the old array into the new one. */
    private void resize() {
        T[] temp = vals;
        vals = (T[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            vals[i] = temp[i];
        }
    }
      
}