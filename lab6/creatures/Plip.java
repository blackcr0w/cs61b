package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;
import java.awt.Color;
import java.util.Map;
import java.util.List;

/** An implementation of a motile pacifist photosynthesizer.
 *  @author Josh Hug
 */
public class Plip extends Creature {
    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    //public double rand;

    /** creates plip with energy equal to E. */
    public Plip(double e) { //Constructor
        super("plip");
        r = 99;
        b = 76;
        energy = e;
        g = 63 + 96 * (int)energy;
    }

    /** creates a plip with energy equal to 1. */
    public Plip() { //Constructor
        this(1);
    }

    public String name() {
        return "plip";
    }

    /** Should return a color with red = 99, blue = 76, and green that varies
     *  linearly based on the energy of the Plip. If the plip has zero energy,
     *  it should have a green value of 63. If it has max energy, it should
     *  have a green value of 255. The green value should vary with energy
     *  linearly in between these two extremes. It's not absolutely vital
     *  that you get this exactly correct.
     */
    public Color color() { 
    //for r, g, they are defined as instant variable, without any ambigiuous, so do not need this.g
    
        r = 99;
        b = 76;
        g = 63 + 96 * (int)(Math.round(energy)); ////Q1: still not sure how to call energy.
        return color(r, g, b);
    }

    /** Do nothing with C, Plips are pacifists. */
    public void attack(Creature c) {
    }

    /** Plips should lose 0.15 units of energy when moving. If you want to
     *  to avoid the magic number warning, you'll need to make a
     *  private static final variable. This is not required for this lab.
     */
    public void move() { ////Q2: What is magic number warning? Q3: The 
        energy = energy - 0.15;
    }


    /** Plips gain 0.2 energy when staying due to photosynthesis. */
    public void stay() {
        energy = energy + 0.2;
        if (energy > 2) 
            energy = 2;
    }

    /** Plips and their offspring each get 50% of the energy, with none
     *  lost to the process. Now that's efficiency! Returns a baby
     *  Plip.
     */
    public Plip replicate() {
        Plip babyPlip = new Plip(this.energy / 2);
        energy = energy / 2;
        return babyPlip;
    }

    /** Plips take exactly the following actions based on NEIGHBORS:
     *  1. If no empty adjacent spaces, STAY.
     *  2. Otherwise, if energy >= 1, REPLICATE.
     *  3. Otherwise, if any Cloruses, MOVE with 50% probability.
     *  4. Otherwise, if nothing else, STAY
     *
     *  Returns an object of type Action. See Action.java for the
     *  scoop on how Actions work. See SampleCreature.chooseAction()
     *  for an example to follow.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {

        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        double rand = HugLifeUtils.random();
        if (empties.size() == 0) 
            return new Action(Action.ActionType.STAY);
        if (this.energy > 1.0) 
            return new Action(Action.ActionType.REPLICATE, empties.get(0));
        List<Direction> clorus = getNeighborsOfType(neighbors, "clorus");
        if (clorus.size() != 0 ) {
            
            //rand = 0.4;
            //msg("hahaha this is " + rand);
            //System.out.println("hahaha this is " + rand);
            if (rand <= 0.5) {
                return new Action(Action.ActionType.STAY);
            }
            else {
                Direction randMove = HugLifeUtils.randomEntry(empties);
                return new Action(Action.ActionType.MOVE, randMove);
            }
        }
        return new Action(Action.ActionType.STAY);
    }
}
