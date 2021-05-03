package car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import info.Score;

public class Cars {

	private final List<Car> list;

	public Cars(Names names) {
		list = names.toCarList();
	}

	public void timeSpend() {
		list.forEach((car) -> car.move(new Score()));
	}

	public void printTrack() {
		list.forEach((car) -> car.printRoute());
	}

	public void printWinners() {
		// TODO 승리자 출력기능 구현 필요
	}

	int getMaxValue() {
		return Collections.max(list, Comparator.comparingInt(Car::getDistance)).getDistance();
	}
}
