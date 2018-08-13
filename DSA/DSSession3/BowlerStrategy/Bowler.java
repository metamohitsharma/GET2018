package GET2018.DSA.DSSession3.BowlerStrategy;

/**
 * THis class contains details about Bowlers
 * 
 * @author Mohit Sharma
 *
 */
public class Bowler {
	int balls;
	String name;

	public Bowler(int balls, String name) throws StrategyException {
		if (balls == 0) {
			throw new StrategyException("Bowler Can't Bowl");
		}
		if (name == null) {
			throw new NullPointerException("Bowler Name can't be Null");
		}
		this.balls = balls;
		this.name = name;
	}

	public void setBalls(int balls) {
		if (balls >= 0) {
			this.balls = balls;
		}
	}

	public int getBalls() {
		return balls;
	}

	public String getBowler() {
		return name;
	}
}
