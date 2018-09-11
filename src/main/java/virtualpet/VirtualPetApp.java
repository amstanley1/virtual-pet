package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("You are out in the woods when a horse runs up to"
				+ " you. You approach the horse slowly and hold out your hand. The horse " + "lets you lead it home.");
		System.out.println("What will you name your new horse?");
		String name = input.nextLine();
		VirtualPet yourHorse = new VirtualPet(name, 8, 5);
		System.out.println("Your horse is named " + yourHorse.getName());
		int userSelection = 0;
		while (userSelection != 5 && !yourHorse.getHasRunAway()) {
			//Check if horse is asleep
			if (yourHorse.getIsAsleep()) {
				System.out.println(yourHorse.getName() + " is asleep. Press 1 to continue.");
				userSelection = input.nextInt();
				input.nextLine();
				if (userSelection == 1) {
					yourHorse.wake();
					System.out.println(yourHorse.getName() + " woke up!");
					System.out.println("Press enter to continue");
					input.nextLine();
					continue;
				} else {
					continue;
				}
			}
			
			//Print horse's stats
			System.out.println();
			System.out.println("Stats for " + yourHorse.getName());
			System.out.println("Hunger: " + yourHorse.getHungerLevel());
			System.out.println("Sleepiness: " + yourHorse.getSleepinessLevel());
			System.out.println("Boredom: " + yourHorse.getBoredomLevel());
			System.out.println();
			
			//List options and ask user to select one
			System.out.println("1. Feed " + yourHorse.getName());
			System.out.println("2. Play with  " + yourHorse.getName());
			if (yourHorse.getIsInPasture()) {
				System.out.println("3. " + yourHorse.getName() + " is in the pasture. Put " + yourHorse.getName()
						+ " in the barn.");
			} else {
				System.out.println("3. " + yourHorse.getName() + " is in the barn. Put " + yourHorse.getName()
						+ " in the pasture.");
			}
			System.out.println("4. Do nothing.");
			System.out.println("5. Quit the game.");
			yourHorse.printHorse();
			System.out.println("What number do you want to select?");
			userSelection = input.nextInt();
			input.nextLine();
			
			//Take action depending on user selected option
			if (userSelection == 1) {
				System.out.println("1. Apples");
				System.out.println("2. Carrots");
				System.out.println("3. Hay");
				System.out.println("What number would you like to select?");
				int userSelectedFood = input.nextInt();
				input.nextLine();
				yourHorse.feed(userSelectedFood);
				System.out.println("You fed " + yourHorse.getName());
				if (userSelectedFood == 1) {
					System.out.println(yourHorse.getName() + " ate all the apples.");
				} else if (userSelectedFood == 2) {
					System.out.println(yourHorse.getName() + " ate some of the carrots.");
				} else if (userSelectedFood == 3) {
					System.out.println(yourHorse.getName() + " ate a little bit of the hay.");
				}
				System.out.println("Press enter to continue");
				input.nextLine();

			} else if (userSelection == 2) {
				System.out.println("You played with " + yourHorse.getName() + ". " + yourHorse.getName() + " is less bored now, but more tired." );
				yourHorse.playWith();
				System.out.println("Press enter to continue");
				input.nextLine();
			} else if (userSelection == 3) {
				if (yourHorse.getIsInPasture()) {
					System.out.println("You put " + yourHorse.getName() + " in the barn.");
					yourHorse.move();
				} else {
					System.out.println("You put " + yourHorse.getName() + " in the pasture.");
					yourHorse.move();
				}
				System.out.println("Press enter to continue");
				input.nextLine();
			}
			
			//call tick method to pass time in the game
			yourHorse.tick();

		}
		
		//check if horse has run away or user has quit the game
		if (yourHorse.getHasRunAway()) {
			System.out.println(yourHorse.getName() + " ran away. You should have taken better care of your horse.");
		} else {
			System.out.println("You have quit the game. Goodbye.");
		}
		input.close();
	}
}
