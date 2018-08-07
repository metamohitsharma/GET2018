package GET2018.DSA.DSSession3.BowlerStrategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on BowlerStrategy
 * 
 * @author Mohit Sharma
 *
 */
public class TestStrategy {

	BowlerStrategy strategy = null;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() throws StrategyException {
		strategy = new BowlerStrategy();
		strategy.addBowler(8, "Mohit");
		strategy.addBowler(5, "Shubham");
		strategy.addBowler(1, "Chirag");
	}

	@Test
	public void testBowlerStrategy() throws StrategyException {
		// Testing the order of Bowler
		List<Bowler> names = strategy.batsmanMinimumRun(9);
		List<Bowler> result = new ArrayList<Bowler>();
		result.add(new Bowler(4, "Mohit"));
		result.add(new Bowler(1, "Shubham"));
		result.add(new Bowler(1, "Mohit"));
		result.add(new Bowler(1, "Shubham"));
		result.add(new Bowler(1, "Mohit"));
		result.add(new Bowler(1, "Shubham"));
		for (int i = 0; i < result.size(); i++) {
			assertEquals(names.get(i).getBalls(), result.get(i).getBalls());
			assertEquals(names.get(i).getBowler(), result.get(i).getBowler());
		}
	}

	@Test
	public void bowlerWithZeroBallException() throws StrategyException {
		// Adding a Bowler having Zero Balls to Bowl
		ex.expect(StrategyException.class);
		ex.expectMessage("Bowler Can't Bowl");
		strategy.addBowler(0, "Rajendra");
	}

	@Test
	public void bowlerWithNullNameException() throws StrategyException {
		// Adding a Bowler Name as Null
		ex.expect(NullPointerException.class);
		ex.expectMessage("Bowler Name can't be Null");
		strategy.addBowler(4, null);
	}

	@Test
	public void ballsToPlayMoreThanDelivered() throws StrategyException {
		// Balls to be Played are more than Balls to be Delivered
		ex.expect(StrategyException.class);
		ex.expectMessage("Balls to be Played are more than Balls to be Delivered");
		strategy.batsmanMinimumRun(15);
	}
}
