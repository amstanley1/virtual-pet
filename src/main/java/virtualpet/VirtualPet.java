package virtualpet;

public class VirtualPet {
	private String name;
	private int hungerLevel;
	private int sleepinessLevel;
	private int wasteLevel;
	private int boredomLevel;
	
	public int getHungerLevel() {
		return this.hungerLevel;
	}
	
	public int getSleepinessLevel() {
		return this.sleepinessLevel;
	}
	
	public int getWasteLevel() {
		return this.wasteLevel;
	}
	
	public int getBoredomLevel() {
		return this.boredomLevel;
	}
	
	public String getName() {
		return this.name;
	}
	
	public VirtualPet() {
		this("", 10, 10);
	}
	
	public VirtualPet(String name, int hungerLevel, int sleepinessLevel) {
		this.name = name;
		this.hungerLevel = hungerLevel;
		this.sleepinessLevel = sleepinessLevel;
		this.wasteLevel = 0;
		this.boredomLevel = 6;
	}

	public void feed() {
	   this.hungerLevel = this.hungerLevel - 5;
	   this.wasteLevel = this.wasteLevel + 2;
	}

	public void playWith() {
		this.boredomLevel = this.boredomLevel - 3;
	}
	
	public void putInPasture() {
		this.boredomLevel = this.boredomLevel - 3;
		this.wasteLevel = this.wasteLevel - 3;
	}

	public void tick() {
		this.hungerLevel++;
		this.wasteLevel++;
		this.boredomLevel++;
		this.sleepinessLevel++;
	}
	
	public void sleep() {
		this.sleepinessLevel = this.sleepinessLevel - 5;
	}

	
}
