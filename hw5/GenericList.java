/** A generic linked list class with a head and a tail pointer to another ListNode
 *  of the same generic type. */
public class GenericList<T>{ //在这个GenericList中，存储的每一项都是T类型的，所以Node不用变，只需要把class变一下
    //class中的T使用来声明，这个list中的数据类型，这是一个gereric class

    /** Inner class used to represent a single node in this linked list. */
    protected class Node {
        
        /** Constructs a new Node with head VALUE and a null tail. */
        public Node(T value) { //记住 constructor格式几乎不用变
            _value = value;
        }

        /** Constructs a new Node with head VALUE and tail NEXT. */
        public Node(T value, Node next) {
            _value = value;
            _next = next;
        }

        /** Returns the element at index i starting at this node in
         *  the linked list. */
        public T get(int i) {
            if (i == 0) return _value;
            if (_next == null) {
                throw new IllegalArgumentException("Index out of bounds");
            } else {
                return _next.get(i - 1); //注意这里的递归使用！！第一项的index从0开始
                //
            }
        }

        /** The value stored in this node */
        T _value;
        /** The next node in the list */
        Node _next;
    }

    @Override
    public String toString() {
        StringBuilder rep = new StringBuilder();
        rep.append("[");
        Node cur = _head;
        while (cur != null && cur._next != null) {
            rep.append(cur._value + ", ");
            cur = cur._next;
        }
        if (cur != null) {
            rep.append(cur._value);
        }
        rep.append("]");
        return rep.toString();
    }

    /** Returns number of items in this list. */
    public int length() {
        return length;
    }

    /** Returns ith element of this list, throwing exception if it
     *  does not exist. */
    public T get(int i) { //在generic method中，用法和平时一样的
        if (_head == null) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return _head.get(i);
    }

    /** Inserts VAL into the front of this list. */
    public void insert(T val) {
        _head = new Node(val, _head);
        length += 1;
    }

    /** The head of this linked list. */
    protected Node _head;
    /** The number of elements in this linked list */
    protected int length;

}
