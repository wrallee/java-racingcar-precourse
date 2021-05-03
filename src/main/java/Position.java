public class Position {

	public static final int CRITICAL_VALUE = 4;

	private int value;

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
}
