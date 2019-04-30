package by.bobruisk.itstep.polimorfizm.model.logic;

import java.util.Scanner;

import by.bobruisk.itstep.polimorfizm.model.data.coffe.Americano;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Latte;
import by.bobruisk.itstep.polimorfizm.model.data.coffemachine.ThirdCoffeMachine;

public class ThirdCoffeMachineWorker {
	static Scanner scanner = new Scanner(System.in);
	
	public static void addIngredients(ThirdCoffeMachine coffeMachine) {
		int choice = 0;
		while (choice != 5) {
			System.out.println("Выберите действие:\n1)Добавить воды\n2)Добавить кофе\n3)Добавить молока\n4)Узнать сколько ингредиентов осталось\n5) Вернуться в меню выбора действий");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				coffeMachine.setWaterLevel(coffeMachine.getMaxWaterLevel());
				break;
			case 2:
				addCoffe(coffeMachine);
				break;
			case 3:
				coffeMachine.setMilkTankVolume(coffeMachine.getMaxMilkVolume());
				break;
			case 4:
				System.out.println(coffeMachine.getStatus());
				break;
			case 5:
				break;
			default:
				System.out.println("Выберите существующее действие");
				break;
			}
		}
	}
	
	
	public static String makeAmericano(ThirdCoffeMachine model) {
		String answer = "";
		Americano americano = new Americano();
		 if ((model.getTankVolume() + americano.getCoffeWeight()) > model.getMaxTankSize()) {
			answer = "Бак с отработанным кофе будет переполнен, нужно очистить бак";
		} else if (model.getWaterLevel() < americano.getWaterVolume() && americano.getWaterVolume() > 0) {
			answer = "Недостаточно воды, нужно ее долить";
		} else if (model.getGroundCoffeLevel() < americano.getCoffeWeight()) {
			answer = "Недостаточно кофе, нужно его досыпать";
		} else if (model.getCondition() == false) {
			answer = "Кофемашина выключена, нужно ее включить";
		} else {
			model.makeAmericano();
			answer = "Американо сделано";
		}
		return answer;
	}
	
	public static String makeLatte(ThirdCoffeMachine model, int milkVolume) {
		String answer = "";
		Latte latte = new Latte(milkVolume);
		 if ((model.getTankVolume() + latte.getCoffeWeight()) > model.getMaxTankSize()) {
			answer = "Бак с отработанным кофе переполнен, нужно очистить бак";
		} else if (model.getWaterLevel() < latte.getWaterVolume() && latte.getWaterVolume() > 0) {
			answer = "Недостаточно воды, нужно ее долить";
		} else if (model.getGroundCoffeLevel() < latte.getCoffeWeight()) {
			answer = "Недостаточно кофе, нужно его досыпать";
		} else if (model.getCondition() == false) {
			answer = "Кофемашина выключена, нужно ее включить";
		} else if (model.getMilkTankVolume() < latte.getMilkVolume()) {
			answer = "Недостаточно молока, нужно его долить";
		} else {
			model.makeLatte(milkVolume);
			answer = "Латте сделано";
		}
		return answer;
	}

	public static void setCoffeMachineCondition(ThirdCoffeMachine coffeMachine) {
		int choice = scanner.nextInt();
		if (choice == 1) {
			coffeMachine.setCondition(true);
		} else if (choice == 2) {
			coffeMachine.setCondition(false);
		} else {
			System.out.println("Вы выбрали не существующую функцию");
		}
	}
	
	public static void grindGrain(ThirdCoffeMachine coffeMachine) {
		int needCoffe = coffeMachine.getMaxGroundCoffeLevel() - coffeMachine.getGroundCoffeLevel(); //Coffe need to grind
		if (needCoffe > coffeMachine.getCoffeBeansTankVolume()) {
			coffeMachine.grindGrain(coffeMachine.getCoffeBeansTankVolume());
		} else {
			coffeMachine.grindGrain(needCoffe);
		}
		System.out.println("Зерновое кофе помолено");
	}

	public static String getStatus(ThirdCoffeMachine coffeMachine) {
		String status;
		if (coffeMachine.getCondition() == true) {
			status = "Кофемашина включена";
		} else {
			status = "Кофемашина выключена";
		}
		return status;
	}

	public static void chooseCoffe(ThirdCoffeMachine coffeMachine) {
		int milkVolume = 0;
		System.out.println("Выберите какое кофе хотите сделать:\n1) Американо\n2) Латте");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			coffeMachine.makeAmericano();
			break;
		case 2:
			System.out.println("Введите количество молока для приготовления латте");
			milkVolume = scanner.nextInt();
			if (milkVolume > coffeMachine.getMaxMilkVolume()) {
				System.out.println("Бак не рассчитан на такое количество молока");
			} else {
				coffeMachine.makeLatte(milkVolume);
			}
			break;
		default:
			System.out.println("Такого кофе нет");
			break;
		}
	}

	public static void makeCoffe(ThirdCoffeMachine coffeMachine) {
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
	
	private static void addGroundCoffe(ThirdCoffeMachine coffeMachine) {
		System.out.println();
		System.out.println("Выберите действие:\n1)Добавить молотый кофе\n2)Перемолоть зерновой кофе");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			coffeMachine.setGroundCoffeLevel(coffeMachine.getMaxGroundCoffeLevel());
			break;
		case 2:
			if (coffeMachine.getCoffeBeansTankVolume()<=0) {
				System.out.println("Ошибка. Отсутствует зерновой кофе");
			} else {
				grindGrain(coffeMachine);
			}
			break;
		default:
			System.out.println("Такого действия не существует");
			break;
		}
	}
	
	private static void addCoffe(ThirdCoffeMachine coffeMachine) {
		System.out.println("Выберите какой кофе хотите добавить:\n1) Молотый\n2) Зерновой");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			addGroundCoffe(coffeMachine);
			break;
		case 2:
			coffeMachine.setCoffeBeansTankVolume(coffeMachine.getMaxCoffeBeansTankVolume());
			break;
		default:
			break;
		}
	}
}
