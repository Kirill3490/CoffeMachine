package by.bobruisk.itstep.polimorfizm.model.data.coffemachine;

import by.bobruisk.itstep.polimorfizm.model.data.coffe.Americano;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Latte;

public class ThirdCoffeMachine extends CoffeMachine implements Buttons {

	private int maxCoffeBeansTankVolume;
	private int coffeBeansTankVolume;

	public ThirdCoffeMachine() {
		this.maxCoffeBeansTankVolume = 200;
		this.coffeBeansTankVolume = 0;
		setCondition(false);
		setTankVolume(0);
		setMaxWaterLevel(500);
		setMaxTankSize(100);
		setMaxGroundCoffeLevel(200);
		setMaxMilkVolume(200);
		setMilkTankVolume(getMilkTankVolume());
		setCoffeBeansTankVolume(getMaxCoffeBeansTankVolume());
		setWaterLevel(0);
		setGroundCoffeLevel(getMaxGroundCoffeLevel());
	}

	public int getMaxCoffeBeansTankVolume() {
		return maxCoffeBeansTankVolume;
	}

	public void setMaxCoffeBeansTankVolume(int maxCoffeBeansTankVolume) {
		this.maxCoffeBeansTankVolume = maxCoffeBeansTankVolume;
	}

	public int getCoffeBeansTankVolume() {
		return coffeBeansTankVolume;
	}

	public void setCoffeBeansTankVolume(int coffeBeansTankVolume) {
		this.coffeBeansTankVolume = coffeBeansTankVolume;
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
		return ("Заполненность бака для отработанного кофе: " + getTankVolume() + "г.			Максимальный объем "
				+ getMaxTankSize() + "г.\nОсталось воды: " + getWaterLevel()
				+ "мл. 			Максимальный объем воды " + getMaxWaterLevel() + "мл.\nОсталось кофе: "
				+ getGroundCoffeLevel() + "г.			Максимальный объем кофе " + getMaxGroundCoffeLevel()
				+ " г.\nОсталось молока " + getMilkTankVolume() + "мл.			Максимальный объем молока"
				+ getMaxMilkVolume() + " мл.\nОбъем бака для зернового кофе " + getCoffeBeansTankVolume()
				+ "г.			Максимальный уровень зернового кофе" + getMaxCoffeBeansTankVolume() + " г.");
	}

	public void grindGrain(int coffeCount) {
		setCoffeBeansTankVolume(getCoffeBeansTankVolume() - coffeCount);
		setGroundCoffeLevel(getGroundCoffeLevel() + coffeCount);
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

}
