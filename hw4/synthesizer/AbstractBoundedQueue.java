package synthesizer;

public abstract class AbstractBoundedQueue implements BoundedQueue {
	protected int fillCount;
	protected int capacity;
	public abstract int capacity();
	public abstract int fillCount();
	public abstract boolean isEmpty();
	public abstract boolean isFull();
	public abstract double peek();
	public abstract double dequeue();
	public abstract void enqueue(double x);
}