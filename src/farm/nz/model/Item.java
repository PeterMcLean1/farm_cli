package farm.nz.model;

import farm.nz.type.ItemType;

public class Item extends StoreItem {
	private ItemType type;
	private boolean crop;
	private boolean animal;
	private int bonus;

	public Item(ItemType type, boolean crop, boolean animal, int price, int bonus, int residual) {
		super();
		this.type = type;
		this.crop = crop;
		this.animal = animal;
		this.setPurchasePrice(price);
		this.bonus = bonus;
		this.setResidualValue(residual);
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

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
