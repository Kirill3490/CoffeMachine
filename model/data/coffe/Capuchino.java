package by.bobruisk.itstep.polimorfizm.model.data.coffe;

public class Capuchino extends Coffe {
	Espresso espresso = new Espresso();

	public Capuchino(int milkVolume) {
		setCoffeWeight(espresso.getCoffeWeight());
		setWaterVolume(espresso.getWaterVolume());
		setMilkVolume(milkVolume);
	}
}
