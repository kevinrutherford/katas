import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GivenAConjuredItem {

	static String CONJURED_ITEM = "Conjured Mana Cake";

	private Item updateFrom(int initialSellIn, int initialQuality) {
		Item item = new Item(CONJURED_ITEM, initialSellIn, initialQuality);
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		GildedRose.updateQuality(items);
		return item;
	}

	@Test
	public void beforeSellDate() {
		Item item = updateFrom(5, 10);
		assertTrue(item.quality == 8);
		assertTrue(item.sellIn == 4);
	}

	@Test
	public void beforeSellDateAtZeroQuality() {
		Item item = updateFrom(5, 0);
		assertTrue(item.quality == 0);
		assertTrue(item.sellIn == 4);
	}

	@Test
	public void onSellDate() {
		Item item = updateFrom(0, 10);
		assertTrue(item.quality == 6);
		assertTrue(item.sellIn == -1);
	}

	@Test
	public void onSellDateAtZeroQuality() {
		Item item = updateFrom(0, 0);
		assertTrue(item.quality == 0);
		assertTrue(item.sellIn == -1);
	}

	@Test
	public void afterSellDate() {
		Item item = updateFrom(-10, 10);
		assertTrue(item.quality == 6);
		assertTrue(item.sellIn == -11);
	}

	@Test
	public void afterSellDateAtZeroQuality() {
		Item item = updateFrom(-10, 0);
		assertTrue(item.quality == 0);
		assertTrue(item.sellIn == -11);
	}

}
