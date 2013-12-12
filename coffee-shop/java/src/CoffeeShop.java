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

class CoffeeShop {
	private final List<Order> orders = new ArrayList<Order>();
	private final Menu menu = new Menu();

	void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menu.lookup(flavourName);
		Order order = new Order(table, flavour);
		orders.add(order);
	}
	
	void service() {
		for (Order order : orders)
			order.serve();		
	}
	
	String report() {
		return "\ntotal CoffeeFlavour objects made: "
				+ menu.totalCoffeeFlavoursMade();
	}

	public static void main(String[] args) {
		CoffeeShop shop = new CoffeeShop();

		shop.takeOrder("Cappuccino", 2);
		shop.takeOrder("Frappe", 1);
		shop.takeOrder("Espresso", 1);
		shop.takeOrder("Frappe", 897);
		shop.takeOrder("Cappuccino", 97);
		shop.takeOrder("Frappe", 3);
		shop.takeOrder("Espresso", 3);
		shop.takeOrder("Cappuccino", 3);
		shop.takeOrder("Espresso", 96);
		shop.takeOrder("Frappe", 552);
		shop.takeOrder("Cappuccino", 121);
		shop.takeOrder("Espresso", 121);

		shop.service();
		System.out.println(shop.report());
	}
}
