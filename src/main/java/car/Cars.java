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
		StringBuilder builder = new StringBuilder();
		int maxValue = getMaxValue();

		for (Car car : list) {
			builder.append(appendWinner(car, maxValue));
		}

		String result = builder.substring(0, builder.lastIndexOf(", "));

		System.out.println(result + "가 최종 우승했습니다.");
	}

	public String appendWinner(Car car, int maxValue) {
		if (car.getDistance() == maxValue) {
			return car.getCarName() + ", ";
		}

		return "";
	}

	int getMaxValue() {
		return Collections.max(list, Comparator.comparingInt(Car::getDistance)).getDistance();
	}
}
