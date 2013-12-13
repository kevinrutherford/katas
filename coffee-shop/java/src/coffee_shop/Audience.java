package coffee_shop;

import java.util.ArrayList;
import java.util.List;

public class Audience implements CoffeeShopListener {
	public List<CoffeeShopListener> listeners = new ArrayList<CoffeeShopListener>();

	void add(CoffeeShopListener listener) {
		listeners.add(listener);
	}

	@Override
	public void orderServed(int tableNumber, String flavourName) {
		for (CoffeeShopListener listener : listeners)
			listener.orderServed(tableNumber, flavourName);
	}

	@Override
	public void newCoffeeFlavourMade(String flavourName) {
		for (CoffeeShopListener listener : listeners)
			listener.newCoffeeFlavourMade(flavourName);
	}

}