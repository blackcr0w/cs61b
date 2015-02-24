package synthesizer;

// Make sure to make this class a part of the synthesizer package
//package <package name>;

public class ArrayRingBuffer extends AbstractBoundedQueue {
  /* Index for the next dequeue or peek. */
  private int first;           
  /* Index for the next enqueue. */
  private int last;             
  /* Array for storing the buffer data. */
  public double[] rb;
  /* to indicate the last operation: dequeue or enqueue */
  private boolean flag;


  /** Create a new ArrayRingBuffer with the given capacity. */
  public ArrayRingBuffer(int capacity) { // constructor
    rb = new double[capacity];
    this.capacity = capacity;
    //System.out.println(this.capacity);
    first = 0;
    last = 0;
    fillCount = 0;

    // TODO: Create new array with capacity elements.
    //       first, last, and fillCount should all be set to 0. 
    //       this.capacity should be set appropriately. Note that the local variable
    //       here shadows the field we inherit from AbstractBoundedQueue.
  }

  /** Adds x to the end of the ring buffer. If there is no room, then
    * throw new RuntimeException("Ring buffer overflow") 
    */
  public void enqueue(double x) {
    flag = true;

    if (this.isFull()) {
      throw new RuntimeException("Ring buffer overflow");
    }

    rb[last] = x;
    last += 1;
    if (last == this.capacity) 
      last = 0;  
    fillCount += 1;


    // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
    // is there room?
  }

  /** Dequeue oldest item in the ring buffer. If the buffer is empty, then
    * throw new RuntimeException("Ring buffer underflow");
    */
  public double dequeue() {
    double x;
    if (this.isEmpty()) {
      throw new RuntimeException("Ring buffer underflow");
    }
    flag = false;
    x = rb[first];
    rb[first] = 0;
    first += 1;
    if (first == this.capacity) 
      first = 0;  

    fillCount += 1;
    return x;

    // TODO: Dequeue the first item. Don't forget to decrease fillCount and update first.
  }

  /** Return oldest item, but don't remove it. */
  public double peek() {
    // TODO: Return the first item. None of your instance variables should change.
    /*if (this.isEmpty()) {
      throw new RuntimeException("Ring buffer underflow");
    }*/
    return rb[first];
  }

  /** return the capacity of the buffer **/
  public int capacity() {
    return this.capacity;
  }
        
  /*  return number of items currently in the buffer*/
  public int fillCount() {
    if (first > last) {
      return (this.capacity - first + last);
    }
    else if(first < last) {
      return (last - first);
    }
    else 
    {
      if (flag == true) {
        return this.capacity;
      }
      else return 0;
    }
  }

  public boolean isEmpty() {
    if ((flag == false) && (first == last))
      return true;
    else return false;
  }

  public boolean isFull() {
    if ((flag == true) && (first == last))
      return true;
    else return false;
  }       
}
