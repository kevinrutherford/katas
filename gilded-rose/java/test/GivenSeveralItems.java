import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GivenSeveralItems {

	private List<Item> items = new ArrayList<Item>();

	@Before
	public void setUp() throws Exception {
		items.add(new Item("NORMAL ITEM", 5, 10));
		items.add(new Item("Aged Brie", 3, 10));
	}

	@Test
	public void test() {
		GildedRose.updateQuality(items);

		assertEquals(9, items.get(0).quality);
		assertEquals(4, items.get(0).sellIn);
		assertEquals(11, items.get(1).quality);
		assertEquals(2, items.get(1).sellIn);
	}
}
