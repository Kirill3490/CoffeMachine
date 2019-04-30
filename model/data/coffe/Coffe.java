package by.bobruisk.itstep.polimorfizm.model.data.coffe;

public abstract class Coffe {
	private int coffeWeight;
	private int waterVolume;
	private int milkVolume;
	
	
	public int getCoffeWeight() {
		return coffeWeight;
	}
	public void setCoffeWeight(int coffeWeight) {
		this.coffeWeight = coffeWeight;
	}
	public int getWaterVolume() {
		return waterVolume;
	}
	public void setWaterVolume(int waterVolume) {
		this.waterVolume = waterVolume;
	}
	public int getMilkVolume() {
		return milkVolume;
	}
	public void setMilkVolume(int milkVolume) {
		this.milkVolume = milkVolume;
	}
	
}
