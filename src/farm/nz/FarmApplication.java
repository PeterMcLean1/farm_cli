package farm.nz;

import farm.nz.model.Farm;
import farm.nz.model.Farmer;
import farm.nz.model.GamePlay;
import farm.nz.util.GameUtil;

public class FarmApplication {

	public static void main(String[] args) {
		Farmer farmer = new Farmer();
		Farm farm = new Farm();
		farm.setFarmer(farmer);
		GamePlay game = new GamePlay(farm);

		// set game length [2.1]
		// GameUtil.setGameDays(game);

		// create farmer (player) [2.2.1]
		// FarmUtil.setName(farmer);
		// FarmUtil.setAge(farmer);

		// create farm
		// FarmUtil.setFarmType(farm); // [2.2.2 ab]
		// 4FarmUtil.setFarmName(farm); // [2.3]

		GameUtil.setupEnvironment(game);
		GameUtil.mainOptionScreen(game);
	}

}
