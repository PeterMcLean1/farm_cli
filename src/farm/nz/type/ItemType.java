package farm.nz.type;

public enum ItemType {
	FERTILIZER("Fertiliser"), SPRAY("Weed Spray"), TRAINING("Skill Training"), FOOD("Animal Food"),
	VITAMINS("Animal Vitamins"), WORMER("Animal Wormer");

	private final String description;

	ItemType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
