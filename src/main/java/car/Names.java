package car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Names {

	public static final String DELIMITER = ",";
	public static final int ZERO = 0;

	private final Set<Name> names;

	public Names(String input) {
		String[] nameArray = input.split(DELIMITER);
		checkNameArray(nameArray);

		names = new HashSet<>();
		for (String nameValue : nameArray) {
			Name name = Name.from(nameValue.trim());
			checkDuplicate(names, name);

			names.add(name);
		}
	}

	public List<Car> toCarList() {
		List<Car> map = new ArrayList<>();

		names.forEach(name -> {
			map.add(new Car(name));
		});

		return map;
	}

	private static void checkDuplicate(Set<Name> set, Name name) {
		if (set.contains(name)) {
			throw new IllegalArgumentException("입력값이 중복되었습니다.");
		}
	}

	private static void checkNameArray(String[] nameArray) {
		if (isEmpty(nameArray)) {
			throw new IllegalArgumentException("적절하지 않은 입력값입니다.");
		}
	}

	private static boolean isEmpty(String[] nameArray) {
		return nameArray == null || nameArray.length == ZERO;
	}
}
