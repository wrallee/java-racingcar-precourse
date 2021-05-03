public class Position {

	public static final int CRITICAL_VALUE = 4;
	public static final int INITIAL_VALUE = 1;

	private int value;

	public Position() {
		this.value = INITIAL_VALUE;
	}

	public int getValue() {
		return this.value;
	}

	public void increaseWithScore(Score score) {
		if (score.isBiggerOrEqualsThan(CRITICAL_VALUE)) {
			this.increase();
		}
	}

	void increase() {
		this.value += 1;
	}

	public String getRouteString() {
		String result = "";

		for (int i = 0; i < value; i++) {
			result += "-";
		}

		return result;
	}
}
