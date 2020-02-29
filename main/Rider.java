package main;
/**
 *This class represents a Rider on the red line. A rider should have an ID, starting station,
destination station, and a direction.
 *
 * @author cindy hou
 */
public class Rider {

	private String riderID;
	private String startingStation;
	private String destinationStation;
	private int  direction = 2; //1 south or 0 north

	/**
	 * – this should construct a Rider with an ID as well as starting and
ending stations. A Rider must start by travelling south
	 * @param riderID
	 * @param startingStation
	 * @param destinationStation
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID = riderID;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;
	}

	public String getStarting() {
		return startingStation;
	}

	public String getDestination() {
		return destinationStation;
	}

	public String getRiderID() {
		return riderID;
	}

	public boolean goingNorth() {
		if(direction == 0){
			return true;
		}
		return false;
	}

	public void swapDirection() {
		if(goingNorth()) {
			direction = 1;
		} else {
			direction = 0;
		}
	}

	public void setDirection(int direct) {
		this.direction = direct;
	}

	@Override
	public String toString() {
		return riderID + ", " + destinationStation;
	}

	public boolean equals(Rider s) {
		if(this.riderID == s.getRiderID()){
			return true;
		}
		return false;
	}
}
