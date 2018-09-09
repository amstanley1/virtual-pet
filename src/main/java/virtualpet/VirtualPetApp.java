package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean isAsleep = false;
		boolean inPasture = false;
		
		System.out.println("You are out in the woods when a horse runs up to"
				+ " you. You approach the horse slowly and hold out your hand. The horse "
				+ "lets you lead it home." );
		System.out.println("What will you name your new horse?");
		String name = input.nextLine();
		VirtualPet yourHorse = new VirtualPet(name, 8, 5);
		System.out.println("Your horse is named " + yourHorse.getName());
		int userSelection = 0;
		while(userSelection != 5) {
			if (isAsleep) {
				System.out.println(yourHorse.getName() + " is asleep. Press 1 to continue.");
				isAsleep = false;
				userSelection = input.nextInt();
				if (userSelection == 1) {
					System.out.println(yourHorse.getName() + " woke up!");
					continue;
				}
			}
			System.out.println();
			System.out.println("Stats for " + yourHorse.getName());
			System.out.println("Hunger: " + yourHorse.getHungerLevel());
			System.out.println("Sleepiness: " + yourHorse.getSleepinessLevel());
			System.out.println("Boredom: " + yourHorse.getBoredomLevel());
			System.out.println();
			System.out.println("1. Feed " + yourHorse.getName());
			System.out.println("2. Play with  " + yourHorse.getName());
			if (inPasture) {
				System.out.println("3. Put " + yourHorse.getName() + " in the barn.");
			} else {
			System.out.println("3. Put " + yourHorse.getName() + " into the pasture.");
			}
			System.out.println("4. Do nothing.");
			System.out.println("5. Quit the game.");
			System.out.println();
			
			
			System.out.println("What number do you want to select?");
			userSelection = input.nextInt();
			input.nextLine();
			if (userSelection == 1) {
				System.out.println("You fed " + yourHorse.getName());
				yourHorse.feed();
			} else if (userSelection == 2) {
				System.out.println("You played with " + yourHorse.getName());
				yourHorse.playWith();
			} else if (userSelection == 3){
				if (inPasture == false) {
					System.out.println("You put " + yourHorse.getName() + " in the pasture.");
					yourHorse.putInPasture();
					inPasture = true;
				} else {
					System.out.println("You put " + yourHorse.getName() + " in the barn.");
					yourHorse.putInPasture();
					inPasture = false;
				}
			} else {
				continue;
			} 
			if(yourHorse.tick() == 1) {
				isAsleep = true;
			}
			
		}
		System.out.println("Goodbye.");
	}
} 
