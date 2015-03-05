import java.util.AbstractList;
import java.util.*;

public class ArrayList61B<E> extends AbstractList<E> {

	private E[] elist;
	private int n;

	public ArrayList61B(int initialCapacity) {
		//if (initialCapacity <= 1)
		//	throw new initialCapacity;
		//E[] a = (E[]) Array.newInstance(c, s);
		// items = (E[]) new Object[1]
		elist = (E[]) new Object[initialCapacity];
		n = 0;
	}

	public ArrayList61B() {
		elist = (E[]) new Object[1];
		n = 0;
	}

	public E get(int i) {
		//if (i <0 || i >= n)
		//	throw new IllegalArgumentException;
		return (elist[i-1]);
	}

	public boolean add(E item) {
		elist[n] = item;
		n += 1;
		return true;
	}

	public int size() {
		return n;
	}


}