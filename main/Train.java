package main;

import java.util.Arrays;

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex = 0;
	private String currentStation;
	private int currentDirection = 3; //1 south or 0 north

	public Train(String currentStation, int direction) {
		passengers = new Rider[TOTAL_PASSENGERS];
		this.currentStation = currentStation;
		this.currentDirection = direction;
	}

	public boolean goingNorth() {
		if (currentDirection == 0) {
			return true;
		}
		return false;
	}

	public void swapDirection() {
		if(goingNorth()) {
			currentDirection = 1;
		} else {
			currentDirection = 0;
		}
	}

	public String currentPassengers() {
		String passenger = "";
		for(int i = 0; i < passengerIndex; i++) {
			passenger += passengers[i].toString();
		}
		return passenger;
	}

	public boolean addPassenger(Rider r) {
		if(r.getStarting().equals(currentStation) && r.goingNorth() == this.goingNorth() && this.passengerIndex <  TOTAL_PASSENGERS) {
			for(int i = 0; i < passengers.length; i ++) {
				if( passengers[i] == null) {
					passengers[i] = r;
				}

			}
			passengerIndex++;
			return true;
		}
		return false;
	}

	public boolean hasSpaceForPassengers() {
		if(this.passengerIndex < TOTAL_PASSENGERS) {
			return true;
		}
		return false;
	}

	public String disembarkPassengers() {
		String arr = "";
		for(int i = 0; i < passengerIndex; i++ ) {
			if(passengers[i].getDestination().equals(currentStation)) {
				//passengers[i] = passengers[i + 1];
				//passengers = disembark(passengers, passengers[i]);
				arr += passengers[i].toString();
				passengers[i] = null;
				passengerIndex--;
			}
		}
		return arr;
	}

	public void updateStation(String s) {
		this.currentStation = s;
	}

	public String getStation() {
		return this.currentStation;
	}

	@Override
	public String toString() {
		return null;
	}
}
