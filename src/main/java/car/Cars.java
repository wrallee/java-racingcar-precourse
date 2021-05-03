package car;

import java.util.HashMap;
import java.util.Map;

import info.Score;

public class Cars {

	public static final int ZERO = 0;
	public static final String DELIMITER = ",";

	private final Map<String, Car> map;

	public Cars(String input) {
		map = new HashMap<>();
		String[] carNames = input.split(DELIMITER);

		checkInput(carNames);

		for (String name : carNames) {
			checkDuplicate(map, name);
			map.put(name, new Car(Name.from(name)));
		}
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

	private static void checkInput(String[] carNames) {
		if (isEmpty(carNames)) {
			throw new IllegalArgumentException("적절하지 않은 입력값입니다.");
		}
	}

	private static void checkDuplicate(Map<String, Car> map, String name) {
		if (map.containsKey(name)) {
			throw new IllegalArgumentException("입력값이 중복되었습니다.");
		}
	}

	private static boolean isEmpty(String[] carNames) {
		return carNames == null || carNames.length == ZERO;
	}
}
