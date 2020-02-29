package main;

public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;

	public Railway() {
		railway = new DoubleLinkedList<Station>();
		stationNames = new String[18];
	}

	public void addStation(Station s) {
		railway.insert(s);
	}

	public void addRider(Rider r) {
		setRiderDirection(r);
		Node<Station> starting = railway.getFirst();
		Node<Station> temp = starting;
		while(temp.next != null && !temp.value.stationName().equals(r.getStarting())) {
			temp = temp.next;
		}
		temp.value.addRider(r);

	}

	public void addTrain(Train t) {
		Node<Station> starting = railway.getFirst();
		Node<Station> temp = starting;
		while(temp.next != null && !temp.value.stationName().equals(t.getStation())) {
			temp= temp.next;
		}
		temp.value.addTrain(t);
	}

	public void setRiderDirection(Rider r) {
		String starting = r.getStarting();
		String destination = r.getDestination();
		int indexStarting = 0;
		int indexDestination = 0;
		for(int i = 0; i < stationNames.length; i++) {
			if(stationNames[i].equals(starting)) {
				indexStarting = i;
			} else if(stationNames[i].equals(destination)) {
				indexDestination = i;
			}
		}
		if(indexDestination - indexStarting< 0) {
			r.setDirection(1);
		} else {
			r.setDirection(0);
		}
	}

	public String simulate() {
		Node<Station> starting = railway.getFirst();
		Node<Station> temp = starting;
		while(temp.next != null) {
			if(temp.value.stationName().equals("Braintree")) {
				Train a = temp.value.southBoundTrains.front();
				temp.value.southBoundTrains.dequeue();
				temp.value.northBoundTrains.enqueue(a);
			} else {
				temp.value.southBoardTrain();

			}
		}
		return null;
	}

	@Override
	public String toString() {
		return null;
	}
}
