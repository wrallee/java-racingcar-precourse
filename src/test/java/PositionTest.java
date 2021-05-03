import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionTest {

	Position position;

	@BeforeEach
	void setUp() {
		position = new Position();
	}

	@Test
	public void 위치_증가_테스트() throws Exception {
		position.increase();
		assertThat(position.getValue()).isEqualTo(1);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
	public void 점수값으로_위치_증가_테스트(int scoreValue, int positionValue) throws Exception {
	    Score score = new Score(scoreValue);
	    position.increaseWithScore(score);
	    assertThat(position.getValue()).isEqualTo(positionValue);
	}
}
