import java.io.PrintStream;

import coffee_shop.CoffeeShopListener;

public class ShopReport implements CoffeeShopListener {
	private StringBuffer log = new StringBuffer();
	private int flavours = 0;

	@Override
	public void orderServed(int tableNumber, String flavour) {
		String message = "Serving " + flavour + " to table " + tableNumber + "\n";
		log.append(message);
	}
	
	void reportOn(PrintStream out) {
		out.print(log);
		out.println("\ntotal CoffeeFlavour objects made: " + flavours);
	}

	@Override
	public void newCoffeeFlavourMade(String flavorName) {
		flavours++;
	}

}
