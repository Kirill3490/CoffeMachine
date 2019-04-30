package by.bobruisk.itstep.polimorfizm.controller;

import java.util.Scanner;

import by.bobruisk.itstep.polimorfizm.model.data.coffemachine.ThirdCoffeMachine;
import by.bobruisk.itstep.polimorfizm.model.logic.ScenarioWorker;
import by.bobruisk.itstep.polimorfizm.model.logic.ThirdCoffeMachineWorker;

public class ThirdCoffeMachineScenario {
	static Scanner scanner = new Scanner(System.in);

	public static void startScenario() {
		ThirdCoffeMachine coffeMachine = new ThirdCoffeMachine();
		int choice = 0;
		String possibility = "Выберите действие:\n1) Состояние кофемашины\n2) Включение и выключение\n3) Сделать кофе\n4) Очистить бак с пустым кофе\n5) Добавить ингредиенты";
		System.out.println(possibility);
		while (choice != 6) {
			System.out.println(possibility);
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println(ThirdCoffeMachineWorker.getStatus(coffeMachine));
				break;
			case 2:
				System.out.println("Выберите действие:\n1) Включить кофемашину\n2) Выключить кофемашину");
				ThirdCoffeMachineWorker.setCoffeMachineCondition(coffeMachine);
				break;
			case 3:
				if (coffeMachine.getCondition() == false) {
					System.out.println("Включите кофемашину");
				} else {
					ThirdCoffeMachineWorker.makeCoffe(coffeMachine);
				}
				break;
			case 4:
				coffeMachine.clearTank();
				System.out.println("Бак очищен");
				break;
			case 5:
				ThirdCoffeMachineWorker.addIngredients(coffeMachine);
				break;
			default:
				System.out.println("Такой опции нет, выберите подходящую");
				break;
			}
			System.out.println("Хотите продолжить?\n1)Да\n2)Нет");
			if (ScenarioWorker.goOn() == false) {
				break;
			}
		}
	}
}
