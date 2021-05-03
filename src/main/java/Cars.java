import java.util.HashMap;
import java.util.Map;

public class Cars {

	public static final String DELIMITER = ",";

	Map<String, Car> map;

	public Cars(String input) {
		map = new HashMap<>();
		String[] carNames = input.split(DELIMITER);

		checkInput(carNames);
		for (String name : carNames) {
			Car car = new Car(Name.from(name));
			map.putIfAbsent(name, car);
		}
	}

	private static void checkInput(String[] carNames) {
		if (carNames == null || carNames.length == 0) {
			throw new IllegalArgumentException("적절하지 않은 입력값입니다.");
		}
	}
}
