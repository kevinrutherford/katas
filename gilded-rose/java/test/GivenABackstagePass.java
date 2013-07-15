import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GivenABackstagePass {

	static String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
	
	private Item updateFrom(int initialSellIn, int initialQuality) {
		Item item = new Item(BACKSTAGE_PASS, initialSellIn, initialQuality);
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		GildedRose.updateQuality(items);
		return item;
	}

	@Test
	public void longBeforeSellDate() {
		Item item = updateFrom(11, 10);
		assertTrue(item.quality == 11);
		assertTrue(item.sellIn == 10);
	}

	@Test
	public void longBeforeSellDateAtMaxQuality() {
		Item item = updateFrom(11, 50);
		assertTrue(item.quality == 50);
		assertTrue(item.sellIn == 10);
	}

	@Test
	public void mediumCloseSellDateUpperBound() {
		Item item = updateFrom(10, 10);
		assertTrue(item.quality == 12);
		assertTrue(item.sellIn == 9);
	}

	@Test
	public void mediumCloseSellDateUpperBoundAtMaxQuality() {
		Item item = updateFrom(10, 50);
		assertTrue(item.quality == 50);
		assertTrue(item.sellIn == 9);
	}

	@Test
	public void mediumCloseSellDateLowerBound() {
		Item item = updateFrom(6, 10);
		assertTrue(item.quality == 12);
		assertTrue(item.sellIn == 5);
	}

	@Test
	public void mediumCloseSellDateLowerBoundAtMaxQuality() {
		Item item = updateFrom(6, 50);
		assertTrue(item.quality == 50);
		assertTrue(item.sellIn == 5);
	}

	@Test
	public void veryCloseToSellDateUpperBound() {
		Item item = updateFrom(5, 10);
		assertTrue(item.quality == 13);
		assertTrue(item.sellIn == 4);
	}

	@Test
	public void veryCloseToSellDateUpperBoundAtMaxQuality() {
		Item item = updateFrom(5, 50);
		assertTrue(item.quality == 50);
		assertTrue(item.sellIn == 4);
	}

	@Test
	public void veryCloseToSellDateLowerBound() {
		Item item = updateFrom(1, 10);
		assertTrue(item.quality == 13);
		assertTrue(item.sellIn == 0);
	}

	@Test
	public void veryCloseToSellDateLowerBoundAtMaxQuality() {
		Item item = updateFrom(1, 50);
		assertTrue(item.quality == 50);
		assertTrue(item.sellIn == 0);
	}

	@Test
	public void onSellDate() {
		Item item = updateFrom(0, 10);
		assertTrue(item.quality == 0);
		assertTrue(item.sellIn == -1);
	}

	@Test
	public void afterSellDate() {
		Item item = updateFrom(-10, 10);
		assertTrue(item.quality == 0);
		assertTrue(item.sellIn == -11);
	}

}
