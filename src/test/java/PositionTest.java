import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionTest {

	Position position;

	@BeforeEach
	void setUp() {
		position = new Position();
	}

	@ParameterizedTest
	@CsvSource(value = {"3:1", "4:2"}, delimiter = ':')
	public void 점수값으로_위치_증가_테스트(int scoreValue, int expectedValue) throws Exception {
	    Score score = new Score(scoreValue);
	    position.increaseWithScore(score);
	    assertThat(position.getValue()).isEqualTo(expectedValue);
	}
}
