package farm.nz.model;

import farm.nz.type.AnimalType;

public class Animal {
	private int happy; // affect daily income
	private int health; // affect daily income
	private int purchasePrice;
	private int dailyIncome; // income produced daily from animal
	private int residual; // value at end of game
	private AnimalType type;

	public Animal(AnimalType type, int happy, int health, int purchasePrice, int dailyIncome, int residual) {
		super();
		this.happy = happy;
		this.health = health;
		this.purchasePrice = purchasePrice;
		this.dailyIncome = dailyIncome;
		this.residual = residual;
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

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getDailyIncome() {
		// TODO calculate income from happy and health
		return dailyIncome;
	}

	public void setDailyIncome(int dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	public int getResidual() {
		return residual;
	}

	public void setResidual(int residual) {
		this.residual = residual;
	}

	public AnimalType getType() {
		return type;
	}

	public void setType(AnimalType type) {
		this.type = type;
	}

}
