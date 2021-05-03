import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	public void 자동차_이름_검증() throws Exception {
	    assertDoesNotThrow(() -> new Car(Name.from("1")));
	    assertDoesNotThrow(() -> new Car(Name.from("12345")));
	    assertThrows(IllegalArgumentException.class, () -> new Car(Name.from("")));
	    assertThrows(IllegalArgumentException.class, () -> new Car(Name.from("123456")));
	}
}
