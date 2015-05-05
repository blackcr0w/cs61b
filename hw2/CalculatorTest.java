import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import list.EquationList;


public class CalculatorTest {
    /* Do not change this to be private. For silly testing reasons it is public. */
    public Calculator tester;

    /**
     * setUp() performs setup work for your Calculator.  In short, we 
     * initialize the appropriate Calculator for you to work with.
     * By default, we have set up the Staff Calculator for you to test your 
     * tests.  To use your unit tests for your own implementation, comment 
     * out the StaffCalculator() line and uncomment the Calculator() line.
     **/
    @Before
    public void setUp() {
        //tester = new StaffCalculator(); // Comment me out to test your Calculator
         tester = new Calculator();   // Un-comment me to test your Calculator
    }

    // TASK 1: WRITE JUNIT TESTS
    // YOUR CODE HERE
    @Test
    public void testAdder(){
        int a = tester.add(3,4);
        assertEquals(7,a);
    }

    @Test
    public void testAdder2(){
        int b = tester.add(-2331,-2991);
        assertEquals(-5322,b);        
    }

    @Test
    public void testAdder3(){
        int c = tester.add(-90,2);
        assertEquals(-88,c);
    }

    @Test 
    public void testMult(){
        assertEquals(6972021, tester.multiply(-2331,-2991));
    }

    @Test
    public void testMult2(){
        assertEquals(-180, tester.multiply(-90,2));        
    }

    @Test
    public void testMult3(){
        assertEquals(21, tester.multiply(3,7));
    }

    // @Test
    // public void testSaveEquation(){
    //     tester.saveEquation("Something",1);
    //     // tester.saveEquation("Another thing",2);
    //     // tester.saveEquation("3rd thing",3);
    //     // EquationList z = new EquationList("3rd thing",3,null);
    //     // EquationList y = new EquationList("Another thing",2,z);
    //     EquationList x = new EquationList("Something",1,null);
    //     assertEquals(x, tester.a);
    // }
    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(CalculatorTest.class);
    }       
}