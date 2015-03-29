import java.lang.Math;
// Don't forget to answer the follow-up question!
public class Bin15 {

    // A string of exactly 15 characters, each a 0 or 1.
    private String myBinStr;

    // A constantly-whining constructor for your testing purposes.
    public Bin15(String input) {

        // Check for null input
        if (input == null) {
            String msg = "Your binary string is null";
            throw new NullPointerException(msg);
        }

        // Check for length
        if (input.length() != 15) {
            String msg = "Your binary string isn't of length 15";
            throw new IllegalArgumentException(msg);
        }

        // Check for illegal characters
        for (int count = 0; count < 15; count++) {
            char c = input.charAt(count);
            // Careful with comparing vs 0 and comparing vs '0'
            if (c != '0' && c != '1') {
                String msg = "Your binary string contains a non-binary character";
                throw new IllegalArgumentException(msg);
            }
        }

        // The input is good. Let's roll.
        this.myBinStr = input;
    }
    
    @Override
    public boolean equals(Object o) {
        int i = 0;
        String s = (String) o;

        for (i = 0; i < 15; i ++) {
            if (s.charAt(i) != myBinStr.charAt(i))
                break;
        }
        return i == 14;
    }
    
    @Override
    public int hashCode() {
        int sum = 0;
        int bit = 0;
        int temp = 0;
        for (int i = 0; i < 15; i ++) {
            char bitTemp = myBinStr.charAt(i);
            int intTemp = (int) bitTemp - 48;
            if (intTemp == 1)
                bit = 1;
            else bit = 0;
            temp = bit * (int)(Math.pow(2.0, (double)i));
            sum = sum + temp;

        }
        return sum; 
    }

    /* DO THIS LAST, AFTER IMPLEMENTING EVERYTHING
    Follow-up question: The current length of our myBinStr is 15. What is the
    longest length possible for this String such that we still can produce a
    perfect hash (assuming we can rewrite the hash function)? Write your answer
    in the method followUpAnswer(). 
    */
    public static final int followUpAnswer() {
        return 31; // YOUR CODE HERE. THIS MAY OR MAY NOT BE CORRECT.
    }
    
    public static void main(String[] args) {
        // Optional testing here. Potentially useless information:
        int c = 0x9 - 1 - 0b01;
        Bin15 testBin = new Bin15("000001111100000");
        int hc = testBin.hashCode();
        //System.out.println(hc);
        // 0x9 means 9 in hexadecimal
        // 1 means 1 in decimal
        // 0b01 means 01 or 1 in binary
        System.out.println("Note to self: Answer follow-up question!");
    }
}

