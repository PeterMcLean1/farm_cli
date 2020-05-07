package farm.nz.model;

import farm.nz.type.CropType;

public class Crop extends StoreItem {
	private int dayPlanted;// day planted
	private int maturity;// days from planting to harvest
	private Paddock paddock;
	private int salePrice;
	private CropType type;

	public Crop() {

	}

	public Crop(CropType type, int price, int salePrice, int maturity, int residual) {
		super(price, residual);
		this.type = type;
		this.salePrice = salePrice;
		this.maturity = maturity;
	}

	public int getDayPlanted() {
		return dayPlanted;
	}

	public int getMaturity() {
		return maturity;
	}

	public Paddock getPaddock() {
		return paddock;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public CropType getType() {
		return type;
	}

	public boolean isMature(Game game) {
		return ((dayPlanted + maturity) <= game.getCurrentDay());

	}

	public void setDayPlanted(int dayPlanted) {
		this.dayPlanted = dayPlanted;
	}

	public void setMaturity(int maturity) {
		this.maturity = maturity;
	}

	public void setPaddock(Paddock paddock) {
		this.paddock = paddock;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public void setType(CropType type) {
		this.type = type;
	}

}
