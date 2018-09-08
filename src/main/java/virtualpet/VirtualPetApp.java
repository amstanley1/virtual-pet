package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("You are out in the woods when a horse runs up to"
				+ " you. You approach the horse slowly and hold out your hand. The horse "
				+ "lets you lead it home." );
		System.out.println("What will you name your new horse?");
		String name = input.nextLine();
		VirtualPet yourHorse = new VirtualPet(name, 8, 5);
		System.out.println("Your horse is named " + yourHorse.getName());
		int userSelection = 0;
		while(userSelection != 4) {
			System.out.println("Stats for " + yourHorse.getName());
			System.out.println("Hunger: " + yourHorse.getHungerLevel());
			System.out.println("Sleepiness: " + yourHorse.getSleepinessLevel());
			System.out.println("Boredom: " + yourHorse.getBoredomLevel());
			System.out.println();
			System.out.println("1. Feed " + yourHorse.getName());
			System.out.println("2. Play with  " + yourHorse.getName());
			System.out.println("3. Put " + yourHorse.getName() + " into the pasture.");
			System.out.println("4. Quit the game.");
			System.out.println("What do you want to do?");
			userSelection = input.nextInt();
			input.nextLine();
			if (userSelection == 1) {
				yourHorse.feed();
			} else if (userSelection == 2) {
				yourHorse.playWith();
			} else {
				yourHorse.putInPasture();
			}
			yourHorse.tick();
		}
		System.out.println("Goodbye.");
	}
} 
