package coffee_shop;

import static org.junit.Assert.*;
import org.junit.Test;

public class CoffeeShopTest implements CoffeeShopListener {

	private int flavoursMade = 0;

	@Test
	public void coffeeFlavoursAreReused() {
		CoffeeShop shop = new CoffeeShop();
		shop.addListener(this);
		shop.takeOrder("Cappuccino", 2);
		shop.takeOrder("Cappuccino", 97);
		assertEquals(1, flavoursMade);
	}

	@Override
	public void orderServed(int tableNumber, String flavour) { }

	@Override
	public void newCoffeeFlavourMade(String flavorName) {
		flavoursMade++;
	}

}
