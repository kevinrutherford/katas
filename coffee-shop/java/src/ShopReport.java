import coffee_shop.CoffeeShopListener;

public class ShopReport implements CoffeeShopListener {

	@Override
	public void orderServed(int tableNumber, String flavour) {
		System.out.println("Serving " + flavour + " to table " + tableNumber);
	}

}
