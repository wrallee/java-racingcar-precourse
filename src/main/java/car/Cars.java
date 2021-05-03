package car;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import info.Score;

public class Cars {

	private final Map<Name, Car> map;

	public Cars(Names names) {
		map = names.toCarsMap();
	}

	public void timeSpend() {
		map.forEach((name, car) -> {
			car.move(new Score());
		});
	}

	public void printTrack() {
		map.forEach((name, car) -> {
			car.printRoute();
		});
	}

	public void printWinners() {
		// TODO 승리자 출력기능 구현 필요
	}

	public int getMaxValue() {
		return Collections.max(map.entrySet(), Comparator.comparingInt(o -> o.getValue().getLocation()))
			.getValue()
			.getLocation();
	}
}
