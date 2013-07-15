import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GivenANormalItem {

	static String NORMAL_ITEM = "NORMAL ITEM";
	
	private Item updateFrom(int initialSellIn, int initialQuality) {
		Item item = new Item(NORMAL_ITEM, initialSellIn, initialQuality);
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		GildedRose.updateQuality(items);
		return item;
	}

	@Test
	public void beforeSellDate() {
		Item item = updateFrom(5, 10);
		assertTrue(item.quality == 9);
		assertTrue(item.sellIn == 4);
	}

	@Test
	public void onSellDate() {
		Item item = updateFrom(0, 10);
		assertTrue(item.quality == 8);
		assertTrue(item.sellIn == -1);
	}

	@Test
	public void afterSellDate() {
		Item item = updateFrom(-10, 10);
		assertTrue(item.quality == 8);
		assertTrue(item.sellIn == -11);
	}

	@Test
	public void ofZeroQuality() {
		Item item = updateFrom(5, 0);
		assertTrue(item.quality == 0);
	}
}
