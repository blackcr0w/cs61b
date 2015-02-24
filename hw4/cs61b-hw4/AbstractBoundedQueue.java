public abstract AbstractBoundedQueue implements BoundedQueue {
	protected int fillCount;
protected int capacity;
public int capacity()
public int fillCount()
public boolean isEmpty()
public boolean isFull()
public abstract double peek();
public abstract double dequeue();
public abstract void enqueue(double x);
}
