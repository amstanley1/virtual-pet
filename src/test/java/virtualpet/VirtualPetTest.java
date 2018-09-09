package virtualpet;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class VirtualPetTest {
	
	VirtualPet pet;
	
	@Before
	public void setup() {
		pet = new VirtualPet("Horace", 0, 7);
	}
	
	@Test
	public void shouldBeAbleToCreateNewVirtualPet() {
		VirtualPet pet = new VirtualPet("Crookshanks", 3, 8);
	}
	

	
	@Test
	public void shouldBeAbleToGetHungerLevel() {
		int hungerLevel = pet.getHungerLevel();
		assertTrue(hungerLevel == 0);
	}
	
	@Test
	public void shouldBeAbleToGetSleepinessLevel() {
		int sleepinessLevel = pet.getSleepinessLevel();
		assertTrue(sleepinessLevel == 7);
	}
	

	
	@Test
	public void shouldBeAbleToFeedPet() {

		int originalHungerLevel = pet.getHungerLevel();
		pet.feed();
	
		assertTrue((originalHungerLevel - 5) == (pet.getHungerLevel()));
	}
	
	@Test
	public void shouldBeAbleToGetBoredomLevel() {
		int boredomLevel = pet.getBoredomLevel();
		assertTrue(boredomLevel == 6);
	}
	
	@Test
	public void shouldBeAbleToPlayWithPet() {
		int originalBoredomLevel = pet.getBoredomLevel();
		pet.playWith();
		assertTrue(originalBoredomLevel - 3 == pet.getBoredomLevel());
	}
	

	@Test
	public void shouldBeAbleToPutIntPasture() {
		int originalBoredomLevel = pet.getBoredomLevel();
	
		pet.putInPasture();
		assertTrue(originalBoredomLevel - 3 == pet.getBoredomLevel());
		
	}
	
	@Test
	public void tickMethodShouldIncrementsAndDecrementProperties() {
		int originalBoredomLevel = pet.getBoredomLevel();
		
		int originalHungerLevel = pet.getHungerLevel();
		int originalSleepinessLevel = pet.getSleepinessLevel();
		pet.tick();
		assertTrue(originalBoredomLevel + 1 == pet.getBoredomLevel());
	
		assertTrue(originalHungerLevel + 1 == pet.getHungerLevel());
		assertTrue(originalSleepinessLevel + 1 == pet.getSleepinessLevel());
	}
	
	@Test
	public void shouldBeAbleToGetName() {
		String name = pet.getName();
		assertTrue(name.equals("Horace"));
	}
}
