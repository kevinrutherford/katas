package coffee_shop;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
	private List<Order> orders = new ArrayList<Order>();

	void service(CoffeeShopListener listener) {
		for (Order order : orders)
			order.serve(listener);
	}

	public void takeOrder(int table, CoffeeFlavour flavour) {
		Order order = new Order(table, flavour);
		orders.add(order);
	}
}