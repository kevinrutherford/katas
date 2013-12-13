package coffee_shop;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
	private final List<Order> orders = new ArrayList<Order>();
	private final Menu menu = new Menu();
	private CoffeeShopListener listener;

	public void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menu.lookup(flavourName);
		Order order = new Order(table, flavour);
		orders.add(order);
	}
	
	public void service() {
		for (Order order : orders)
			order.serve(listener);
	}

	public int numberOfFlavoursMade() {
		return menu.totalCoffeeFlavoursMade();
	}

	public void addListener(CoffeeShopListener listener) {
		this.listener = listener;
	}
}
