package com.gildedrose;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.stream.Collectors.toList;

class GildedRose {

	static final String AGED_BRIE = "Aged Brie";
	static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

	static final int MAX_QUALITY = 50;
	static final int MIN_QUALITY = 0;
	static final int EXPIRED = 0;
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {

		List<Item> nonSulfuras = Arrays.stream(items).filter(item -> !SULFURAS.equals(item.name)).collect(toList());

		nonSulfuras.stream()
				.filter(item -> AGED_BRIE.equals(item.name))
				.peek(this::increaseQualityForBrie)
				.forEach(this::decreaseSellIn);

		nonSulfuras.stream()
				.filter(item -> BACKSTAGE.equals(item.name))
				.peek(this::increaseQualityForBackstage)
				.forEach(this::decreaseSellIn);

		nonSulfuras.stream()
				.filter(item -> !AGED_BRIE.equals(item.name) && !BACKSTAGE.equals(item.name))
				.peek(this::decreaseQuality)
				.forEach(this::decreaseSellIn);
	}

	private void increaseQualityForBrie(Item item) {
		int increase = 1;
		if (item.sellIn <= EXPIRED) {
			increase++;
		}
		item.quality = min(item.quality + increase, MAX_QUALITY);
	}

	private void increaseQualityForBackstage(Item item) {
		int increase = 1;
		if (item.sellIn <= 10) {
			increase = 2;
		}
		if (item.sellIn <= 5) {
			increase = 3;
		}
		if (item.sellIn == 0) {
			increase = item.quality * -1;
		}
		item.quality = min(item.quality + increase, MAX_QUALITY);
	}

	private void decreaseQuality(Item item) {
		int decrease = 1;
		if (item.sellIn <= EXPIRED) {
			decrease++;
		}
		item.quality = max(item.quality - decrease, MIN_QUALITY);
	}

	private void decreaseSellIn(Item item) {
		item.sellIn--;
	}
}
