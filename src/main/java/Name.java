public class Name {

	String value;

	Name(String value) {
		checkLength(value);
		this.value = value;
	}

	public static Name from(String value) {
		return new Name(value);
	}

	private static void checkLength(String value) {
		if (value == null || value.length() < 1 || 5 < value.length()) {
			throw new IllegalArgumentException("이름은 1~5 길이의 문자열로 구성되어야 합니다.");
		}
	}
}
