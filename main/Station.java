package main;

public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	String name;

	public Station(String name) {
		this.name = name;
		northBoundRiders = new Queue<Rider>(10);
		southBoundRiders = new Queue<Rider>(10);
		northBoundTrains = new Queue<Train>(10);
		southBoundTrains = new Queue<Train>(10);
	}

	public boolean addRider(Rider r) {
		if(!r.getStarting().equals(this.name)){
			return false;
		}

		if(r.goingNorth()) {
			northBoundRiders.enqueue(r);
		} else {
			southBoundRiders.enqueue(r);
		}
		return true;
	}

	public String addTrain(Train t) {
		t.updateStation(name);
		if(t.goingNorth()) {
			northBoundTrains.enqueue(t);
		} else {
			southBoundTrains.enqueue(t);
		}
		return name + "disembarking passenger: " + t.disembarkPassengers();
	}

	public Train southBoardTrain() {
		if(southBoundTrains.size() == 0) {
			return null;
		}
		Train t = southBoundTrains.front();
		southBoundTrains.dequeue();
		while (t.hasSpaceForPassengers()) {
			t.addPassenger(southBoundRiders.front());
			southBoundRiders.dequeue();
		}
		return t;
	}

	public Train northBoardTrain() {
		if(northBoundTrains.size()== 0) {
			return null;
		}
		Train t = northBoundTrains.front();
		northBoundTrains.dequeue();
		while(t.hasSpaceForPassengers()) {
			t.addPassenger(northBoundRiders.front());
			northBoundRiders.dequeue();
		}
		return t;
	}

	public void moveTrainNorthToSouth() {
		Train first = northBoundTrains.front();
		first.swapDirection();
		this.addTrain(first);

	}

	public void moveTrainSouthToNorth() {
		Train first = southBoundTrains.front();
		southBoundTrains.dequeue();
		first.swapDirection();
		this.addTrain(first);
	}

	@Override
	public String toString() {
		return "Station " + stationName()  ;
	}

	public String stationName() {
		return name;
	}

	public boolean equals(Station s) {
		if(this.stationName().equals(s.stationName())) {
			return true;
		}
		return false;
	}
}
