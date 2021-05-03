package car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
	public void 중복_입력값_검증_테스트() throws Exception {
		String input = "pobi,crong,pobi";
	    assertThrows(IllegalArgumentException.class, () -> new Cars(new Names(input)));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:1:1:1", "1:5:5:5", "1:8:2:8"}, delimiter = ':')
	public void 최대값_추출_테스트(int r1, int r2, int r3, int expectedResult) throws Exception {
		Car car1 = mock(Car.class);
		Car car2 = mock(Car.class);
		Car car3 = mock(Car.class);
		Map<Name, Car> map = new HashMap<Name, Car>() {{
			put(Name.from("1"), car1);
			put(Name.from("2"), car2);
			put(Name.from("3"), car3);
		}};

		Names mockNames = mock(Names.class);
		doReturn(map).when(mockNames).toCarsMap();

		doReturn(r1).when(car1).getLocation();
		doReturn(r2).when(car2).getLocation();
		doReturn(r3).when(car3).getLocation();

		Cars cars = new Cars(mockNames);

		assertThat(cars.getMaxValue()).isEqualTo(expectedResult);
	}
}
