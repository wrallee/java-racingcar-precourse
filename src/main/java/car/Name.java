package car;

public class Name {

	public static final int MIN_LENGTH = 1;
	public static final int MAX_LENGTH = 5;

	private final String value;

	Name(String value) {
		checkLength(value);
		this.value = value;
	}

	public static Name from(String value) {
		return new Name(value);
	}

	private static void checkLength(String value) {
		if (value == null || value.length() < MIN_LENGTH || MAX_LENGTH < value.length()) {
			throw new IllegalArgumentException("이름은 1~5 길이의 문자열로 구성되어야 합니다.");
		}
	}

	@Override
	public String toString() {
		return value;
	}
}