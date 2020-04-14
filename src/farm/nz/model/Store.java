package farm.nz.model;

import java.util.ArrayList;
import java.util.List;

import farm.nz.type.AnimalType;
import farm.nz.type.CropType;
import farm.nz.type.ItemType;

public class Store {
	private List<Crop> cropList = new ArrayList<Crop>();
	private List<Item> itemList = new ArrayList<Item>();
	private List<Animal> animalList = new ArrayList<Animal>();

	public Store() {
		// (CropType type, int purchasePrice, int salePrice, int maturity)
		cropList.add(new Crop(CropType.CORN, 5, 20, 2));
		cropList.add(new Crop(CropType.TOMATO, 4, 13, 3));
		cropList.add(new Crop(CropType.BEET, 6, 12, 1));
		cropList.add(new Crop(CropType.PUMPKIN, 3, 30, 4));
		cropList.add(new Crop(CropType.WHEAT, 1, 4, 1));
		cropList.add(new Crop(CropType.PEA, 2, 6, 2));
		// (ItemType type, boolean crop, boolean animal, int price, int bonus, int
		// residual)
		itemList.add(new Item(ItemType.FERTILIZER, true, false, 5, 2, 5));
		itemList.add(new Item(ItemType.SPRAY, true, false, 3, 1, 3));
		itemList.add(new Item(ItemType.TRAINING, false, false, 10, 5, 0));
		itemList.add(new Item(ItemType.FOOD, false, true, 1, 1, 1));
		itemList.add(new Item(ItemType.VITAMINS, false, true, 2, 3, 1));
		itemList.add(new Item(ItemType.WORMER, false, true, 3, 5, 2));
		// (AnimalType type, int happy, int health, int purchasePrice, int dailyIncome,
		// int residual)
		animalList.add(new Animal(AnimalType.CHICKEN, 1, 5, 10, 2, 10));
		animalList.add(new Animal(AnimalType.SHEEP, 1, 5, 20, 5, 20));
		animalList.add(new Animal(AnimalType.COW, 1, 5, 30, 8, 30));

	}

	public List<Crop> getCropList() {
		return cropList;
	}

	public void setCropList(List<Crop> cropList) {
		this.cropList = cropList;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

}
