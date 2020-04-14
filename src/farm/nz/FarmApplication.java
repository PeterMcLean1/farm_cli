package farm.nz;

import farm.nz.model.Farm;
import farm.nz.model.Farmer;
import farm.nz.util.FarmUtil;

public class FarmApplication {

	public static void main(String[] args) {
		// create farmer (player)
		Farmer farmer = new Farmer();
		FarmUtil.setName(farmer);
		FarmUtil.setAge(farmer);
		// create farm
		Farm farm = new Farm();
		FarmUtil.setFarmName(farm);
		FarmUtil.setFarmType(farm);
		FarmUtil.setFarmDays(farm);
	}

}
