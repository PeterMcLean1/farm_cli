package farm.nz;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import farm.nz.model.Item;
import farm.nz.type.ItemType;

public class ItemModelTest {
	
//	public Item(ItemType type, boolean crop, boolean animal, boolean skill, int price, int bonus, int residual) {
//		super(price, residual);
//		this.type = type;
//		this.crop = crop;
//		this.animal = animal;
//		this.skill = skill;
//		this.bonus = bonus;
	
	@Test
	void itemConstructorTest() {

		Item item = new Item(ItemType.FERTILIZER, true, false, false, 5, 3, 5);
		
		assertTrue(item.getBonus() == 3);
		assertTrue(item.getPurchasePrice() == 5);
		assertTrue(item.getResidualValue() == 5);
		assertTrue(item.getType() == ItemType.FERTILIZER);
		assertTrue(item.isAnimal() == false);
		assertTrue(item.isCrop() == true);
		assertTrue(item.isSkill() == false);

	}
	
	@Test
	void itemSetGetTest() {
		
		Item item = new Item();
		
		item.setBonus(13);
		item.setPurchasePrice(15);
		item.setResidualValue(9);
		item.setType(ItemType.SPRAY);
		item.setAnimal(false);
		item.setCrop(true);
		item.setSkill(true);
		
		assertTrue(item.getBonus() == 13);
		assertTrue(item.getPurchasePrice() == 15);
		assertTrue(item.getResidualValue() == 9);
		assertTrue(item.getType() == ItemType.SPRAY);
		assertTrue(item.isAnimal() == false);
		assertTrue(item.isCrop() == true);
		assertTrue(item.isSkill() == true);
		

	}

}
