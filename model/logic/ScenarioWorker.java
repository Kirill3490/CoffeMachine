package by.bobruisk.itstep.polimorfizm.model.logic;

import java.util.Scanner;

public class ScenarioWorker {
	
	static Scanner scanner = new Scanner(System.in);
	public static boolean goOn() {
		boolean answer = false;
		int choice = 0;
		while (choice != 1 || choice != 2) {
			choice = scanner.nextInt();
			if (choice == 1) {
				answer = true;
				break;
			} else if (choice == 2) {
				break;
			} else {
				System.out.println("Выберите существующий вариант ответа");
			}
		}
		return answer;
	}
}
