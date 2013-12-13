package coffee_shop;

public class CoffeeShop {
	private Kitchen kitchen = new Kitchen();
	private final Menu menu = new Menu();
	private CoffeeShopListener listener;

	public void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menu.lookup(flavourName, listener);
		kitchen.takeOrder(table, flavour);
	}
	
	public void service() {
		kitchen.service(listener);
	}

	public void addListener(CoffeeShopListener listener) {
		this.listener = listener;
	}
}
