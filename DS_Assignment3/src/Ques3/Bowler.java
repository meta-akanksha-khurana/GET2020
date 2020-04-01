package Ques3;

/**
 * This class represents Bowler
 * @author Akanksha
 *
 */
public class Bowler {
	
	//bowler represents Bowler number
	private int bowler;
	
	//balls represent number of bowlers each bowler has
	private int balls;
	
	//Constructor
	Bowler(int bowler,int balls) {
		this.bowler = bowler;
		this.balls = balls;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public int getBowler() {
		return bowler;
	}

	public void setBowler(int bowler) {
		this.bowler = bowler;
	}
	
}
