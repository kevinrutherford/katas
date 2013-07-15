import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GivenAgedBrie {

	static String AGED_BRIE = "Aged Brie";
	
	private Item updateFrom(int initialSellIn, int initialQuality) {
		Item item = new Item(AGED_BRIE, initialSellIn, initialQuality);
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		GildedRose.updateQuality(items);
		return item;
	}

	@Test
	public void beforeSellDate() {
		Item item = updateFrom(5, 10);
		assertTrue(item.quality == 11);
		assertTrue(item.sellIn == 4);
	}
	
	@Test
	public void beforeSellDateWithMaxQuality() {
		Item item = updateFrom(5, 50);
		assertTrue(item.quality == 50);
		assertTrue(item.sellIn == 4);
	}

	@Test
	public void onSellDate() {
		Item item = updateFrom(0, 10);
		assertTrue(item.quality == 12);
		assertTrue(item.sellIn == -1);
	}

	@Test
	public void onSellDateWithMaxQuality() {
		Item item = updateFrom(0, 50);
		assertTrue(item.quality == 50);
		assertTrue(item.sellIn == -1);
	}

	@Test
	public void afterSellDate() {
		Item item = updateFrom(-10, 10);
		assertTrue(item.quality == 12);
		assertTrue(item.sellIn == -11);
	}

	@Test
	public void afterSellDateWithMaxQuality() {
		Item item = updateFrom(-10, 50);
		assertTrue(item.quality == 50);
		assertTrue(item.sellIn == -11);
	}

}
