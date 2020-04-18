package farm.nz.model;

import farm.nz.type.AnimalType;

public class Animal extends StoreItem {
	private int happy; // affect daily income
	private int health; // affect daily income
	private int dailyIncome; // income produced daily from animal
	private AnimalType type;

	public Animal(AnimalType type, int happy, int health, int price, int dailyIncome, int residual) {
		super(price, residual);
		this.happy = happy;
		this.health = health;
		this.dailyIncome = dailyIncome;
		this.type = type;
	}

	public int getHappy() {
		return happy;
	}

	public void setHappy(int happy) {
		this.happy = happy;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDailyIncome() {
		// TODO calculate income from happy and health
		return dailyIncome;
	}

	public void setDailyIncome(int dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	public AnimalType getType() {
		return type;
	}

	public void setType(AnimalType type) {
		this.type = type;
	}

}
