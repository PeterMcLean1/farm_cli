package farm.nz.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Paddock {
	private static final AtomicInteger count = new AtomicInteger(0);
	private final int paddockID;
	private Farm farm;
	private Crop crop;

	public Paddock(Farm farm) {
		this.farm = farm;
		this.paddockID = count.incrementAndGet(); // give the paddock a unique incremental ID
		farm.addPaddock(this);
	}

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public boolean hasCrop() {
		return (null != crop);
	}

	public int getPaddockID() {
		return paddockID;
	}

}
