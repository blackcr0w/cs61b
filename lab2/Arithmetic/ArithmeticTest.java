import static org.junit.Assert.*;
import org.junit.Test;
//imports are what give you access to the JUnit methods and functionality that you'll need to run JUnit tests
public class ArithmeticTest {

    /** Performs a few arbitrary tests to see if the product method is correct */

    @Test //each method that is a test will be preceded by a @Test
    public void testProduct() {  // test method 1
        /* assertEquals for comparison of ints takes two arguments:
        assertEquals(expected, actual).
        if it is false, then the assertion will be false, and this test will fail.
        */

        assertEquals(30, Arithmetic.product(5, 6));
        assertEquals(-30, Arithmetic.product(5, -6));
        assertEquals(0, Arithmetic.product(0, -6));
    }

    /** Performs a few arbitrary tests to see if the sum method is correct */

    @Test 
    public void testSum() {  // test method 2

        assertEquals(11, Arithmetic.sum(5, 6));
        assertEquals(-1, Arithmetic.sum(5, -6));
        assertEquals(-6, Arithmetic.sum(0, -6));
        assertEquals(0, Arithmetic.sum(6, -6));
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(ArithmeticTest.class);
        //The following line will run all tests in SomeTest when put in the main method of your test program.
        /* ven though testSum included many assert statements, 
         * you only saw the first failure 
         * (even though you know that all of the asserts would have failed!) */
    }
}
