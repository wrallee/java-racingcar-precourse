package car;

import info.Score;

public class Car {

	private final Name name;
	private final Position position;

	public Car(Name name) {
		this.name = name;
		this.position = new Position();
	}

	public int getLocation() {
		return position.getValue();
	}

	public void move(Score score) {
		position.increaseWithScore(score);
	}

	public void printRoute() {
		System.out.println(name + " : " + position.getRouteString());
	}
}
