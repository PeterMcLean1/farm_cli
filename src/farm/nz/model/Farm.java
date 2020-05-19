package farm.nz.model;

import java.util.ArrayList;
import java.util.List;

import farm.nz.type.FarmType;

public class Farm {
	private List<Animal> animals = new ArrayList<Animal>();
	private Farmer farmer;
	private List<Item> items = new ArrayList<Item>();
	private int maintenance;
	private String name;
	private List<Paddock> paddocks = new ArrayList<Paddock>();
	private FarmType type;

	public Farm() {

	}

	public Farm(Farmer farmer) {
		this.farmer = farmer;

	}

	public void addAnimal(Animal animal) {
		this.animals.add(animal);
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void addPaddock(Paddock paddock) {
		this.paddocks.add(paddock);
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public List<Item> getItems() {
		return items;
	}

	public int getMaintenance() {
		return maintenance;
	}

	public String getName() {
		return name;
	}

	public List<Paddock> getPaddocks() {
		return paddocks;
	}

	public FarmType getType() {
		return type;
	}

	public void removeAnimal(Animal animal) {
		if (animals.contains(animal)) {
			animals.remove(animal);
		}
	}

	public void removeItem(Item item) {
		if (items.contains(item)) {
			items.remove(item);
		}
	}

	public void removePaddock(Paddock paddock) {
		if (paddocks.contains(paddock)) {
			paddocks.remove(paddock);
		}
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setMaintenance(int maintenance) {
		this.maintenance = maintenance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPaddocks(List<Paddock> paddocks) {
		this.paddocks = paddocks;
	}

	public void setType(FarmType type) {
		this.type = type;
	}

}
