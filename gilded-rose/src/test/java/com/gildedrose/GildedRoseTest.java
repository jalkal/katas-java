package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private final String REGULAR = "foo";
    private final String AGED_BRIE = "Aged Brie";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    private final int MAX_QUALITY = 50;
    private final int MIN_QUALITY = 0;
    private final int EXPIRED = 0;

    GildedRose testSubject;

    @Test
    public void updateQuality_nameDoesNotChange() {
        //Given
        testSubject = aGilderRose(REGULAR, 5, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(REGULAR, testSubject.items[0].name);
    }

    @Test
    public void updateQuality_regularProduct_sellInDecreaseOne() {
        //Given
        testSubject = aGilderRose(REGULAR, 5, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(4, testSubject.items[0].sellIn);
    }

    @Test
    public void updateQuality_regularProduct_qualityDecreaseOne() {
        //Given
        testSubject = aGilderRose(REGULAR, 5, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(4, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_regularProductExpired_qualityDecreaseTwice() {
        //Given
        testSubject = aGilderRose(REGULAR, EXPIRED, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(3, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_regularProductZeroQuality_qualityDoesNotNegative() {
        //Given
        testSubject = aGilderRose(REGULAR, 1, MIN_QUALITY);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(MIN_QUALITY, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_regularProductExpired_qualityDoesNotNegative() {
        //Given
        testSubject = aGilderRose(REGULAR, EXPIRED, 1);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(MIN_QUALITY, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrie_qualityIncreaseOnce() {
        //Given
        testSubject = aGilderRose(AGED_BRIE, 5, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(6, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieExpired_qualityIncreaseTwice() {
        //Given
        testSubject = aGilderRose(AGED_BRIE, EXPIRED, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(7, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieFiftyQuality_maxQualityFifty() {
        //Given
        testSubject = aGilderRose(AGED_BRIE, 5, MAX_QUALITY);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(MAX_QUALITY, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieExpiredFortyNineQuality_maxQualityFifty() {
        //Given
        testSubject = aGilderRose(AGED_BRIE, EXPIRED, 49);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(MAX_QUALITY, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasProduct_qualityDoesNotChange() {
        //Given
        testSubject = aGilderRose(SULFURAS, 5, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(5, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasProduct_sellInDoesNotChange() {
        //Given
        testSubject = aGilderRose(SULFURAS, 5, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(5, testSubject.items[0].sellIn);
    }

    @Test
    public void updateQuality_backstageWithElevenDays_qualityIncreaseOne() {
        //Given
        testSubject = aGilderRose(BACKSTAGE, 11, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(6, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_backstageWithTenDays_qualityIncreaseTwo() {
        //Given
        testSubject = aGilderRose(BACKSTAGE, 10, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(7, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_backstageWithSixDays_qualityIncreaseTwo() {
        //Given
        testSubject = aGilderRose(BACKSTAGE, 6, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(7, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_backstageWithFiveDays_qualityIncreaseThree() {
        //Given
        testSubject = aGilderRose(BACKSTAGE, 5, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(8, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_backstageWithOneDay_qualityIncreaseThree() {
        //Given
        testSubject = aGilderRose(BACKSTAGE, 1, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(8, testSubject.items[0].quality);
    }

    @Test
    public void updateQuality_backstageExpired_qualityChangeToZero() {
        //Given
        testSubject = aGilderRose(BACKSTAGE, EXPIRED, 5);
        //When
        testSubject.updateQuality();
        //Then
        assertEquals(MIN_QUALITY, testSubject.items[0].quality);
    }

    private GildedRose aGilderRose(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        return new GildedRose(items);
    }
}
