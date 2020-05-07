package farm.nz.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Paddock {
	private static final AtomicInteger count = new AtomicInteger(0);
	private Crop crop;
	private final int paddockID;

	public Paddock() {
		this.paddockID = count.incrementAndGet(); // give the paddock a unique incremental ID
	}

	public Crop getCrop() {
		return crop;
	}

	public int getPaddockID() {
		return paddockID;
	}

	public boolean hasCrop() {
		return (null != crop);
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

}
