public class Car {

	private final Name name;
	private final Position position;

	public Car(Name name) {
		this.name = name;
		this.position = new Position();
	}

	public void printRoute() {
		System.out.println(name + " : " + position.getRouteString());
	}
}
