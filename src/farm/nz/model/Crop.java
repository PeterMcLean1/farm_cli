package farm.nz.model;

import farm.nz.type.CropType;

public class Crop {
	private CropType type;
	private int purchasePrice;
	private int salePrice;
	private int maturity;
	private int dayPlanted;
	private Paddock paddock;

	public Crop(CropType type, int purchasePrice, int salePrice, int maturity) {
		super();
		this.type = type;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.maturity = maturity;
	}

	public CropType getType() {
		return type;
	}

	public void setType(CropType type) {
		this.type = type;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
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
