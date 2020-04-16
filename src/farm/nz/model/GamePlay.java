package farm.nz.model;

public class GamePlay {

	private int daysToPlay;
	private int currentDay = 1;
	private int actionCount = 2;
	private Farm farm;

	public void setActionCount() {
		this.actionCount = 2;
	}

	public GamePlay(Farm farm) {
		this.farm = farm;
	}

	public int getCurrentDay() {
		return currentDay;
	}

	public void incrementCurrentDay() {
		this.currentDay = currentDay++;
	}

	public int getDaysToPlay() {
		return daysToPlay;
	}

	public void setDaysToPlay(int daysToPlay) {
		this.daysToPlay = daysToPlay;
	}

	public int getActionCount() {
		return actionCount;
	}

	public void reduceActionCount() {
		this.actionCount--;
	}

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

}
