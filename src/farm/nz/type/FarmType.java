package farm.nz.type;

public enum FarmType {
	FLAT(1, 1, 5, "Flat land"), HILL(2, 2, 8, "Hill country"), RIVER(3, 3, 6, "River"), FOREST(4, 4, 10, "Forest");

	private final double eventChance;
	private final int upkeep;
	private final int maxPaddocks;
	private final String description;

	FarmType(double eventChance, int upkeep, int maxPaddocks, String description) {
		this.eventChance = eventChance;
		this.upkeep = upkeep;
		this.maxPaddocks = maxPaddocks;
		this.description = description;

	}

	public double getEventChance() {
		return eventChance;
	}

	public int getUpkeep() {
		return upkeep;
	}

	public int getMaxPaddocks() {
		return maxPaddocks;
	}

	public String getDescription() {
		return description;
	}

}
