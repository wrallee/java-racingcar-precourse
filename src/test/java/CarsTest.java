import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

	@ParameterizedTest
	@ValueSource(strings = {"pobi,crong,honux", "pobi"})
	public void 입력값으로_자동차들_생성(String input) throws Exception {
		assertDoesNotThrow(() -> new Cars(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"pobiii,crong,honux", ",", ""})
	public void 입력값으로_자동차들_생성_실패(String input) throws Exception {
		assertThrows(IllegalArgumentException.class, () -> new Cars(input));
	}
}
