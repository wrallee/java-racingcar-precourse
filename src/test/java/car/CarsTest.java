package car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
	public void 최대값_추출_테스트(int r0, int r1, int r2, int expectedResult) throws Exception {
		List<Car> list = new ArrayList<>();
		list.add(mock(Car.class));
		list.add(mock(Car.class));
		list.add(mock(Car.class));

		Names mockNames = mock(Names.class);
		doReturn(list).when(mockNames).toCarList();

		doReturn(r0).when(list.get(0)).getDistance();
		doReturn(r1).when(list.get(1)).getDistance();
		doReturn(r2).when(list.get(2)).getDistance();

		Cars cars = new Cars(mockNames);

		assertThat(cars.getMaxValue()).isEqualTo(expectedResult);
	}
}
