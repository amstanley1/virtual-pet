package virtualpet;

public class VirtualPet {
	private String name;
	private int hungerLevel;
	private int sleepinessLevel;
	private int boredomLevel;
	
	public int getHungerLevel() {
		return this.hungerLevel;
	}
	
	public int getSleepinessLevel() {
		return this.sleepinessLevel;
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
		
		this.boredomLevel = 6;
	}

	public void feed() {
	   this.hungerLevel = this.hungerLevel - 5;
	
	}

	public void playWith() {
		this.boredomLevel = this.boredomLevel - 3;
	}
	
	public void putInPasture() {
		this.boredomLevel = this.boredomLevel - 3;
	
	}
	
	public void putInBarn() {
		this.boredomLevel = this.boredomLevel + 2;

	}

	public int tick() {
		this.hungerLevel++;

		this.boredomLevel++;
		this.sleepinessLevel++;
		if (this.sleepinessLevel > 8) {
			this.sleep();
			return 1;
		}
		return 0;
	}
	
	public void sleep() {
		this.sleepinessLevel = this.sleepinessLevel - 5;
	}

	
}
