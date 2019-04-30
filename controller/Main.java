package by.bobruisk.itstep.polimorfizm.controller;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Выберите какую кофемашину вы хотите купить:\n1) Первая модель - может готовить эспрессо и американо\n2) Вторая модель может готовить эспрессо, американо, латте и капучино\n3) Третья модель может готовить американо и латте, но можно засыпать зерновое кофе");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			FirstCoffeMachineScenario.startScenario();
			break;
		case 2:
			SecondCoffeMachineScenario.startScenario();
			break;
		case 3:
			SecondCoffeMachineScenario.startScenario();
			break;
		default:
			System.out.println("Такой модели не существует");
			break;
		}
		scanner.close();
	}
}
