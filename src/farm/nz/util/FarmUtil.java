package farm.nz.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import farm.nz.model.Farm;
import farm.nz.model.Farmer;
import farm.nz.type.FarmType;

public class FarmUtil {
	static Scanner keyboard = new Scanner(System.in);

	public static void setFarmDays(Farm farm) {
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
				farm.setDays(days);
				looper = false;
			}
		}

	}

	public static void setFarmName(Farm farm) {
		boolean looper = true;
		while (looper) {
			String name = "";
			System.out.println("Farm name must be less than 25 characters");
			System.out.println("Please enter a name for your farm:");
			name = keyboard.next();
			if (25 < name.length()) {
				continue;
			}
			System.out.println("The name of your farm is " + name + ", is this correct? (Y/N)");
			String response = keyboard.next();
			if (response.equalsIgnoreCase("y")) {
				farm.setName(name);
				looper = false;
			}
		}
	}

	public static void setFarmType(Farm farm) {
		StringBuffer sb = new StringBuffer();
		sb.append("Please select your farm type (1-4):\n\n");
		sb.append("1. " + FarmType.FLAT.getDescription() + "\n");
		sb.append("2. " + FarmType.HILL.getDescription() + "\n");
		sb.append("3. " + FarmType.RIVER.getDescription() + "\n");
		sb.append("4. " + FarmType.FOREST.getDescription());
		boolean looper = true;

		while (looper) {
			System.out.println(sb.toString());
			int response1 = keyboard.nextInt();
			setType(farm, response1);
			System.out.println("Your farm type is " + farm.getType().getDescription() + ", is this correct? (Y/N)");
			String response2 = keyboard.next();
			if (response2.equalsIgnoreCase("y")) {
				looper = false;
			}
		}

	}

	private static void setType(Farm farm, int selection) {

		switch (selection) {
		case 1:
			farm.setType(FarmType.FLAT);
			break;
		case 2:
			farm.setType(FarmType.HILL);
			break;
		case 3:
			farm.setType(FarmType.RIVER);
			break;
		case 4:
			farm.setType(FarmType.FOREST);
			break;
		default:
			farm.setType(FarmType.FLAT);
			break;
		}

	}

	public static void setAge(Farmer farmer) {
		boolean looper = true;
		int age = 1;
		while (looper) {

			try {
				System.out.println("Please enter a whole number between 1 and 100");
				System.out.println("Please enter your age:");
				// nextInt will throw InputMismatchException
				// if the next token does not match the Integer
				// regular expression, or is out of range
				age = keyboard.nextInt();
				if (100 < age || 0 > age) {
					continue;
				}
			} catch (InputMismatchException exception) {
				// scanner reset
				keyboard = new Scanner(System.in);
				continue;
			}

			System.out.println("Your age is " + age + ", is this correct? (Y/N)");
			String response = keyboard.next();
			if (response.equalsIgnoreCase("y")) {
				farmer.setAge(age);
				looper = false;
			}
		}
	}

	public static void setName(Farmer farmer) {
		boolean looper = true;
		System.out.println("Welcome farmer!");
		while (looper) {
			String name = "";
			System.out.println("Player name must be 3-15 characters, and contain no special characters");
			System.out.println("Please enter your player name:");
			name = keyboard.next();
			// regex validate name = no special characters 3-15 long
			if (!name.matches("[A-Za-z0-9]{3,15}")) {
				continue;
			}
			System.out.println("Your name is " + name + ", is this correct? (Y/N)");
			String response = keyboard.next();
			if (response.equalsIgnoreCase("y")) {
				farmer.setName(name);
				looper = false;

			}
		}
	}

}
