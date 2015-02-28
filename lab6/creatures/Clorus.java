package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;
import java.awt.Color;
import java.util.Map;
import java.util.List;

/** Another implementation of another motile attactive photosynthesizer.
 *  @author Jack Zhao
 */
public class Clorus extends Creature {
	/** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    /** creates plip with energy equal to E. */
    public Clorus(double e) { //Constructor
        super("clorus");
        r = 34;
        b = 231;
        energy = e;
        g = 0;
    }

    public Clorus() { //Constructor
        this(1);
    }

    public String name() {
        return "clorus";
    }

    public Color color() { 
		return color(r, g, b);
    }

    public void move() { ////Q2: What is magic number warning? Q3: The 
        energy = energy - 0.03;
    }


    /** Plips gain 0.2 energy when staying due to photosynthesis. */
    public void stay() {
        energy = energy - 0.01;
    }
    public void attack(Creature c) {
    	energy = energy + c.energy;
    	//c.energy = 0;
    }

    public Clorus replicate() {
        Clorus babyPlip = new Clorus(this.energy / 2);
        energy = energy / 2;
        return babyPlip;
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {

        List<Direction> empties = getNeighborsOfType(neighbors, "empty");

        if (empties.size() == 0) 
            return new Action(Action.ActionType.STAY);
        //if (this.energy > 1.0) 
        //    return new Action(Action.ActionType.REPLICATE, empties.get(0));
        List<Direction> plips = getNeighborsOfType(neighbors, "plip");
        if (plips.size() != 0 ) {
        //   double rand = HugLifeUtils.random();
 
            Direction randATTACK = HugLifeUtils.randomEntry(plips);
            return new Action(Action.ActionType.ATTACK, randATTACK);
        }
        if (energy >=1) {
        	Direction randREPLICATE = HugLifeUtils.randomEntry(empties);
        	return new Action(Action.ActionType.REPLICATE, randREPLICATE);
        }
        Direction randMove = HugLifeUtils.randomEntry(empties);
        
        return new Action(Action.ActionType.MOVE, randMove);
    }
	
} 