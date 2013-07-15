import static org.junit.Assert.assertEquals;

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
		assertEquals(8, item.quality);
		assertEquals(4, item.sellIn);
	}

	@Test
	public void beforeSellDateAtZeroQuality() {
		Item item = updateFrom(5, 0);
		assertEquals(0, item.quality);
		assertEquals(4, item.sellIn);
	}

	@Test
	public void onSellDate() {
		Item item = updateFrom(0, 10);
		assertEquals(6, item.quality);
		assertEquals(-1, item.sellIn);
	}

	@Test
	public void onSellDateAtZeroQuality() {
		Item item = updateFrom(0, 0);
		assertEquals(0, item.quality);
		assertEquals(-1, item.sellIn);
	}

	@Test
	public void afterSellDate() {
		Item item = updateFrom(-10, 10);
		assertEquals(6, item.quality);
		assertEquals(-11, item.sellIn);
	}

	@Test
	public void afterSellDateAtZeroQuality() {
		Item item = updateFrom(-10, 0);
		assertEquals(0, item.quality);
		assertEquals(-11, item.sellIn);
	}

}
