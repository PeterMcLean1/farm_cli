package farm.nz.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import farm.nz.model.Animal;
import farm.nz.model.Crop;
import farm.nz.model.Farm;
import farm.nz.model.Game;
import farm.nz.model.Item;
import farm.nz.model.Paddock;

/**
 * Contains methods to print general game play options to console
 * 
 * @author peter.mclean
 *
 */
public class GameUtil {

	static Scanner keyboard = new Scanner(System.in);

	/**
	 * Pushes the existing text output up the screen so that it does not distract
	 * from the current user actions
	 */
	public static void clearScreen() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}

	}

	/**
	 * Prints a header with useful status information for the current farmer
	 * 
	 * @param game Used to track game progress
	 */
	public static void header(Game game) {
		clearScreen();
		Farm farm = game.getFarm();
		StringBuffer sb1 = new StringBuffer();
		sb1.append(farm.getName());
		int nameLength = sb1.length();
		int spaces = 25 - nameLength;
		for (int i = 0; i < spaces; i++) {
			sb1.append(" ");
		}
		StringBuffer sb2 = new StringBuffer();
		sb2.append("---------------------------------------------\n");
		sb2.append("| ");
		sb2.append(sb1);
		sb2.append("   Account: $");
		sb2.append(farm.getAccount());
		sb2.append(" |\n");
		sb2.append("---------------------------------------------\n");
		sb2.append("| Day: ");
		sb2.append(game.getCurrentDay());
		sb2.append(" of ");
		sb2.append(game.getDaysToPlay());
		sb2.append("         Actions remaining: ");
		sb2.append(game.getActionCount());
		sb2.append(" |\n");
		sb2.append("---------------------------------------------");
		System.out.println(sb2.toString());
	}

	/**
	 * Displays the main menu for the game
	 * 
	 * @param game Used to track game progress
	 */
	public static void mainScreen(Game game) {
		StringBuffer sb = new StringBuffer();
		sb.append("What would you like to do next? (1-5):\n\n");
		sb.append("1. View Crops\n");
		sb.append("2. View Animals\n");
		sb.append("3. View Supplies\n");
		sb.append("4. Farm maintenance\n");
		sb.append("5. Visit Store\n");
		sb.append("6. Move to next day\n");

		boolean looper = true;

		while (looper) {
			header(game);
			System.out.println(sb.toString());
			int selection = GameUtil.getInputNumber();

			switch (selection) {
			case 1:
				viewCrops(game);
				looper = false;
				break;
			case 2:
				viewAnimals(game);
				looper = false;
				break;
			case 3:
				viewItems(game);
				looper = false;
				break;
			case 4:
				farmMaintenance(game);
				looper = false;
				break;
			case 5:
				StoreUtil.mainStore(game);
				looper = false;
				break;
			case 6:
				game.incrementCurrentDay();
				game.setActionCount();
				continue;
			default:
				continue;
			}
		}

	}

	/**
	 * Handles input that needs to be safely parsed from String to Integer
	 * 
	 * @return Returns the input parsed as an int or -1 on error
	 */
	public static int getInputNumber() {
		if (keyboard.hasNext()) {
			try {
				return Integer.parseInt(keyboard.next());
				// parseInt will throw NumberFormatException
				// if the next token does not match the Integer
				// regular expression, or is out of range
			} catch (NumberFormatException nfe) {
				return -1;
			}
		}
		return -1;
	}

	/**
	 * Used to set up programmed game options prior to the start of game play
	 * 
	 * @param game Used to track game progress
	 */
	public static void setupEnvironment(Game game) {
		Farm farm = game.getFarm();
		farm.setAccount(50);
		farm.setName("Peter Valley Farm");
		game.setDaysToPlay(5);
		farm.addPaddock(new Paddock());
		farm.addPaddock(new Paddock());
	}

	/**
	 * Displays the actions available to be applied to an animal
	 * 
	 * @param animal The animal being viewed
	 * @param game   Used to track game progress
	 */

	public static void viewAnimal(Animal animal, Game game) {
		header(game);
		System.out.println("You have selected a " + animal.getType().getDescription());
		System.out.println("What action do you wish to perform?\n");
		System.out.println("1. * Play with animal (+2 happiness)");
		System.out.println("2. * Use item on animal (+item-bonus health)");
		System.out.println("3. Return to Animal list");

		int selection = GameUtil.getInputNumber();

		switch (selection) {
		case 1:
			animal.setHappy(animal.getHappy() + 2);
			game.reduceActionCount();
			viewAnimals(game);
			break;
		case 2:
			viewAnimalItems(animal, game);
			break;
		default:
			viewAnimals(game);
		}

	}

	/**
	 * 
	 * @param game Used to track game instance progress
	 */
	public static void farmMaintenance(Game game) {
		header(game);
		System.out.println("1. * Fencing (+1 paddock to your farm)");
		System.out.println("2. * Barn repair (+3 happiness to a random animal)");
		System.out.println("3. Return to main menu");
		int selection = GameUtil.getInputNumber();

		switch (selection) {
		case 1:
			Paddock paddock = new Paddock();
			game.getFarm().addPaddock(paddock);
			game.reduceActionCount();
			mainScreen(game);
			break;
		case 2:
			List<Animal> animals = game.getFarm().getAnimals();
			if (animals.size() > 0) {
				Random rand = new Random();
				Animal animal = animals.get(rand.nextInt(animals.size()));
				animal.setHappy(animal.getHappy() + 3);
				game.reduceActionCount();
			}
			mainScreen(game);
			break;
		default:
			mainScreen(game);
		}

	}

	/**
	 * 
	 * @param animal The animal to apply an item to
	 * @param game   Used to track game instance progress
	 */
	public static void viewAnimalItems(Animal animal, Game game) {
		header(game);
		System.out.println("Select the item you wish to use:");
		Farm farm = game.getFarm();
		List<Item> items = farm.getItems();
		List<Item> animalItems = new ArrayList<Item>();
		for (Item item : items) {
			if (item.isAnimal()) {
				animalItems.add(item);
			}
		}
		int lineNumber = 1;

		for (Item item : animalItems) {
			System.out.println(lineNumber + ". " + item.getType().getDescription());

			lineNumber++;
		}
		int selection = GameUtil.getInputNumber();
		lineNumber = 1;

		for (Item item : animalItems) {
			if (selection == lineNumber) {
				animal.setHealth(animal.getHealth() + item.getBonus());
				farm.getItems().remove(item);
				game.reduceActionCount();
			}
			lineNumber++;
		}
		viewAnimals(game);

	}

	/**
	 * 
	 * @param game Used to track game instance progress
	 */
	public static void viewAnimals(Game game) {
		Farm farm = game.getFarm();
		List<Animal> animals = farm.getAnimals();
		header(game);
		int lineNumber = 1;
		System.out.println("Select an animal");

		for (Animal animal : animals) {

			System.out.println(lineNumber + ". " + animal.getType().getDescription() + " (Happiness: "
					+ animal.getHappy() + " Health: " + animal.getHealth() + ")");
			lineNumber++;
		}
		System.out.println(lineNumber + ". Return to main menu");
		int selection = GameUtil.getInputNumber();

		lineNumber = 1;

		for (Animal animal : animals) {
			if (selection == lineNumber) {
				viewAnimal(animal, game);
			}
			lineNumber++;
		}
		mainScreen(game);

	}

	/**
	 * 
	 * @param game Used to track game instance progress
	 */
	public static void viewCrops(Game game) {
		Farm farm = game.getFarm();
		header(game);
		int lineNumber = 1;

		for (Paddock paddock : farm.getPaddocks()) {
			if (paddock.hasCrop()) {
				Crop crop = paddock.getCrop();
				int timeGrown = game.getCurrentDay() - crop.getDayPlanted();
				int timeMature = crop.getDayPlanted() + crop.getMaturity() - game.getCurrentDay();
				System.out.println(
						lineNumber + ". Paddock " + paddock.getPaddockID() + " (" + crop.getType().getDescription()
								+ ", Days grown: " + timeGrown + ", Days to harvest: " + timeMature + ")");
			} else {
				System.out.println(lineNumber + ". Paddock " + paddock.getPaddockID() + " (no crop!)");
				// System.out.println("NOTE: Visit the General Store to buy and plant crops");
			}
			lineNumber++;
		}
		System.out.println(lineNumber + ". Return to main menu");
		int selection = GameUtil.getInputNumber();

		lineNumber = 1;

		for (Paddock paddock : farm.getPaddocks()) {
			if (selection == lineNumber) {
				viewPaddock(paddock, game);
			}
			lineNumber++;
		}

		mainScreen(game);

	}

	/**
	 * Menu to select actions on a crop
	 * 
	 * @param paddock A space to plant crops in
	 * @param game    Used to track game progress
	 */
	public static void viewPaddock(Paddock paddock, Game game) {
		header(game);

		Crop crop = paddock.getCrop();
		if (null == crop) {
			viewCrops(game);
		} else {

			System.out.println("You have selected paddock " + paddock.getPaddockID() + " containing "
					+ crop.getType().getDescription());
			System.out.println("What action do you wish to perform?\n");
			System.out.println("1. * Water crop");
			System.out.println("2. * Use item on crop");
			if (crop.isMature(game)) {
				System.out.println("3. * Harvest crop (crop is ready)");
			} else {
				System.out.println("3. Harvest crop (crop is not ready)");
			}

			System.out.println("4. Return to crop list");

			int selection = GameUtil.getInputNumber();

			switch (selection) {
			case 1:
				crop.setMaturity(crop.getMaturity() - 1);
				game.reduceActionCount();
				viewCrops(game);
				break;
			case 2:
				viewCropItems(paddock, game);
				break;
			case 3:
				if (paddock.getCrop().isMature(game)) {
					game.getFarm().setAccount(game.getFarm().getAccount() + paddock.getCrop().getSalePrice());
					paddock.setCrop(null);
				}
				viewPaddock(paddock, game);
				break;
			default:
				viewCrops(game);
			}
		}

	}

	/**
	 * 
	 * @param paddock
	 * @param game    Used to track game instance progress
	 */
	public static void viewCropItems(Paddock paddock, Game game) {
		header(game);
		System.out.println("Select the item you wish to use:");
		Farm farm = game.getFarm();
		List<Item> items = farm.getItems();
		List<Item> cropItems = new ArrayList<Item>();
		for (Item item : items) {
			if (item.isCrop()) {
				cropItems.add(item);
			}
		}
		int lineNumber = 1;

		for (Item item : cropItems) {
			System.out.println(lineNumber + ". " + item.getType().getDescription());
			lineNumber++;
		}

		System.out.println(lineNumber + ". Return to crop list");
		int selection = GameUtil.getInputNumber();

		lineNumber = 1;

		for (Item item : cropItems) {
			if (selection == lineNumber) {
				paddock.getCrop().setMaturity(paddock.getCrop().getMaturity() - item.getBonus());
				farm.getItems().remove(item);
				game.reduceActionCount();
			}
			lineNumber++;
		}

		viewCrops(game);

	}

	/**
	 * 
	 * @param game Used to track game instance progress
	 */
	public static void viewItems(Game game) {
		header(game);
		Farm farm = game.getFarm();
		int lineNumber = 1;

		for (Item item : farm.getItems()) {
			System.out.println(lineNumber + ". " + item.getType().getDescription());
			lineNumber++;
		}

		System.out.println(lineNumber + ". Return to main menu");
		int response = GameUtil.getInputNumber();
		mainScreen(game);

	}

}
