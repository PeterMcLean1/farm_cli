package farm.nz.util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import farm.nz.model.Animal;
import farm.nz.model.Crop;
import farm.nz.model.Farm;
import farm.nz.model.GamePlay;
import farm.nz.model.Item;
import farm.nz.model.Paddock;
import farm.nz.model.Store;

public class GameUtil {

	static Scanner keyboard = new Scanner(System.in);

	public static void header(GamePlay game) {
		clearScreen();
		String farmName = game.getFarm().getName();
		int nameLength = farmName.length();
		int spaces = 30 - nameLength;
		for (int i = 0; i < spaces; i++) {
			farmName = farmName + " ";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("----------------------------------------\n");
		sb.append("| " + farmName + " | Account: $" + game.getFarm().getAccount() + " |\n");
		sb.append("| Day: " + game.getCurrentDay() + " of " + game.getDaysToPlay() + " | Actions remaining: "
				+ game.getActionCount() + " |\n");
		sb.append("----------------------------------------");
		System.out.println(sb.toString());
	}

	/*
	 * Used to set up options on farm prior to game play starting
	 */
	public static void setupEnvironment(GamePlay game) {
		Farm farm = game.getFarm();
		farm.setAccount(50);
		farm.setName("Peter Valley");
		game.setDaysToPlay(5);
		farm.addPaddock(new Paddock());
		farm.addPaddock(new Paddock());
	}

	public static void mainOptionScreen(GamePlay game) {
		StringBuffer sb = new StringBuffer();
		header(game);

		sb.append("What would you like to do next? (1-5):\n\n");
		sb.append("1. View Crops\n");
		sb.append("2. View Animals\n");
		sb.append("3. View Supplies\n");
		sb.append("4. Visit Store\n");
		sb.append("5. Move to next day\n");

		boolean looper = true;

		while (looper) {
			System.out.println(sb.toString());
			int selection;
			try {
				// nextInt will throw InputMismatchException
				// if the next token does not match the Integer
				// regular expression, or is out of range
				selection = keyboard.nextInt();
			} catch (InputMismatchException exception) {
				// scanner reset
				keyboard = new Scanner(System.in);
				continue;
			}

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
				clearScreen();
				viewItems(game);
				looper = false;
				break;
			case 4:
				visitStore(game);
				looper = false;
				break;
			case 5:
				game.incrementCurrentDay();
				continue;
			default:
				continue;
			}
		}

	}

	public static void viewCrops(GamePlay game) {
		Farm farm = game.getFarm();
		int lineNumber = 1;
		header(game);

		for (Paddock paddock : farm.getPaddocks()) {
			if (paddock.hasCrop()) {
				System.out.println(lineNumber + ". Paddock " + paddock.getPaddockID() + " ("
						+ paddock.getCrop().getType().getDescription() + ")");
			} else {
				System.out.println(lineNumber + ". Paddock " + paddock.getPaddockID() + " (no crop!)");
			}
			lineNumber++;
		}

	}

	public static void viewAnimals(GamePlay game) {
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
		int selection = 0;
		try {
			// nextInt will throw InputMismatchException
			// if the next token does not match the Integer
			// regular expression, or is out of range
			selection = keyboard.nextInt();
		} catch (InputMismatchException exception) {
			// scanner reset
			keyboard = new Scanner(System.in);

		}
		int lineNumber2 = 1;

		for (Animal animal : animals) {

			if (selection == lineNumber2) {
				viewAnimal(animal, game);
			}
			lineNumber2++;

		}

	}

	public static void viewAnimal(Animal animal, GamePlay game) {
		header(game);
		System.out.println("You have selected a " + animal.getType().getDescription());
		System.out.println("What action do you wish to perform?\n");
		System.out.println("1. Play with animal");
		System.out.println("2. Use item on animal");
		System.out.println("3. Return to menu");

		int selection = 0;
		try {
			// nextInt will throw InputMismatchException
			// if the next token does not match the Integer
			// regular expression, or is out of range
			selection = keyboard.nextInt();
		} catch (InputMismatchException exception) {
			// scanner reset
			keyboard = new Scanner(System.in);
		}

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

	public static void viewAnimalItems(Animal animal, GamePlay game) {
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
		int selection = 0;
		try {
			// nextInt will throw InputMismatchException
			// if the next token does not match the Integer
			// regular expression, or is out of range
			selection = keyboard.nextInt();
		} catch (InputMismatchException exception) {
			// scanner reset
			keyboard = new Scanner(System.in);

		}

		int lineNumber2 = 1;

		for (Item item : animalItems) {

			if (selection == lineNumber2) {
				animal.setHealth(animal.getHealth() + item.getBonus());
				farm.getItems().remove(item);
				game.reduceActionCount();

			}

			lineNumber2++;

		}
		viewAnimals(game);

	}

	public static void viewItems(GamePlay game) {
		header(game);
		Farm farm = game.getFarm();
		int lineNumber = 1;

		for (Item item : farm.getItems()) {

			System.out.println(lineNumber + ". " + item.getType().getDescription());
			lineNumber++;
		}
	}

	public static void visitStore(GamePlay game) {
		StringBuffer sb = new StringBuffer();
		header(game);
		sb.append("Welcome to the General Store!\n");
		sb.append("What would you like to do next? (1-4):\n\n");
		sb.append("1. Buy Crops\n");
		sb.append("2. Buy Animals\n");
		sb.append("3. Buy Supplies\n");
		sb.append("4. Exit General Store\n");

		boolean looper = true;

		while (looper) {
			System.out.println(sb.toString());
			int selection;
			try {
				// nextInt will throw InputMismatchException
				// if the next token does not match the Integer
				// regular expression, or is out of range
				selection = keyboard.nextInt();
			} catch (InputMismatchException exception) {
				// scanner reset
				keyboard = new Scanner(System.in);
				continue;
			}

			switch (selection) {
			case 1:
				buyCrops(game);
				looper = false;
				break;
			case 2:
				buyAnimals(game);
				looper = false;
				break;
			case 3:
				buySupplies(game);
				looper = false;
				break;
			case 4:
				mainOptionScreen(game);
				looper = false;
				break;
			default:
				continue;
			}
		}
	}

	public static void buyCrops(GamePlay game) {
		header(game);

		Farm farm = game.getFarm();
		List<Paddock> paddocks = farm.getPaddocks();
		List<Paddock> emptyPaddocks = new ArrayList<Paddock>();
		for (Paddock p : paddocks) {
			if (!p.hasCrop()) {
				emptyPaddocks.add(p);

			}

		}
		System.out.println("You have " + emptyPaddocks.size() + " empty Paddocks");
		Store store = new Store();
		List<Crop> crops = store.getCropList();

		int lineNumber = 1;
		for (Crop crop : crops) {
			System.out.println(
					lineNumber + ". " + crop.getType().getDescription() + "($" + crop.getPurchasePrice() + ")");
			lineNumber++;
		}
		System.out.println(lineNumber + ". General Store Menu");

		int selection = 0;
		try {
			// nextInt will throw InputMismatchException
			// if the next token does not match the Integer
			// regular expression, or is out of range
			selection = keyboard.nextInt();
		} catch (InputMismatchException exception) {
			// scanner reset
			keyboard = new Scanner(System.in);

		}
		if (emptyPaddocks.size() == 0) {
			visitStore(game);
		}
		int lineNumber2 = 1;

		for (Crop crop : crops) {

			if (selection == lineNumber2) {
				if (crop.getPurchasePrice() <= farm.getAccount()) {
					farm.setAccount(farm.getAccount() - crop.getPurchasePrice());
					Paddock p = emptyPaddocks.get(0);

					p.setCrop(crop);
					emptyPaddocks.remove(p);
				}
			}
			lineNumber2++;

		}
		visitStore(game);
	}

	public static void buyAnimals(GamePlay game) {
		header(game);
		Farm farm = game.getFarm();
		System.out.println("Please select the Animal to purchase?");
		Store store = new Store();
		List<Animal> animals = store.getAnimalList();
		int lineNumber = 1;
		for (Animal animal : animals) {
			System.out.println(
					lineNumber + ". " + animal.getType().getDescription() + "($" + animal.getPurchasePrice() + ")");
			lineNumber++;
		}
		System.out.println(lineNumber + ". General Store Menu");
		int selection = 0;
		try {
			// nextInt will throw InputMismatchException
			// if the next token does not match the Integer
			// regular expression, or is out of range
			selection = keyboard.nextInt();
		} catch (InputMismatchException exception) {
			// scanner reset
			keyboard = new Scanner(System.in);

		}
		int lineNumber2 = 1;

		for (Animal animal : animals) {

			if (selection == lineNumber2) {
				if (animal.getPurchasePrice() <= farm.getAccount()) {

					farm.setAccount(farm.getAccount() - animal.getPurchasePrice());
					farm.addAnimal(animal);
				}

			}
			lineNumber2++;

		}
		visitStore(game);

	}

	public static void buySupplies(GamePlay game) {
		header(game);
		Farm farm = game.getFarm();
		Store store = new Store();
		List<Item> items = store.getItemList();
		int lineNumber = 1;
		for (Item item : items) {
			System.out.println(
					lineNumber + ". " + item.getType().getDescription() + "($" + item.getPurchasePrice() + ")");
			lineNumber++;
		}
		System.out.println(lineNumber + ". General Store Menu");

		int selection = 0;
		try {
			// nextInt will throw InputMismatchException
			// if the next token does not match the Integer
			// regular expression, or is out of range
			selection = keyboard.nextInt();
		} catch (InputMismatchException exception) {
			// scanner reset
			keyboard = new Scanner(System.in);

		}
		int lineNumber2 = 1;

		for (Item item : items) {

			if (selection == lineNumber2) {
				if (item.getPurchasePrice() <= farm.getAccount()) {

					farm.setAccount(farm.getAccount() - item.getPurchasePrice());
					farm.addItem(item);
				}

			}
			lineNumber2++;

		}
		visitStore(game);

	}

	public static void clearScreen() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}

	}

	public static void setGameDays(GamePlay game) {
		boolean looper = true;
		int days = 0;

		while (looper) {
			try {
				System.out.println("Please enter the number of days you want to play (5-10):");
				// nextInt will throw InputMismatchException
				// if the next token does not match the Integer
				// regular expression, or is out of range
				days = keyboard.nextInt();
				if (days < 5 || days > 10) {
					continue;
				}
			} catch (InputMismatchException exception) {
				// scanner reset
				keyboard = new Scanner(System.in);
				continue;
			}

			System.out.println("Play for " + days + " days? (Y/N)");
			String response = keyboard.next();
			if (response.equalsIgnoreCase("y")) {
				game.setDaysToPlay(days);
				GameUtil.clearScreen();
				looper = false;
			}
		}

	}

}
