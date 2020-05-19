package farm.nz.model;

public class Game {

	private int account;
	private int actionCount = 0;
	private int currentDay = 1;
	private int daysToPlay;
	private Farm farm;
	private int maxDailyActions = 2;

	public Game() {

	}

	public Game(Farm farm) {
		this.farm = farm;
	}

	public int getAccount() {
		return account;
	}

	public int getActionCount() {
		return actionCount;
	}

	public int getCurrentDay() {
		return currentDay;
	}

	public int getDaysToPlay() {
		return daysToPlay;
	}

	public Farm getFarm() {
		return farm;
	}

	public int getMaxDailyActions() {
		return maxDailyActions;
	}

	/**
	 * Used to determine if the player has more daily actions
	 * 
	 * @return Does this player have more daily actions today
	 */
	public boolean hasActions() {
		return actionCount < maxDailyActions;
	}

	public void incrementActionCount() {
		this.actionCount++;
	}

	public void incrementCurrentDay() {
		this.currentDay++;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public void setActionCount(int actionCount) {
		this.actionCount = actionCount;
	}

	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}

	public void setDaysToPlay(int daysToPlay) {
		this.daysToPlay = daysToPlay;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	public void setMaxDailyActions(int maxDailyActions) {
		this.maxDailyActions = maxDailyActions;
	}

}
