package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

/** Tests the plip class   
 *  @authr FIXME
 */

public class TestPlip {

    @Test
    public void testBasics() {
        Plip p = new Plip(2);
        assertEquals(2.0, p.energy(), 0.01);
        assertEquals(new Color(99, 255, 76), p.color());
        p.move();
        assertEquals(1.85, p.energy(), 0.01);
        p.move();
        assertEquals(1.70, p.energy(), 0.01);
        p.stay();
        assertEquals(1.90, p.energy(), 0.01);
        p.stay();
        assertEquals(2.00, p.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Plip p = new Plip(2);
        Plip p_baby = p.replicate();
        assertEquals(1, p.energy(), 0.01);
        assertEquals(1, p_baby.energy(), 0.01);
        assertNotSame(p, p_baby);
    }

    @Test
    public void testChooseREPLICATE() {
        Plip p = new Plip(0.6);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Clorus());
        surrounded.put(Direction.RIGHT, new Clorus());
        surrounded.put(Direction.LEFT, new Clorus());
        surrounded.put(Direction.RIGHT, new Empty());

        //You can create new empties with new Empty();
        //Despite what the spec says, you cannot test for Cloruses nearby yet.
        //Sorry!  

        Action actual = p.chooseAction(surrounded);
        //double randNum;
        //randNum = p.rand;
        //System.out.println("hahaha this is " + randNum);
        Action expected = new Action(Action.ActionType.MOVE, Direction.RIGHT);

        assertEquals(expected, actual);
    }
    /*@Test
    public void testChooseREPLICATE2() {
        Plip p = new Plip(2.0);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.LEFT, new Empty());
        surrounded.put(Direction.BOTTOM, new Empty());
        surrounded.put(Direction.TOP, new Empty());
        surrounded.put(Direction.RIGHT, new Empty());

        //You can create new empties with new Empty();
        //Despite what the spec says, you cannot test for Cloruses nearby yet.
        //Sorry!  

        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.REPLICATE, Direction.RIGHT);

        assertEquals(expected, actual);
    }*/

    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(TestPlip.class));
    }
} 
