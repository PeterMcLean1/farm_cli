package farm.nz.model;

import java.util.ArrayList;
import java.util.List;

import farm.nz.type.FarmType;

public class Farm {
	private String name;
	private int account;
	private int maintenance;
	private FarmType type;
	private int days;
	private List<Paddock> paddocks = new ArrayList<Paddock>();

	public List<Paddock> getPaddocks() {
		return paddocks;
	}

	public void setPaddocks(List<Paddock> paddocks) {
		this.paddocks = paddocks;
	}

	public void addPaddock(Paddock paddock) {
		this.paddocks.add(paddock);
	}

	public void removePaddock(Paddock paddock) {
		if (paddocks.contains(paddock)) {
			paddocks.remove(paddock);
		}
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Farm() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(int maintenance) {
		this.maintenance = maintenance;
	}

	public FarmType getType() {
		return type;
	}

	public void setType(FarmType type) {
		this.type = type;
	}

}
