package by.bobruisk.itstep.polimorfizm.model.data.coffemachine;

import by.bobruisk.itstep.polimorfizm.model.data.coffe.Americano;
import by.bobruisk.itstep.polimorfizm.model.data.coffe.Espresso;

public class FirstCoffeMachine extends CoffeMachine implements Buttons {

	public FirstCoffeMachine() {
		setCondition(false);
		setTankVolume(0);
		setWaterLevel(500);
		setMaxTankSize(100);
		setGroundCoffeLevel(200);
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
				+ "мл.\nУровень кофе: " + getGroundCoffeLevel() + "г.");
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

}
