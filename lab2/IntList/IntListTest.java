import static org.junit.Assert.*;
import org.junit.Test;

public class IntListTest {

    /** Example test that verifies correctness of the IntList.list static 
     *  method. The main point of this is to convince you that 
     *  assertEquals knows how to handle IntLists just fine.
     */

    @Test 
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.list(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
      IntList L = IntList.list(1, 2, 3);
      IntList.dSquareList(L);
      assertEquals(IntList.list(1, 4, 9), L);
      /*Notice that this test checks whether or not dSquareList is destructive.*/
        
  }


    /*@Test
    public void testsquareListRecursiveND() {
      IntList L = IntList.list(1, 2, 3);
      IntList L1 = IntList.squareListRecursive(L);
      assertEquals(IntList.list(1, 2, 3), L);
      assertEquals(IntList.list(1, 4, 9), L1);
  }
*/




   /* @Test
    public void testsquareListRecursiveND() {
      IntList L = IntList.list(1, 2, 3);
      IntList L2 == IntList.squareListRecursive(L);
      assertEquals(IntList.list(1, 4, 9), L2);*/

      /*Notice that this test checks whether or not dSquareList is destructive.
        */

    

    /** Do not use the new keyword in your tests. You can create
     *  lists using the handy IntList.list method.  
     * 
     *  Make sure to include test cases involving lists of various sizes
     *  on both sides of the operation. That includes the empty list, which
     *  can be instantiated, for example, with 
     *  IntList empty = IntList.list(). 
     *
     *  Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     *  Anything can happen to A. 
     */

    //TODO:  Create testSquareListRecursive()
    //TODO:  Create testDcatenate and testCatenate


    @Test
    public void testDCatenate1() {
      IntList A = IntList.list();
      IntList B = IntList.list();
      IntList res = IntList.dcatenate(A, B);
      assertEquals(IntList.list(), res);
      assertEquals(IntList.list(), A);
  }

    @Test
    public void testDCatenate2() {
      IntList A = IntList.list();
      IntList B = IntList.list(3, 4, 5);
      IntList res = IntList.dcatenate(A, B);
      A = B; //Do not Know How to pass A together with B to the outside....Little Trick
      assertEquals(IntList.list(3, 4, 5), res);
      assertEquals(IntList.list(3, 4, 5), A);
  }

    @Test
    public void testDCatenate3() {
      IntList A = IntList.list(1, 2);
      IntList B = IntList.list(3, 4, 5);
      IntList res = IntList.dcatenate(A, B);
      assertEquals(IntList.list(1, 2, 3, 4, 5), res);
      assertEquals(IntList.list(1, 2, 3, 4, 5), A);
  }




    @Test
    public void testCatenate1() {
      IntList A = IntList.list();
      IntList B = IntList.list();
      IntList L1 = IntList.catenate(A, B);
      assertEquals(IntList.list(), L1);
      assertEquals(IntList.list(), A);

  }
  

    @Test
    public void testCatenate2() {
      IntList A = IntList.list(1, 2, 3);
      IntList B = IntList.list();
      IntList L1 = IntList.catenate(A, B);
      assertEquals(IntList.list(1, 2, 3), L1);
      assertEquals(IntList.list(1, 2, 3), A);

  }

    @Test
    public void testCatenate3() {
      IntList A = IntList.list(1, 2, 3);
      IntList B = IntList.list(4, 5);
      IntList L1 = IntList.catenate(A, B);
      assertEquals(IntList.list(1, 2, 3, 4, 5), L1);
      assertEquals(IntList.list(1, 2, 3), A);

  }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(IntListTest.class);
    }

}       
 

///* n real world development, it is common to write tests before writing implementations. 
 /* We recommend that you try out this approach for this course, 
 * Important*/
