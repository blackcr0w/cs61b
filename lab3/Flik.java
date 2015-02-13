public class Flik {


	/* static boolean isSameNumber (Integer a, Integer b) { // return TRUE or FLASE
		return a == b;
	} */

	/* I simplly abandon the passing process and judge (i != j) in the main funcion */

	public static void main (String [] args) {
		int i = 0;
		for (int j = 0; i < 500; ++i, ++j) { // i=i+1 excute first
			if (i != j) { // if (i != j) Jump out  
          break; // Jump out of the loop
			}
		}
		System.out.println("i is " + i);
	}

}
