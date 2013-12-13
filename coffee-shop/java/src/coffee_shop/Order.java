package coffee_shop;

class Order {
	private final int tableNumber;
	private final CoffeeFlavour flavour;
	private final CoffeeShop coffeeShop;

	Order(int tableNumber, CoffeeFlavour flavor, CoffeeShop coffeeShop) {
		this.tableNumber = tableNumber;
		this.flavour = flavor;
		this.coffeeShop = coffeeShop;
	}

	void serve() {
		coffeeShop.orderServed(tableNumber, flavour.toString());
	}
}