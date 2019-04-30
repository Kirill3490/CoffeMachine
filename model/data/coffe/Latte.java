package by.bobruisk.itstep.polimorfizm.model.data.coffe;

public class Latte extends Coffe{
	
	Espresso espresso = new Espresso();
	
	public Latte(int milkVolume) {
		setCoffeWeight(espresso.getCoffeWeight());
		setWaterVolume(espresso.getWaterVolume());
		setMilkVolume(milkVolume);
	}
}
