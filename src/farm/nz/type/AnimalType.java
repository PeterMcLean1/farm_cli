package farm.nz.type;

public enum AnimalType {
	CHICKEN("Chicken"), SHEEP("Sheep"), COW("Cow");

	private final String description;

	AnimalType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
