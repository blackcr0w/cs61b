/*
 * JUnit tests for the Triangle class
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author melaniecebula
 */
public class TriangleTest {
  /**  We've already created a testScalene method.  Please fill in testEquilateral, and additionally
   *   create tests for Isosceles, Negative Sides, and Invalid sides
   **/

    @Test
    public void testScalene() {
        Triangle t = new Triangle(30, 40, 50);
        String result = t.triangleType();
        assertEquals("Scalene", result);
    }

    @Test
    public void testEquilateral() {
      //TODO: FILL IN
      Triangle t2 = new Triangle(30, 40, 50);
      String result2 = t2.triangleType();
      assertEquals("Scalene", result2);

      Triangle t3 = new Triangle(-30, 40, 50);
      String result3 = t3.triangleType();
      assertEquals("At least one length is less than 0!", result3);

      Triangle t4 = new Triangle(10, 10, 50);
      String result4 = t4.triangleType();
      assertEquals("The lengths of the triangles do not form a valid triangle!", result4);

    }

    //TODO: CREATE MORE TESTS

    @Test
    public void testTriangleType() {
        Triangle t5 = new Triangle(30, 30, 30);
        String result5 = t5.triangleType();
        assertEquals("Equilateral", result5);
    }

    public static void main(String[] args) {
      //TODO: RUN TESTS (Look in ArithmeticTest.java main method for help!)
      jh61b.junit.textui.runClasses(TriangleTest.class);

      //The following line will run all tests in SomeTest when put in the main method of your test program.
        /* ven though testSum included many assert statements, 
         * you only saw the first failure 
         * (even though you know that all of the asserts would have failed!) */

    }
}
