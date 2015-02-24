package synthesizer;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Julian Early
 */

public class TestArrayRingBuffer {
	ArrayRingBuffer arb;

	/* @Test
	public void testConstructor()
	{
		arb = new synthesizer.ArrayRingBuffer(1);
		System.out.println(arb.first + " " + arb.last + " " + arb.fillCount);

	} */

    @Test
    public void enqueueTests() {
    	arb = new synthesizer.ArrayRingBuffer(5);

        arb.enqueue(1.1);

        arb.enqueue(2.2);
        arb.enqueue(3.3);
        int a1 = (int)Math.round((double) arb.rb[0]);
        int a2 = (int)Math.round((double) arb.rb[1]);
        int a3 = (int)Math.round((double) arb.rb[2]);
        assertEquals(1, a1);
        assertEquals(2, a2);
        assertEquals(3, a3);

    }
    @Test
    public void dequeueTest() {
    	arb = new synthesizer.ArrayRingBuffer(5);

        arb.enqueue(1.1);

        arb.enqueue(2.2);
        arb.enqueue(3.3);
        arb.enqueue(4.4);
        arb.enqueue(5.1);

        arb.dequeue();
        arb.dequeue();

        int a1 = (int)Math.round((double) arb.rb[2]);
        int a2 = (int)Math.round((double) arb.rb[3]);
        int a3 = (int)Math.round((double) arb.rb[4]);

        assertEquals(3, a1);
        assertEquals(4, a2);
        //assertEquals(5, a3);

        arb.enqueue(6.1);
        int a4 = (int)Math.round((double) arb.rb[0]);
        assertEquals(6, a4);

    }
    @Test
    public void peekTests() {
    	arb = new synthesizer.ArrayRingBuffer(5);

        arb.enqueue(1.1);

        arb.enqueue(2.2);
        arb.enqueue(3.3);
        int a1 = (int)Math.round((double) arb.peek());

        assertEquals(1, a1);

        arb.dequeue();
        arb.dequeue();

        int a2 = (int)Math.round((double) arb.peek());
        assertEquals(3, a2);

    }
    @Test
    public void capacityTest() {
    	arb = new synthesizer.ArrayRingBuffer(5);

        arb.enqueue(1.1);

        arb.enqueue(2.2);
        arb.enqueue(3.3);

        assertEquals(5, arb.capacity);


    }

    @Test
    public void fillCountTest() {
    	arb = new synthesizer.ArrayRingBuffer(5);

        arb.enqueue(1.1);

        arb.enqueue(2.2);
        arb.enqueue(3.3);
        arb.enqueue(4.4);
        arb.enqueue(5.5);
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(6.6);

        assertEquals(4, arb.fillCount());
    }    

    @Test
    public void isEmptyisFullTest() {
    	arb = new synthesizer.ArrayRingBuffer(5);

        arb.enqueue(1.1);

        arb.enqueue(2.2);
        arb.enqueue(3.3);
        arb.enqueue(4.4);
        arb.enqueue(5.5);
        assertTrue(arb.isFull());

        arb.dequeue();
        arb.dequeue();
        arb.enqueue(6.6);
        assertFalse(arb.isEmpty());
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();

        assertTrue(arb.isEmpty());
    } 



    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}