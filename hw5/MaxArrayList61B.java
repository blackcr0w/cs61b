public class MaxArrayList61B<T extends Comparable<T>> extends ArrayList61B<T> {

    /** The largest element added to this list so far. */
    private T max;

    @Override
    public boolean add(T item) {
        if (max == null || max.compareTo(item) < 0) {
            max = item;
            return super.add(item);
        } else {
            return false;
        }
    }

}