package farm.nz;

import farm.nz.model.Farm;
import farm.nz.model.Farmer;
import farm.nz.model.Game;
import farm.nz.service.GameService;
import farm.nz.service.SetupService;

public class FarmApplication {

	public static void main(String[] args) {
		Farmer farmer = new Farmer();
		Farm farm = new Farm(farmer);
		Game game = new Game(farm);

		// set game length [2.1]
		SetupService.setGameDays(game);

		// create farmer (player) [2.2.1]
		SetupService.setName(farmer);
		SetupService.setAge(farmer);

		// create farm
		SetupService.setFarmType(farm); // [2.2.2 ab]
		SetupService.setFarmName(farm); // [2.3]

		GameService.setupEnvironment(game);
		GameService.startInfo(game);
		GameService.mainScreen(game);
	}

}
