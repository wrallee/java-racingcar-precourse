public class Score {

	private int value;

	public Score(int value) {
		checkScore(value);
		this.value = value;
	}

	private static void checkScore(int value) {
		if (value < 0 || 9 < value) {
			throw new IllegalArgumentException("점수값은 0~9 사이의 숫자로 생성되어야 합니다.");
		}
	}
}
