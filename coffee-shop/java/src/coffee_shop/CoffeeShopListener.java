package coffee_shop;

public interface CoffeeShopListener {
	void orderServed(int tableNumber, String flavour);
	void newCoffeeFlavourMade(String flavorName);
}
