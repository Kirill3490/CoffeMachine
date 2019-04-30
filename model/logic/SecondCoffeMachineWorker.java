package by.bobruisk.itstep.polimorfizm.model.logic;

import java.util.Scanner;

import by.bobruisk.itstep.polimorfizm.model.data.coffe.Americano;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Capuchino;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Espresso;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Latte;
import by.bobruisk.itstep.polimorfizm.model.data.coffemachine.SecondCoffeMachine;

public class SecondCoffeMachineWorker {
	static Scanner scanner = new Scanner(System.in);

	public static void addIngredients(SecondCoffeMachine coffeMachine) {
		int choice = 0;
		while (choice != 4) {
			System.out.println("Что добавить:\n1) Воды\n2) Кофе\n3) Молока\n4) Вернуться в меню выбора действий");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				coffeMachine.setWaterLevel(coffeMachine.getMaxWaterLevel());
				break;
			case 2:
				coffeMachine.setGroundCoffeLevel(coffeMachine.getMaxGroundCoffeLevel());
				break;
			case 3:
				coffeMachine.setMilkTankVolume(coffeMachine.getMaxMilkVolume());
				break;
			case 4:
				break;
			default:
				System.out.println("Выберите существующее действие");
				break;
			}
		}
	}

	public static String makeEspresso(SecondCoffeMachine model) {
		String answer = "";
		Espresso espresso = new Espresso();
		if ((model.getTankVolume() + espresso.getCoffeWeight()) <= model.getMaxTankSize()
				&& model.getWaterLevel() >= espresso.getWaterVolume()
				&& model.getGroundCoffeLevel() >= espresso.getCoffeWeight() && model.getCondition() == true) {
			model.makeEspresso();
			answer = "Эспрессо сделано";
		} else if ((model.getTankVolume() + espresso.getCoffeWeight()) > model.getMaxTankSize()) {
			answer = "Бак с отработанным кофе будет переполнен, нужно очистить бак";
		} else if (model.getWaterLevel() < espresso.getWaterVolume() && model.getWaterLevel() > 0) {
			answer = "Недостаточно воды, нужно ее долить";
		} else if (model.getGroundCoffeLevel() < espresso.getCoffeWeight()) {
			answer = "Недостаточно кофе, нужно его досыпать";
		} else if (model.getCondition() == false) {
			answer = "Кофемашина выключена, нужно ее включить";
		}
		return answer;
	}

	public static String makeAmericano(SecondCoffeMachine model) {
		String answer = "";
		Americano americano = new Americano();
		if ((model.getTankVolume() + americano.getCoffeWeight()) <= model.getMaxTankSize()
				&& model.getWaterLevel() >= americano.getWaterVolume()
				&& model.getGroundCoffeLevel() >= americano.getCoffeWeight() && model.getCondition() == true) {
			model.makeAmericano();
			answer = "Американо сделано";
		} else if ((model.getTankVolume() + americano.getCoffeWeight()) > model.getMaxTankSize()) {
			answer = "Бак с отработанным кофе будет переполнен, нужно очистить бак";
		} else if (model.getWaterLevel() < americano.getWaterVolume()) {
			answer = "Недостаточно воды, нужно ее долить";
		} else if (model.getGroundCoffeLevel() < americano.getCoffeWeight()) {
			answer = "Недостаточно кофе, нужно его досыпать";
		} else if (model.getCondition() == false) {
			answer = "Кофемашина выключена, нужно ее включить";
		}
		return answer;
	}

	public static String makeCapuchino(SecondCoffeMachine model, int milkVolume) {
		String answer = "";
		Capuchino capuchino = new Capuchino(milkVolume);
		if ((model.getTankVolume() + capuchino.getCoffeWeight()) <= model.getMaxTankSize()
				&& model.getWaterLevel() >= capuchino.getWaterVolume()
				&& model.getGroundCoffeLevel() >= capuchino.getCoffeWeight() && model.getCondition() == true
				&& capuchino.getMilkVolume() >= model.getMilkTankVolume()) {
			model.makeLatte(milkVolume);
			answer = "Капучино сделано";
		} else if ((model.getTankVolume() + capuchino.getCoffeWeight()) > model.getMaxTankSize()) {
			answer = "Бак с отработанным кофе будет переполнен, нужно очистить бак";
		} else if (model.getWaterLevel() < capuchino.getWaterVolume()) {
			answer = "Недостаточно воды, нужно ее долить";
		} else if (model.getGroundCoffeLevel() < capuchino.getCoffeWeight()) {
			answer = "Недостаточно кофе, нужно его досыпать";
		} else if (model.getCondition() == false) {
			answer = "Кофемашина выключена, нужно ее включить";
		} else if (model.getMilkTankVolume() < capuchino.getMilkVolume()) {
			answer = "Недостаточно молока, нужно его долить";
		}
		return answer;
	}

	public static String makeLatte(SecondCoffeMachine model, int milkVolume) {
		String answer = "";
		Latte latte = new Latte(milkVolume);
		if (model.getTankVolume() < model.getMaxTankSize() && model.getWaterLevel() >= latte.getWaterVolume()
				&& model.getGroundCoffeLevel() >= latte.getCoffeWeight() && model.getCondition() == true
				&& latte.getMilkVolume() >= model.getMilkTankVolume()) {
			model.makeLatte(milkVolume);
			answer = "Латте сделано";
		} else if ((model.getTankVolume() + latte.getCoffeWeight()) > model.getMaxTankSize()) {
			answer = "Бак с отработанным кофе переполнен, нужно очистить бак";
		} else if (model.getWaterLevel() < latte.getWaterVolume()) {
			answer = "Недостаточно воды, нужно ее долить";
		} else if (model.getGroundCoffeLevel() < latte.getCoffeWeight()) {
			answer = "Недостаточно кофе, нужно его досыпать";
		} else if (model.getCondition() == false) {
			answer = "Кофемашина выключена, нужно ее включить";
		} else if (model.getMilkTankVolume() < latte.getMilkVolume()) {
			answer = "Недостаточно молока, нужно его долить";
		}
		return answer;
	}

	public static void setCoffeMachineCondition(SecondCoffeMachine coffeMachine) {
		int choice = scanner.nextInt();
		if (choice == 1) {
			coffeMachine.setCondition(true);
		} else if (choice == 2) {
			coffeMachine.setCondition(false);
		} else {
			System.out.println("Вы выбрали не существующую функцию");
		}
	}

	public static String getStatus(SecondCoffeMachine coffeMachine) {
		String status;
		if (coffeMachine.getCondition() == true) {
			status = "Кофемашина включена";
		} else {
			status = "Кофемашина выключена";
		}
		return status;
	}

	public static void chooseCoffe(SecondCoffeMachine coffeMachine) {
		int milkVolume = 0;
		System.out.println("Выберите какое кофе хотите сделать:\n1) Эспрессо\n2) Американо\n3) Латте\n4) Капучино");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			coffeMachine.makeEspresso();
			break;
		case 2:
			coffeMachine.makeAmericano();
			break;
		case 3:
			System.out.println("Введите количество молока для приготовления латте");
			milkVolume = scanner.nextInt();
			if (milkVolume > coffeMachine.getMaxMilkVolume()) {
				System.out.println("Бак не рассчитан на такое количество молока");
			} else {
				coffeMachine.makeLatte(milkVolume);
			}
			break;
		case 4:
			System.out.println("Введите количество молока для приготовления Капучино");
			milkVolume = scanner.nextInt();
			if (milkVolume > coffeMachine.getMaxMilkVolume()) {
				System.out.println("Бак не рассчитан на такое количество молока");
			} else {
				coffeMachine.makeCapuchino(milkVolume);
			}
			break;
		default:
			System.out.println("Такого кофе нет");
			break;
		}
	}

	public static void makeCoffe(SecondCoffeMachine coffeMachine) {
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
}
