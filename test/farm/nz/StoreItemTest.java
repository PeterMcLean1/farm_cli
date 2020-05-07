package farm.nz;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import farm.nz.model.StoreItem;


public class StoreItemTest {
	
	@Test
	void storeItemConstructorTest() {

		StoreItem storeItem = new StoreItem(3,5);
		
		assertTrue(storeItem.getPurchasePrice() == 3);
		assertTrue(storeItem.getResidualValue() == 5);
	

	}
	
	@Test
	void storeItemSetGetTest() {

		StoreItem storeItem = new StoreItem();
		
		storeItem.setPurchasePrice(3);
		storeItem.setResidualValue(5);
		
		assertTrue(storeItem.getPurchasePrice() == 3);
		assertTrue(storeItem.getResidualValue() == 5);
	

	}

}
