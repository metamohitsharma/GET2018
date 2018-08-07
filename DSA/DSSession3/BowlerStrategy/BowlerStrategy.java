package GET2018.DSA.DSSession3.BowlerStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * This class tell the order of Bowler chosen by you as captain.
 * 
 * @author Mohit Sharma
 *
 */
public class BowlerStrategy {
	private List<Bowler> bowlers = new ArrayList<Bowler>();

	/**
	 * Adds Bowler in bowlers List
	 * 
	 * @param bowl
	 * @param name
	 * @throws StrategyException
	 */
	public void addBowler(int ball, String name) throws StrategyException {
		bowlers.add(new Bowler(ball, name));
	}

	/**
	 * Returns Bowler's Order so that Batsman Score Minimum Run
	 * 
	 * @return
	 * @throws StrategyException
	 */
	public List<Bowler> batsmanMinimumRun(int noOfBalls) throws StrategyException {
		List<Bowler> bowlerOrder = new ArrayList<Bowler>();
		if (totalBalls() < noOfBalls) {
			throw new StrategyException("Balls to be Played are more than Balls to be Delivered");
		}
		while (noOfBalls != 0) {

			// provide index in list of bowlers which has maximum balls
			int bolwerIndex = getMaxBallBolwer();
			String bowler = bowlers.get(bolwerIndex).getBowler();
			int orderSize = bowlerOrder.size();
			if (orderSize == 0) {
				bowlerOrder.add(new Bowler(1, bowler));
			} else if (!bowler.equals(bowlerOrder.get(orderSize - 1) // Checking whether the previous Bowler is same or
																		// not
					.getBowler())) {
				bowlerOrder.add(new Bowler(1, bowler));
			} else {
				bowlerOrder.get(bowlerOrder.size() - 1)
						.setBalls(bowlerOrder.get(bowlerOrder.size() - 1).getBalls() + 1);
			}
			bowlers.get(bolwerIndex).setBalls(bowlers.get(bolwerIndex).getBalls() - 1);
			noOfBalls--;
		}
		return bowlerOrder;
	}

	/**
	 * Gives index of Bowler have maximum balls
	 * 
	 * @return
	 */
	private int getMaxBallBolwer() {
		int numberOfBowlers = bowlers.size();
		int maxBalls = bowlers.get(0).getBalls();
		int index = 0;
		for (int i = 0; i < numberOfBowlers; i++) {
			int balls = bowlers.get(i).getBalls();
			if (balls > maxBalls) {
				maxBalls = balls;
				index = i;
			}
		}
		return index;
	}

	/**
	 * Calculates Total No of Balls Bowlers can Bowl
	 */
	public int totalBalls() {
		int totalBalls = 0;
		for (Bowler bowler : bowlers) {
			totalBalls += bowler.getBalls();
		}
		return totalBalls;
	}
}
