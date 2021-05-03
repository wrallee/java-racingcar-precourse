package car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

	@ParameterizedTest
	@ValueSource(strings = {"pobi,crong,honux", "pobi"})
	public void 입력값으로_자동차들_생성(String input) throws Exception {
		assertDoesNotThrow(() -> new Cars(new Names(input)));
	}

	@ParameterizedTest
	@ValueSource(strings = {"pobiii,crong,honux", ",", ""})
	public void 입력값으로_자동차들_생성_실패(String input) throws Exception {
		assertThrows(IllegalArgumentException.class, () -> new Cars(new Names(input)));
	}

	@Test
	public void 중복입력값_테스트() throws Exception {
		String input = "pobi,crong,pobi";
	    assertThrows(IllegalArgumentException.class, () -> new Cars(new Names(input)));
	}
}
