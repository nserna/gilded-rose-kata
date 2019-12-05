package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void normalItemTest() {
        Item[] items = new Item[] { new Item("foo", 1, 3),
                new Item("+5 Dexterity Vest", 10, 20) ,
                new Item("+5 Dexterity Vest", 10, 120) ,
                new Item("+5 Dexterity Vest", 10, -20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // checking - At the end of each day our system lowers both values for every item
        assertEquals(0, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
        assertEquals(9, app.items[1].sellIn);
        assertEquals(19, app.items[1].quality);
        assertEquals(9, app.items[2].sellIn);
        assertEquals(119, app.items[2].quality);
        assertEquals(9, app.items[3].sellIn);
        assertEquals(-20, app.items[3].quality);

        app.updateQuality();

        // checking -  Once the sell by date has passed, Quality degrades twice as fast
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals(8, app.items[1].sellIn);
        assertEquals(18, app.items[1].quality);

        app.updateQuality();

        // checking -  The Quality of an item is never negative
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals(7, app.items[1].sellIn);
        assertEquals(17, app.items[1].quality);
    }

    @Test
    public void agedBrieItemTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 1),
                new Item("Aged Brie", -1, 50),
                new Item("Aged Brie", -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // checking -  "Aged Brie" actually increases in Quality the older it gets
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);

        app.updateQuality();
        // checking -  Once the sell by date has passed, Quality degrades twice as fast
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);

        // checking -  The Quality of an item is never more than 50
        assertEquals("Aged Brie", app.items[1].name);
        assertEquals(-3, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);

    }

    @Test
    public void sulfurasItemTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", 15, -20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // checking - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);
        assertEquals(15, app.items[1].sellIn);
        assertEquals(-20, app.items[1].quality);

        app.updateQuality();

        // checking - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(15, app.items[1].sellIn);
        assertEquals(-20, app.items[1].quality);

    }


    @Test
    public void backstageItemTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 7, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // checking -  "Backstage passes" logic;
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
        assertEquals(6, app.items[1].sellIn);
        assertEquals(22, app.items[1].quality);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(23, app.items[2].quality);
        assertEquals(-1, app.items[3].sellIn);
        assertEquals(0, app.items[3].quality);


    }


    @Test
    public void ConjuredItemTest() {
        Item[] items = new Item[] {new Item("Conjured Mana Cake", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // checking - "Conjured" items degrade in Quality twice as fast as normal items
        assertEquals(0, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);

    }

}
