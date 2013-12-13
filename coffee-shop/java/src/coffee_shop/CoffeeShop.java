package coffee_shop;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
	private Kitchen kitchen = new Kitchen(this);
	private final Menu menu = new Menu(this);
	private List<CoffeeShopListener> listeners = new ArrayList<CoffeeShopListener>();

	public void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menu.lookup(flavourName);
		kitchen.takeOrder(table, flavour);
	}

	public void service() {
		kitchen.service();
	}

	public void addListener(CoffeeShopListener listener) {
		listeners.add(listener);
	}

	void newCoffeeFlavourMade(String flavourName) {
		for (CoffeeShopListener listener : listeners)
			listener.newCoffeeFlavourMade(flavourName);
	}

	void orderServed(int tableNumber, String flavourName) {
		for (CoffeeShopListener listener : listeners)
			listener.orderServed(tableNumber, flavourName);
	}
}
