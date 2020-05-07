package farm.nz;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import farm.nz.model.Farm;
import farm.nz.model.Game;


public class GameModelTest {
	
	@Test
	void gameConstructorTest() {
		
		Farm farm = new Farm();
		farm.setName("FarmOne");
		Game game = new Game(farm);
		
		assertTrue(game.getFarm().getName() == "FarmOne");

	}
	
	
	@Test
	void gameSetGetTest() {

		Game game = new Game();
		
		game.setActionCount(3);
		game.setCurrentDay(12);
		game.setDaysToPlay(34);
		game.setMaxDailyActions(54);
		Farm farm = new Farm();
		farm.setName("FarmTwo");
		game.setFarm(farm);
		
		assertTrue(game.getActionCount() == 3);
		assertTrue(game.getCurrentDay() == 12);
		assertTrue(game.getDaysToPlay() == 34);
		assertTrue(game.getMaxDailyActions() == 54);
		assertTrue(game.getFarm().getName() == "FarmTwo");

	}
	
	@Test
	void gameIncrementActionCountTest() {
		
		Game game = new Game();

		assertTrue(game.getActionCount() == 0);
		game.incrementActionCount();
		assertTrue(game.getActionCount() == 1);

		
	}
	
	@Test
	void gameIncrementCurrentDayTest() {
		
		Game game = new Game();

		assertTrue(game.getCurrentDay() == 1);
		game.incrementCurrentDay();
		assertTrue(game.getCurrentDay() == 2);
		
	}
	
	@Test
	void gameHasActionsTest() {
		
		Game game = new Game();
		
		assertTrue(game.hasActions() == true);
		
		for (int i = 0; i < game.getMaxDailyActions(); i++) {
			game.incrementActionCount();
		}

		assertTrue(game.hasActions() == false);
		
	}

}
