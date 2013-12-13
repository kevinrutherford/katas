package coffee_shop;

public class CoffeeShop {
	private Kitchen kitchen = new Kitchen(this);
	private final Menu menu = new Menu(this);
	private CoffeeShopListener listener;

	public void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menu.lookup(flavourName);
		kitchen.takeOrder(table, flavour);
	}

	public void service() {
		kitchen.service();
	}

	public void addListener(CoffeeShopListener listener) {
		this.listener = listener;
	}

	void newCoffeeFlavourMade(String flavourName) {
		if (listener != null)
			listener.newCoffeeFlavourMade(flavourName);
	}

	void orderServed(int tableNumber, String flavourName) {
		if (listener != null)
			listener.orderServed(tableNumber, flavourName);
	}
}
