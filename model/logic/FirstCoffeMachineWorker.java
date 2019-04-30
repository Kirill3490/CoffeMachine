package by.bobruisk.itstep.polimorfizm.model.logic;

import java.util.Scanner;

import by.bobruisk.itstep.polimorfizm.model.data.coffe.Americano;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Espresso;
import by.bobruisk.itstep.polimorfizm.model.data.coffemachine.FirstCoffeMachine;

public class FirstCoffeMachineWorker {
	static Scanner scanner = new Scanner(System.in);

	public static void addIngredients(FirstCoffeMachine coffeMachine) {
		int choice = 0;
		while (choice != 3) {
			System.out.println("Что добавить:\n1) Воды\n2) Кофе\n3) Вернуться в меню выбора действий");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				coffeMachine.setWaterLevel(500);
				break;
			case 2:
				coffeMachine.setGroundCoffeLevel(200);
				break;
			case 3:
				break;
			default:
				System.out.println("Выберите существующее действие");
				break;
			}
		}
	}
	
	public static void chooseCoffe(FirstCoffeMachine coffeMachine) {
		System.out.println("Выберите какое кофе хотите сделать:\n1) Эспрессо\n2) Американо");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			coffeMachine.makeEspresso();
			System.out.println("Сделано эспрессо");
			break;
		case 2:
			coffeMachine.makeAmericano();
			System.out.println("Сделано американо");
			break;
		default:
			System.out.println("Такого кофе нет");
			break;
		}
	}
	
	public static void makeCoffe(FirstCoffeMachine coffeMachine) {
		while (true) {
			chooseCoffe(coffeMachine);
			System.out.println("Хотите сварить еще кофе?\n1)Да\n2)Нет");
			int choice = scanner.nextInt();
			if (choice != 1) {
				System.out.println("Возвращение в меню");
				break;
			}
		}
	}
	
	public static void setCoffeMachineCondition(FirstCoffeMachine coffeMachine) {
		int choice = scanner.nextInt();
		if (choice == 1) {
			coffeMachine.setCondition(true);
		} else if (choice == 2) {
			coffeMachine.setCondition(false);
		} else {
			System.out.println("Вы выбрали не существующую функцию");
		}
	}

	public static String getStatus(FirstCoffeMachine coffeMachine) {
		String status;
		if (coffeMachine.getCondition() == true) {
			status = "Кофемашина включена";
		} else {
			status = "Кофемашина выключена";
		}
		return status;
	}
	
	public static String makeEspresso(FirstCoffeMachine model) {
		String answer = "";
		Espresso espresso = new Espresso();
		if (model.getTankVolume() < model.getMaxTankSize() && model.getWaterLevel() >= espresso.getWaterVolume()
				&& model.getGroundCoffeLevel() >= espresso.getCoffeWeight() && model.getCondition() == true) {
			model.makeEspresso();
			answer = "Эспрессо сделано";
		} else if (model.getTankVolume() >= model.getMaxTankSize()) {
			answer = "Бак с отработанным кофе переполнен, нужно очистить бак";
		} else if (model.getWaterLevel() < espresso.getWaterVolume()) {
			answer = "Недостаточно воды, нужно ее долить";
		} else if (model.getGroundCoffeLevel() < espresso.getCoffeWeight()) {
			answer = "Недостаточно кофе, нужно его досыпать";
		} else if (model.getCondition() == false) {
			answer = "Кофемашина выключена, нужно ее включить";
		}
		return answer;
	}

	public static String makeAmericano(FirstCoffeMachine model) {
		String answer = "";
		Americano americano = new Americano();
		if (model.getTankVolume() < model.getMaxTankSize() && model.getWaterLevel() >= americano.getWaterVolume()
				&& model.getGroundCoffeLevel() >= americano.getCoffeWeight() && model.getCondition() == true) {
			model.makeAmericano();
			answer = "Американо сделано";
		} else if (model.getTankVolume() >= model.getMaxTankSize()) {
			answer = "Бак с отработанным кофе переполнен, нужно очистить бак";
		} else if (model.getWaterLevel() < americano.getWaterVolume()) {
			answer = "Недостаточно воды, нужно ее долить";
		} else if (model.getGroundCoffeLevel() < americano.getCoffeWeight()) {
			answer = "Недостаточно кофе, нужно его досыпать";
		} else if (model.getCondition() == false) {
			answer = "Кофемашина выключена, нужно ее включить";
		}
		return answer;
	}
}
