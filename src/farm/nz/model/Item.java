package farm.nz.model;

import farm.nz.type.ItemType;

public class Item {
	private ItemType type;
	private boolean crop;
	private boolean animal;
	private int purchasePrice;
	private int bonus;
	private int residual;

	public Item(ItemType type, boolean crop, boolean animal, int price, int bonus, int residual) {
		super();
		this.type = type;
		this.crop = crop;
		this.animal = animal;
		this.purchasePrice = price;
		this.bonus = bonus;
		this.residual = residual;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public boolean isCrop() {
		return crop;
	}

	public void setCrop(boolean crop) {
		this.crop = crop;
	}

	public boolean isAnimal() {
		return animal;
	}

	public void setAnimal(boolean animal) {
		this.animal = animal;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int price) {
		this.purchasePrice = price;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getResidual() {
		return residual;
	}

	public void setResidual(int residual) {
		this.residual = residual;
	}

}
