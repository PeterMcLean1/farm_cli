package farm.nz.model;

import farm.nz.type.AnimalType;

public class Animal extends StoreItem {
	private int happy; // affect daily income
	private int health; // affect daily income
	private int baseIncome; // income produced daily from animal
	private AnimalType type;

	public Animal(AnimalType type, int happy, int health, int price, int baseIncome, int residual) {
		super(price, residual);
		this.happy = happy;
		this.health = health;
		this.baseIncome = baseIncome;
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

	public int getBaseIncome() {
		return baseIncome;
	}

	public int getDailyIncome() {
		int bonusIncome = (this.happy + this.health) / 2;
		return baseIncome + bonusIncome;

	}

	public void setBaseIncome(int baseIncome) {
		this.baseIncome = baseIncome;
	}

	public AnimalType getType() {
		return type;
	}

	public void setType(AnimalType type) {
		this.type = type;
	}

}
