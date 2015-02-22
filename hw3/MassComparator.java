import java.util.Comparator;

/**
 * MassComparator.java
 */

public class MassComparator implements Comparator<Planet> {

    public MassComparator() {
    }

    /** Returns the difference in mass as an int.
     *  Round after calculating the difference. */
    public int compare(Planet planet1, Planet planet2) {
<<<<<<< HEAD
        return (int)(planet1.getMass() - planet2.getMass());
=======
        // REPLACE THIS LINE WITH YOUR SOLUTION
>>>>>>> 5053240e14ac83e7ffd2bf6db76e173c8f35e1b5
    }
}