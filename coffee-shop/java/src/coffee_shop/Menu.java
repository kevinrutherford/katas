package coffee_shop;

import java.util.HashMap;
import java.util.Map;

// Menu acts as a factory and cache for CoffeeFlavour flyweight objects
class Menu {
	private Map<String, CoffeeFlavour> flavours = new HashMap<String, CoffeeFlavour>();
	private final CoffeeShop coffeeShop;

	Menu(CoffeeShop coffeeShop) {
		this.coffeeShop = coffeeShop;
	}

	CoffeeFlavour lookup(String flavorName) {
		if (!flavours.containsKey(flavorName)) {
			flavours.put(flavorName, new CoffeeFlavour(flavorName));
			coffeeShop.newCoffeeFlavourMade(flavorName);
		}
		return flavours.get(flavorName);
	}

	int totalCoffeeFlavoursMade() {
		return flavours.size();
	}
}