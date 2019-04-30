package by.bobruisk.itstep.polimorfizm.model.data.coffemachine;

public abstract class CoffeMachine {
	private boolean condition;
	private int waterLevel;
	private int maxWaterLevel;
	
	private int groundCoffeLevel;
	private int maxGroundCoffeLevel;
	
	private int maxTankSize;
	private int tankVolume;
	
	private int milkTankVolume;
	private int maxMilkVolume;
	
	
	public int getMaxWaterLevel() {
		return maxWaterLevel;
	}
	public void setMaxWaterLevel(int maxWaterLevel) {
		this.maxWaterLevel = maxWaterLevel;
	}
	public int getMaxGroundCoffeLevel() {
		return maxGroundCoffeLevel;
	}
	public void setMaxGroundCoffeLevel(int maxGroundCoffeLevel) {
		this.maxGroundCoffeLevel = maxGroundCoffeLevel;
	}
	public int getMilkTankVolume() {
		return milkTankVolume;
	}
	public void setMilkTankVolume(int milkTankVolume) {
		this.milkTankVolume = milkTankVolume;
	}
	public int getMaxMilkVolume() {
		return maxMilkVolume;
	}
	public void setMaxMilkVolume(int maxMilkVolume) {
		this.maxMilkVolume = maxMilkVolume;
	}
	public boolean getCondition() {
		return condition;
	}
	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	public int getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(int waterLevel) {
		this.waterLevel = waterLevel;
	}
	public int getGroundCoffeLevel() {
		return groundCoffeLevel;
	}
	public void setGroundCoffeLevel(int groundCoffeLevel) {
		this.groundCoffeLevel = groundCoffeLevel;
	}
	public int getTankVolume() {
		return tankVolume;
	}
	public void setTankVolume(int tankVolume) {
		this.tankVolume = tankVolume;
	}
	public int getMaxTankSize() {
		return maxTankSize;
	}
	public void setMaxTankSize(int maxTankSize) {
		this.maxTankSize = maxTankSize;
	}
	
	
	
}
