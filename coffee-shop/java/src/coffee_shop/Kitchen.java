package coffee_shop;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
	private List<Order> orders = new ArrayList<Order>();
	private final CoffeeShop coffeeShop;

	Kitchen(CoffeeShop coffeeShop) {
		this.coffeeShop = coffeeShop;
	}

	void service() {
		for (Order order : orders)
			order.serve();
	}

	public void takeOrder(int table, CoffeeFlavour flavour) {
		Order order = new Order(table, flavour, coffeeShop);
		orders.add(order);
	}
}