package synthesizer;


// Make sure to make this class a part of the synthesizer package
//package <package name>;

//Make sure this class is public
public class GuitarString { // GuitarString is an independent class, no relation with the BoundedQueue
    /** Constants. Do not change. In case you're curious, the keyword final means
      * the values cannot be changed at runtime. We'll discuss this and other topics
      * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor
    
    /* Buffer for storing sound data. */
    private BoundedQueue buffer; //buffer is the interface, maybe need cast.

    //private int capaInt;
    
    /* Indicate whether there is same numbers int the queque. */


    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) { //constructor
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        double capaDouble = SR / frequency;
        int capaInt = (int)Math.round((double) capaDouble);

        buffer = new ArrayRingBuffer(capaInt); ////Q1: What is buffer's static and dynamic type?

        for (int i = 0; i < capaInt;  i += 1) 
            buffer.enqueue(0);
    }

    /*private boolean isSame (int n) {
        for (int i = 0; i < buffer.capacity; i += 1) { //buffer.capacity =capaInt
            if (i == n) continue;
            if (buffer[i] == buffer[n])
                return true;
            else
                return false;
        }        

    }*/    
    
    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in the buffer, and replace it with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
        for (int i = 0; i < buffer.capacity(); i += 1) {
            buffer.dequeue();
            double r = Math.random() - 0.5;
            buffer.enqueue(r); 
        }
    }
    
    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
            double a = buffer.dequeue();
            double b = buffer.peek();
            double c = (a + b) * 0.5 * 0.996;
            buffer.enqueue(c);
        

    }
    
    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
    
}
