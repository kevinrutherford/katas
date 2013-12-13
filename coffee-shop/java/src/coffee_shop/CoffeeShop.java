package coffee_shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Instances of CoffeeFlavour will be the Flyweights
class CoffeeFlavour {
	private final String name;

	CoffeeFlavour(String newFlavor) {
		this.name = newFlavor;
	}

	@Override
	public String toString() {
		return name;
	}
}

// Menu acts as a factory and cache for CoffeeFlavour flyweight objects
class Menu {
	private Map<String, CoffeeFlavour> flavours = new HashMap<String, CoffeeFlavour>();

	CoffeeFlavour lookup(String flavorName) {
		if (!flavours.containsKey(flavorName))
			flavours.put(flavorName, new CoffeeFlavour(flavorName));
		return flavours.get(flavorName);
	}

	int totalCoffeeFlavoursMade() {
		return flavours.size();
	}
}

class Order {
	private final int tableNumber;
	private final CoffeeFlavour flavour;

	Order(int tableNumber, CoffeeFlavour flavor) {
		this.tableNumber = tableNumber;
		this.flavour = flavor;
	}

	void serve() {
		System.out.println("Serving " + flavour + " to table " + tableNumber);
	}
}

public class CoffeeShop {
	private final List<Order> orders = new ArrayList<Order>();
	private final Menu menu = new Menu();

	public void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menu.lookup(flavourName);
		Order order = new Order(table, flavour);
		orders.add(order);
	}
	
	public void service() {
		for (Order order : orders)
			order.serve();		
	}
	
	public String report() {
		return "\ntotal CoffeeFlavour objects made: "
				+ menu.totalCoffeeFlavoursMade();
	}

	public int numberOfFlavoursMade() {
		return menu.totalCoffeeFlavoursMade();
	}
}
