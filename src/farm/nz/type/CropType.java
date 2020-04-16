package farm.nz.type;

public enum CropType {
	CORN("Corn"), TOMATO("Tomato"), BEET("Fodder Beet"), PUMPKIN("Pumpkin"), WHEAT("Wheat"), PEA("Peas");

	private final String description;

	CropType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
