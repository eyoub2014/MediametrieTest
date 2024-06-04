package com.sparklingcup;

public class SparklingCup {
	private static final int MAX_QUALITY = 50;

	Item[] items;

	public SparklingCup(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : this.items) {
			switch (Item.getItemType(item.name)) {
			case "aged brie":
				item.quality = Math.min(MAX_QUALITY, item.quality + 1);
				break;
			case "backstage pass":
				int qualityIncrement = 0;
				if (item.sellIn <= 5) {
					qualityIncrement = 3;
				} else if (item.sellIn <= 10) {
					qualityIncrement = 2;
				} else {
					qualityIncrement = 1;
				}
				item.quality = Math.min(MAX_QUALITY, item.quality + qualityIncrement);
				break;
			case "sulfuras":
				// La qualité de Sulfuras ne change jamais
				break;
			case "conjured":
				item.quality = Math.max(0, item.quality - 2);
				break;
			default:
				item.quality = Math.max(0, item.quality - 1);
				break;
			}
			item.sellIn = item.sellIn - 1;
			if (item.sellIn < 0) {
				switch (Item.getItemType(item.name)) {
				case "aged brie":
					item.quality = Math.min(MAX_QUALITY, item.quality + 1);
					break;
				case "backstage pass":
					item.quality = 0;
					break;
				case "sulfuras":
					// La qualité de Sulfuras ne change jamais
					break;
				case "conjured":
					item.quality = Math.max(0, item.quality - 2);
					break;
				default:
					item.quality = Math.max(0, item.quality - 1);
					break;
				}
			}
		}
	}

}
