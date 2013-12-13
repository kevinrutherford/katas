package coffee_shop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoffeeShopTest implements CoffeeShopListener {

	private int flavoursMade = 0;
	private CoffeeShop shop;
	private String serviceReport = "";
	
	@Before
	public void setUp() {
		shop = new CoffeeShop();
		shop.addListener(this);
	}

	@Test
	public void coffeeFlavourConstructionIsReported() {
		shop.takeOrder("Cappuccino", 97);
		assertEquals(1, flavoursMade);
	}

	@Test
	public void ordersServedAreReported() {
		shop.takeOrder("Cappuccino", 97);
		shop.service();
		assertEquals("[97, Cappuccino]", serviceReport);
	}

	@Test
	public void coffeeFlavoursAreReused() {
		shop.takeOrder("Cappuccino", 2);
		shop.takeOrder("Cappuccino", 97);
		assertEquals(1, flavoursMade);
	}

	@Test
	public void ordersAreServedInOrder() {
		shop.takeOrder("Cappuccino", 2);
		shop.takeOrder("Mocha", 97);
		shop.service();
		assertEquals("[2, Cappuccino][97, Mocha]", serviceReport);
	}

	@Override
	public void orderServed(int tableNumber, String flavour) {
		serviceReport += "[" + tableNumber + ", " + flavour + "]";
	}

	@Override
	public void newCoffeeFlavourMade(String flavorName) {
		flavoursMade++;
	}

}
