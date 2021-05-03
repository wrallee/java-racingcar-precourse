package car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import info.Score;

public class CarTest {

	@Test
	public void 자동차_이름_검증() throws Exception {
	    assertDoesNotThrow(() -> new Car(Name.from("1")));
	    assertDoesNotThrow(() -> new Car(Name.from("12345")));
	    assertThrows(IllegalArgumentException.class, () -> new Car(Name.from("")));
	    assertThrows(IllegalArgumentException.class, () -> new Car(Name.from("123456")));
	}

	@ParameterizedTest
	@CsvSource(value = {"3:1", "4:2"}, delimiter = ':')
	public void 자동차_이동_테스트(int scoreValue, int expectedValue) throws Exception {
	    Car car = new Car(Name.from("Abc"));
	    Score score = new Score(scoreValue);

	    car.move(score);

	    assertThat(car.getLocation()).isEqualTo(expectedValue);
	}
}
