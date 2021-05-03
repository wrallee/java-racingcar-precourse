import java.util.Scanner;

import car.Cars;
import car.Names;

public class Display {

	private Names names;
	private int count;

	public void initGame() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = scanner.nextLine();
		names = new Names(input);

		System.out.println("시도할 횟수는 몇회인가요?");
		count = scanner.nextInt();

		scanner.close();
	}

	public void startGame() {
		Cars cars = new Cars(names);

		for (int i = 0; i < count; i++) {
			cars.printTrack();
			cars.timeSpend();
			System.out.println();
		}

		cars.printTrack();
		cars.printWinners();
	}
}
