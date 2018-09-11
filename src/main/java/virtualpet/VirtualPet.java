package virtualpet;

public class VirtualPet {

	// Fields for name, hunger level, sleepiness level, boredom level, state of
	// sleep, and location
	private String name;
	private int hungerLevel;
	private int sleepinessLevel;
	private int boredomLevel;
	private boolean isAsleep;
	private boolean isInPasture;
	private boolean hasRunAway;

	// Getters
	public boolean getIsAsleep() {
		return this.isAsleep;
	}

	public boolean getIsInPasture() {
		return this.isInPasture;
	}

	public boolean getHasRunAway() {
		return this.hasRunAway;
	}

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

	// Constructors
	public VirtualPet() {
		this("", 10, 10);
	}

	public VirtualPet(String name, int hungerLevel, int sleepinessLevel) {
		this.name = name;
		this.hungerLevel = hungerLevel;
		this.sleepinessLevel = sleepinessLevel;

		this.boredomLevel = 6;
	}

	// Feed Pet, lowers hunger level depending on user selected food number
	public void feed(int userSelectedFood) {
		switch (userSelectedFood) {
		case 1:
			if (this.hungerLevel < 5) {
				this.hungerLevel = 0;
			} else {
				this.hungerLevel = this.hungerLevel - 5;
			}
			break;
		case 2:
			if (this.hungerLevel < 3) {
				this.hungerLevel = 0;
			} else {
				this.hungerLevel = this.hungerLevel - 3;
			}
			break;
		case 3:
			if (this.hungerLevel < 1) {
				this.hungerLevel = 0;
			} else {
				this.hungerLevel = this.hungerLevel - 1;
			}
			break;
		}
	}

	// Play with pet, lowers boredom level
	public void playWith() {
		if (this.boredomLevel < 3) {
			this.boredomLevel = 0;
		} else {
			this.boredomLevel = this.boredomLevel - 3;
		}
		if (this.sleepinessLevel > 8) {
			this.sleepinessLevel = 10;
		} else {
			this.sleepinessLevel = this.sleepinessLevel + 2;
		}
	}

	// move pet to pasture if in barn, or to barn if in pasture by toggling the
	// boolean isInPasture property
	public void move() {
		if (this.isInPasture) {
			this.isInPasture = false;
			if (this.boredomLevel > 8) {
				this.boredomLevel = 10;
			} else {
				this.boredomLevel = this.boredomLevel + 2;
			}
		} else {
			if (this.boredomLevel < 3) {
				this.boredomLevel = 0;
			} else {
				this.boredomLevel = this.boredomLevel - 3;
			}
			this.isInPasture = true;
		}
	}

	// makes time pass, raises pet's needs, if pet sleepiness level is above 8 it will
	//go to sleep, if it's hunger level is above 8, it will run away.
	public void tick() {
		if (this.hungerLevel > 8) {
			this.hasRunAway = true;
		} else {
			this.hungerLevel++;
		}
		if (this.boredomLevel < 10) {
			this.boredomLevel++;
		}
		this.sleepinessLevel++;
		if (this.sleepinessLevel > 8) {
			this.sleep();
		}
	}

	// sleep method, lowers sleepiness level, sets boolean isAsleep
	// to true
	public void sleep() {
		this.sleepinessLevel = this.sleepinessLevel - 5;
		this.isAsleep = true;
	}

	// wake method, sets boolean isAsleep to false
	public void wake() {
		this.isAsleep = false;
	}

	// prints pet, prints with fence if horse isInPasture is true
	public void printHorse() {
		if (this.isInPasture) {
			System.out.println("                         ^^   ");
			System.out.println("                  ______/''\\");
			System.out.println("                 #       /\\ \\          ||--||--||--||");
			System.out.println("                # ||___||  ''          ||--||--||--||");
			System.out.println("                  ||   ||              ||--||--||--||");
		} else {

			System.out.println("                         ^^   ");
			System.out.println("                  ______/''\\");
			System.out.println("                 #       /\\ \\");
			System.out.println("                # ||___||  '' ");
			System.out.println("                  ||   ||");

		}
	}

}
