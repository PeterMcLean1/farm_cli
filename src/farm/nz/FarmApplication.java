package farm.nz;

import farm.nz.model.Farm;
import farm.nz.model.Farmer;
import farm.nz.model.Game;
import farm.nz.util.GameUtil;
import farm.nz.util.SetupUtil;

public class FarmApplication {

	public static void main(String[] args) {
		Farmer farmer = new Farmer();
		Farm farm = new Farm(farmer);
		Game game = new Game(farm);

		// set game length [2.1]
		SetupUtil.setGameDays(game);

		// create farmer (player) [2.2.1]
		SetupUtil.setName(farmer);
		SetupUtil.setAge(farmer);

		// create farm
		SetupUtil.setFarmType(farm); // [2.2.2 ab]
		SetupUtil.setFarmName(farm); // [2.3]

		GameUtil.setupEnvironment(game);
		GameUtil.startInfo(game);
		GameUtil.mainScreen(game);
	}

}
