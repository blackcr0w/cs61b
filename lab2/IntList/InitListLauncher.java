/* Similar to what we see in Head first Java,
 * we will often create a test drive class.
 */

public class InitListLauncher {
    public static void main(String[] args) {
        IntList A = IntList.list();
        IntList B = IntList.list(3, 4, 5);
        IntList res = IntList.dcatenate(A, B);
      	/* while (res != null) {
      		System.out.println(res.head);
      		res = res.tail; 
    	} */
      while (B != null) {
          System.out.println (B.head);
          B = B.tail; 
      }
      while (A != null) {
          System.out.println(A.head);
          A = A.tail;
      }
    	
    } 
} 