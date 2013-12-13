package coffee_shop;

public class CoffeeShop {
	private Kitchen kitchen = new Kitchen(this);
	private final Menu menu = new Menu(this);
	private Audience audience = new Audience();

	public void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menu.lookup(flavourName);
		kitchen.takeOrder(table, flavour);
	}

	public void service() {
		kitchen.service();
	}

	public void addListener(CoffeeShopListener listener) {
		audience.add(listener);
	}

	void newCoffeeFlavourMade(String flavourName) {
		audience.newCoffeeFlavourMade(flavourName);
	}

	void orderServed(int tableNumber, String flavourName) {
		audience.orderServed(tableNumber, flavourName);
	}
}
