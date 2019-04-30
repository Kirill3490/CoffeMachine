package by.bobruisk.itstep.polimorfizm.model.data.coffemachine;

import by.bobruisk.itstep.polimorfizm.model.data.coffe.Americano;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Capuchino;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Espresso;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Latte;

public class SecondCoffeMachine extends CoffeMachine implements Buttons{
	public SecondCoffeMachine() {
		setCondition(false);
		setMaxWaterLevel(500);
		setMaxTankSize(100);
		setMaxGroundCoffeLevel(200);
		setMaxMilkVolume(200);
		setTankVolume(0);
		setMilkTankVolume(getMaxMilkVolume());
		setGroundCoffeLevel(getGroundCoffeLevel());
		setWaterLevel(getMaxWaterLevel());
	}

	@Override
	public void turnOnButton() {
		setCondition(true);

	}

	@Override
	public void turnOffButton() {
		setCondition(false);
	}

	@Override
	public void clearTank() {
		setGroundCoffeLevel(0);

	}

	public String getStatus() {
		return ("Подключено питание: " + getCondition() + "\nОбъем бака для отработанного койфе: " + getMaxTankSize()
				+ "г.\nУровень заполнения бака: " + getTankVolume() + "г.\nУровень воды: " + getWaterLevel()
				+ "мл.\nУровень кофе: " + getGroundCoffeLevel() + "г.\n Уровень молока " + getMilkTankVolume() + "мл.");
	}

	public void makeEspresso() {
		Espresso espresso = new Espresso();
		setGroundCoffeLevel(getGroundCoffeLevel() - espresso.getCoffeWeight());
		setWaterLevel(getWaterLevel() - espresso.getWaterVolume());
		setTankVolume(getTankVolume() + espresso.getCoffeWeight());
	}
	
	public void makeAmericano() {
		Americano americano = new Americano();
		setGroundCoffeLevel(getGroundCoffeLevel() - americano.getCoffeWeight());
		setWaterLevel(getWaterLevel() - americano.getWaterVolume());
		setTankVolume(getTankVolume() + americano.getCoffeWeight());
	}
	
	public void makeLatte(int milkVolume) {
		Latte latte = new Latte(milkVolume);
		setGroundCoffeLevel(getGroundCoffeLevel() - latte.getCoffeWeight());
		setWaterLevel(getWaterLevel() - latte.getWaterVolume());
		setTankVolume(getTankVolume() + latte.getCoffeWeight());
		setMilkTankVolume(getMilkTankVolume() - milkVolume);
	}
	
	public void makeCapuchino(int milkVolume) {
		Capuchino capuchino = new Capuchino(milkVolume);
		setGroundCoffeLevel(getGroundCoffeLevel() - capuchino.getCoffeWeight());
		setWaterLevel(getWaterLevel() - capuchino.getWaterVolume());
		setTankVolume(getTankVolume() + capuchino.getCoffeWeight());
		setMilkTankVolume(getMilkTankVolume() - milkVolume);
	}
}
