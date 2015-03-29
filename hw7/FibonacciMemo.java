import java.util.HashMap; // Import Java's HashMap so we can use it

public class FibonacciMemo {

    /**
     * The classic recursive implementation with no memoization. Don't care
     * about graceful error catching, we're only interested in performance.
     * 
     * @param n
     * @return The nth fibonacci number
     */
    public static int c;
    public static int b;
    public static int a;
    public static int fibNoMemo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibNoMemo(n - 2) + fibNoMemo(n - 1);
    }

    /**
     * Your optimized recursive implementation with memoization. 
     * You may assume that n is non-negative.
     * 
     * @param n
     * @return The nth fibonacci number
     */
    public static int fibMemo(int n) {
         a = 1;
         b = 1;
        //int c;
        if (n == 0)
            return 0;
        if (n == 1 || n == 2) 
            return 1;

        for (int i = 0; i < n - 2; i ++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * Answer the following question as a returned String in this method:
     * Why does even a correctly implemented fibMemo not return 2,971,215,073
     * as the 47th Fibonacci number?
     */
    public static String why47() {
        String answer = "potatoes";
        answer += "Overflow " + answer + " and tapioca";
        return answer;
    }

/*    public static void main(String[] args) {
        // Optional testing here        
        String m = "Fibonacci's real name was Leonardo Pisano Bigollo.";
        m += "\n" + "He was the son of a wealthy merchant.\n";
        System.out.println(m);
        System.out.println("0: " + FibonacciMemo.fibMemo(300));
        System.out.println("1: " + FibonacciMemo.fibMemo(1));
        System.out.println("2: " + FibonacciMemo.fibNoMemo(2));
        System.out.println("3: " + FibonacciMemo.fibNoMemo(3));
        System.out.println("4: " + FibonacciMemo.fibNoMemo(300));

        // 46th Fibonacci = 1,836,311,903
        // 47th Fibonacci = 2,971,215,073
    }*/
}
