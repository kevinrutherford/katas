package coffee_shop;

public interface CoffeeShopListener {
	void orderServed(int tableNumber, String flavourName);
	void newCoffeeFlavourMade(String flavourName);
}
