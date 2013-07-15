import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GivenSulfuras {

	static String SULFURAS = "Sulfuras, Hand of Ragnaros";
	
	private Item updateFrom(int initialSellIn, int initialQuality) {
		Item item = new Item(SULFURAS, initialSellIn, initialQuality);
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		GildedRose.updateQuality(items);
		return item;
	}

	@Test
	public void beforeSellDate() {
		Item item = updateFrom(5, 80);
		assertTrue(item.quality == 80);
		assertTrue(item.sellIn == 5);
	}

	@Test
	public void onSellDate() {
		Item item = updateFrom(0, 80);
		assertTrue(item.quality == 80);
		assertTrue(item.sellIn == 0);
	}

	@Test
	public void afterSellDate() {
		Item item = updateFrom(-10, 80);
		assertTrue(item.quality == 80);
		assertTrue(item.sellIn == -10);
	}
}
