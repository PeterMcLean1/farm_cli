package farm.nz.model;

import farm.nz.type.CropType;

public class Crop extends StoreItem {
	private CropType type;
	private int salePrice;
	private int maturity;// days it takes from plant to harvest
	private int dayPlanted;// day planted
	private Paddock paddock;

	public Crop(CropType type, int purchasePrice, int salePrice, int maturity, int residual) {
		super();
		this.type = type;
		this.setPurchasePrice(purchasePrice);
		this.salePrice = salePrice;
		this.maturity = maturity;
		this.setResidualValue(residual);
	}

	public boolean isMature(Game game) {
		return ((dayPlanted + maturity) <= game.getCurrentDay());

	}

	public CropType getType() {
		return type;
	}

	public void setType(CropType type) {
		this.type = type;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getMaturity() {
		return maturity;
	}

	public void setMaturity(int maturity) {
		this.maturity = maturity;
	}

	public Paddock getPaddock() {
		return paddock;
	}

	public int getDayPlanted() {
		return dayPlanted;
	}

	public void setDayPlanted(int dayPlanted) {
		this.dayPlanted = dayPlanted;
	}

	public void setPaddock(Paddock paddock) {
		this.paddock = paddock;
	}

}
