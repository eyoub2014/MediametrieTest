package com.sparklingcup;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SparklingCupTest {
	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		SparklingCup app = new SparklingCup(items);
		app.updateQuality();
		assertEquals("foo", app.items[0].name);
	}
	
	@Test
	void testAgedBrie() {
	    Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
	    SparklingCup app = new SparklingCup(items);
	    app.updateQuality();
	    assertEquals("Aged Brie", app.items[0].name);
	    assertEquals(9, app.items[0].sellIn);
	    assertEquals(21, app.items[0].quality);
	}
	/**
	 * Teste la mise à jour de la qualité et de la date de péremption d'un article de type "Conjured"
	 * avec une date de péremption de 3 jours et une qualité de 6.
	 */
	@Test
	void testConjuredItem() {
	    Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
	    SparklingCup app = new SparklingCup(items);
	    app.updateQuality();
	    assertEquals("Conjured Mana Cake", app.items[0].name);
	    assertEquals(2, app.items[0].sellIn);
	    assertEquals(4, app.items[0].quality);
	}

}