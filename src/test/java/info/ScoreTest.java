package info;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ScoreTest {

	@Test
	public void 점수_생성값_검증() throws Exception {
	    assertDoesNotThrow(() -> new Score(0));
	    assertDoesNotThrow(() -> new Score(9));
	    assertThrows(IllegalArgumentException.class, () -> new Score(-1));
	    assertThrows(IllegalArgumentException.class, () -> new Score(10));
	}
}
