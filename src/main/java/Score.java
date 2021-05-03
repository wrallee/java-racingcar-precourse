public class Score {

	public static final int BOUND_LIMIT = 10;
	public static final int MIN_SCORE = 0;
	public static final int MAX_SCORE = 9;

	private int value;

	Score(int value) {
		checkScore(value);
		this.value = value;
	}

	public Score() {
		this((int)(Math.random() * BOUND_LIMIT));
	}

	public boolean isBiggerOrEqualsThan(int target) {
		return this.value >= target;
	}

	private static void checkScore(int value) {
		if (value < MIN_SCORE || MAX_SCORE < value) {
			throw new IllegalArgumentException("점수값은 0~9 사이의 숫자로 생성되어야 합니다.");
		}
	}
}
